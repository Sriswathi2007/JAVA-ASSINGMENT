import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}
interface AddressBookInterface {
    void addContact(Contact contact);
    void viewAllContacts();
    Contact searchContactByName(String name);
}
class AddressBook implements AddressBookInterface {
    private List<Contact> contacts;
    public AddressBook() {
        this.contacts = new ArrayList<>();
    }
    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }
    @Override
    public void viewAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
    @Override
    public Contact searchContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }
}
public class AddressBookApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        int choice;

        do {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add a new contact.");
            System.out.println("2. View all contacts.");
            System.out.println("3. Search for a contact by name.");
            System.out.println("4. Exit the program.");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String email = scanner.nextLine();
                    Contact contact = new Contact(name, phoneNumber, email);
                    addressBook.addContact(contact);
                    break;
                case 2:
                    System.out.println("Contact List:");
                    addressBook.viewAllContacts();
                    break;
                case 3:
                    System.out.print("Enter the name to search: ");
                    String searchName = scanner.nextLine();
                    Contact searchedContact = addressBook.searchContactByName(searchName);
                    if (searchedContact != null) {
                        System.out.println("Contact found: " + searchedContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }
}
