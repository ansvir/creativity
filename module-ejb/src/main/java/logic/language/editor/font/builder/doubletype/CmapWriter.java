// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.io.IOException;
import java.util.List;
import java.util.Collections;
import java.util.Hashtable;
import java.util.ArrayList;

public class CmapWriter extends FontFormatWriter
{
    final long k_basicLatinStart = 32L;
    final long k_basicLatinEnd = 126L;
    final long k_tableEnd = 65535L;
    final int k_unmappedChar = 0;
    private OS2Writer m_os2;
    private ArrayList<Long> m_unicodes;
    private ArrayList<Long> m_startCodes;
    private ArrayList<Long> m_endCodes;
    private Hashtable<Long, Long> m_unicode2glyph;
    private ArrayList<TTUnicodeRange> m_unicodeRanges;
    private ArrayList<Long> m_idDeltas;
    private ArrayList<Long> m_idRangeOffsets;
    private boolean m_isIncludeVersion0;
    private byte[] m_version0;
    private byte[] m_version4;
    private byte[] m_version12;
    
    public CmapWriter(final OS2Writer a_os2) {
        this.m_unicodes = new ArrayList<Long>();
        this.m_startCodes = new ArrayList<Long>();
        this.m_endCodes = new ArrayList<Long>();
        this.m_unicode2glyph = new Hashtable<Long, Long>();
        this.m_unicodeRanges = new ArrayList<TTUnicodeRange>();
        this.m_idDeltas = new ArrayList<Long>();
        this.m_idRangeOffsets = new ArrayList<Long>();
        this.m_os2 = a_os2;
        this.m_isIncludeVersion0 = false;
    }
    
    private void prepare() {
        Collections.sort(this.m_unicodeRanges);
        TTUnicodeRange range = this.m_unicodeRanges.get(0);
        this.m_os2.m_usFirstCharIndex = (int)range.getStartCode();
        this.m_os2.m_usLastCharIndex = (int)range.getEndCode();
        for (int i = 0; i < this.m_unicodeRanges.size(); ++i) {
            range = this.m_unicodeRanges.get(i);
            this.m_startCodes.add(range.getStartCode());
            this.m_endCodes.add(range.getEndCode());
            this.m_idDeltas.add(0L);
            this.m_idRangeOffsets.add(2L * (this.m_unicodeRanges.size() - i) + 2L + 2L * this.m_unicodes.size());
            this.m_os2.m_usLastCharIndex = (int)range.getEndCode();
            this.m_os2.setUnicodeRangeFlag(range.getOsTwoFlag());
            for (long unicode = range.getStartCode(); unicode <= range.getEndCode(); ++unicode) {
                this.m_unicodes.add(unicode);
            }
        }
        this.m_startCodes.add(65535L);
        this.m_endCodes.add(65535L);
        this.m_idDeltas.add(1L);
        this.m_idRangeOffsets.add(0L);
    }
    
    @Override
    public void write() throws IOException {
        this.prepare();
        if (this.m_isIncludeVersion0) {
            this.storeVersion0();
        }
        this.storeVersion4();
        this.reset();
        this.writeUInt16(0);
        this.writeUInt16(this.getNumOfEncoding());
        if (this.m_isIncludeVersion0) {
            this.writeUInt16(1);
            this.writeUInt16(0);
            this.writeUInt32(this.size() + 4 + 8);
        }
        this.writeUInt16(3);
        this.writeUInt16(1);
        int version4Offset = this.size() + 4;
        if (this.m_isIncludeVersion0) {
            version4Offset += this.m_version0.length;
        }
        this.writeUInt32(version4Offset);
        if (this.m_isIncludeVersion0) {
            this.m_buffer.write(this.m_version0);
        }
        this.m_buffer.write(this.m_version4);
        this.pad();
    }
    
    private int getNumOfEncoding() {
        if (this.m_isIncludeVersion0) {
            return 2;
        }
        return 1;
    }
    
    public void addUnicodeRange(final TTUnicodeRange a_range) {
        if (!this.m_unicodeRanges.contains(a_range)) {
            this.m_unicodeRanges.add(a_range);
        }
    }
    
    public void addMapping(final long a_unicode, final long a_glyfIndex) {
        this.m_unicode2glyph.put(a_unicode, a_glyfIndex);
    }
    
