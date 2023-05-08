public class Main {
    public static void main(String[] args) {
        Converter.initialize();
        if (args.length != 2) {
            showUsageMessage();
            System.exit(1);
        } else if (args[0].equals("-w")) {
            try {
                System.out.println(Converter.convertStringFromNormalToWidespace(args[1]));
            } catch (InvalidCharException e) {
                System.out.println("Bitte NUR normale Zeichen eingeben");
                System.exit(1);
            }
        } else if (args[0].equals("-n")) {
            try {
                System.out.println(Converter.convertStringFromWidespaceToNormal(args[1]));
            } catch (InvalidCharException e) {
                System.out.println("Bitte NUR Widespace-Zeichen eingeben");
                System.exit(1);
            }
        } else {
            showUsageMessage();
            System.exit(1);
        }
    }
    public static void showUsageMessage() {
        System.out.println("Usage: widespace [-w/-d] <String>");
    }
}