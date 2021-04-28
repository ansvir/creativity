// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.io.IOException;

public class MaxpWriter extends FontFormatWriter
{
    private int m_numGlyphs;
    private int m_maxPoints;
    private int m_maxContours;
    private int m_maxCompositePoints;
    private int m_maxCompositeContours;
    private int m_maxZones;
    private int m_maxTwilightPoints;
    private int m_maxStorage;
    private int m_maxFunctionDefs;
    private int m_maxInstructionDefs;
    private int m_maxStackElements;
    private int m_maxSizeOfInstructions;
    private int m_maxComponentElements;
    private int m_maxComponentDepth;
    
    public MaxpWriter() {
        this.m_numGlyphs = 98;
        this.m_maxPoints = 0;
        this.m_maxContours = 0;
        this.m_maxCompositePoints = 0;
        this.m_maxCompositeContours = 0;
        this.m_maxZones = 2;
        this.m_maxTwilightPoints = 128;
        this.m_maxStorage = 64;
        this.m_maxFunctionDefs = 128;
        this.m_maxInstructionDefs = 128;
        this.m_maxStackElements = 128;
        this.m_maxSizeOfInstructions = 128;
        this.m_maxComponentElements = 128;
        this.m_maxComponentDepth = 0;
    }
    
    @Override
    public void write() throws IOException {
        this.writeFixed32(1.0);
        this.writeUInt16(this.m_numGlyphs);
        this.writeUInt16(this.m_maxPoints);
        this.writeUInt16(this.m_maxContours);
        this.writeUInt16(this.m_maxCompositePoints);
        this.writeUInt16(this.m_maxCompositeContours);
        this.writeUInt16(this.m_maxZones);
        this.writeUInt16(this.m_maxTwilightPoints);
        this.writeUInt16(this.m_maxStorage);
        this.writeUInt16(this.m_maxFunctionDefs);
        this.writeUInt16(this.m_maxInstructionDefs);
        this.writeUInt16(this.m_maxStackElements);
        this.writeUInt16(this.m_maxSizeOfInstructions);
        this.writeUInt16(this.m_maxComponentElements);
        this.writeUInt16(this.m_maxComponentDepth);
        this.pad();
    }
    
    @Override
    protected String getTag() {
        return "maxp";
    }
    
    public void setNumGlyphs(final int a_value) {
        this.m_numGlyphs = a_value;
    }
    
    public void updateNumOfPoints(final int a_value) {
        if (a_value > this.m_maxPoints) {
            this.m_maxPoints = a_value;
        }
    }
    
    public void updateNumOfContours(final int a_value) {
        if (a_value > this.m_maxContours) {
            this.m_maxContours = a_value;
        }
    }
    
    public void updateNumOfCompositePoints(final int a_value) {
        if (a_value > this.m_maxCompositePoints) {
            this.m_maxCompositePoints = a_value;
        }
    }
    
    public void updateNumOfCompositeContours(final int a_value) {
        if (a_value > this.m_maxCompositeContours) {
            this.m_maxCompositeContours = a_value;
        }
    }
    
    public void updateSizeOfInstructions(final int a_value) {
        if (a_value > this.m_maxSizeOfInstructions) {
            this.m_maxSizeOfInstructions = a_value;
        }
    }
    
    public void updateNumOfComponentElements(final int a_value) {
        if (a_value > this.m_maxComponentElements) {
            this.m_maxComponentElements = a_value;
        }
    }
    
    public void updateComponentDepth(final int a_value) {
        if (a_value > this.m_maxComponentDepth) {
            this.m_maxComponentDepth = a_value;
        }
    }
}
