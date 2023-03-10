import static java.lang.System.exit;

public class Rent {
    public static void main(String[] args) {
        int command = 1;
        for(int i = 0; i < args.length; i++) {
            if(args[i].equals("-r")) {
                command = 1;
            }
            else if (args[i].equals("-a")) {
                if(args.length < 5) {
                    System.err.println("usage: java Rent -a ID START DURTN PRICE");
                    exit(1);
                }
            }
            else if (args[i].equals("-d")) {
                if(args.length < 3 ) {
                    System.err.println("usage: Java Rent -a ID START PRICE");
                    exit(1);
                }
            }
        }
        exit(0);
    }
}