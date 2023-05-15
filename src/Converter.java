import java.util.HashMap;
import java.util.Map;

public class Converter {
    public static char convertCharFromNormalToWidespace(char normal, int shift) {
        int normal1 = normal + shift;
        return (char) normal1;
    }
    public static String convertString(String string, int shift) {
        char[] charredString = string.toCharArray();
        char[] newCharredString = new char[charredString.length];
        for (int i = 0; i < charredString.length; i++) {
            newCharredString[i] = convertCharFromNormalToWidespace(charredString[i], shift);
        }
        return String.copyValueOf(newCharredString);
    }
}