public class Main {
    public static void main(String[] args) {
        int shift = 65248;
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage: CharacterShifter.jar <string> [shift]");
            System.exit(1);
        } else if (args.length == 1) {
            System.out.println(Converter.convertString(args[0], shift));
        } else if (args.length == 2) {
            shift = Integer.parseInt(args[1]);
            System.out.println(Converter.convertString(args[0], shift));
        }
    }
    //dang it
}