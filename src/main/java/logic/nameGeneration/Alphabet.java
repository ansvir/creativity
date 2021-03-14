package logic.nameGeneration;

public enum Alphabet {
    VOWELS("aeiouy"), CONSONANTS("bcdfghjklmnpqrstvwxz"), ALPHABET("abcdefghijklmnopqrstuvwxyz");
    private String letters;
    Alphabet(String letters){
        this.letters = letters;
    }
    public String getLetters(){ return letters;}
}
