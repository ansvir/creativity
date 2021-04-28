package logic.language.editor.font.builder;

import java.awt.Point;
import name.suchanek.doubletype.TTGlyph;

public class DefaultGlyphs
{
    public static TTGlyph undef() {
        final TTGlyph g = new TTGlyph();
        g.setAdvanceWidth(400);
        g.addPoint(new Point(0, 400));
        g.addFlag(1);
        g.addPoint(new Point(400, 400));
        g.addFlag(1);
        g.addPoint(new Point(400, 0));
        g.addFlag(1);
        g.addPoint(new Point(0, 0));
        g.addFlag(1);
        g.addEndPoint(3);
        return g;
    }
    
    public static TTGlyph nullGlyph() {
        final TTGlyph g = new TTGlyph();
        g.setAdvanceWidth(0);
        return g;
    }
    
    public static TTGlyph spaceGlyph() {
        final TTGlyph g = new TTGlyph();
        g.setAdvanceWidth(400);
        return g;
    }
}
