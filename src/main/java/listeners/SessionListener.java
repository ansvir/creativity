package listeners;

import logic.nameGeneration.Letter;
import logic.nameGeneration.Name;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent e) {
        HttpSession session = e.getSession();
        List<Letter> letters = Letter.getDefaultLetterSettingsList();
        session.setAttribute("letterList", letters);
        session.setAttribute("letterListString", Letter.convertLetterListToArrayOfJsonObjectsString(letters));
        session.setAttribute("nameLength", Name.getDefaultNameLength());
    }
    public void sessionDestroyed(HttpSessionEvent e) {
    }
}
