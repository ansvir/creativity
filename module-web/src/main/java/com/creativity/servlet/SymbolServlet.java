package com.creativity.servlet;

import entity.Symbol;
import service.SymbolEJB;
import utils.CommonUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("symbol/figures/*")
public class SymbolServlet extends HttpServlet {

    @Inject
    SymbolEJB symbolEJB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String imageName = request.getPathInfo().substring(1);
        Symbol symbol = new Symbol();
        symbol.setId(Long.parseLong(imageName));
        byte[] figure = symbolEJB.findSymbol(symbol).getFigure();
        response.setContentType(getServletContext().getMimeType(imageName));
        response.setContentLength(figure.length);
        response.getOutputStream().write(figure);
    }
}
