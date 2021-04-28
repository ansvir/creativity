// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.io.IOException;
import java.util.ArrayList;

public class LocaWriter extends FontFormatWriter
{
    public ArrayList<Integer> m_offsets;
    
    public LocaWriter() {
        this.m_offsets = new ArrayList<Integer>();
    }
    
    @Override
    public void write() throws IOException {
        for (int i = 0; i < this.m_offsets.size(); ++i) {
            this.writeUInt32(this.m_offsets.get(i));
        }
        this.pad();
    }
    
    @Override
    protected String getTag() {
        return "loca";
    }
}
