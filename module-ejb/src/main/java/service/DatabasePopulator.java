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

@Singleton
@Startup
public class DatabasePopulator {

    @Inject
    private UserEJB userEJB;

    @Inject
    private RoleEJB roleEJB;

    @Inject
    private SymbolEJB symbolEJB;

    private final String defaultSymbolsDirectory = "../../../module-ejb/src/main/resources/defaultSymbols/";

    @PostConstruct
    private void populateDB() {
        List<Symbol> symbols = new ArrayList<>();
        System.out.println(CommonUtils.getAbsolutePath());
        System.out.println(CommonUtils.isFileExists(defaultSymbolsDirectory + "a.png"));
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
//            new InitialContext().bind("creativity/default/files/aFigure", aFigure);
//            new InitialContext().bind("creativity/default/files/bFigure", bFigure);
//            new InitialContext().bind("creativity/default/files/cFigure", cFigure);
//            new InitialContext().bind("creativity/default/files/dFigure", dFigure);
//            new InitialContext().bind("creativity/default/files/eFigure", eFigure);
//            new InitialContext().bind("creativity/default/files/fFigure", fFigure);
//            new InitialContext().bind("creativity/default/files/gFigure", gFigure);
//            new InitialContext().bind("creativity/default/files/hFigure", hFigure);
//            new InitialContext().bind("creativity/default/files/iFigure", iFigure);
//            new InitialContext().bind("creativity/default/files/jFigure", jFigure);
//            new InitialContext().bind("creativity/default/files/kFigure", kFigure);
//            new InitialContext().bind("creativity/default/files/lFigure", lFigure);
//            new InitialContext().bind("creativity/default/files/mFigure", mFigure);
//            new InitialContext().bind("creativity/default/files/nFigure", nFigure);
//            new InitialContext().bind("creativity/default/files/oFigure", oFigure);
//            new InitialContext().bind("creativity/default/files/pFigure", pFigure);
//            new InitialContext().bind("creativity/default/files/qFigure", qFigure);
//            new InitialContext().bind("creativity/default/files/rFigure", rFigure);
//            new InitialContext().bind("creativity/default/files/sFigure", sFigure);
//            new InitialContext().bind("creativity/default/files/tFigure", tFigure);
//            new InitialContext().bind("creativity/default/files/uFigure", uFigure);
//            new InitialContext().bind("creativity/default/files/vFigure", vFigure);
//            new InitialContext().bind("creativity/default/files/wFigure", wFigure);
//            new InitialContext().bind("creativity/default/files/xFigure", xFigure);
//            new InitialContext().bind("creativity/default/files/yFigure", yFigure);
//            new InitialContext().bind("creativity/default/files/zFigure", zFigure);
        Symbol aSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(0)), aFigure, "ej");
        Symbol bSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(1)), bFigure, "bi");
        Symbol cSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(2)), cFigure, "si");
        Symbol dSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(3)), dFigure, "dzi");
        Symbol eSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(4)), eFigure, "i");
        Symbol fSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(5)), fFigure, "ef");
        Symbol gSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(6)), gFigure, "dji");
        Symbol hSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(7)), hFigure, "eich");
        Symbol iSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(8)), iFigure, "aj");
        Symbol jSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(9)), jFigure, "djej");
        Symbol kSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(10)), kFigure, "kej");
        Symbol lSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(11)), lFigure, "el");
        Symbol mSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(12)), mFigure, "em");
        Symbol nSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(13)), nFigure, "en");
        Symbol oSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(14)), oFigure, "ow");
        Symbol pSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(15)), pFigure, "pi");
        Symbol qSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(16)), qFigure, "khu");
        Symbol rSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(17)), rFigure, "ar");
        Symbol sSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(18)), sFigure, "es");
        Symbol tSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(19)), tFigure, "ti");
        Symbol uSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(20)), uFigure, "yu");
        Symbol vSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(21)), vFigure, "vi");
        Symbol wSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(22)), wFigure, "dablwi");
        Symbol xSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(23)), xFigure, "eks");
        Symbol ySymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(24)), yFigure, "vaj");
        Symbol zSymbol = new Symbol(String.valueOf(Alphabet.ALPHABET.getLetters().toUpperCase().charAt(25)), zFigure, "zet");
        symbols.add(aSymbol);
        symbols.add(bSymbol);
        symbols.add(cSymbol);
        symbols.add(dSymbol);
        symbols.add(eSymbol);
        symbols.add(fSymbol);
        symbols.add(gSymbol);
        symbols.add(hSymbol);
        symbols.add(iSymbol);
        symbols.add(jSymbol);
        symbols.add(kSymbol);
        symbols.add(lSymbol);
        symbols.add(mSymbol);
        symbols.add(nSymbol);
        symbols.add(oSymbol);
        symbols.add(pSymbol);
        symbols.add(qSymbol);
        symbols.add(rSymbol);
        symbols.add(sSymbol);
        symbols.add(tSymbol);
        symbols.add(uSymbol);
        symbols.add(vSymbol);
        symbols.add(wSymbol);
        symbols.add(xSymbol);
        symbols.add(ySymbol);
        symbols.add(zSymbol);
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
