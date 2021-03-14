package logic.nameGeneration;

public enum Code {
    VOWEL_CODE(0), CONSONANT_CODE(1);
    private int code;
    Code(int code) {
        this.code = code;
    }
    public int getCode() { return code;}
}
