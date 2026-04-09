import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryManager {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Package> packages = new ArrayList<>();

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n==== DELIVERY PACKAGE MANAGER ====");
            System.out.println("1. Add Package");
            System.out.println("2. Sort Packages");
            System.out.println("3. Display Packages");
            System.out.println("4. Exit");
            System.out.println("=====================================");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addPackage();
                case 2 -> sortPackages();
                case 3 -> displayPackages();
                case 4 -> System.out.println("\nExiting program...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    static void addPackage() {
        System.out.println("-----------------------------------------");
        System.out.println("\n========= INPUT PACKAGE INFO =========");
        System.out.print("Enter ID (int): ");
        int id = sc.nextInt();
        sc.nextLine(); // clear newline

        if (id < 0) {
            System.out.println("ID must be positive!");
            return;
        }

        for (Package p : packages) {
            if (p.getId() == id) {
                System.out.println("Duplicate ID not allowed!");
                return;
            }
        }

        System.out.print("Enter Recipient Name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        System.out.print("Enter Weight (kg): ");
        double weight = Double.parseDouble(sc.nextLine());
        if (weight <= 0) {
            System.out.println("Weight must be positive!");
            return;
        }

        packages.add(new Package(id, name, weight));
        System.out.println("Package added successfully!");
    }

    static void sortPackages() {
        if (packages.isEmpty()) {
            System.out.println("No packages to sort!");
            return;
        }

        System.out.println("\nSort by:");
        System.out.println("1. ID");
        System.out.println("2. Recipient Name");
        System.out.println("3. Weight");
        System.out.print("Enter choice: ");
        int type = Integer.parseInt(sc.nextLine());

        System.out.println("\nOrder:");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        System.out.print("Enter choice: ");
        int order = Integer.parseInt(sc.nextLine());
        boolean ascending = (order == 1);

        // BUBBLE SORT (without unused boolean)
        for (int i = 0; i < packages.size() - 1; i++) {
            for (int j = 0; j < packages.size() - i - 1; j++) {
                Package p1 = packages.get(j);
                Package p2 = packages.get(j + 1);

                boolean condition = switch (type) {
                    case 1 -> ascending ? p1.getId() > p2.getId() : p1.getId() < p2.getId();
                    case 2 -> ascending ? p1.getRecipientName().compareToIgnoreCase(p2.getRecipientName()) > 0
                                        : p1.getRecipientName().compareToIgnoreCase(p2.getRecipientName()) < 0;
                    case 3 -> ascending ? p1.getWeight() > p2.getWeight() : p1.getWeight() < p2.getWeight();
                    default -> false;
                };

                if (condition) {
                    packages.set(j, p2);
                    packages.set(j + 1, p1);
                }
            }
        }

        System.out.println("\nPackages sorted successfully!");
        displayPackages();
    }

    static void displayPackages() {
        if (packages.isEmpty()) {
            System.out.println("No packages available!");
            return;
        }

        System.out.println("\n==== PACKAGE LIST ====");
        System.out.printf("%-10s %-20s %-10s\n", "ID", "Recipient", "Weight");
        System.out.println("---------------------------------------------");

        for (Package p : packages) {
            System.out.println(p);
        }
    }
}
