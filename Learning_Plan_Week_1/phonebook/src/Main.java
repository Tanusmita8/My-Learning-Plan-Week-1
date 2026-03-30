import phonebook.PhoneBook;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Phonebook App ===");

        while (true) {
            System.out.println("\n1. Add contact");
            System.out.println("2. Search by name");
            System.out.println("3. Search by phone number");
            System.out.println("4. List all contacts");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();     // consume leftover newline after nextInt()

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter surname: ");
                String surname = scanner.nextLine();
                System.out.print("Enter phone: ");
                String phone = scanner.nextLine();
                phoneBook.addContact(name, surname, phone);

            } else if (choice == 2) {
                System.out.print("Enter name or surname to search: ");
                phoneBook.searchByName(scanner.nextLine());

            } else if (choice == 3) {
                System.out.print("Enter phone number to search: ");
                phoneBook.searchByPhone(scanner.nextLine());

            } else if (choice == 4) {
                phoneBook.listAll();

            } else if (choice == 5) {
                System.out.println("Goodbye!");
                break;      // exits the while loop → program ends

            } else {
                System.out.println("Invalid option, try again.");
            }
        }

        scanner.close();
    }
}