    public long getGlyfIndex(final Long a_key) {
        long retval = 0L;
        if (this.m_unicode2glyph.containsKey(a_key)) {
            retval = this.m_unicode2glyph.get(a_key);
        }
        return retval;
    }
    
    private void storeVersion0() throws IOException {
        this.reset();
        this.writeVersion0();
        this.m_version0 = this.toByteArray();
        this.reset();
    }
    
    private void storeVersion4() throws IOException {
        this.reset();
        this.writeVersion4();
        this.m_version4 = this.toByteArray();
        this.reset();
    }
    
    private void storeVersion12() throws IOException {
        this.reset();
        this.writeVersion12();
        this.m_version12 = this.toByteArray();
        this.reset();
    }
    
    @Override
    protected String getTag() {
        return "cmap";
    }
    
    private void writeVersion0() throws IOException {
        this.writeUInt16(0);
        this.writeUInt16(262);
        this.writeUInt16(0);
        for (int i = 0; i < 256; ++i) {
            if (i == 0 || i == 8 || i == 29) {
                this.writeUInt8((int)this.getGlyfIndex(0L));
            }
            else if (i == 9 || i == 13) {
                this.writeUInt8((int)this.getGlyfIndex(13L));
            }
            else {
                this.writeUInt8((int)this.getGlyfIndex((long)i));
            }
        }
    }
    
    private void writeVersion4() throws IOException {
        final int segCount = this.m_startCodes.size();
        for (int i = 0; i < segCount; ++i) {
            final Long n = this.m_endCodes.get(i);
            this.writeUInt16(n.intValue());
        }
        this.writeUInt16(0);
        for (int i = 0; i < segCount; ++i) {
            final Long n = this.m_startCodes.get(i);
            this.writeUInt16(n.intValue());
        }
        for (int i = 0; i < segCount; ++i) {
            final Long n = this.m_idDeltas.get(i);
            this.writeInt16(n.intValue());
        }
        for (int i = 0; i < segCount; ++i) {
            final Long n = this.m_idRangeOffsets.get(i);
            this.writeInt16(n.intValue());
        }
        for (int i = 0; i < this.m_unicodes.size(); ++i) {
            final Long unicode = this.m_unicodes.get(i);
            this.writeUInt16((int)this.getGlyfIndex(unicode));
        }
        final byte[] bytes = this.m_bytes.toByteArray();
        this.reset();
        this.writeUInt16(4);
        this.writeUInt16(bytes.length + 14);
        this.writeUInt16(0);
        this.writeUInt16(segCount * 2);
        final int searchRange = this.getSearchRange(segCount);
        this.writeUInt16(searchRange);
        this.writeUInt16(this.getEntrySelector(searchRange));
        this.writeUInt16(this.getRangeShift(segCount, searchRange));
        this.m_buffer.write(bytes);
    }
    
    public void writeVersion12() throws IOException {
        final ArrayList<Long> startCharCode = new ArrayList<Long>();
        final ArrayList<Long> endCharCode = new ArrayList<Long>();
        final ArrayList<Long> startGlyphCode = new ArrayList<Long>();
        startCharCode.add(32L);
        endCharCode.add(126L);
        startGlyphCode.add(1L);
        final long length = 16 + 12 * startCharCode.size();
        this.writeFixed32(12.0);
        this.writeUInt32(length);
        this.writeUInt32(0L);
        this.writeUInt32(startCharCode.size());
        for (int i = 0; i < startCharCode.size(); ++i) {
            this.writeUInt32(startCharCode.get(i));
            this.writeUInt32(endCharCode.get(i));
            this.writeUInt32(startGlyphCode.get(i));
        }
    }
    
    private int getSearchRange(final int a_value) {
        final int retval = (int)Math.pow(2.0, Math.floor(Math.log(a_value) / Math.log(2.0)));
        return 2 * retval;
    }
    
    private int getEntrySelector(final int a_searchRange) {
        final int retval = (int)(Math.log(a_searchRange / 2) / Math.log(2.0));
        return retval;
    }
    
    private int getRangeShift(final int a_value, final int a_searchRange) {
        final int retval = 2 * a_value - a_searchRange;
        return retval;
    }
}
