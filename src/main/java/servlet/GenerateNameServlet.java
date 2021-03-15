package servlet;

import logic.nameGeneration.Letter;
import logic.nameGeneration.NameGenerationLogic;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
        HttpSession session = request.getSession();
        NameGenerationLogic nameGenerationLogic = new NameGenerationLogic((List<Letter>) session.getAttribute("letterList"), (int) session.getAttribute("nameLength"));
        String generatedName = nameGenerationLogic.generateName();
        String generatedLastName = nameGenerationLogic.generateName();
        response.setContentType("text/plain");
        response.getWriter().write(generatedName+" "+generatedLastName);
    }


}
