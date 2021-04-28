// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.io.IOException;

public class OS2Writer extends FontFormatWriter
{
    final int FW_THIN = 100;
    final int FW_EXTRALIGHT = 200;
    final int FW_LIGHT = 300;
    final int FW_NORMAL = 400;
    final int FW_MEDIUM = 500;
    final int FW_SEMIBOLD = 600;
    final int FW_BOLD = 700;
    final int FW_EXTRABOLD = 800;
    final int FW_BLACK = 900;
    final int FWIDTH_NORMAL = 5;
    final int k_editableEmbedding = 8;
    final int k_sansSerif = 2048;
    final int k_basicLatin = 1;
    final int k_latin1Supplement = 2;
    final int k_regular = 64;
    final int k_basicLatinStart = 32;
    final int k_basciLatinEnd = 126;
    private HeadWriter m_head;
    int m_xAvgCharWidth;
    int m_usWeightClass;
    int m_usWidthClass;
    int m_fsType;
    int m_ySubscriptXSize;
    int m_ySubscriptYSize;
    int m_ySubscriptXOffset;
    int m_ySubscriptYOffset;
    int m_ySuperscriptXSize;
    int m_ySuperscriptYSize;
    int m_ySuperscriptXOffset;
    int m_ySuperscriptYOffset;
    int m_yStrikeoutSize;
    int m_yStrikeoutPosition;
    int m_sFamilyClass;
    long m_ulUnicodeRange1;
    long m_ulUnicodeRange2;
    long m_ulUnicodeRange3;
    long m_ulUnicodeRange4;
    String m_vendId;
    int m_fsSelection;
    int m_usFirstCharIndex;
    int m_usLastCharIndex;
    private int m_sTypoAscender;
    private int m_sTypoDescender;
    private int m_sTypoLineGap;
    private int m_usWinAscent;
    private int m_usWinDescent;
    long m_ulCodePageRange1;
    long m_ulCodePageRange2;
    private int m_sxHeight;
    private int m_sCapHeight;
    int m_usDefaultChar;
    int m_usBreakChar;
    int m_usMaxContext;
    
    public OS2Writer(final HeadWriter a_head) {
        this.m_xAvgCharWidth = 512;
        this.m_usWeightClass = 400;
        this.m_usWidthClass = 5;
        this.m_fsType = 0;
        this.m_ySubscriptXSize = 128;
        this.m_ySubscriptYSize = 128;
        this.m_ySubscriptXOffset = 0;
        this.m_ySubscriptYOffset = -64;
        this.m_ySuperscriptXSize = 128;
        this.m_ySuperscriptYSize = 128;
        this.m_ySuperscriptXOffset = 0;
        this.m_ySuperscriptYOffset = 64;
        this.m_yStrikeoutSize = 51;
        this.m_yStrikeoutPosition = 512;
        this.m_sFamilyClass = 2048;
        this.m_ulUnicodeRange1 = 3L;
        this.m_ulUnicodeRange2 = 0L;
        this.m_ulUnicodeRange3 = 0L;
        this.m_ulUnicodeRange4 = 0L;
        this.m_vendId = "NONE";
        this.m_fsSelection = 64;
        this.m_usFirstCharIndex = 32;
        this.m_usLastCharIndex = 126;
        this.m_sTypoAscender = 1024;
        this.m_sTypoDescender = 0;
        this.m_sTypoLineGap = 0;
        this.m_usWinAscent = 1024;
        this.m_usWinDescent = 0;
        this.m_ulCodePageRange1 = 0L;
        this.m_ulCodePageRange2 = 0L;
        this.m_sxHeight = 512;
        this.m_sCapHeight = 1024;
        this.m_usDefaultChar = 0;
        this.m_usBreakChar = 32;
        this.m_usMaxContext = 1;
        this.m_head = a_head;
    }
    
    public void setCapHeight(final int a_value) {
        this.m_sCapHeight = a_value;
    }
    
    public void setXHeight(final int a_value) {
        this.m_sxHeight = a_value;
    }
    
    public void setTypoAscender(final int a_value) {
        this.m_sTypoAscender = a_value;
    }
    
    public void setTypoDescender(final int a_value) {
        this.m_sTypoDescender = a_value;
    }
    
    public void setTypoLineGap(final int a_value) {
        this.m_sTypoLineGap = a_value;
    }
    
