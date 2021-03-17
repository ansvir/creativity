package logic.name.generation;

import resource.NameGenerationDefaultSettingsManager;

import java.util.ArrayList;
import java.util.List;

public class Letter {

    private String symbol;
    private short priority;

    public Letter(String symbol, short priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public short getPriority() {
        return priority;
    }

    public void setPriority(short priority) {
        this.priority = priority;
    }

    public static List<Letter> getDefaultLetterSettingsList() {
        List<Letter> letterList = new ArrayList<>();
        for(String letter : Alphabet.ALPHABET.getLetters().split("")) {
            String priority = NameGenerationDefaultSettingsManager.getProperty("priority." + letter);
            letterList.add(new Letter(letter, Short.parseShort(priority)));
        }
        return letterList;
    }

    public static String convertLetterListToArrayOfJsonObjectsString(List<Letter> letters) {
        String result = "[";
        for(int i=0;i<letters.size();i++) {

            if(i < letters.size()-1) {
                result += letterToJsonObjectString(letters.get(i))+ ", ";
            } else {
                result += letterToJsonObjectString(letters.get(i));
            }
        }
        result += "]";
        return result;
    }

    private static String letterToJsonObjectString(Letter letter) {
        return "{'symbol':'"+letter.getSymbol()+"', 'priority':"+letter.getPriority()+"}";
    }
    @Override
    public String toString() {
        return "Letter{" +
                "symbol='" + symbol + '\'' +
                ", priority=" + priority +
                '}';
    }
}
