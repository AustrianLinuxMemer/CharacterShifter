import java.util.HashMap;
import java.util.Map;

public class Converter {
    public static char convertCharFromNormalToWidespace(char normal) {
        int normal1 = normal + 65248;
        return (char) normal1;
    }
    public static char convertCharFromWidespaceToNormal(char widespace){
        int widespace1 = widespace - 65248;
        return (char) widespace1;
    }
    public static boolean isValidNormalCharacter(char character){
        return character >= 32 && character <= 127;
    }
    public static boolean isValidWidespaceCharacter(char character){
        return character >= 32 + 65248 && character <= 127 + 65248;
    }
    public static String convertString(String string) {
        char[] charredString = string.toCharArray();
        char[] newCharredString = new char[charredString.length];
        for (int i = 0; i < charredString.length; i++) {
            if (isValidNormalCharacter(charredString[i])) {
                newCharredString[i] = convertCharFromNormalToWidespace(charredString[i]);
            } else if (isValidWidespaceCharacter(charredString[i])) {
                newCharredString[i] = convertCharFromWidespaceToNormal(charredString[i]);
            } else {
                System.exit(1);
            }
        }
        String toBeReturned = whitespaceCorrection(String.copyValueOf(newCharredString));
        return toBeReturned;
    }
    public static String whitespaceCorrection(String toBeCorrected) {
        String correctedString = "";
        String[] splinter = toBeCorrected.split("\uFF00");
        for (int i = 0; i < splinter.length; i++) {
            correctedString = correctedString.concat(splinter[i] + "  ");
        }
        return correctedString;
    }
}
