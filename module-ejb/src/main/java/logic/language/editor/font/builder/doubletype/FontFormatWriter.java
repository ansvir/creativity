// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.util.Date;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class FontFormatWriter
{
    protected DataOutputStream m_buffer;
    protected ByteArrayOutputStream m_bytes;
    private int m_offset;
    
    public FontFormatWriter() {
        this.init();
    }
    
    protected void init() {
        this.m_bytes = new ByteArrayOutputStream();
        this.m_buffer = new DataOutputStream(this.m_bytes);
        this.m_offset = 0;
    }
    
    public void write() throws IOException {
    }
    
    public byte[] toByteArray() {
        return this.m_bytes.toByteArray();
    }
    
    public int size() {
        return this.m_bytes.size();
    }
    
    public void reset() {
        this.m_bytes.reset();
    }
    
    protected void writeFixed32(final double a_value) throws IOException {
        final int k_denom = 16384;
        short mantissa = (short)Math.floor(a_value);
        int fraction = (int)((a_value - mantissa) * 16384.0);
        if (fraction > 16384) {
            fraction = 0;
            ++mantissa;
        }
        this.m_buffer.writeShort(mantissa);
        this.m_buffer.writeShort(fraction);
    }
    
    protected void writeUInt16(final int a_value) throws IOException {
        this.writeInt16((short)(0xFFFF & a_value));
    }
    
    protected void writeInt16(final int a_value) throws IOException {
        this.m_buffer.writeShort((short)a_value);
    }
    
    protected void writeFWord(final int a_value) throws IOException {
        this.writeInt16(a_value);
    }
    
    protected void writeUFWord(final int a_value) throws IOException {
        this.writeUInt16(a_value);
    }
    
    protected void writeUInt32(final long a_value) throws IOException {
        this.writeInt32((int)(-1L & a_value));
    }
    
    protected void writeInt32(final int a_value) throws IOException {
        this.m_buffer.writeInt(a_value);
    }
    
    protected void writeUInt8(final int a_byte) throws IOException {
        this.m_buffer.writeByte(a_byte);
    }
    
    protected void writeTag(final String a_value) throws IOException {
        final String s = String.valueOf(a_value) + "    ";
        for (int i = 0; i < 4; ++i) {
            this.writeUInt8(s.charAt(i));
        }
    }
    
    protected void writeLongDateTime(final Date a_date) throws IOException {
        long sec = a_date.getTime() / 1000L;
        sec += 2081376000L;
        this.m_buffer.writeLong(sec);
    }
    
    protected String getTag() {
        throw new RuntimeException("unimplemnted call to getTag");
    }
    
    protected long getCheckSum() {
        long retval = 0L;
        final byte[] bytes = this.toByteArray();
        for (int i = 0; i < bytes.length / 4; ++i) {
            long n = 0L;
            for (int j = 0; j < 4; ++j) {
                n += bytes[4 * i + j] << (4 - j) * 8;
            }
            retval += n;
        }
        return retval;
    }
    
    protected void pad() throws IOException {
        final int align = 4;
        final int numOfPad = align - this.toByteArray().length % align;
        if (numOfPad == align) {
            return;
        }
        for (int i = 0; i < numOfPad; ++i) {
            this.writeUInt8(0);
        }
    }
    
    public int getOffset() {
        return this.m_offset;
    }
    
    public void setOffset(final int a_value) {
        this.m_offset = a_value;
    }
    
    public static String toString(final char c) {
        if (c > ' ' && c < '\u007f') {
            return "'" + c + "'";
        }
        return "'" + c + "' (0x" + Integer.toHexString(c).toUpperCase() + ")";
    }
    
    public static void warning(final Object... s) {
        System.err.print("Warning:");
        for (final Object s2 : s) {
            System.err.print(" ");
            System.err.print(s2);
        }
        System.err.println();
    }
}
