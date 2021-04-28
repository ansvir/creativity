// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.util.Iterator;
import java.io.IOException;
import java.util.Calendar;
import java.util.ArrayList;

public class NameWriter extends FontFormatWriter
{
    public static final String k_regular = "Regular";
    private static final String k_utf16be = "UTF-16BE";
    private static final String k_iso8859_1 = "ISO-8859-1";
    String m_sample;
    protected String fontName;
    protected String designer;
    protected String designerUrl;
    protected String license;
    protected String licenseUrl;
    private ArrayList<TTName> m_names;
    
    public NameWriter() {
        this.m_sample = "The quick brown fox jumps over the lazy dog.";
        this.fontName = "Test";
        this.designer = null;
        this.designerUrl = null;
        this.license = "CC-BY";
        this.licenseUrl = "http://creativecommons.org/licenses/by/4.0/";
        this.m_names = new ArrayList<TTName>();
    }
    
    public void setNames(final String fontName, final String designer, final String designerUrl) {
        this.fontName = fontName;
        this.designer = designer;
        this.designerUrl = designerUrl;
    }
    
    private void prepare() {
        this.m_names.clear();
        this.addNames();
    }
    
    private void addNames() {
        final Calendar now = Calendar.getInstance();
        final int year = now.get(1);
        final int month = now.get(2);
        final int day = now.get(5);
        this.addName(0, "© " + year + " " + this.designer);
        this.addName(1, this.fontName);
        this.addName(2, "regular");
        this.addName(3, String.valueOf(this.fontName) + " regular");
        this.addName(4, this.fontName);
        this.addName(5, "Version " + year + "-" + month + "-" + day);
        this.addName(6, this.fontName.replaceAll("[^A-Za-z0-9]", ""));
        this.addName(7, "n/a");
        this.addName(8, "n/a");
        if (this.designer != null) {
            this.addName(9, this.designer);
        }
        if (this.designerUrl != null) {
            this.addName(12, this.designerUrl);
        }
        if (this.designer != null) {
            this.addName(13, this.license);
        }
        if (this.designer != null) {
            this.addName(14, this.licenseUrl);
        }
        this.addName(19, this.m_sample);
    }
    
    private void addName(final int a_nameId, String a_value) {
        if (a_value.isEmpty()) {
            a_value = "NA";
        }
        try {
            this.add(0, 0, 0, a_nameId, a_value.getBytes("UTF-16BE"));
            this.add(1, 0, 0, a_nameId, a_value.getBytes("ISO-8859-1"));
            this.add(3, 1, 1033, a_nameId, a_value.getBytes("UTF-16BE"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void addMicrosoftUnicodeEnglish(final int a_nameId, final String a_value) {
        try {
            this.add(3, 1, 1033, a_nameId, a_value.getBytes("UTF-16BE"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void add(final int a_platformId, final int a_encodingId, final int a_languageId, final int a_nameId, final byte[] a_bytes) {
        final TTName name = new TTName(a_platformId, a_encodingId, a_languageId, a_nameId, a_bytes);
        this.m_names.add(name);
    }
    
    @Override
    public void write() throws IOException {
        this.prepare();
        this.writeUInt16(0);
        this.writeUInt16(this.m_names.size());
        this.writeUInt16(12 * this.m_names.size() + 6);
        int offset = 0;
        for (final TTName name : this.m_names) {
            this.writeUInt16(name.getPlatformId());
            this.writeUInt16(name.getEncodingId());
            this.writeUInt16(name.getLanguageId());
            this.writeUInt16(name.getNameId());
            this.writeUInt16(name.getStringLength());
            this.writeUInt16(offset);
            offset += name.getStringLength();
        }
        for (final TTName name : this.m_names) {
            this.m_buffer.write(name.getBytes());
        }
        this.pad();
    }
    
    @Override
    protected String getTag() {
        return "name";
    }
}
