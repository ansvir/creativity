package logic.name.generation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static logic.name.generation.Alphabet.*;
import static logic.name.generation.Code.CONSONANT_CODE;
import static logic.name.generation.Code.VOWEL_CODE;

public class NameGenerationLogic {
    final Random RANDOM = new Random();
    private List<Letter> letters;
    private int nameLength;
    private String name;
    private boolean generateLastName;

    public NameGenerationLogic(List<Letter> letters, int nameLength, boolean generateLastName) {
        this.letters = letters;
        this.nameLength = nameLength;
        this.generateLastName = generateLastName;
    }

    public String generateName() {
        String firstName = generateOneName();
        String lastName = "";
        if (generateLastName) {
            lastName = generateOneName();
        }
        return (firstName + " " +lastName).trim();
    }

    private String generateOneName() {
        name = "";
        int currentLetter;
        for (int i=0;i<this.nameLength;i++) {
            int nextLetter = -1;
            if (i>=2) {
                nextLetter = returnNextVowelOrConsonant(i);
            }
            currentLetter = returnCurrentLetter(nextLetter);
            name += generateNameOnTheBasisOfPriorities(currentLetter);
        }
        name = returnFirstLetterUppercase(name);
        return name;
    }

    private int returnCurrentLetter(int nextLetter) {
        int currentLetter;
        if (nextLetter != -1) {
            currentLetter = nextLetter;
        } else {
            currentLetter = randomIntWithLimit(2);
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

    private String returnFirstLetterUppercase(String string) {
        String firstLetter = string.substring(0,1).toUpperCase();
        return firstLetter + string.substring(1);
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public void setLetters(List<Letter> letters) {
        this.letters = letters;
    }

    private String generateNameOnTheBasisOfPriorities(int code) {
        int prioritiesSum = sumPriorities(code);
        List<String> lettersPriorities = fillLettersPriorities(code);
        int chosenLetterIndex = randomIntWithLimit(prioritiesSum);
        return lettersPriorities.get(chosenLetterIndex);
    }

    private int randomIntWithLimit(int limit) {
        return RANDOM.nextInt(limit);
    }

    private int sumPriorities(int code) {
        int prioritiesSum = 0;
        if (code == VOWEL_CODE.getCode()) {
            for (String vowelLetter : VOWELS.getLetters().split("")) {
                for (Letter letter : this.letters) {
                    if (letter.getSymbol().equals(vowelLetter)) {
                        prioritiesSum += letter.getPriority();
                    }
                }
            }
        } else {
            for (String consonantLetter : CONSONANTS.getLetters().split("")) {
                for (Letter letter : this.letters) {
                    if (letter.getSymbol().equals(consonantLetter)) {
                        prioritiesSum += letter.getPriority();
                    }
                }
            }
        }
        return prioritiesSum;
    }

    private List<String> fillLettersPriorities(int code) {
        List<String> lettersPriorities = new ArrayList<>();
        if (code == VOWEL_CODE.getCode()) {
            for (Letter letter : this.letters) {
                for (String vowelLetter : VOWELS.getLetters().split("")) {
                    if (letter.getSymbol().equals(vowelLetter)) {
                        for (int i=0;i<letter.getPriority();i++) {
                            lettersPriorities.add(letter.getSymbol());
                        }
                        break;
                    }
                }
            }
        } else {
            for (Letter letter : this.letters) {
                for (String consonantLetter : CONSONANTS.getLetters().split("")) {
                    if (letter.getSymbol().equals(consonantLetter)) {
                        for (int i=0;i<letter.getPriority();i++) {
                            lettersPriorities.add(letter.getSymbol());
                        }
                        break;
                    }
                }
            }
        }
        return lettersPriorities;
    }

}
