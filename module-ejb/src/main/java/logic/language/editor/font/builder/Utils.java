package logic.language.editor.font.builder;

public class Utils {
    public static <T> String enumMemberToString(T attribute) {
        return attribute.toString().toLowerCase().replace('_','-');
    }

    public static <T> String enumMemberToStringUnderlineToDoubleDot(T attribute) {
        return attribute.toString().toLowerCase().replace('_','-');
    }
}
