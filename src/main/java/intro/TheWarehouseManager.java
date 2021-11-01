package main.java.intro;
import java.util.Scanner;


/**
 * Provides necessary methods to deal through the Warehouse management actions
 *
 * @author riteshp
 */
public class TheWarehouseManager {
    // =====================================================================================
    // Member Variables
    // =====================================================================================

    // To read inputs from the console/CLI
    private final Scanner reader = new Scanner(System.in);
    private final String[] userOptions = {
            "1. List items by warehouse", "2. Search an item and place an order", "3. Quit"
    };
    // To refer the user provided name.
    private String userName;
    private String item_name;
    private int count_warehouse1 = 0;
    private int count_warehouse2 = 0;
    private int count_warehouse;
    private String userAnswer;
    private String userAnswer1;
    private int amountOrder;
    private int choice;


    // =====================================================================================
    // Public Member Methods
    // =====================================================================================

    /**
     * Welcome User
     */
    public void welcomeUser() {
        this.seekUserName();
        this.greetUser();
    }

    /**
     * Ask for user's choice of action
     *
     * @return
     */
    public int getUsersChoice() {
        System.out.println(" What would you like to do?. Please select the option you want: ");
        for (String i : userOptions) {
            System.out.println(i);
        }

        System.out.println("Type the number of the operation: ");
            return reader.nextInt();

    }


    /**
     * Initiate an action based on given option
     */
    public void performAction(int option) {
        switch (option) {
            case 1:
                System.out.println("Warehouse 1");
                for (int i = 0; i < Repository.WAREHOUSE1.length; i++) {
                    System.out.println(Repository.WAREHOUSE1[i]);
                }

                System.out.println("Warehouse 2");
                for (int i = 0; i < Repository.WAREHOUSE2.length; i++) {
                    System.out.println(Repository.WAREHOUSE2[i]);
                }
                break;
            case 2:
                reader.nextLine();
                System.out.println("Please input an item name ");

                this.item_name = this.reader.nextLine().toLowerCase();

                for (int i = 0, j = 0; i < Repository.WAREHOUSE1.length && j < Repository.WAREHOUSE2.length ; i++, j++) {
                    if(Repository.WAREHOUSE1[i].toLowerCase().equals(item_name)){
                        this.count_warehouse1 = this.count_warehouse1 + 1;
                    }
                    if(Repository.WAREHOUSE2[j].toLowerCase().equals(item_name)){
                        this.count_warehouse2 = this.count_warehouse2 + 1;
                    }
                }
                this.count_warehouse = this.count_warehouse1 + this.count_warehouse2;
                System.out.println("Number of items present in warehouse : " + this.count_warehouse);

                if (this.count_warehouse1 > 0 && this.count_warehouse2 > 0){
                    System.out.println(this.item_name + " is present in both warehouses");
                    if (this.count_warehouse1 > this.count_warehouse2){
                        System.out.println("Warehouse 1 has the greatest number of items " + this.count_warehouse1);
                        }else if(this.count_warehouse2 > this.count_warehouse1)  {
                            System.out.println("Warehouse 2 has the greatest number of items: " + this.count_warehouse2);
                        }else{
                        System.out.println("Warehouse 1 and 2 have the same number of items: " + this.count_warehouse1);
                    }
                }


                if (this.count_warehouse1 > 0 && this.count_warehouse2 == 0){
                    System.out.println(this.item_name + " is present in warehouse 1");
                }
                if (this.count_warehouse2 > 0 && this.count_warehouse1 == 0){
                    System.out.println(this.item_name + " is present in warehouse 2");
                }
                if (this.count_warehouse2 == 0 && this.count_warehouse1 == 0){
                    System.out.println(this.item_name + " is not in stock");
                }
                // Ask user if he/she wants to place an order
                System.out.println("Do you want to place an order? Please write Yes or No");
                this.userAnswer = this.reader.nextLine().toLowerCase();
                if (this.userAnswer.equals("yes")) {
                    System.out.println("How many do you want? ");
                    this.amountOrder = this.reader.nextInt();
                    reader.nextLine();

                    if (this.amountOrder <= this.count_warehouse) {
                        System.out.println("You ordered " + this.amountOrder + " qty of: " + this.item_name);
                    }

                    if (this.amountOrder > this.count_warehouse) {
                        System.out.println("Sorry! We don't have that amount. Do you want to order the maximum amount available instead? Please write yes or no");
                        this.userAnswer1 = this.reader.nextLine().toLowerCase();
                        if (this.userAnswer1.equals("yes")) {
                            System.out.println("You ordered " + this.count_warehouse + " qty of: " + this.item_name);

                        }

                    }
                }

                break;

            case 3:
                break;

            default:
                System.out.println("Invalid option");
        }


    }

    /**
     * Confirm an action
     *
     * @return action
     */
//    public boolean confirm(String message) {
//        // TODO
//    }

    /**
     * End the application
     */
    public void quit() {
        System.out.printf("\nThank you for your visit, %s!\n", this.userName);
        System.exit(0);
    }

    // =====================================================================================
    // Private Methods
    // =====================================================================================

    /**
     * Get user's name via CLI
     */
    private void seekUserName() {
        System.out.println("Please write your name here: ");
        this.userName = this.reader.nextLine();

    }

    /**
     * Print a welcome message with the given user's name
     */
    private void greetUser() {
        System.out.println("Hello!! " + this.userName);

    }

    public boolean confirm(String s) {
        return false;
    }
}




//    private void listItemsByWarehouse() {
//        // TODO
//    }
//
//    private void listItems(String[] warehouse) {
//        // TODO
//    }
//
//    private void searchItemAndPlaceOrder() {
//        // TODO
//    }
//
//    /**
//     * Ask the user to specify an Item to Order
//     *
//     * @return String itemName
//     */
//    private String askItemToOrder() {
//        // TODO
//    }
//
//    /**
//     * Calculate total availability of the given item
//     *
//     * @param itemName itemName
//     * @return integer availableCount
//     */
//    private int getAvailableAmount(String itemName) {
//        // TODO
//    }
//
//    /**
//     * Find the count of an item in a given warehouse
//     *
//     * @param item the item
//     * @param warehouse the warehouse
//     * @return count
//     */
//    private int find(String item, String[] warehouse) {
//        // TODO
//    }
//
//    /** Ask order amount and confirm order */
//    private void askAmountAndConfirmOrder(int availableAmount, String item) {
//        // TODO
//    }
//
//    /**
//     * Get amount of order
//     *
//     * @param availableAmount
//     * @return
//     */
//    private int getOrderAmount(int availableAmount) {
//        // TODO
//    }
//}