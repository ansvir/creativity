package logic.name.generation;

public enum Alphabet {
    VOWELS("aeiouy"), CONSONANTS("bcdfghjklmnpqrstvwxz"), ALPHABET("abcdefghijklmnopqrstuvwxyz");
    private final String letters;
    Alphabet(String letters){
        this.letters = letters;
    }
    public String getLetters(){ return letters;}
}
