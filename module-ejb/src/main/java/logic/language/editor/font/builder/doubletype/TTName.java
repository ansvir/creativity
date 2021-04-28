// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

public class TTName
{
    public static final int k_unicode = 0;
    public static final int k_unicodeDefaultEncode = 0;
    public static final int k_macintosh = 1;
    public static final int k_macRomanEncode = 0;
    public static final int k_macEnglishLang = 0;
    public static final int k_microsoft = 3;
    public static final int k_winSymbolEncode = 0;
    public static final int k_winUnicodeEncode = 1;
    public static final int k_winShiftJisEncode = 2;
    public static final int k_winEnglishLang = 1033;
    private int m_platformId;
    private int m_encodingId;
    private int m_languageId;
    private int m_nameId;
    private byte[] m_bytes;
    
    public TTName(final int a_platformId, final int a_encodingId, final int a_languageId, final int a_nameId, final byte[] a_bytes) {
        this.m_platformId = a_platformId;
        this.m_encodingId = a_encodingId;
        this.m_languageId = a_languageId;
        this.m_nameId = a_nameId;
        this.m_bytes = a_bytes;
    }
    
    public int getPlatformId() {
        return this.m_platformId;
    }
    
    public int getEncodingId() {
        return this.m_encodingId;
    }
    
    public int getLanguageId() {
        return this.m_languageId;
    }
    
    public int getNameId() {
        return this.m_nameId;
    }
    
    public byte[] getBytes() {
        return this.m_bytes;
    }
    
    public int getStringLength() {
        return this.m_bytes.length;
    }
}
