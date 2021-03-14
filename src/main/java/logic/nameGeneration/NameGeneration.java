package logic.nameGeneration;

import java.util.Random;

import static logic.nameGeneration.Alphabet.CONSONANTS;
import static logic.nameGeneration.Alphabet.VOWELS;
import static logic.nameGeneration.Code.CONSONANT_CODE;
import static logic.nameGeneration.Code.VOWEL_CODE;

public class NameGeneration {
    final Random RANDOM = new Random();
    String name;
    public String generateName() {
        name = "";
        int currentLetter;
        for (int i=0;i<10;i++) {
            int nextLetter = -1;
            if (i>=2) {
                nextLetter = returnNextVowelOrConsonant(i);
            }
            currentLetter = returnCurrentLetter(nextLetter);
            name += chooseLetterFromAlphabet(currentLetter);
        }
        name = returnFirstLetterUppercase();
        return name;
    }

    private String chooseLetterFromAlphabet(int currentLetter) {
        char chosenLetter;
        if (currentLetter == VOWEL_CODE.getCode()) {
            int vowelIndex = RANDOM.nextInt(VOWELS.getLetters().length());
            chosenLetter = VOWELS.getLetters().charAt(vowelIndex);
        } else {
            int consonantIndex = RANDOM.nextInt(CONSONANTS.getLetters().length());
            chosenLetter = CONSONANTS.getLetters().charAt(consonantIndex);
        }

        return String.valueOf(chosenLetter);
    }

    private int returnCurrentLetter(int nextLetter) {
        int currentLetter;
        if (nextLetter != -1) {
            currentLetter = nextLetter;
        } else {
            currentLetter = RANDOM.nextInt(2);
        }
        return currentLetter;
    }

    private int returnNextVowelOrConsonant(int i) {
        int nextLetter = -1;
        if (name.substring(i-2, i).matches("^["+ VOWELS.getLetters() + "]{2}$")) {
            nextLetter = CONSONANT_CODE.getCode();
        } else if (name.substring(i-2, i).matches("^["+ CONSONANTS.getLetters() + "]{2}$")) {
            nextLetter = VOWEL_CODE.getCode();
        }
        return nextLetter;
    }

    private String returnFirstLetterUppercase() {
        String firstLetter = name.substring(0,1).toUpperCase();
        return firstLetter + name.substring(1);
    }

}
