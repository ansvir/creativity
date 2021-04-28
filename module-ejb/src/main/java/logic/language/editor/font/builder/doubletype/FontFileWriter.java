// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
import java.io.RandomAccessFile;

public class FontFileWriter extends FontFormatWriter
{
    private CmapWriter m_cmap;
    private GlyfWriter m_glyf;
    private LocaWriter m_loca;
    private HeadWriter m_head;
    private HdmxWriter m_hdmx;
    private HheaWriter m_hhea;
    private HmtxWriter m_hmtx;
    private MaxpWriter m_maxp;
    private NameWriter m_name;
    private PostWriter m_post;
    private OS2Writer m_os2;
    private KernWriter m_kern;
    protected RandomAccessFile m_file;
    private ArrayList<FontFormatWriter> m_tables;
    
    public FontFileWriter(final RandomAccessFile a_file) {
        this.m_tables = new ArrayList<FontFormatWriter>();
        this.m_file = a_file;
        this.m_loca = new LocaWriter();
        this.m_maxp = new MaxpWriter();
        this.m_head = new HeadWriter();
        this.m_hdmx = new HdmxWriter();
        this.m_os2 = new OS2Writer(this.m_head);
        this.m_cmap = new CmapWriter(this.m_os2);
        this.m_glyf = new GlyfWriter(this.m_loca, this.m_maxp, this.m_head, this.m_hdmx);
        this.m_hhea = new HheaWriter(this.m_glyf, this.m_head);
        this.m_hmtx = new HmtxWriter(this.m_glyf, this.m_hhea);
        this.m_name = new NameWriter();
        this.m_post = new PostWriter();
        this.m_kern = new KernWriter(this.m_cmap);
        this.m_tables.add(this.m_head);
        this.m_tables.add(this.m_hhea);
        this.m_tables.add(this.m_maxp);
        this.m_tables.add(this.m_os2);
        this.m_tables.add(this.m_name);
        this.m_tables.add(this.m_cmap);
        this.m_tables.add(this.m_loca);
        this.m_tables.add(this.m_hmtx);
        this.m_tables.add(this.m_glyf);
        this.m_tables.add(this.m_post);
        this.m_tables.add(this.m_kern);
    }
    
    public void addKern(final char c1, final char c2, final int kern) {
        this.m_kern.addKerning(c1, c2, kern);
    }
    
    public void setNames(final String fontName, final String designer, final String designerUrl) {
        this.m_name.setNames(fontName, designer, designerUrl);
    }
    
    @Override
    public void write() throws IOException {
        this.m_cmap.write();
        this.m_hmtx.write();
        this.m_hhea.write();
        this.m_glyf.write();
        this.m_loca.write();
        this.m_head.setCheckSumAdjustment(0L);
        this.m_head.write();
        this.m_maxp.write();
        this.m_name.write();
        this.m_post.write();
        this.m_os2.write();
        this.m_kern.write();
        this.writeTableDirectory();
        final byte[] tableDir = this.toByteArray();
        for (final FontFormatWriter table : this.m_tables) {
            this.m_buffer.write(table.toByteArray());
        }
        final long checkSum = -1313820742L - (-1L & this.getCheckSum());
        this.m_head.setCheckSumAdjustment(checkSum);
        this.m_head.reset();
        this.m_head.write();
        this.reset();
        this.m_buffer.write(tableDir);
        for (final FontFormatWriter table2 : this.m_tables) {
            this.m_buffer.write(table2.toByteArray());
        }
        this.m_file.write(this.toByteArray());
        this.m_file.close();
    }
    
    public void setAscent(final int a_value) {
        this.m_os2.setTypoAscender(a_value);
        this.m_os2.setCapHeight(a_value);
    }
    
    public void setDescent(final int a_value) {
        this.m_os2.setTypoDescender(-a_value);
    }
    
    public void setXHeight(final int a_value) {
        this.m_os2.setXHeight(a_value);
    }
    
    public void setLineGap(final int a_value) {
        this.m_os2.setTypoLineGap(a_value);
        this.m_hhea.setLineGap(a_value);
    }
    
    public void addUnicodeRange(final TTUnicodeRange a_range) {
        this.m_cmap.addUnicodeRange(a_range);
    }
    
    public void setCodeRangeFlag(final int a_codeRange) {
        this.m_os2.setCodePageRangeFlag(a_codeRange);
    }
    
    public int addGlyph(final TTGlyph a_glyph) {
        return this.m_glyf.add(a_glyph);
    }
    
    public TTGlyph getGlyph(final int a_index) {
        return this.m_glyf.getGlyph(a_index);
    }
    
    public void addCharacterMapping(final long a_unicode, final long a_glyfIndex) {
        this.m_cmap.addMapping(a_unicode, a_glyfIndex);
    }
    
    public long getCharacterMapping(final long a_unicode) {
        return this.m_cmap.getGlyfIndex(new Long(a_unicode));
    }
    
    private void writeTableDirectory() throws IOException {
        int tableOffset;
        final int headerLength = tableOffset = this.m_tables.size() * 16 + 16;
        for (final FontFormatWriter table : this.m_tables) {
            table.setOffset(tableOffset);
            tableOffset += table.size();
        }
        final ArrayList<FontFormatWriter> tables = (ArrayList<FontFormatWriter>)this.m_tables.clone();
        Collections.sort(tables, new Comparator<FontFormatWriter>() {
            @Override
            public int compare(final FontFormatWriter a_lhs, final FontFormatWriter a_rhs) {
                return a_lhs.getTag().compareTo(a_rhs.getTag());
            }
            
            @Override
            public boolean equals(final Object a_value) {
                return false;
            }
        });
        this.writeFixed32(1.0);
        final int numOfTables = tables.size();
        this.writeUInt16(numOfTables);
        final int searchRange = getSearchRange(numOfTables);
        this.writeUInt16(searchRange);
        final int entrySelector = getEntrySelector(numOfTables);
        this.writeUInt16(entrySelector);
        this.writeUInt16(numOfTables * 16 - searchRange);
        for (final FontFormatWriter table2 : tables) {
            this.writeTag(table2.getTag());
            this.writeUInt32(table2.getCheckSum());
            this.writeUInt32(table2.getOffset());
            this.writeUInt32(table2.size());
        }
        for (int i = 0; i < 4; ++i) {
            this.writeUInt8(0);
        }
    }
    
    public static int getSearchRange(final int a_value) {
        final int retval = (int)Math.pow(2.0, Math.floor(Math.log(a_value) / Math.log(2.0)));
        return 16 * retval;
    }
    
    public static int getEntrySelector(final int a_value) {
        final int retval = (int)Math.floor(Math.log(a_value) / Math.log(2.0));
        return retval;
    }
}
