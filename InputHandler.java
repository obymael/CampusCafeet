
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    // Vänta på att användaren trycker ENTER
    public void waitForEnter() {
        scanner.nextLine();
    }

    // Läs in text från användaren
    public String readString() {
        return scanner.nextLine();
    }

    // Läs in en char från användaren
    public char readChar() {
        String input = scanner.nextLine().trim();

        if (input.length() != 1) {
            throw new IllegalArgumentException("Please enter a single character.");
        }

        return input.charAt(0);
    }

    // Läs in ett heltal från användaren
    public int readInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    // Stäng Scanner när programmet avslutas
    public void close() {
        scanner.close();
    }
}
