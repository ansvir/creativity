package com.creativity.servlet;

import command.Command;
import command.qualifiers.EmptyCommandQualifier;
import factory.CommandFactory;
import resource.MessageManager;
import resource.PagesManager;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreativityServlet extends HttpServlet {

    @Inject
    @EmptyCommandQualifier
    private Command command;

    @Inject
    private CommandFactory commandFactory;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("command");
        try {
            command = commandFactory.defineCommand(action);
        } catch (IllegalArgumentException e) {
            request.setAttribute("msg", action + " " + MessageManager.getProperty("message.wrongaction"));
        }
        String page;
        try {
            page = command.execute(request, response);
        } catch (IOException e) {
            page = PagesManager.getProperty("page.error");
        }
        if (page != null) {
            if (page.equals("not redirecting")) {
                return;
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = PagesManager.getProperty("page.index");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}