package service;

import entity.*;
import logic.name.generation.Alphabet;
import org.apache.commons.io.IOUtils;
import utils.CommonUtils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.CommonDataSource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static logic.language.editor.Keyboard.KEYS;
import static logic.name.generation.Alphabet.ALPHABET;

@Singleton
@Startup
public class DatabasePopulator {

    @Inject
    private UserEJB userEJB;

    @Inject
    private RoleEJB roleEJB;

    @Inject
    private SymbolEJB symbolEJB;

    @PostConstruct
    private void populateDB() {
        List<Symbol> symbols = new ArrayList<>();
        final String defaultSymbolsDirectory = "../../../module-ejb/src/main/resources/defaultSymbols/";
        byte[] _1Figure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "1.png");
        byte[] _2Figure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "2.png");
        byte[] _3Figure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "3.png");
        byte[] _4Figure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "4.png");
        byte[] _5Figure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "5.png");
        byte[] _6Figure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "6.png");
        byte[] _7Figure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "7.png");
        byte[] _8Figure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "8.png");
        byte[] _9Figure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "9.png");
        byte[] _0Figure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "0.png");
        byte[] aFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "a.png");
        byte[] bFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "b.png");
        byte[] cFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "c.png");
        byte[] dFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "d.png");
        byte[] eFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "e.png");
        byte[] fFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "f.png");
        byte[] gFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "g.png");
        byte[] hFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "h.png");
        byte[] iFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "i.png");
        byte[] jFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "j.png");
        byte[] kFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "k.png");
        byte[] lFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "l.png");
        byte[] mFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "m.png");
        byte[] nFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "n.png");
        byte[] oFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "o.png");
        byte[] pFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "p.png");
        byte[] qFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "q.png");
        byte[] rFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "r.png");
        byte[] sFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "s.png");
        byte[] tFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "t.png");
        byte[] uFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "u.png");
        byte[] vFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "v.png");
        byte[] wFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "w.png");
        byte[] xFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "x.png");
        byte[] yFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "y.png");
        byte[] zFigure = CommonUtils.fileToByteArray(defaultSymbolsDirectory + "z.png");

        Symbol _1Symbol = new Symbol(String.valueOf(KEYS.getKeys().toUpperCase().charAt(0)), _1Figure, "wan");
        Symbol _2Symbol = new Symbol(String.valueOf(KEYS.getKeys().toUpperCase().charAt(1)), _2Figure, "tu");
        Symbol _3Symbol = new Symbol(String.valueOf(KEYS.getKeys().toUpperCase().charAt(2)), _3Figure, "thri");
        Symbol _4Symbol = new Symbol(String.valueOf(KEYS.getKeys().toUpperCase().charAt(3)), _4Figure, "fo");
        Symbol _5Symbol = new Symbol(String.valueOf(KEYS.getKeys().toUpperCase().charAt(4)), _5Figure, "faiv");
        Symbol _6Symbol = new Symbol(String.valueOf(KEYS.getKeys().toUpperCase().charAt(5)), _6Figure, "syks");
        Symbol _7Symbol = new Symbol(String.valueOf(KEYS.getKeys().toUpperCase().charAt(6)), _7Figure, "sewen");
        Symbol _8Symbol = new Symbol(String.valueOf(KEYS.getKeys().toUpperCase().charAt(7)), _8Figure, "eit");
        Symbol _9Symbol = new Symbol(String.valueOf(KEYS.getKeys().toUpperCase().charAt(8)), _9Figure, "nain");
        Symbol _0Symbol = new Symbol(String.valueOf(KEYS.getKeys().toUpperCase().charAt(9)), _0Figure, "zyro");
        Symbol aSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(0)), aFigure, "ej");
        Symbol bSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(1)), bFigure, "bi");
        Symbol cSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(2)), cFigure, "si");
        Symbol dSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(3)), dFigure, "dzi");
        Symbol eSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(4)), eFigure, "i");
        Symbol fSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(5)), fFigure, "ef");
        Symbol gSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(6)), gFigure, "dji");
        Symbol hSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(7)), hFigure, "eich");
        Symbol iSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(8)), iFigure, "aj");
        Symbol jSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(9)), jFigure, "djej");
        Symbol kSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(10)), kFigure, "kej");
        Symbol lSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(11)), lFigure, "el");
        Symbol mSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(12)), mFigure, "em");
        Symbol nSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(13)), nFigure, "en");
        Symbol oSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(14)), oFigure, "ow");
        Symbol pSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(15)), pFigure, "pi");
        Symbol qSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(16)), qFigure, "khu");
        Symbol rSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(17)), rFigure, "ar");
        Symbol sSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(18)), sFigure, "es");
        Symbol tSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(19)), tFigure, "ti");
        Symbol uSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(20)), uFigure, "yu");
        Symbol vSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(21)), vFigure, "vi");
        Symbol wSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(22)), wFigure, "dablwi");
        Symbol xSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(23)), xFigure, "eks");
        Symbol ySymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(24)), yFigure, "vaj");
        Symbol zSymbol = new Symbol(String.valueOf(ALPHABET.getLetters().toUpperCase().charAt(25)), zFigure, "zet");

        symbols.add(_1Symbol);symbols.add(_2Symbol);symbols.add(_3Symbol);symbols.add(_4Symbol);symbols.add(_5Symbol);
        symbols.add(_6Symbol);symbols.add(_7Symbol);symbols.add(_8Symbol);symbols.add(_9Symbol);symbols.add(_0Symbol);

        symbols.add(aSymbol);
        symbols.add(bSymbol);symbols.add(cSymbol);symbols.add(dSymbol);symbols.add(eSymbol);symbols.add(fSymbol);
        symbols.add(gSymbol);symbols.add(hSymbol);symbols.add(iSymbol);symbols.add(jSymbol);symbols.add(kSymbol);
        symbols.add(lSymbol);symbols.add(mSymbol);symbols.add(nSymbol);symbols.add(oSymbol);symbols.add(pSymbol);
        symbols.add(qSymbol);symbols.add(rSymbol);symbols.add(sSymbol);symbols.add(tSymbol);symbols.add(uSymbol);
        symbols.add(vSymbol);symbols.add(wSymbol);symbols.add(xSymbol);symbols.add(ySymbol);symbols.add(zSymbol);

        for (Symbol symbol : symbols) {
            symbolEJB.createSymbol(symbol);
        }

        List<Culture> cultures = new ArrayList<>();
        Culture culture = new Culture("English prescription", symbols);
        cultures.add(culture);
        List<Language> languages = new ArrayList<>();
        Language language = new Language("English", "English language with custom letters style", cultures);
        languages.add(language);

        User adminUser = new User("svirepa.anton@gmail.com", "admin", "admin", languages);
        User someUser = new User("user@gmail.com", "user", "user", null);

        if (userEJB.findByEmail(adminUser) == null) {
            userEJB.createUser(adminUser);
        }
        if (userEJB.findByEmail(someUser) == null) {
            userEJB.createUser(someUser);
        }

        Role adminRole = new Role("admin");
        Role userRole = new Role("user");

        if (roleEJB.findByName(adminRole) == null) {
            roleEJB.createRole(adminRole);
        }
        if (roleEJB.findByName(userRole) == null) {
            roleEJB.createRole(userRole);
        }
    }
}
