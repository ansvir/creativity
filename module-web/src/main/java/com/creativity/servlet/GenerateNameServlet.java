package com.creativity.servlet;

import logic.name.generation.Letter;
import logic.name.generation.NameGenerationLogic;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GenerateNameServlet extends HttpServlet {

    @Inject
    private NameGenerationLogic nameGenerationLogic;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        List<Letter> letterList = (List<Letter>) session.getAttribute("letterList");
        int nameLength = (Integer) session.getAttribute("nameLength");
        boolean generateLastName = (Boolean) session.getAttribute("generateLastName");
        System.out.println(generateLastName);
        nameGenerationLogic.setLetters(letterList);
        nameGenerationLogic.setNameLength(nameLength);
        nameGenerationLogic.setGenerateLastName(generateLastName);
        System.out.println(nameGenerationLogic.getGenerateLastName());
        String generatedName = nameGenerationLogic.generateName();
        response.setContentType("text/plain");
        response.getWriter().write(generatedName);
    }
}
