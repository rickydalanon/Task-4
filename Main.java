package hardware;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Hardware> list = HardwareRepository.getHardwareList();
        Scanner sc = new Scanner(System.in);

        displayData(list);

        System.out.print("\nDo you want to add new item? (yes/no): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("How many items do you want to add? ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                System.out.println("\nItem #" + (i + 1));
                System.out.print("Enter Brand: ");
                String brand = sc.nextLine();
                System.out.print("Enter Type (Laptop/Phone): ");
                String type = sc.nextLine();
                System.out.print("Enter Spec: ");
                int spec = sc.nextInt();
                sc.nextLine();

                if (type.equalsIgnoreCase("Laptop") || type.equalsIgnoreCase("Phone")) {
                    HardwareRepository.addHardwareToDatabase(brand, type, spec);
                } else {
                    System.out.println("Invalid type, skipped.");
                }
            }

            list = HardwareRepository.getHardwareList();
            System.out.println("\n=== UPDATED DATA FROM DATABASE ===");
            displayData(list);
        }
    }

    public static void displayData(ArrayList<Hardware> list) {
        int lap16 = 0, lap32 = 0, ph50 = 0;

        System.out.println("\n=== Hardware Masterlist ===");

        for (Hardware h : list) {
            System.out.println(h.getBrand() + " (" + h.getType() + ") - " + h.interpretSpec());

            // Rule 4: Polymorphic Audit using instanceof
            if (h instanceof Laptop) {
                if (h.getSpec() == 16) lap16++;
                else if (h.getSpec() == 32) lap32++;
            } else if (h instanceof Phone) {
                if (h.getSpec() == 50) ph50++;
            }
        }

        System.out.println("\n=== Inventory Summary ===");
        System.out.println("16GB Laptops: " + lap16);
        System.out.println("32GB Laptops: " + lap32);
        System.out.println("50MP Phones: " + ph50);
    }
}