package logic.nameGeneration;

import org.junit.Test;

import java.util.List;

import static logic.nameGeneration.Alphabet.ALPHABET;

public class TestGenerateName {

    @Test
    public void testGenerateName() {
        String name = new NameGenerationLogic(Letter.getDefaultLetterSettingsList(), Name.getDefaultNameLength() ).generateName();
        System.out.println(name);
    }

    @Test
    public void testSplitAlphabet() {
        for (String letter : ALPHABET.getLetters().toUpperCase().split("")) {
            System.out.print(letter+" | ");
        }
    }

    @Test
    public void testGetDefaultLetterSettings() {
        List<Letter> letters = Letter.getDefaultLetterSettingsList();
        for (Letter letter : letters) {
            System.out.println(letter.toString());
        }
    }

    @Test
    public void testConvertObjectToJsonObjectString() {
        System.out.println(Letter.convertLetterListToArrayOfJsonObjectsString(Letter.getDefaultLetterSettingsList()));
    }
}
