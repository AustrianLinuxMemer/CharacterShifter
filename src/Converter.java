public class Converter {
    public static String convertString(String string, int shift) {
        char[] charredString = string.toCharArray();
        for (int i = 0; i < charredString.length; i++) {
            charredString[i] = (char) (charredString[i] + shift);
        }
        return String.copyValueOf(charredString);
    }
}
