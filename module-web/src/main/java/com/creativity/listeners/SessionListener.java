package com.creativity.listeners;

import logic.language.editor.Keyboard;
import logic.name.generation.Letter;
import logic.name.generation.Name;
import utils.CommonUtils;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

import static logic.language.editor.Keyboard.KEYS;
import static logic.name.generation.Alphabet.CONSONANTS;
import static logic.name.generation.Alphabet.VOWELS;

@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent e) {
        HttpSession session = e.getSession();
        List<Letter> letters = Letter.getDefaultLetterSettingsList();
        session.setAttribute("letterList", letters);
        session.setAttribute("letterListString", CommonUtils.convertListOfObjectsToJson(letters));
        session.setAttribute("nameLength", Name.getDefaultNameLength());
        session.setAttribute("vowels", VOWELS.getLetters());
        session.setAttribute("consonants", CONSONANTS.getLetters());
        session.setAttribute("passedAuth", null);
        session.setAttribute("generateLastName", Name.getDefaultGenerateLastName());
        session.setAttribute("user", null);
        session.setAttribute("keys", KEYS.getKeys().split(""));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
    }
}
