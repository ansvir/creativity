package logic.nameGeneration;

import org.junit.Test;

import static logic.nameGeneration.Alphabet.ALPHABET;

public class TestGenerateName {

    @Test
    public void testGenerateName() {
        String name = new NameGeneration().generateName();
        System.out.println(name);
    }

    @Test
    public void testSplitAlphabet() {
        for (String letter : ALPHABET.getLetters().split("\\|")) {
            System.out.print(letter+" ");
        }
    }
}
