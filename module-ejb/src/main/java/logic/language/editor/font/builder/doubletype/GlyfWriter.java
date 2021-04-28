// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

public class GlyfWriter extends FontFormatWriter
{
    private ArrayList<TTGlyph> m_glyphs;
    private LocaWriter m_loca;
    private MaxpWriter m_maxp;
    private HeadWriter m_head;
    private HdmxWriter m_hdmx;
    
    public GlyfWriter(final LocaWriter a_loca, final MaxpWriter a_maxp, final HeadWriter a_head, final HdmxWriter a_hdmx) {
        this.m_loca = a_loca;
        this.m_maxp = a_maxp;
        this.m_head = a_head;
        this.m_hdmx = a_hdmx;
        this.m_glyphs = new ArrayList<TTGlyph>();
    }
    
    @Override
    public void write() throws IOException {
        this.m_hdmx.setNumGlyphs(this.numOfGlyph());
        this.m_maxp.setNumGlyphs(this.numOfGlyph());
        this.m_loca.m_offsets.clear();
        for (int i = 0; i < this.m_glyphs.size(); ++i) {
            this.writeGlyph(this.m_glyphs.get(i));
            this.m_hdmx.updatePixelWidth(i, this.m_glyphs.get(i));
        }
        this.m_loca.m_offsets.add(this.size());
    }
    
    public int add(final TTGlyph a_glyph) {
        this.m_head.updateMax(a_glyph.getMax());
        this.m_head.updateMin(a_glyph.getMin());
        this.m_glyphs.add(a_glyph);
        return this.m_glyphs.size() - 1;
    }
    
    public int numOfGlyph() {
        return this.m_glyphs.size();
    }
    
    public TTGlyph getGlyph(final int a_index) {
        return this.m_glyphs.get(a_index);
    }
    
    private void writeGlyph(final TTGlyph a_glyph) throws IOException {
        this.m_loca.m_offsets.add(this.size());
        if (a_glyph == null) {
            return;
        }
        if (a_glyph.isSimple()) {
            this.writeSimpleGlyph(a_glyph);
        }
        else {
            this.writeCompoundGlyph(a_glyph);
        }
        this.pad();
    }
    
    private void writeSimpleGlyph(final TTGlyph a_glyph) throws IOException {
        if (a_glyph.getNumOfContours() == 0) {
            return;
        }
        this.m_maxp.updateNumOfContours(a_glyph.getNumOfContours());
        this.writeInt16(a_glyph.getNumOfContours());
        this.writeMinMax(a_glyph);
        for (int i = 0; i < a_glyph.getNumOfContours(); ++i) {
            this.writeUInt16(a_glyph.getEndPoint(i));
        }
        final int numOfInst = a_glyph.getNumOfInstructions();
        this.m_maxp.updateSizeOfInstructions(numOfInst);
        this.writeUInt16(numOfInst);
        for (int i = 0; i < numOfInst; ++i) {
            this.writeUInt8(a_glyph.getInstruction(i));
        }
        for (int i = 0; i < a_glyph.getNumOfFlags(); ++i) {
            final int flag = a_glyph.getFlag(i);
            this.writeUInt8(flag);
        }
        this.m_maxp.updateNumOfPoints(a_glyph.getNumOfPoints());
        int lastX = 0;
        for (int i = 0; i < a_glyph.getNumOfPoints(); ++i) {
            final Point point = a_glyph.getPoint(i);
            this.writeInt16(point.x - lastX);
            lastX = point.x;
        }
        int lastY = 0;
        for (int i = 0; i < a_glyph.getNumOfPoints(); ++i) {
            final Point point2 = a_glyph.getPoint(i);
            this.writeInt16(point2.y - lastY);
            lastY = point2.y;
        }
    }
    
    private void writeCompoundGlyph(final TTGlyph a_glyph) throws IOException {
        this.m_maxp.updateNumOfCompositePoints(a_glyph.getNumOfCompositePoints());
        this.m_maxp.updateNumOfCompositeContours(a_glyph.getNumOfCompositeContours());
        this.writeInt16(-1);
        this.writeMinMax(a_glyph);
        final int numOfGlyphs = a_glyph.getNumOfFlags();
        this.m_maxp.updateNumOfComponentElements(numOfGlyphs);
        this.m_maxp.updateComponentDepth(a_glyph.getComponentDepth());
        for (int i = 0; i < numOfGlyphs; ++i) {
            this.writeUInt16(a_glyph.getFlag(i));
            this.writeUInt16(a_glyph.getGlyfIndex(i));
            this.writeInt16(a_glyph.getArg1(i));
            this.writeInt16(a_glyph.getArg2(i));
        }
    }
    
    private void writeMinMax(final TTGlyph a_glyph) throws IOException {
        final Point min = a_glyph.getMin();
        final Point max = a_glyph.getMax();
        this.writeFWord(min.x);
        this.writeFWord(min.y);
        this.writeFWord(max.x);
        this.writeFWord(max.y);
    }
    
    @Override
    protected String getTag() {
        return "glyf";
    }
}
