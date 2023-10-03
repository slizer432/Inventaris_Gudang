import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String name;
    private int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + ": " + quantity;
    }
}

public class Inventaris {
    private static ArrayList<Item> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nInventory System Menu:");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item Quantity");
            System.out.println("3. View Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    updateItemQuantity();
                    break;
                case 3:
                    viewInventory();
                    break;
                case 4:
                    System.out.println("Exiting Inventory System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();

        Item newItem = new Item(name, quantity);
        inventory.add(newItem);
        System.out.println("Item added to inventory.");
    }

    private static void updateItemQuantity() {
        System.out.print("Enter item name to update quantity: ");
        String name = scanner.nextLine();

        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new quantity: ");
                int newQuantity = scanner.nextInt();
                item.setQuantity(newQuantity);
                System.out.println("Quantity updated.");
                return;
            }
        }

        System.out.println("Item not found in inventory.");
    }

    private static void viewInventory() {
        System.out.println("\nInventory:");
        for (Item item : inventory) {
            System.out.println(item);
        }
    }
}
