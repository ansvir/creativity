// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.awt.Point;
import java.util.ArrayList;

public class TTGlyph
{
    public static final int k_onCurve = 1;
    public static final int ARG_1_AND_2_ARE_WORDS = 1;
    public static final int ARGS_ARE_XY_VALUES = 2;
    public static final int ROUND_XY_TO_GRID = 4;
    public static final int WE_HAVE_A_SCALE = 8;
    public static final int MORE_COMPONENTS = 32;
    public static final int WE_HAVE_AN_X_AND_Y_SCALE = 64;
    public static final int WE_HAVE_A_TWO_BY_TWO = 128;
    public static final int WE_HAVE_INSTRUCTIONS = 256;
    public static final int USE_MY_METRICS = 512;
    public static final int OVERLAP_COMPOUND = 1024;
    public static final int MDAP0 = 46;
    public static final int MDAP1 = 47;
    public static final int IUP0 = 48;
    public static final int IUP1 = 49;
    public static final int PUSHB000 = 176;
    public static final int PUSHB001 = 177;
    public static final int PUSHB010 = 178;
    public static final int PUSHB011 = 179;
    public static final int PUSHB100 = 180;
    public static final int PUSHB101 = 181;
    public static final int PUSHB110 = 182;
    public static final int PUSHB111 = 183;
    public static final int SVTCA0 = 0;
    public static final int SVTCA1 = 1;
    public static final int SPVFS = 10;
    public static final int SFVFS = 11;
    public static final int SFVTPV = 14;
    public static final int DELTAP1 = 93;
    public static final int DELTAP2 = 113;
    public static final int DELTAP3 = 114;
    public static final int SDB = 94;
    private ArrayList<Point> m_points;
    private ArrayList<Integer> m_endPtsOfContours;
    private ArrayList<Integer> m_instructions;
    private ArrayList<Integer> m_flags;
    private ArrayList<Integer> m_glyfIndeces;
    private ArrayList<Integer> m_arg1s;
    private ArrayList<Integer> m_arg2s;
    private boolean m_isSimple;
    private int m_advanceWidth;
    private int m_numOfCompositePoints;
    private int m_numOfCompositeContours;
    private int m_componentDepth;
    private Point m_min;
    private Point m_max;
    
    public static int toF2Dot14(final double a_value) {
        int retval = 0;
        if (a_value >= 2.0 || a_value < -2.0) {
            throw new RuntimeException(String.valueOf(Double.toString(a_value)) + " out of range");
        }
        final int mantissa = (int)Math.floor(a_value);
        final int fraction = (int)Math.floor((a_value - mantissa) * 16384.0);
        int twoBitPart;
        if ((twoBitPart = mantissa) < 0) {
            twoBitPart = 4 + mantissa;
        }
        retval = (twoBitPart << 14 | fraction);
        return retval;
    }
    
    public static int toDeltaArg(final int a_relativePpem, final int a_step) {
        int retval = 0;
        if (a_step < -8 || a_step > 8 || a_step == 0) {
            throw new RuntimeException("Out of range");
        }
        int selector = 0;
        if (a_step > 0) {
            selector = a_step + 7;
        }
        else {
            selector = a_step + 8;
        }
        retval = (a_relativePpem << 4 | selector);
        return retval;
    }
    
    public TTGlyph() {
        this.m_points = new ArrayList<Point>();
        this.m_endPtsOfContours = new ArrayList<Integer>();
        this.m_instructions = new ArrayList<Integer>();
        this.m_flags = new ArrayList<Integer>();
        this.m_glyfIndeces = new ArrayList<Integer>();
        this.m_arg1s = new ArrayList<Integer>();
        this.m_arg2s = new ArrayList<Integer>();
        this.m_isSimple = true;
        this.m_advanceWidth = 512;
        this.m_numOfCompositePoints = 0;
        this.m_numOfCompositeContours = 0;
        this.m_componentDepth = 0;
        this.m_min = null;
        this.m_max = null;
        this.init();
    }
    
    public void init() {
        this.m_isSimple = true;
        this.m_points.clear();
        this.m_endPtsOfContours.clear();
        this.m_instructions.clear();
        this.m_flags.clear();
        this.m_glyfIndeces.clear();
        this.m_arg1s.clear();
        this.m_arg2s.clear();
        this.m_advanceWidth = 512;
    }
    
