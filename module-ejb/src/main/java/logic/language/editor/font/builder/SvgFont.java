package logic.language.editor.font.builder;

import java.util.regex.Matcher;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.IOException;
import name.suchanek.doubletype.FontFormatWriter;
import java.io.File;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class SvgFont
{
    public static final String NOPATH = "  \u00ad";
    public static Pattern glyphPattern;
    public static Pattern glyphContentPattern;
    public static Pattern pathPattern;
    public static Pattern numberPattern;
    public static Pattern kernPattern;
    public static Pattern fontPattern;
    protected TreeMap<Character, String> paths;
    protected TreeMap<Character, Double> widths;
    protected TreeMap<Character, Map<Character, Double>> kerns;
    protected double ascent;
    protected double descent;
    protected String name;
    
    static {
        SvgFont.glyphPattern = Pattern.compile("<glyph([^>]*)>");
        SvgFont.glyphContentPattern = Pattern.compile("unicode=\"([^']+)\" horiz-adv-x=\"([^']+)\" (?:d=\"([^']+)\")?");
        SvgFont.pathPattern = Pattern.compile("([a-zA-Z])\\s*([-0-9. ,]++)");
        SvgFont.numberPattern = Pattern.compile("[-0-9.]+");
        SvgFont.kernPattern = Pattern.compile("<hkern u1=\"([^']+)\" u2=\"([^']+)\" k=\"([^']+)\"");
        SvgFont.fontPattern = Pattern.compile("<font-face (?:font-(?:weight|style)=\"([^']+)\" )?font-family=\"([^']+)\" units-per-em=\"([^']+)\" ascent=\"([^']+)\" descent=\"([^']+)\"");
    }
    
    public double getAscent() {
        return this.ascent;
    }
    
    public double getDescent() {
        return this.descent;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Set<Character> characters() {
        return this.paths.keySet();
    }
    
    public String pathOf(final char c) {
        return this.paths.get(c);
    }
    
    public double widthFor(final char c) {
        return this.widths.get(c);
    }
    
    public Set<Character> kernings() {
        return this.kerns.keySet();
    }
    
    public Set<Character> kerningsOf(final char c) {
        return this.kerns.get(c).keySet();
    }
    
    public Double kerning(final char c1, final char c2) {
        final Map<Character, Double> map = this.kerns.get(c1);
        if (map == null) {
            return null;
        }
        return map.get(c2);
    }
    
    public SvgFont(final File file) throws IOException {
        this.paths = new TreeMap<Character, String>();
        this.widths = new TreeMap<Character, Double>();
        this.kerns = new TreeMap<Character, Map<Character, Double>>();
        this.ascent = 550.0;
        this.descent = -150.0;
        this.name = "Test Font";
        if (!file.getName().endsWith(".svg")) {
            FontFormatWriter.warning("Not an SVG font file:", file.getCanonicalPath());
            throw new IOException();
        }
        final String content = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
        final Matcher fontMatcher = SvgFont.fontPattern.matcher(content);
        if (fontMatcher.find()) {
            if (fontMatcher.group(1) == null) {
                this.name = fontMatcher.group(2);
            }
            else {
                this.name = String.valueOf(fontMatcher.group(2)) + " " + fontMatcher.group(1);
            }
            this.ascent = getDouble(fontMatcher.group(3));
            this.descent = getDouble(fontMatcher.group(4));
        }
        else {
            FontFormatWriter.warning("Cound not find pattern", "<font-face font-family='...' units-per-em='...' ascent='...' descent='...'");
        }
        final Matcher glypthMatcher = SvgFont.glyphPattern.matcher(content);
        while (glypthMatcher.find()) {
            final Matcher glyphContentMatcher = SvgFont.glyphContentPattern.matcher(glypthMatcher.group(1));
            if (!glyphContentMatcher.find()) {
                FontFormatWriter.warning("Glyph content should be unicode='...' horiz-adv-x='...' d='...', and not", glypthMatcher.group());
            }
            else {
                final char c = getChar(glyphContentMatcher.group(1));
                final double width = getDouble(glyphContentMatcher.group(2));
                String path = glyphContentMatcher.group(3);
                if (path == null) {
                    if ("  \u00ad".indexOf(c) == -1) {
                        FontFormatWriter.warning("No path for character", FontFormatWriter.toString(c));
                    }
                    path = "";
                }
                if (this.paths.containsKey(c)) {
                    FontFormatWriter.warning("Duplicate character:", FontFormatWriter.toString(c));
                }
                else {
                    this.paths.put(c, path);
                    this.widths.put(c, width);
                }
            }
        }
        if (this.paths.isEmpty()) {
            FontFormatWriter.warning("No <glyph> declaration found in file");
        }
        final Matcher kernMatcher = SvgFont.kernPattern.matcher(content);
        while (kernMatcher.find()) {
            final char c2 = getChar(kernMatcher.group(1));
            final char c3 = getChar(kernMatcher.group(2));
            final double kern = getDouble(kernMatcher.group(3));
            Map<Character, Double> map = this.kerns.get(c2);
            if (map == null) {
                this.kerns.put(c2, map = new TreeMap<Character, Double>());
            }
            map.put(c3, kern);
        }
    }
    
    public static char getChar(final String s) {
        try {
            if (s.startsWith("&#x")) {
                return (char)Integer.parseInt(s.substring(3, s.length() - 1), 16);
            }
            if (s.startsWith("&#")) {
                return (char)Integer.parseInt(s.substring(2, s.length() - 1), 10);
            }
            if (s.length() == 1) {
                return s.charAt(0);
            }
        }
        catch (NumberFormatException ex) {}
        FontFormatWriter.warning("Cannot parse char", s);
        return '\0';
    }
    
    public static double getDouble(final String s) {
        try {
            return Double.parseDouble(s);
        }
        catch (NumberFormatException e) {
            FontFormatWriter.warning("Unparsable number:", s);
            return 0.0;
        }
    }
}
