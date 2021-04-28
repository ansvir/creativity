// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.io.IOException;

public class HheaWriter extends FontFormatWriter
{
    private GlyfWriter m_glyf;
    private HeadWriter m_head;
    private int m_lineGap;
    private int m_maxAdvanceWidth;
    private int m_minRightSideBearing;
    
    public HheaWriter(final GlyfWriter a_glyf, final HeadWriter a_head) {
        this.m_lineGap = 0;
        this.m_maxAdvanceWidth = 0;
        this.m_minRightSideBearing = 0;
        this.m_glyf = a_glyf;
        this.m_head = a_head;
    }
    
    public void setLineGap(final int a_value) {
        this.m_lineGap = a_value;
    }
    
    public void setMaxAdvanceWidth(final int a_value) {
        this.m_maxAdvanceWidth = a_value;
    }
    
    public void setMinRightSideBearing(final int a_value) {
        this.m_minRightSideBearing = a_value;
    }
    
    @Override
    public void write() throws IOException {
        this.writeFixed32(1.0);
        this.writeFWord(this.m_head.getMax().y);
        this.writeFWord(this.m_head.getMin().y);
        this.writeFWord(this.m_lineGap);
        this.writeUFWord(this.m_maxAdvanceWidth);
        final int minLeftSideBearing = this.m_head.getMin().x;
        this.writeFWord(minLeftSideBearing);
        this.writeFWord(this.m_minRightSideBearing);
        final int xMaxExtent = this.m_head.getMax().x - this.m_head.getMin().x;
        this.writeFWord(xMaxExtent);
        this.writeInt16(1);
        this.writeInt16(0);
        for (int i = 0; i < 5; ++i) {
            this.writeInt16(0);
        }
        this.writeInt16(0);
        final int numOfHMetrics = this.m_glyf.numOfGlyph();
        this.writeUInt16(numOfHMetrics);
        this.pad();
    }
    
    @Override
    protected String getTag() {
        return "hhea";
    }
}
