package servlet;

import command.Command;
import factory.ActionFactory;
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

public class ProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.setAttribute("alphabet", ALPHABET.getLetters().split("\\|"));
        ActionFactory client = new ActionFactory();
        Command command = client.defineCommand(request);
        String page;
        try {
            page = command.execute(request, response, session);
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