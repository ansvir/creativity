package logic.language.editor.font.builder;

import com.google.typography.font.sfntly.Font;
import com.google.typography.font.sfntly.FontFactory;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.anim.dom.SVGOMDocument;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGPath;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import potrace.compat.ConvertToJavaCurves;
import potrace.compat.PathElement;
import potrace.potracej.Bitmap;
import potrace.potracej.PoTraceJ;
import potrace.potracej.param_t;
import potrace.potracej.path_t;
import utils.CommonUtils;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;

public class ImageConverter {
    private static param_t param = new param_t();
    private static Bitmap bmp;
    private static BufferedImage result;
    private static final double scale = 3;
    private static GeneralPath path;
    private static ByteArrayOutputStream baos;
    public static byte[] convertRasterToSVG(byte[] sourceArray) {
        path = new GeneralPath();
        baos = new ByteArrayOutputStream();
        BufferedImage sourceImage = CommonUtils.convertByteArrayToBufferedImage(sourceArray);
        WritableRaster raster = sourceImage.getRaster();
        int[] iarr = new int[4];
        bmp = new Bitmap((sourceImage.getWidth()), (sourceImage.getHeight()));
        for(int y=0; y<sourceImage.getHeight(); y++) {
            for(int x=0; x<sourceImage.getWidth(); x++) {
                int[] pixel = raster.getPixel(x, y, iarr);
                if (pixel[0] + pixel[1] + pixel[2] + pixel[3] != 0) {
                    bmp.put(x, y, 1);
                }
            }
        }

        doTrace();

        SVGOMDocument document = createSvgDocument(640,500);
        putPathToSvgDocument(document, path);
        byte[] outputBytes = null;
        try {
            saveSvgDocumentToBytesArray(document);
            outputBytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputBytes;
    }

    private static void doTrace() {
        PoTraceJ poTraceJ = new PoTraceJ(param);
        path_t trace;
        trace = poTraceJ.trace(bmp);
        ArrayList<PathElement> pathElements = new ArrayList<>();
        ConvertToJavaCurves.convert(trace, new HashSet<>(), pathElements);

        if (result != null) {
            result.flush();
        }
        result = new BufferedImage((int)(scale * bmp.getWidth()), (int)(scale * bmp.getHeight()), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = (Graphics2D) result.getGraphics();
        g2.scale(scale,scale);
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, bmp.getWidth(), bmp.getHeight());
        g2.setColor(Color.BLACK);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        for (PathElement pathElement : pathElements) {
            switch (pathElement.getType()) {
                case CLOSE_PATH:
                    path.closePath();
                    break;
                case LINE_TO:
                    path.lineTo(pathElement.getP0x(), pathElement.getP0y());
                    break;
                case MOVE_TO:
                    path.moveTo(pathElement.getP0x(), pathElement.getP0y());
                    break;
                case CURVE_TO:
                    path.curveTo(pathElement.getP0x(), pathElement.getP0y(), pathElement.getP1x(), pathElement.getP1y(), pathElement.getP2x(), pathElement.getP2y());
                    break;
            }
        }

//        AffineTransform at = g2.getTransform();
//        AffineTransform translate = AffineTransform.getTranslateInstance(0.0, -500.0);
//        g2.transform(translate);
//        AffineTransform scale = AffineTransform.getScaleInstance(1.0, -1.0);
//        g2.transform(scale);
//        g2.setTransform(at);

//        AffineTransform transformation = AffineTransform.getScaleInstance(1, -1);
//        transformation.translate(0, -result.getHeight(null));

//        AffineTransform transformation = new AffineTransform();
//        transformation.scale(1.0, -1.0);
//        transformation.translate(0.0, -result.getHeight());
//        path.transform(transformation);

        g2.setPaint(Color.black);
        g2.fill(path);


//        AffineTransform aT = g2.getTransform();Rectangle2D rect = new Rectangle2D.Float(1.0,1.0,2.0,3.0);
//        AffineTransform rotate45 =
//                AffineTransform.getRotateInstance(Math.PI/4.0,0.0,0.0)
//        g2.transform(rotate45);
//        g2.draw(rect);g2.setTransform(aT);

    }

    private static SVGOMDocument createSvgDocument(int width, int height) {
        DOMImplementation domImpl = SVGDOMImplementation.getDOMImplementation();
        SVGOMDocument document = (SVGOMDocument) domImpl.createDocument(SVGDOMImplementation.SVG_NAMESPACE_URI, "svg", null);
        Element svgTag = document.getRootElement();
        svgTag.setAttribute("width", String.valueOf(width));
        svgTag.setAttribute("height", String.valueOf(height));
        return document;
    }

    private static void putPathToSvgDocument(SVGOMDocument document, GeneralPath path) {
        SVGGeneratorContext ctx = SVGGeneratorContext.createDefault(document);
        SVGPath svgPath = new SVGPath(ctx);
        Element svgElement = svgPath.toSVG(path);
        svgElement.setAttribute("fill", "#000");
//        svgElement.setAttribute("transform", "scale(1, -1), translate(0, -500)");
        document.getRootElement().appendChild(svgElement);
    }

    private static void saveSvgDocumentToBytesArray(SVGOMDocument document) throws IOException {
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        try (Writer out = new OutputStreamWriter(baos, StandardCharsets.UTF_8)) {
            svgGenerator.stream(document.getDocumentElement(), out);
        }
    }

}
