// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.util.ArrayList;

public class TTPixelSize
{
    private static int s_em;
    private static boolean s_isInitialized;
    private static ArrayList<TTPixelSize> s_list;
    private int m_pixel;
    private String m_description;
    private int[] m_pixelWidths;
    private int m_maxPixelWidth;
    
    static {
        TTPixelSize.s_em = 1024;
        TTPixelSize.s_isInitialized = false;
        TTPixelSize.s_list = new ArrayList<TTPixelSize>();
    }
    
    public static int getEm() {
        return TTPixelSize.s_em;
    }
    
    public static ArrayList<TTPixelSize> getList() {
        initList();
        return TTPixelSize.s_list;
    }
    
    private static void initList() {
        if (TTPixelSize.s_isInitialized) {
            return;
        }
        TTPixelSize.s_isInitialized = true;
        TTPixelSize.s_list.add(new TTPixelSize(11, "11px: 8pt(96dpi)/11pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(12, "12px: 9pt(96dpi)/12pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(13, "13px: 10pt(96dpi)/13pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(14, "14px: 10.5pt(96dpi)/14pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(15, "15px: 11pt(96dpi)/15pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(16, "16px: 12pt(96dpi)/16pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(17, "17px: 13pt(96dpi)/17pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(18, "18px: 13.5pt(96dpi)/18pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(19, "19px: 14pt(96dpi)/14pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(20, "20px: 15pt(96dpi)/20pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(21, "21px: 16pt(96dpi)/21pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(22, "22px: 16.5pt(96dpi)/22pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(23, "23px: 17pt(96dpi)/23pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(24, "24px: 18pt(96dpi)/24pt(72dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(27, "27px: 20pt(96dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(29, "29px: 22pt(96dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(32, "32px: 24pt(96dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(33, "33px: 8pt(300dpi) "));
        TTPixelSize.s_list.add(new TTPixelSize(37, "37px: 28pt(96dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(42, "42px: 10pt(300dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(46, "46px: 11pt(300dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(50, "50px: 12pt(300dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(54, "54px: 13pt(300dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(58, "58px: 14pt(300dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(67, "67px: 16pt(300dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(75, "75px: 18pt(300dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(83, "83px: 20pt(300dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(92, "92px: 22pt(300dpi)"));
        TTPixelSize.s_list.add(new TTPixelSize(100, "100px: 24pt(300dpi)"));
    }
    
    public TTPixelSize(final int a_pixel, final String a_description) {
        this.m_maxPixelWidth = 0;
        this.m_pixel = a_pixel;
        this.m_description = a_description;
    }
    
    public int getPixel() {
        return this.m_pixel;
    }
    
    public String getDescription() {
        return this.m_description;
    }
    
    public void setPixelWidthsSize(final int a_size) {
        this.m_pixelWidths = new int[a_size];
        this.m_maxPixelWidth = 0;
    }
    
    public void setPixelWidth(final int a_glyphIndex, final int a_value) {
        this.m_pixelWidths[a_glyphIndex] = a_value;
        if (a_value > this.m_maxPixelWidth) {
            this.m_maxPixelWidth = a_value;
        }
    }
    
    public int[] getPixelWidths() {
        return this.m_pixelWidths;
    }
    
    public int getPixelWidth(final int a_glyphIndex) {
        return this.m_pixelWidths[a_glyphIndex];
    }
    
    public int getMaxPixelWidth() {
        return this.m_maxPixelWidth;
    }
}
