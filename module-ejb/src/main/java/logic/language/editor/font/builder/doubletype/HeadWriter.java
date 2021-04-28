// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.io.IOException;
import java.util.Date;
import java.awt.Point;

public class HeadWriter extends FontFormatWriter
{
    public static final int k_yZeroIsBaseLine = 1;
    public static final int k_xLeftMostBlackIsLsb = 2;
    public static final int k_scaledPointDiffer = 4;
    public static final int k_useIntegerScaling = 8;
    public static final int k_scaleLinear = 16;
    public static final int k_xZeroIsBaseLine = 32;
    public static final int k_linguisticRendering = 128;
    public static final int k_defaultMetamorphosis = 256;
    public static final int k_rightToLeft = 512;
    public static final int k_indicRearrangement = 1024;
    private final long k_magicNumber = 1594834165L;
    private long m_checkSumAdjustment;
    private Point m_min;
    private Point m_max;
    
    public HeadWriter() {
        this.m_checkSumAdjustment = 0L;
        this.m_min = new Point(0, 0);
        this.m_max = new Point(0, 0);
    }
    
    void setCheckSumAdjustment(final long a_value) {
        this.m_checkSumAdjustment = a_value;
    }
    
    public Point getMin() {
        return this.m_min;
    }
    
    public Point getMax() {
        return this.m_max;
    }
    
    public void updateMin(final Point a_value) {
        if (a_value.x < this.m_min.x) {
            this.m_min.x = a_value.x;
        }
        if (a_value.y < this.m_min.y) {
            this.m_min.y = a_value.y;
        }
    }
    
    public void updateMax(final Point a_value) {
        if (a_value.x > this.m_max.x) {
            this.m_max.x = a_value.x;
        }
        if (a_value.y > this.m_max.y) {
            this.m_max.y = a_value.y;
        }
    }
    
    @Override
    public void write() throws IOException {
        this.writeFixed32(1.0);
        this.writeFixed32(1.0);
        this.writeUInt32(this.m_checkSumAdjustment);
        this.writeUInt32(1594834165L);
        this.writeUInt16(7);
        this.writeUInt16(1024);
        this.writeLongDateTime(new Date());
        this.writeLongDateTime(new Date());
        this.writeFWord(this.m_min.x);
        this.writeFWord(this.m_min.y);
        this.writeFWord(this.m_max.x);
        this.writeFWord(this.m_max.y);
        this.writeUInt16(0);
        this.writeUInt16(11);
        this.writeInt16(2);
        this.writeInt16(1);
        this.writeInt16(0);
        this.pad();
    }
    
    @Override
    protected String getTag() {
        return "head";
    }
}
