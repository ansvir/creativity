package main;

import com.cloudconvert.client.CloudConvertClient;
import com.cloudconvert.client.setttings.StringSettingsProvider;
import com.cloudconvert.dto.request.ConvertFilesTaskRequest;
import com.cloudconvert.dto.request.UrlExportRequest;
import com.cloudconvert.dto.request.UrlImportRequest;
import com.cloudconvert.dto.response.JobResponse;
import com.cloudconvert.dto.response.TaskResponse;
import com.google.common.collect.ImmutableMap;
import com.google.typography.font.sfntly.Font;
import com.google.typography.font.sfntly.FontFactory;
import fontastic.Fontastic;
import logic.language.editor.font.builder.FontBuilder;
import logic.language.editor.font.builder.ImageConverter;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.anim.dom.SVGOMDocument;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGPath;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.doubletype.ossa.Engine;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import potrace.compat.ConvertToJavaCurves;
import potrace.compat.PathElement;
import potrace.potracej.Bitmap;
import potrace.potracej.PoTraceJ;
import potrace.potracej.param_t;
import potrace.potracej.path_t;
import processing.core.PApplet;
import sun.nio.ch.IOUtil;
import utils.CommonUtils;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        byte[] aFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/a.png");
        byte[] bFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/b.png");
        byte[] cFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/c.png");
        byte[] dFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/d.png");
        byte[] eFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/e.png");
        byte[] fFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/f.png");
        byte[] gFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/g.png");
        byte[] hFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/h.png");
        byte[] iFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/i.png");
        byte[] jFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/j.png");
        byte[] kFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/k.png");
        byte[] lFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/l.png");
        byte[] mFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/m.png");
        byte[] nFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/n.png");
        byte[] oFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/o.png");
        byte[] pFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/p.png");
        byte[] qFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/q.png");
        byte[] rFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/r.png");
        byte[] sFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/s.png");
        byte[] tFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/t.png");
        byte[] uFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/u.png");
        byte[] vFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/v.png");
        byte[] wFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/w.png");
        byte[] xFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/x.png");
        byte[] yFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/y.png");
        byte[] zFigure = CommonUtils.fileToByteArray("module-ejb/src/main/resources/defaultSymbols/z.png");

        byte[] aSvg = ImageConverter.convertRasterToSVG(aFigure);
        byte[] bSvg = ImageConverter.convertRasterToSVG(bFigure);
        byte[] cSvg = ImageConverter.convertRasterToSVG(cFigure);
        byte[] dSvg = ImageConverter.convertRasterToSVG(dFigure);
        byte[] eSvg = ImageConverter.convertRasterToSVG(eFigure);
        byte[] fSvg = ImageConverter.convertRasterToSVG(fFigure);
        byte[] gSvg = ImageConverter.convertRasterToSVG(gFigure);
        byte[] hSvg = ImageConverter.convertRasterToSVG(hFigure);
        byte[] iSvg = ImageConverter.convertRasterToSVG(iFigure);
        byte[] jSvg = ImageConverter.convertRasterToSVG(jFigure);
        byte[] kSvg = ImageConverter.convertRasterToSVG(kFigure);
        byte[] lSvg = ImageConverter.convertRasterToSVG(lFigure);
        byte[] mSvg = ImageConverter.convertRasterToSVG(mFigure);
        byte[] nSvg = ImageConverter.convertRasterToSVG(nFigure);
        byte[] oSvg = ImageConverter.convertRasterToSVG(oFigure);
        byte[] pSvg = ImageConverter.convertRasterToSVG(pFigure);
        byte[] qSvg = ImageConverter.convertRasterToSVG(qFigure);
        byte[] rSvg = ImageConverter.convertRasterToSVG(rFigure);
        byte[] sSvg = ImageConverter.convertRasterToSVG(sFigure);
        byte[] tSvg = ImageConverter.convertRasterToSVG(tFigure);
        byte[] uSvg = ImageConverter.convertRasterToSVG(uFigure);
        byte[] vSvg = ImageConverter.convertRasterToSVG(vFigure);
        byte[] wSvg = ImageConverter.convertRasterToSVG(wFigure);
        byte[] xSvg = ImageConverter.convertRasterToSVG(xFigure);
        byte[] ySvg = ImageConverter.convertRasterToSVG(yFigure);
        byte[] zSvg = ImageConverter.convertRasterToSVG(zFigure);

        List<byte[]> svgs = new ArrayList<>();
        svgs.add(aSvg); svgs.add(bSvg); svgs.add(cSvg); svgs.add(dSvg); svgs.add(eSvg); svgs.add(fSvg); svgs.add(gSvg);
        svgs.add(hSvg); svgs.add(iSvg);svgs.add(jSvg); svgs.add(kSvg); svgs.add(lSvg); svgs.add(mSvg); svgs.add(nSvg);
        svgs.add(oSvg); svgs.add(pSvg); svgs.add(qSvg); svgs.add(rSvg); svgs.add(sSvg); svgs.add(tSvg); svgs.add(uSvg);
        svgs.add(vSvg); svgs.add(wSvg); svgs.add(xSvg); svgs.add(ySvg); svgs.add(zSvg);
        
        File font = FontBuilder.buildSVGFont(svgs);
    }
}
