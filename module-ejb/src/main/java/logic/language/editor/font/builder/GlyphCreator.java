package logic.language.editor.font.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import name.suchanek.doubletype.FontFormatWriter;
import java.awt.Point;
import name.suchanek.doubletype.TTGlyph;

public class GlyphCreator
{
    protected static TTGlyph glyph(final char c, final double width, final String path) {
        final TTGlyph glyph = new TTGlyph();
        glyph.setAdvanceWidth((int)width * 2);
        final Point point = new Point(0, 0);
        boolean hasContours = false;
        String[] split;
        for (int length = (split = path.split("z")).length, i = 0; i < length; ++i) {
            final String contour = split[i];
            final Matcher m2 = SvgFont.pathPattern.matcher(contour);
            final int numPoints = glyph.getNumOfPoints();
            while (m2.find()) {
                hasContours = true;
                final char command = m2.group(1).charAt(0);
                final List<Double> numbers = getNumbers(m2.group(2));
                switch (command) {
                    case 'L':
                    case 'M':
                    case 'l':
                    case 'm': {
                        if (numbers.size() != 2) {
                            FontFormatWriter.warning("Invalid numbers in glyph", FontFormatWriter.toString(c), "at command", command, m2.group(2));
                            continue;
                        }
                        for (Double number : numbers) {
                            System.out.println(number);
                        }
                        final int x = numbers.get(0).intValue() * 2;
                        final int y = numbers.get(1).intValue() * 2;
                        if (Character.isLowerCase(command)) {
                            point.setLocation(x + point.x, y + point.y);
                        }
                        else {
                            point.setLocation(x, y);
                        }
                        glyph.addPoint(new Point(point.x, point.y));
                        glyph.addFlag(1);
                        continue;
                    }
                    case 'A':
                    case 'a':
                    case 'C':
                    case 'c': {
                        if (numbers.size() != 7 && numbers.size() != 6) {
                            FontFormatWriter.warning("Invalid numbers in glyph", FontFormatWriter.toString(c), "at command", command, m2.group(2));
                            continue;
                        }
                        final double x2 = point.x / 2.0;
                        final double y2 = point.y / 2.0;
                        final double rx = numbers.get(0);
                        final double ry = numbers.get(1);
                        final double rotation = numbers.get(2);
                        final double largeflag = numbers.get(3);
                        final double sweepflag = numbers.get(4);
                        double x3 = numbers.get(5);
                        double y3 = numbers.get(6);
                        if (Character.isLowerCase(command)) {
                            x3 += x2;
                            y3 += y2;
                        }
                        if (rotation != 0.0) {
                            FontFormatWriter.warning("Unsupported rotation in glyph", FontFormatWriter.toString(c), ":", m2.group());
                        }
                        if (rx != ry) {
                            FontFormatWriter.warning("Unsupported elliptic curve in glyph", FontFormatWriter.toString(c), ":", m2.group());
                        }
                        final Arc arc = new Arc(x2, y2, x3, y3, rx, ry, sweepflag, largeflag);
                        if (!arc.isOK()) {
                            FontFormatWriter.warning("Pathological arc in glyph", FontFormatWriter.toString(c), ":", m2.group(), arc);
                        }
                        else {
                            for (final double[] bezier : arc.asBezier()) {
                                glyph.addPoint(new Point((int)bezier[0] * 2, (int)bezier[1] * 2));
                                glyph.addFlag((int)bezier[2]);
                            }
                        }
                        point.setLocation(x3 * 2.0, y3 * 2.0);
                        continue;
                    }
                    default: {
                        FontFormatWriter.warning("Unsupported path command in glyph", c, (int)c, ":", m2.group());
                        continue;
                    }
                }
            }
            if (numPoints < glyph.getNumOfPoints()) {
                glyph.addEndPoint(glyph.getNumOfPoints() - 1);
            }
        }
        if (hasContours && glyph.getNumOfContours() == 0) {
            return null;
        }
        return glyph;
    }
    
    public static TTGlyph makeGlyph(final char c, final SvgFont svgFont) {
        final String svgPath = svgFont.pathOf(c);
        if (svgPath == null) {
            FontFormatWriter.warning("No glyph defined for", FontFormatWriter.toString(c));
            return null;
        }
        final double width = svgFont.widthFor(c);
        final TTGlyph glyph = glyph(c, width, svgPath);
        return glyph;
    }
    
    public static List<Double> getNumbers(final String string) {
        final List<Double> result = new ArrayList<Double>();
        final Matcher m = SvgFont.numberPattern.matcher(string);
        while (m.find()) {
            result.add(Double.parseDouble(m.group()));
        }
        return result;
    }
}
