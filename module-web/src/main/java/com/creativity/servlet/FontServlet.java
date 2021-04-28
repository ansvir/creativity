package com.creativity.servlet;

import entity.Symbol;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import service.SymbolEJB;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Stream;

@WebServlet("font/file.svg")
public class FontServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File("../../../module-web/src/main/webapp/static/fonts/svgFont.svg");
        byte[] fileArray = FileUtils.readFileToByteArray(file);
        response.getWriter().println(new String(fileArray, StandardCharsets.UTF_8));
    }
}
