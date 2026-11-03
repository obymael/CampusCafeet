public class Menu {
    private final InputHandler input;
    private final OrderManager orderManager;
    private final RegistreringAnOrder registreringAnOrder;

    public Menu(InputHandler input, OrderManager orderManager) {
        this.input = input;
        this.orderManager = orderManager;
        this.registreringAnOrder = new RegistreringAnOrder();
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
        System.out.println("====================================");
    }

    private void confirmExit() {
        System.out.print("Are you sure you want to close the café? (Y/N): ");

        while (true) {

            String answer = input.readString();

            if (answer.equalsIgnoreCase("Y")) {
                System.out.println("Thanks for visiting javac ☕️");
                isOpen = false;
                return;
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("Great! The coffee is still brewing!");
                return;
            } else {
                System.out.print("Invalid answer! Please enter Y or N: ");
            }
        }

    }

    private void returnToMenu() {
        System.out.println();
        System.out.print("Press ENTER to return to main menu...");
        input.waitForEnter();
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
                    registreringAnOrder.showProducts();
                    break;
                case 2:
                    System.out.println("Placing an order...");
                    registreringAnOrder.placeOrder(input, orderManager);
                    break;
                case 3:
                    // System.out.println("Showing all orders...");
                    orderManager.showAllOrders();
                    break;
                case 4:
                    // System.out.println("Showing order queue...");
                    orderManager.showOrderQueue();
                    break;
                case 5:
                    // System.out.println("Preparing next order...");
                    orderManager.prepareNextOrder();
                    break;
                case 6:
                    System.out.println("Handing out order...");
                    registreringAnOrder.orderReceipt(choice, null, null);
                    break;
                case 7:
                    System.out.println("Showing statistics...");
                    break;
                case 8:
                    confirmExit();
                    return; // Avsluta hela metoden (i.e. kör inte returnToMenu())
            }

            // Vänta på ENTER innan huvudmenyn visas igen
            returnToMenu();

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }

    }
}
