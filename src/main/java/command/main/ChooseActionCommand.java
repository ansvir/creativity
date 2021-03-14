package command.main;

import command.Command;
import resource.PagesManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChooseActionCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String page;
        String actionCode = request.getParameter("actionCode");
        switch (actionCode) {
            case "generateNameSettings": {
                page = PagesManager.getProperty("page.generateNameSettings");
                return page;
            }
            case "generateName": {
                page = PagesManager.getProperty("page.generateName");
                return page;
            }
            default: {
                return PagesManager.getProperty("page.error");
            }
        }
    }
}
