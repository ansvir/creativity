package listeners;

import logic.name.generation.Letter;
import logic.name.generation.Name;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

import static logic.name.generation.Alphabet.CONSONANTS;
import static logic.name.generation.Alphabet.VOWELS;

@WebListener
public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent e) {
        HttpSession session = e.getSession();
        List<Letter> letters = Letter.getDefaultLetterSettingsList();
        session.setAttribute("letterList", letters);
        session.setAttribute("letterListString", Letter.convertLetterListToArrayOfJsonObjectsString(letters));
        session.setAttribute("nameLength", Name.getDefaultNameLength());
        session.setAttribute("vowels", VOWELS.getLetters());
        session.setAttribute("consonants", CONSONANTS.getLetters());
        session.setAttribute("passedAuth", null);
        session.setAttribute("generateLastName", Name.getDefaultGenerateLastName());
    }
    public void sessionDestroyed(HttpSessionEvent e) {
    }
}
