// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.io.IOException;

public class HmtxWriter extends FontFormatWriter
{
    HheaWriter m_hhea;
    GlyfWriter m_glyf;
    
    public HmtxWriter(final GlyfWriter a_glyf, final HheaWriter a_hhea) {
        this.m_hhea = a_hhea;
        this.m_glyf = a_glyf;
    }
    
    @Override
    public void write() throws IOException {
        final TTGlyph glyphZero = this.m_glyf.getGlyph(0);
        int maxWidth = glyphZero.getAdvanceWidth();
        int minRightSideBearing = glyphZero.getRightSideBearing();
        for (int i = 0; i < this.m_glyf.numOfGlyph(); ++i) {
            final TTGlyph glyph = this.m_glyf.getGlyph(i);
            if (glyph.getAdvanceWidth() > maxWidth) {
                maxWidth = glyph.getAdvanceWidth();
            }
            if (glyph.getRightSideBearing() < minRightSideBearing) {
                minRightSideBearing = glyph.getRightSideBearing();
            }
            this.writeUFWord(glyph.getAdvanceWidth());
            this.writeFWord(glyph.getLeftSideBearing());
        }
        this.m_hhea.setMaxAdvanceWidth(maxWidth);
        this.m_hhea.setMinRightSideBearing(minRightSideBearing);
        this.pad();
    }
    
    @Override
    protected String getTag() {
        return "hmtx";
    }
}
