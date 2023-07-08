import java.util.Scanner;

public class demo {
    private int id;
    private String title;
    private String author;
    private double price;
    private int quantity;

    public demo(int id, String title, String author, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookstoreInventory bookstoreInventory = new BookstoreInventory();

        int choice;
        do {
            System.out.println("Welcome to the Bookstore Inventory");
            System.out.println("1. Add a book");
            System.out.println("2. Update book details");
            System.out.println("3. Delete a book");
            System.out.println("4. Retrieve book information");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the remaining newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume the remaining newline character
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter book quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();  // Consume the remaining newline character

                    Book bookToAdd = new Book(id, title, author, price, quantity);
                    bookstoreInventory.addBook(bookToAdd);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter the book ID to update: ");
                    int bookIdToUpdate = scanner.nextInt();
                    scanner.nextLine();  // Consume the remaining newline character

                    Book bookToUpdate = bookstoreInventory.getBookById(bookIdToUpdate);
                    if (bookToUpdate == null) {
                        System.out.println("Book not found!");
                    } else {
                        System.out.print("Enter new book title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter new book author: ");
                        String newAuthor = scanner.nextLine();
                        System.out.print("Enter new book price: ");
                        double newPrice = scanner.nextDouble();
                        System.out.print("Enter new book quantity: ");
                        int newQuantity = scanner.nextInt();
                        scanner.nextLine();  // Consume the remaining newline character

                        bookToUpdate.setTitle(newTitle);
                        bookToUpdate.setAuthor(newAuthor);
                        bookToUpdate.setPrice(newPrice);
                        bookToUpdate.setQuantity(newQuantity);

                        bookstoreInventory.updateBook(bookToUpdate);
                        System.out.println("Book details updated successfully!");
                    }
                    break;

                case 3:
                    System.out.print("Enter the book ID to delete: ");
                    int bookIdToDelete = scanner.nextInt();
                    scanner.nextLine();  // Consume the remaining newline character

                    bookstoreInventory.deleteBook(bookIdToDelete);
                    System.out.println("Book deleted successfully!");
                    break;

                case 4:
                    System.out.print("Enter the book ID to retrieve: ");
                    int bookIdToRetrieve = scanner.nextInt();
                    scanner.nextLine();  // Consume the remaining newline character

                    Book retrievedBook = bookstoreInventory.getBookById(bookIdToRetrieve);
                    if (retrievedBook == null) {
                        System.out.println("Book not found!");
                    } else {
                        System.out.println("Book details:");
                        System.out.println("ID: " + retrievedBook.getId());
                        System.out.println("Title: " + retrievedBook.getTitle());
                        System.out.println("Author: " + retrievedBook.getAuthor());
                        System.out.println("Price: " + retrievedBook.getPrice());
                        System.out.println("Quantity: " + retrievedBook.getQuantity());
                    }
                    break;

                case 0:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }

            System.out.println();  // Add a line break for better readability
        } while (choice != 0);

        scanner.close();
        bookstoreInventory.closeConnection();
    }
}
