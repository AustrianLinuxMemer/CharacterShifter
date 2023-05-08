import java.util.HashMap;
import java.util.Map;

public class Converter {
    public static Map<Character, Character> map; //<normal, widespace>
    public static Map<Character, Character> invertedMap; //<widespace, normal>
    public static void initialize() {
        char[] normalChars = new char[]{' ', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~'};
        char[] widespaceChars = new char[]{' ', '！', '＂', '＃', '＄', '％', '＆', '＇', '（', '）', '＊', '＋', '，', '－', '．', '／', '０', '１', '２', '３', '４', '５', '６', '７', '８', '９', '：', '；', '＜', '＝', '＞', '？', '＠', 'Ａ', 'Ｂ', 'Ｃ', 'Ｄ', 'Ｅ', 'Ｆ', 'Ｇ', 'Ｈ', 'Ｉ', 'Ｊ', 'Ｋ', 'Ｌ', 'Ｍ', 'Ｎ', 'Ｏ', 'Ｐ', 'Ｑ', 'Ｒ', 'Ｓ', 'Ｔ', 'Ｕ', 'Ｖ', 'Ｗ', 'Ｘ', 'Ｙ', 'Ｚ', '［', '＼', '］', '＾', '＿', '｀', 'ａ', 'ｂ', 'ｃ', 'ｄ', 'ｅ', 'ｆ', 'ｇ', 'ｈ', 'ｉ', 'ｊ', 'ｋ', 'ｌ', 'ｍ', 'ｎ', 'ｏ', 'ｐ', 'ｑ', 'ｒ', 'ｓ', 'ｔ', 'ｕ', 'ｖ', 'ｗ', 'ｘ', 'ｙ', 'ｚ', '｛', '｜', '｝', '～'};
        map = new HashMap<Character, Character>();
        invertedMap = new HashMap<Character, Character>();
        for (int i = 0; i < normalChars.length; i++) {
            map.put(normalChars[i], widespaceChars[i]);
            invertedMap.put(widespaceChars[i], normalChars[i]);
        }
    }
    public static char convertCharFromNormalToWidespace(char normal) {
        return (Character)map.get(normal);
    }
    public static char convertCharFromWidespaceToNormal(char widespace){
        return (Character)invertedMap.get(widespace);
    }
    public static boolean isValidNormalCharacter(char character) throws InvalidCharException {
        if (map.containsKey(character)) {
            return true;
        } else {
            throw new InvalidCharException();
        }
    }
    public static boolean isValidWidespaceCharacter(char character) throws InvalidCharException {
        if (invertedMap.containsKey(character)) {
            return true;
        } else {
            throw new InvalidCharException();
        }
    }
    public static boolean isValidNormalString(String string) throws InvalidCharException {
        char[] charredString = string.toCharArray();
        for (int i = 0; i < charredString.length; i++) {
            if (!isValidNormalCharacter(charredString[i])){
                return false;
            }
        }
        return true;
    }
    public static boolean isValidWidespaceString(String string) throws InvalidCharException {
        char[] charredString = string.toCharArray();
        for (int i = 0; i < charredString.length; i++) {
            if (!isValidWidespaceCharacter(charredString[i])) {
                return false;
            }
        }
        return true;
    }
    public static String convertStringFromNormalToWidespace(String string) throws InvalidCharException {
        isValidNormalString(string);
        char[] charredString = string.toCharArray();
        char[] newCharredString = new char[charredString.length];
        for (int i = 0; i < charredString.length; i++) {
            newCharredString[i] = convertCharFromNormalToWidespace(charredString[i]);
        }
        return String.copyValueOf(newCharredString);
    }
    public static String convertStringFromWidespaceToNormal(String string) throws InvalidCharException {
        isValidWidespaceString(string);
        char[] charredString = string.toCharArray();
        char[] newCharredString = new char[charredString.length];
        for (int i = 0; i < charredString.length; i++) {
            newCharredString[i] = convertCharFromWidespaceToNormal(charredString[i]);
        }
        return String.copyValueOf(newCharredString);
    }
}