    public void buildCompound() {
        this.init();
        this.m_isSimple = false;
        this.addFlag(39);
        this.addFlag(7);
        this.addGlyfIndex(3);
        this.addGlyfIndex(3);
        this.addArg1(0);
        this.addArg2(0);
        this.addArg1(0);
        this.addArg2(500);
    }
    
    public void addEndPoint(final int a_value) {
        this.m_endPtsOfContours.add(a_value);
    }
    
    public int getNumOfContours() {
        if (this.isSimple()) {
            return this.m_endPtsOfContours.size();
        }
        return -1;
    }
    
    public int getEndPoint(final int a_index) {
        return this.m_endPtsOfContours.get(a_index);
    }
    
    public int getAdvanceWidth() {
        return this.m_advanceWidth;
    }
    
    public void setAdvanceWidth(final int a_value) {
        this.m_advanceWidth = a_value;
    }
    
    public Point getMax() {
        if (this.m_max == null) {
            this.m_max = new Point(0, 0);
        }
        return this.m_max;
    }
    
    public Point getMin() {
        if (this.m_min == null) {
            this.m_min = new Point(0, 0);
        }
        return this.m_min;
    }
    
    public boolean isSimple() {
        return this.m_isSimple;
    }
    
    public void setSimple(final boolean a_isSimple) {
        this.m_isSimple = a_isSimple;
    }
    
    public void addInstruction(final int a_value) {
        this.m_instructions.add(a_value);
    }
    
    public int getInstruction(final int a_index) {
        return this.m_instructions.get(a_index);
    }
    
    public int getNumOfInstructions() {
        return this.m_instructions.size();
    }
    
    public void addFlag(final int a_value) {
        this.m_flags.add(a_value);
    }
    
    public int getFlag(final int a_index) {
        return this.m_flags.get(a_index);
    }
    
    public int getNumOfFlags() {
        return this.m_flags.size();
    }
    
    public void addPoint(final Point a_value) {
        this.m_points.add(a_value);
        this.updateMinMax(a_value);
    }
    
    private void updateMinMax(final Point a_value) {
        if (this.m_max == null) {
            this.m_max = new Point(a_value);
        }
        if (this.m_min == null) {
            this.m_min = new Point(a_value);
        }
        if (a_value.x > this.m_max.x) {
            this.m_max.x = a_value.x;
        }
        if (a_value.x < this.m_min.x) {
            this.m_min.x = a_value.x;
        }
        if (a_value.y > this.m_max.y) {
            this.m_max.y = a_value.y;
        }
        if (a_value.y < this.m_min.y) {
            this.m_min.y = a_value.y;
        }
    }
    
    public Point getPoint(final int a_index) {
        return this.m_points.get(a_index);
    }
    
    public int getNumOfPoints() {
        return this.m_points.size();
    }
    
    public int getLastIndex() {
        return this.m_points.size() - 1;
    }
    
    public void addGlyfIndex(final int a_value) {
        this.m_glyfIndeces.add(a_value);
    }
    
    public int getGlyfIndex(final int a_index) {
        return this.m_glyfIndeces.get(a_index);
    }
    
    public void addArg1(final int a_value) {
        this.m_arg1s.add(a_value);
    }
    
    public int getArg1(final int a_index) {
        return this.m_arg1s.get(a_index);
    }
    
    public void addArg2(final int a_value) {
        this.m_arg2s.add(a_value);
    }
    
    public int getArg2(final int a_index) {
        return this.m_arg2s.get(a_index);
    }
    
    public int getNumOfCompositePoints() {
        if (this.isSimple()) {
            return this.getNumOfPoints();
        }
        return this.m_numOfCompositePoints;
    }
    
    public void setNumOfCompositePoints(final int a_value) {
        this.m_numOfCompositePoints = a_value;
    }
    
    public int getNumOfCompositeContours() {
        if (this.isSimple()) {
            return this.getNumOfContours();
        }
        return this.m_numOfCompositeContours;
    }
    
    public void setNumOfCompositeContours(final int a_value) {
        this.m_numOfCompositeContours = a_value;
    }
    
    public int getComponentDepth() {
        if (this.isSimple()) {
            return 0;
        }
        return this.m_componentDepth;
    }
    
    public void setComponentDepth(final int a_value) {
        this.m_componentDepth = a_value;
    }
    
    public int getLeftSideBearing() {
        return this.getMin().x;
    }
    
    public int getRightSideBearing() {
        return this.getAdvanceWidth() - this.getMax().x;
    }
}
