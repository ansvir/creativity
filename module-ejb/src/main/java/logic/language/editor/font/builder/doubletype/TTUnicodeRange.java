// 
// Decompiled by Procyon v0.5.36
// 

package logic.language.editor.font.builder.doubletype;

import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

public class TTUnicodeRange implements Comparable
{
    public static final long k_notDef = 1L;
    public static final long k_null = 0L;
    public static final long k_cr = 13L;
    public static final long k_space = 32L;
    private static List<TTUnicodeRange> s_list;
    private String m_block;
    private long m_start;
    private long m_end;
    private int m_osTwoFlag;
    private int m_codePageFlag;
    
    static {
        TTUnicodeRange.s_list = Arrays.asList(new TTUnicodeRange("BASIC_LATIN", 32L, 127L, 0, 63), new TTUnicodeRange("LATIN_1_SUPPLEMENT", 128L, 255L, 1, 0), new TTUnicodeRange("LATIN_EXTENDED_A", 256L, 383L, 2), new TTUnicodeRange("LATIN_EXTENDED_B", 384L, 591L, 3), new TTUnicodeRange("IPA_EXTENSIONS", 592L, 687L, 4), new TTUnicodeRange("SPACING_MODIFIER_LETTERS", 688L, 767L, 5), new TTUnicodeRange("COMBINING_DIACRITICAL_MARKS", 768L, 879L, 6), new TTUnicodeRange("GREEK", 880L, 1023L, 7, 3), new TTUnicodeRange("CYRILLIC", 1024L, 1279L, 9, 2), new TTUnicodeRange("ARMENIAN", 1328L, 1423L, 10), new TTUnicodeRange("HEBREW", 1424L, 1535L, 11, 5), new TTUnicodeRange("ARABIC", 1536L, 1791L, 13, 6), new TTUnicodeRange("SYRIAC", 1792L, 1871L, 71), new TTUnicodeRange("THAANA", 1920L, 1983L, 72), new TTUnicodeRange("DEVANAGARI", 2304L, 2431L, 15), new TTUnicodeRange("BENGALI", 2432L, 2559L, 16), new TTUnicodeRange("GURMUKHI", 2560L, 2687L, 17), new TTUnicodeRange("GUJARATI", 2688L, 2815L, 18), new TTUnicodeRange("ORIYA", 2816L, 2943L, 19), new TTUnicodeRange("TAMIL", 2944L, 3071L, 20), new TTUnicodeRange("TELUGU", 3072L, 3199L, 21), new TTUnicodeRange("KANNADA", 3200L, 3327L, 22), new TTUnicodeRange("MALAYALAM", 3328L, 3455L, 23), new TTUnicodeRange("SINHALA", 3456L, 3583L, 73), new TTUnicodeRange("THAI", 3584L, 3711L, 24, 16), new TTUnicodeRange("LAO", 3712L, 3839L, 25), new TTUnicodeRange("TIBETAN", 3840L, 4095L, 70), new TTUnicodeRange("MYANMAR", 4096L, 4255L, 74), new TTUnicodeRange("GEORGIAN", 4256L, 4351L, 26), new TTUnicodeRange("HANGUL_JAMO", 4352L, 4607L, 28, 19), new TTUnicodeRange("ETHIOPIC", 4608L, 4991L, 75), new TTUnicodeRange("CHEROKEE", 5024L, 5119L, 76), new TTUnicodeRange("UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS", 5120L, 5759L, 77), new TTUnicodeRange("OGHAM", 5760L, 5791L, 78), new TTUnicodeRange("RUNIC", 5792L, 5887L, 79), new TTUnicodeRange("KHMER", 6016L, 6143L, 80), new TTUnicodeRange("MONGOLIAN", 6144L, 6319L, 81), new TTUnicodeRange("LATIN_EXTENDED_ADDITIONAL", 7680L, 7935L, 29), new TTUnicodeRange("GREEK_EXTENDED", 7936L, 8191L, 30), new TTUnicodeRange("GENERAL_PUNCTUATION", 8192L, 8303L, 31), new TTUnicodeRange("SUPERSCRIPTS_AND_SUBSCRIPTS", 8304L, 8351L, 32), new TTUnicodeRange("CURRENCY_SYMBOLS", 8352L, 8399L, 33), new TTUnicodeRange("COMBINING_MARKS_FOR_SYMBOLS", 8400L, 8447L, 34), new TTUnicodeRange("LETTERLIKE_SYMBOLS", 8448L, 8527L, 35), new TTUnicodeRange("NUMBER_FORMS", 8528L, 8591L, 36), new TTUnicodeRange("ARROWS", 8592L, 8703L, 37), new TTUnicodeRange("MATHEMATICAL_OPERATORS", 8704L, 8959L, 38), new TTUnicodeRange("MISCELLANEOUS_TECHNICAL", 8960L, 9215L, 39), new TTUnicodeRange("CONTROL_PICTURES", 9216L, 9279L, 40), new TTUnicodeRange("OPTICAL_CHARACTER_RECOGNITION", 9280L, 9311L, 41), new TTUnicodeRange("ENCLOSED_ALPHANUMERICS", 9312L, 9471L, 42), new TTUnicodeRange("BOX_DRAWING", 9472L, 9599L, 43), new TTUnicodeRange("BLOCK_ELEMENTS", 9600L, 9631L, 44), new TTUnicodeRange("GEOMETRIC_SHAPES", 9632L, 9727L, 45), new TTUnicodeRange("MISCELLANEOUS_SYMBOLS", 9728L, 9983L, 46), new TTUnicodeRange("DINGBATS", 9984L, 10175L, 47), new TTUnicodeRange("BRAILLE_PATTERNS", 10240L, 10495L, 82), new TTUnicodeRange("CJK_RADICALS_SUPPLEMENT", 11904L, 12031L, 59), new TTUnicodeRange("KANGXI_RADICALS", 12032L, 12255L, 59), new TTUnicodeRange("IDEOGRAPHIC_DESCRIPTION_CHARACTERS", 12272L, 12287L, 59), new TTUnicodeRange("CJK_SYMBOLS_AND_PUNCTUATION", 12288L, 12351L, 48), new TTUnicodeRange("HIRAGANA", 12352L, 12447L, 49, 17), new TTUnicodeRange("KATAKANA", 12448L, 12543L, 50, 17), new TTUnicodeRange("BOPOMOFO", 12544L, 12591L, 51), new TTUnicodeRange("HANGUL_COMPATIBILITY_JAMO", 12592L, 12687L, 52, 19), new TTUnicodeRange("KANBUN", 12688L, 12703L, 59), new TTUnicodeRange("BOPOMOFO_EXTENDED", 12704L, 12735L, 51), new TTUnicodeRange("KATAKANA_PHONETIC_EXTENSIONS", 12784L, 12799L, 50, 17), new TTUnicodeRange("ENCLOSED_CJK_LETTERS_AND_MONTHS", 12800L, 13055L, 54), new TTUnicodeRange("CJK_COMPATIBILITY", 13056L, 13311L, 55), new TTUnicodeRange("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A", 13312L, 19903L, 59), new TTUnicodeRange("CJK_UNIFIED_IDEOGRAPHS", 19968L, 40959L, 59, 17), new TTUnicodeRange("YI_SYLLABLES", 40960L, 42127L, 83), new TTUnicodeRange("YI_RADICALS", 42128L, 42191L, 83), new TTUnicodeRange("HANGUL_SYLLABLES", 44032L, 55215L, 56), new TTUnicodeRange("HIGH_SURROGATES", 55296L, 56191L, 0), new TTUnicodeRange("HIGH_PRIVATE_USE_SURROGATES", 56192L, 56319L, 0), new TTUnicodeRange("LOW_SURROGATES", 56320L, 57343L, 0), new TTUnicodeRange("PRIVATE_USE_AREA", 57344L, 63743L, 60), new TTUnicodeRange("CJK_COMPATIBILITY_IDEOGRAPHS", 63744L, 64255L, 61), new TTUnicodeRange("ALPHABETIC_PRESENTATION_FORMS", 64256L, 64335L, 62), new TTUnicodeRange("ARABIC_PRESENTATION_FORMS_A", 64336L, 65023L, 62), new TTUnicodeRange("COMBINING_HALF_MARKS", 65056L, 65071L, 64), new TTUnicodeRange("CJK_COMPATIBILITY_FORMS", 65072L, 65103L, 65), new TTUnicodeRange("SMALL_FORM_VARIANTS", 65104L, 65135L, 66), new TTUnicodeRange("ARABIC_PRESENTATION_FORMS_B", 65136L, 65279L, 67), new TTUnicodeRange("HALFWIDTH_AND_FULLWIDTH_FORMS", 65280L, 65519L, 68, 17), new TTUnicodeRange("SPECIALS", 65520L, 65535L, 69));
    }
    
