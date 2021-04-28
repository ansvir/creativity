package logic.language.editor.font.builder;

import com.google.typography.font.sfntly.FontFactory;
import com.google.typography.font.sfntly.data.WritableFontData;
import com.sun.javafx.css.converters.FontConverter;
import fontastic.Fontastic;
import logic.language.editor.font.builder.schema.svg.Path;
import logic.language.editor.font.builder.schema.svgfont.*;
import logic.language.editor.font.converter.ConvertFont;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.doubletype.ossa.Engine;
import org.xml.sax.SAXException;
import processing.core.PApplet;
import utils.CommonUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FontBuilder {
    public static File buildSVGFont(List<byte[]> svgs) {
        List<String> paths = new ArrayList<>();
        try {
            XMLHandler xmlHandler = new XMLHandler();
            for (byte[] svg : svgs) {
                InputStream is = new ByteArrayInputStream(svg);
                paths.add(xmlHandler.parsePath(is));
            }
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        MissingGlyph missingGlyph = new MissingGlyph();

        Glyph aGlyph = new Glyph();
        aGlyph.setUnicode("a");
        aGlyph.setD(paths.get(0));
        Glyph bGlyph = new Glyph();
        bGlyph.setUnicode("b");
        bGlyph.setD(paths.get(1));
        Glyph cGlyph = new Glyph();
        cGlyph.setUnicode("c");
        cGlyph.setD(paths.get(2));
        Glyph dGlyph = new Glyph();
        dGlyph.setUnicode("d");
        dGlyph.setD(paths.get(3));
        Glyph eGlyph = new Glyph();
        eGlyph.setUnicode("e");
        eGlyph.setD(paths.get(4));
        Glyph fGlyph = new Glyph();
        fGlyph.setUnicode("f");
        fGlyph.setD(paths.get(5));
        Glyph gGlyph = new Glyph();
        gGlyph.setUnicode("g");
        gGlyph.setD(paths.get(6));
        Glyph hGlyph = new Glyph();
        hGlyph.setUnicode("h");
        hGlyph.setD(paths.get(7));
        Glyph iGlyph = new Glyph();
        iGlyph.setUnicode("i");
        iGlyph.setD(paths.get(8));
        Glyph jGlyph = new Glyph();
        jGlyph.setUnicode("j");
        jGlyph.setD(paths.get(9));
        Glyph kGlyph = new Glyph();
        kGlyph.setUnicode("k");
        kGlyph.setD(paths.get(10));
        Glyph lGlyph = new Glyph();
        lGlyph.setUnicode("l");
        lGlyph.setD(paths.get(11));
        Glyph mGlyph = new Glyph();
        mGlyph.setUnicode("m");
        mGlyph.setD(paths.get(12));
        Glyph nGlyph = new Glyph();
        nGlyph.setUnicode("n");
        nGlyph.setD(paths.get(13));
        Glyph oGlyph = new Glyph();
        oGlyph.setUnicode("o");
        oGlyph.setD(paths.get(14));
        Glyph pGlyph = new Glyph();
        pGlyph.setUnicode("p");
        pGlyph.setD(paths.get(15));
        Glyph qGlyph = new Glyph();
        qGlyph.setUnicode("q");
        qGlyph.setD(paths.get(16));
        Glyph rGlyph = new Glyph();
        rGlyph.setUnicode("r");
        rGlyph.setD(paths.get(17));
        Glyph sGlyph = new Glyph();
        sGlyph.setUnicode("s");
        sGlyph.setD(paths.get(18));
        Glyph tGlyph = new Glyph();
        tGlyph.setUnicode("t");
        tGlyph.setD(paths.get(19));
        Glyph uGlyph = new Glyph();
        uGlyph.setUnicode("u");
        uGlyph.setD(paths.get(20));
        Glyph vGlyph = new Glyph();
        vGlyph.setUnicode("v");
        vGlyph.setD(paths.get(21));
        Glyph wGlyph = new Glyph();
        wGlyph.setUnicode("w");
        wGlyph.setD(paths.get(22));
        Glyph xGlyph = new Glyph();
        xGlyph.setUnicode("x");
        xGlyph.setD(paths.get(23));
        Glyph yGlyph = new Glyph();
        yGlyph.setUnicode("y");
        yGlyph.setD(paths.get(24));
        Glyph zGlyph = new Glyph();
        zGlyph.setUnicode("z");
        zGlyph.setD(paths.get(25));

        List<Glyph> glyphs = new ArrayList<>();
        glyphs.add(aGlyph); glyphs.add(bGlyph); glyphs.add(cGlyph);
        glyphs.add(dGlyph); glyphs.add(eGlyph); glyphs.add(fGlyph);
        glyphs.add(gGlyph); glyphs.add(hGlyph); glyphs.add(iGlyph);
        glyphs.add(jGlyph); glyphs.add(kGlyph); glyphs.add(lGlyph);
        glyphs.add(mGlyph); glyphs.add(nGlyph); glyphs.add(oGlyph);
        glyphs.add(pGlyph); glyphs.add(qGlyph); glyphs.add(rGlyph);
        glyphs.add(sGlyph); glyphs.add(tGlyph); glyphs.add(uGlyph);
        glyphs.add(vGlyph); glyphs.add(wGlyph); glyphs.add(xGlyph);
        glyphs.add(yGlyph); glyphs.add(zGlyph);
        FontFace fontFace = new FontFace();
        Font font = new Font();
        font.setFontFace(fontFace);
        font.setMissingGlyph(missingGlyph);
        font.setGlyphs(glyphs);
        font.setId("user-font");
        Defs defs = new Defs();
        defs.setFont(font);
        Metadata metadata = new Metadata();
        SVG svg = new SVG();
        svg.setMetadata(metadata);
        svg.setDefs(defs);
        File output = null;
        try {
            output = new File("module-ejb/src/main/resources/tempSVG/svgFont.svg");
            JAXBContext jaxbContext = JAXBContext.newInstance(SVG.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(svg, output);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return output;
    }
}
