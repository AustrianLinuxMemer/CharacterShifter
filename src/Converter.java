public class Converter {
    public static char convertCharFromNormalToWidespace(char normal, int shift) {
        return (char) (normal + shift);
    }
    public static String convertString(String string, int shift) {
        char[] charredString = string.toCharArray();
        for (int i = 0; i < charredString.length; i++) {
            charredString[i] = convertCharFromNormalToWidespace(charredString[i], shift);
        }
        return String.copyValueOf(newCharredString);
    }
}
