// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;

public class HdmxWriter extends FontFormatWriter
{
    private int m_numGlyphs;
    
    public static int getNumOfPixelSizes() {
        return TTPixelSize.getList().size();
    }
    
    public static ArrayList<TTPixelSize> getPixelSizes() {
        return TTPixelSize.getList();
    }
    
    public HdmxWriter() {
        this.m_numGlyphs = 98;
    }
    
    public void setNumGlyphs(final int a_value) {
        this.m_numGlyphs = a_value;
        for (final TTPixelSize pixelSize : getPixelSizes()) {
            pixelSize.setPixelWidthsSize(a_value);
        }
    }
    
    public void updatePixelWidth(final int a_glyphIndex, final TTGlyph a_glyph) {
        final double advanceWidth = a_glyph.getAdvanceWidth();
        final double em = TTPixelSize.getEm();
        for (final TTPixelSize pixelSize : TTPixelSize.getList()) {
            final int width = (int)Math.round(pixelSize.getPixel() * advanceWidth / em);
            pixelSize.setPixelWidth(a_glyphIndex, width);
        }
    }
    
    @Override
    public void write() throws IOException {
        int numOfPads = 4 - (this.m_numGlyphs + 2) % 4;
        if (numOfPads == 4) {
            numOfPads = 0;
        }
        final int size = this.m_numGlyphs + 2 + numOfPads;
        this.writeInt16(0);
        this.writeInt16(getNumOfPixelSizes());
        System.out.printf("num of pixel sizes %d\n", getNumOfPixelSizes());
        this.writeInt32(size);
        System.out.printf("num of glyphs %d\n", this.m_numGlyphs);
        for (final TTPixelSize pixelSize : getPixelSizes()) {
            this.writeUInt8(pixelSize.getPixel());
            this.writeUInt8(pixelSize.getMaxPixelWidth());
            int[] pixelWidths;
            for (int length = (pixelWidths = pixelSize.getPixelWidths()).length, i = 0; i < length; ++i) {
                final int pixelWidth = pixelWidths[i];
                this.writeUInt8(pixelWidth);
            }
            for (int j = 0; j < numOfPads; ++j) {
                this.writeUInt8(0);
            }
        }
        this.pad();
    }
    
    @Override
    protected String getTag() {
        return "hdmx";
    }
}
