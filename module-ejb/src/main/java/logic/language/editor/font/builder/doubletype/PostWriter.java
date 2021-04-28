// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.io.IOException;

public class PostWriter extends FontFormatWriter
{
    boolean m_isMonospaced;
    
    public PostWriter() {
        this.m_isMonospaced = false;
    }
    
    @Override
    public void write() throws IOException {
        this.writeFixed32(3.0);
        this.writeFixed32(10.0);
        this.writeFWord(0);
        this.writeFWord(60);
        if (this.m_isMonospaced) {
            this.writeUInt32(1L);
        }
        else {
            this.writeUInt32(0L);
        }
        this.writeUInt32(0L);
        this.writeUInt32(0L);
        this.writeUInt32(0L);
        this.writeUInt32(0L);
        this.pad();
    }
    
    @Override
    protected String getTag() {
        return "post";
    }
}
