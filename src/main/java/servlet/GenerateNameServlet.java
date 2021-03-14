package servlet;


import command.Command;
import factory.ActionFactory;
import logic.nameGeneration.NameGeneration;
import resource.MessageManager;
import resource.PagesManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static logic.nameGeneration.Alphabet.ALPHABET;

public class GenerateNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String generatedName = new NameGeneration().generateName();
        response.setContentType("text/plain");
        response.getWriter().write(generatedName);
    }


}
