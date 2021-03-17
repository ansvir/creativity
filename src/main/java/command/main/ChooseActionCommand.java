package command.main;

import command.Command;
import command.qualifiers.ChooseActionCommandQualifier;
import resource.PagesManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ChooseActionCommandQualifier
public class ChooseActionCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
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