    public static TTUnicodeRange of(final long a_unicode) {
        for (final TTUnicodeRange range : TTUnicodeRange.s_list) {
            if (range.contains(a_unicode)) {
                return range;
            }
        }
        return null;
    }
    
    public static TTUnicodeRange forName(final String blockName) {
        for (final TTUnicodeRange range : TTUnicodeRange.s_list) {
            if (range.m_block.equalsIgnoreCase(blockName)) {
                return range;
            }
        }
        return null;
    }
    
    public TTUnicodeRange(final String a_block, final long a_start, final long a_end, final int a_osTwoFlag) {
        this(a_block, a_start, a_end, a_osTwoFlag, 0);
    }
    
    public TTUnicodeRange(final String a_block, final long a_start, final long a_end, final int a_osTwoFlag, final int a_codePageFlag) {
        this.m_block = null;
        this.m_start = 0L;
        this.m_end = 0L;
        this.m_osTwoFlag = 0;
        this.m_codePageFlag = 0;
        this.m_block = a_block;
        this.m_start = a_start;
        this.m_end = a_end;
        this.m_osTwoFlag = a_osTwoFlag;
        this.m_codePageFlag = a_codePageFlag;
    }
    
    @Override
    public boolean equals(final Object a_object) {
        final TTUnicodeRange object = (TTUnicodeRange)a_object;
        return this.m_start == object.m_start;
    }
    
    @Override
    public int compareTo(final Object a_object) {
        final TTUnicodeRange object = (TTUnicodeRange)a_object;
        if (this.m_start < object.m_start) {
            return -1;
        }
        if (this.m_start == object.m_start) {
            return 0;
        }
        return 1;
    }
    
    public boolean contains(final long c) {
        return c >= this.m_start && c <= this.m_end;
    }
    
    @Override
    public String toString() {
        return this.m_block;
    }
    
    public long getStartCode() {
        return this.m_start;
    }
    
    public long getEndCode() {
        return this.m_end;
    }
    
    public int getOsTwoFlag() {
        return this.m_osTwoFlag;
    }
    
    public int getCodeRangeFlag() {
        return this.m_codePageFlag;
    }
}
