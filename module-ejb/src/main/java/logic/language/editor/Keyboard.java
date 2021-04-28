package logic.language.editor;

public enum Keyboard {
    KEYS("1234567890qwertyuiopasdfghjklzxcvbnm!@#$%^&*()-=+-[]{}:'\"\\/<>,.`~");
    private final String keys;
    Keyboard(String keys){
        this.keys = keys;
    }
    public String getKeys(){ return keys;}
}
