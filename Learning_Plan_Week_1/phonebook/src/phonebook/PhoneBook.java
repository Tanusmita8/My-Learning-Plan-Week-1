package phonebook;

import model.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class PhoneBook {

    private ArrayList<Contact> allContacts = new ArrayList<>();
    private HashMap<String, Contact> byPhone = new HashMap<>();
    private TreeMap<String, Contact> bySurname = new TreeMap<>();

    public void addContact(String name, String surname, String phone) {
        Contact contact = new Contact(name, surname, phone);

        allContacts.add(contact);
        byPhone.put(phone, contact);
        bySurname.put(surname + " " + name, contact);

        System.out.println("Contact added: " + contact);
    }

    public void searchByName(String query) {
        boolean found = false;
        for (Contact c : allContacts) {
            if (c.getName().equalsIgnoreCase(query) || c.getSurname().equalsIgnoreCase(query)) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) System.out.println("No contact found for: " + query);
    }

    public void searchByPhone(String phone) {
        Contact c = byPhone.get(phone);
        if (c != null) System.out.println(c);
        else System.out.println("No contact found for number: " + phone);
    }

    public void listAll() {
        if (bySurname.isEmpty()) {
            System.out.println("Phonebook is empty.");
            return;
        }
        System.out.println("--- All Contacts (sorted by surname) ---");
        for (Contact c : bySurname.values()) {
            System.out.println(c);
        }
        System.out.println("----------------------------------------");
    }
}