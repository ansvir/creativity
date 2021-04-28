// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;

public class KernWriter extends FontFormatWriter
{
    protected CmapWriter cmapWriter;
    protected Map<Character, Map<Character, Integer>> kerning;
    protected int numKern;
    
    public KernWriter(final CmapWriter cmapWriter) {
        this.kerning = new TreeMap<Character, Map<Character, Integer>>();
        this.numKern = 0;
        this.cmapWriter = cmapWriter;
    }
    
    public void addKerning(final char c1, final char c2, final int kern) {
        Map<Character, Integer> map = this.kerning.get(c1);
        if (map == null) {
            this.kerning.put(c1, map = new TreeMap<Character, Integer>());
        }
        if (map.put(c2, kern) == null) {
            ++this.numKern;
        }
    }
    
    @Override
    public void write() throws IOException {
        this.writeUInt16(0);
        this.writeUInt16(1);
        this.writeUInt16(0);
        this.writeUInt16(14 + this.numKern * 3 * 2);
        this.writeUInt16(1);
        this.writeUInt16(this.numKern);
        this.writeUInt16(getSearchRange(this.numKern) * 6);
        this.writeUInt16(getEntrySelector(this.numKern));
        this.writeUInt16((this.numKern - getSearchRange(this.numKern)) * 6);
        int counter = 0;
        for (final Character c1 : this.kerning.keySet()) {
            final Map<Character, Integer> map = this.kerning.get(c1);
            for (final Character c2 : map.keySet()) {
                final int i1 = (int)this.cmapWriter.getGlyfIndex((long)c1);
                if (i1 == 0) {
                    FontFormatWriter.warning("Undefined first character in kerning:", FontFormatWriter.toString(c1));
                }
                this.writeUInt16(i1);
                final int i2 = (int)this.cmapWriter.getGlyfIndex((long)c2);
                if (i2 == 0) {
                    FontFormatWriter.warning("Undefined second character in kerning:", FontFormatWriter.toString(c2));
                }
                this.writeUInt16(i2);
                final int kern = map.get(c2);
                this.writeFWord(kern);
                ++counter;
            }
        }
        if (counter != this.numKern) {
            FontFormatWriter.warning("Kern counting problem:", counter, this.numKern);
        }
        this.pad();
    }
    
    public static int getSearchRange(final int a_value) {
        final int retval = (int)Math.pow(2.0, Math.floor(Math.log(a_value) / Math.log(2.0)));
        return retval;
    }
    
    public static int getEntrySelector(final int a_value) {
        final int retval = (int)Math.floor(Math.log(a_value) / Math.log(2.0));
        return retval;
    }
    
    @Override
    protected String getTag() {
        return "kern";
    }
}
