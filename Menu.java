public class Menu {
    private final InputHandler input;
    public Menu (InputHandler input) {
        this.input = input;
    }
    private boolean isOpen = true; // Open Status

    public void start() {
        while (isOpen) {
            showMenu();
            handleChoice();
        }
    }

    private void showMenu() {
        System.out.printf("\n========== %s menu ==========\n", CampusCafeet.CAFE_NAME);
        System.out.println("1. View products & prices");
        System.out.println("2. Place an order");
        System.out.println("3. View all orders");
        System.out.println("4. View order queue");
        System.out.println("5. Prepare next order");
        System.out.println("6. Pick up completed order");
        System.out.println("7. Today's statistics");
        System.out.println("8. Exit");
        System.out.println("=====================================");
    }

    private void confirmExit() {
        System.out.println("Are you sure you want to close the café? (Y/N)");

        String answer = input.readString();

        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("Thanks for visiting javac ☕️");
            isOpen = false;
        } else if (answer.equalsIgnoreCase("N")) {
            System.out.println("Great! The coffee is still brewing!");
        } else {
            System.out.println("Invalid answer! Please enter Y or N.");
        }
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
                    confirmExit();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }

    }
}