
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

    // Läs in ett heltal från användaren
    public int readInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    // Stäng Scanner när programmet avslutas
    public void close() {
        scanner.close();
    }
}
