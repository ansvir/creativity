// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.util.Iterator;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class TTCodePage
{
    public static TTCodePage US_ASCII;
    public static TTCodePage Latin_1;
    private static boolean s_isInitialized;
    private static ArrayList<TTCodePage> s_list;
    private String m_name;
    private int m_osTwoFlag;
    private Charset m_charset;
    
    static {
        TTCodePage.US_ASCII = new TTCodePage("US-ASCII", "US-ASCII", 64);
        TTCodePage.Latin_1 = new TTCodePage("windows-1252", "Latin 1 windows-1252", 0);
        TTCodePage.s_isInitialized = false;
        TTCodePage.s_list = new ArrayList<TTCodePage>();
    }
    
    public static String[] getNames() {
        initList();
        final String[] retval = new String[TTCodePage.s_list.size()];
        for (int i = 0; i < TTCodePage.s_list.size(); ++i) {
            final TTCodePage codePage = TTCodePage.s_list.get(i);
            retval[i] = codePage.getName();
        }
        return retval;
    }
    
    public static TTCodePage forName(final String a_name) {
        initList();
        final TTCodePage retval = null;
        for (final TTCodePage codePage : TTCodePage.s_list) {
            if (codePage.getName().equals(a_name)) {
                return codePage;
            }
        }
        for (final TTCodePage codePage : TTCodePage.s_list) {
            if (codePage.getCharset() == null) {
                continue;
            }
            if (codePage.getCharset().name().equals(a_name)) {
                return codePage;
            }
        }
        return retval;
    }
    
    private static void initList() {
        if (TTCodePage.s_isInitialized) {
            return;
        }
        TTCodePage.s_isInitialized = true;
        TTCodePage.s_list.add(TTCodePage.US_ASCII);
        TTCodePage.s_list.add(TTCodePage.Latin_1);
        TTCodePage.s_list.add(new TTCodePage("ISO-2022-JP", "Japan-JIS", 17));
        TTCodePage.s_list.add(new TTCodePage("windows-1250", "Latin 2: Eastern Europe windows-1250", 1));
        TTCodePage.s_list.add(new TTCodePage("windows-1251", "Cyrillic windows-1251", 2));
        TTCodePage.s_list.add(new TTCodePage("windows-1253", "Greek windows-1253", 3));
        TTCodePage.s_list.add(new TTCodePage("windows-1254", "Turkish windows-1254", 4));
        TTCodePage.s_list.add(new TTCodePage("windows-1258", "Vietnamese windows-1258", 8));
        TTCodePage.s_list.add(new TTCodePage("windows-1255", "Hebrew windows-1255", 5));
        TTCodePage.s_list.add(new TTCodePage("windows-1256", "Arabic windows-1256", 6));
        TTCodePage.s_list.add(new TTCodePage("windows-1257", "Windows Baltic", 7));
        TTCodePage.s_list.add(new TTCodePage("Thai windows-874", 16));
        TTCodePage.s_list.add(new TTCodePage("x-mswin-936", "Chinese: Simplified", 18));
        TTCodePage.s_list.add(new TTCodePage("Korean Wansung", 19));
        TTCodePage.s_list.add(new TTCodePage("x-windows-950", "Chinese: Traditional", 20));
    }
    
    public TTCodePage(final String a_charsetName, final String a_name, final int a_osTwoFlag) {
        this.m_osTwoFlag = 0;
        this.m_charset = null;
        if (Charset.isSupported(a_charsetName)) {
            this.m_charset = Charset.forName(a_charsetName);
        }
        this.m_name = a_name;
        this.m_osTwoFlag = a_osTwoFlag;
    }
    
    public TTCodePage(final String a_name, final int a_osTwoFlag) {
        this.m_osTwoFlag = 0;
        this.m_charset = null;
        this.m_name = a_name;
        this.m_osTwoFlag = a_osTwoFlag;
    }
    
    @Override
    public String toString() {
        return this.m_name;
    }
    
    public String getName() {
        return this.m_name;
    }
    
    public Charset getCharset() {
        return this.m_charset;
    }
    
    public int getOsTwoFlag() {
        return this.m_osTwoFlag;
    }
}