    public void setUnicodeRangeFlag(final int a_pos) {
        final int which = a_pos / 32;
        final int where = a_pos % 32;
        final long what = 1 << where;
        switch (which) {
            case 0: {
                this.m_ulUnicodeRange1 |= what;
                break;
            }
            case 1: {
                this.m_ulUnicodeRange2 |= what;
                break;
            }
            case 2: {
                this.m_ulUnicodeRange3 |= what;
                break;
            }
            case 3: {
                this.m_ulUnicodeRange4 |= what;
                break;
            }
        }
    }
    
    public void setCodePageRangeFlag(final int a_pos) {
        final int which = a_pos / 32;
        final int where = a_pos % 32;
        final long what = 1 << where;
        switch (which) {
            case 0: {
                this.m_ulCodePageRange1 |= what;
                break;
            }
            case 1: {
                this.m_ulCodePageRange2 |= what;
                break;
            }
        }
    }
    
    @Override
    public void write() throws IOException {
        this.m_usWinAscent = this.m_head.getMax().y;
        this.m_usWinDescent = 0;
        if (this.m_head.getMin().y < 0) {
            this.m_usWinDescent = -this.m_head.getMin().y;
        }
        this.writeUInt16(2);
        this.writeInt16(this.m_xAvgCharWidth = (this.m_head.getMax().x - this.m_head.getMin().x) * 2 / 3);
        this.writeUInt16(this.m_usWeightClass);
        this.writeUInt16(this.m_usWidthClass);
        this.writeInt16(this.m_fsType);
        this.writeInt16(this.m_ySubscriptXSize = (this.m_head.getMax().x - this.m_head.getMin().x) * 1 / 3);
        this.writeInt16(this.m_ySubscriptYSize = (this.m_head.getMax().y - this.m_head.getMin().y) * 1 / 3);
        this.writeInt16(this.m_ySubscriptXOffset = 0);
        this.writeInt16(this.m_ySubscriptYOffset = -(this.m_head.getMax().y - this.m_head.getMin().y) * 1 / 3);
        this.writeInt16(this.m_ySuperscriptXSize = (this.m_head.getMax().x - this.m_head.getMin().x) * 1 / 3);
        this.writeInt16(this.m_ySuperscriptYSize = (this.m_head.getMax().y - this.m_head.getMin().y) * 1 / 3);
        this.writeInt16(this.m_ySuperscriptXOffset = 0);
        this.writeInt16(this.m_ySuperscriptYOffset = (this.m_head.getMax().y - this.m_head.getMin().y) * 1 / 3);
        this.writeInt16(this.m_yStrikeoutSize = (this.m_head.getMax().y - this.m_head.getMin().y) / 100);
        this.writeInt16(this.m_yStrikeoutPosition = (this.m_head.getMax().y - this.m_head.getMin().y) * 1 / 2);
        this.writeInt16(this.m_sFamilyClass);
        this.writePanose();
        this.writeUInt32(this.m_ulUnicodeRange1);
        this.writeUInt32(this.m_ulUnicodeRange2);
        this.writeUInt32(this.m_ulUnicodeRange3);
        this.writeUInt32(this.m_ulUnicodeRange4);
        this.writeTag(this.m_vendId);
        this.writeUInt16(this.m_fsSelection);
        this.writeUInt16(this.m_usFirstCharIndex);
        this.writeUInt16(this.m_usLastCharIndex = 65535);
        this.writeUInt16(this.m_sTypoAscender = this.m_head.getMax().y - this.m_head.getMin().y);
        this.writeUInt16(this.m_sTypoDescender);
        this.writeUInt16(this.m_sTypoLineGap);
        this.writeUInt16(this.m_usWinAscent = this.m_head.getMax().y);
        this.writeUInt16(this.m_usWinDescent);
        this.writeUInt32(this.m_ulCodePageRange1);
        this.writeUInt32(this.m_ulCodePageRange2);
        this.writeInt16(this.m_sxHeight = this.m_head.getMax().y - this.m_head.getMin().y);
        this.writeInt16(this.m_sCapHeight = this.m_sxHeight);
        this.writeUInt16(this.m_usDefaultChar);
        this.writeUInt16(this.m_usBreakChar);
        this.writeUInt16(this.m_usMaxContext = 2);
        this.pad();
    }
    
    private void writePanose() throws IOException {
        this.writeUInt8(0);
        this.writeUInt8(0);
        this.writeUInt8(0);
        this.writeUInt8(0);
        this.writeUInt8(0);
        this.writeUInt8(0);
        this.writeUInt8(0);
        this.writeUInt8(0);
        this.writeUInt8(0);
        this.writeUInt8(0);
    }
    
    @Override
    protected String getTag() {
        return "OS/2 ";
    }
}
