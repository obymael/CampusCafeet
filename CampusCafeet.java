/** CampusCafeet - innehåller main
 *
 */
public class CampusCafeet {
    public static final String CAFE_NAME = "javac ☕️";

    static void printWelcome() {
        System.out.println("===== C A M P U S  C A F É =====");
        System.out.println();
        System.out.println("Welcome to " + CAFE_NAME + "!");
        System.out.println("Compiling caffeine, one cup at a time.");
        System.out.println();
        System.out.println("No coffee? NullPointerException.");
        System.out.println("No money? InsufficientFundsException.");
        System.out.println("No motivation? That's a feature, not a bug.");
        System.out.println();
        System.out.println("Press ENTER to brew some chaos...");
    }
    public static void main(String[] args) {
        InputHandler input = new InputHandler();
        Menu menu = new Menu(input); // Skapa en menu

        // Kalla på metoderna härifrån
        printWelcome();

        // Vänta tills användaren trycker enter
        input.waitForEnter();

        // Starta menyn
        menu.start();

        // Stäng scannern
        input.close();
    }
}
