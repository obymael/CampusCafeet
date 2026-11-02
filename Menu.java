public class Menu {
    private final InputHandler input;
    public Menu (InputHandler input) {
        this.input = input;
    }
    private boolean isOpen = true;

    public void start() {
        System.out.println("===== C A M P U S  C A F É =====");

        while (isOpen) {
            showMenu();
            handleChoice();
        }
    }

    private void showMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. View products & prices");
        System.out.println("2. Place an order");
        System.out.println("3. View all orders");
        System.out.println("4. View order queue");
        System.out.println("5. Prepare next order");
        System.out.println("6. Pick up completed order");
        System.out.println("7. Today's statistics");
        System.out.println("8. Exit");
        System.out.println("===============================");
    }

    private void handleChoice() {
        System.out.print("Choose an option (1-8): ");

        try {
            int choice = input.readInt();

            if (choice < 1 || choice > 8) {
                System.out.println("Invalid option! Choose option 1-8.");
                return;
            }

            switch (choice) {
                case 1:
                    System.out.println("Showing products...");
                    break;
                case 2:
                    System.out.println("Placing an order...");
                    break;
                case 3:
                    System.out.println("Showing all orders...");
                    break;
                case 4:
                    System.out.println("Showing order queue...");
                    break;
                case 5:
                    System.out.println("Preparing next order...");
                    break;
                case 6:
                    System.out.println("Handing out order...");
                    break;
                case 7:
                    System.out.println("Showing statistics...");
                    break;
                case 8:
                    System.out.println("Thanks for visiting Campus Café!");
                    isOpen = false;
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }

    }
}