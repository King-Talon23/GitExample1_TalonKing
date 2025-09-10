package TK;

import java.util.ArrayList;
import java.util.Scanner;

public class library {
    private ArrayList<book> books = new ArrayList<>();
    private ArrayList<Long> isbnList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice = 0;
        do {
            printMenu();
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            } else {
                choice = Integer.parseInt(input);
            }

            
            switch (choice) {
                case 1 -> addBook();
                case 2 -> editBook();
                case 3 -> deleteBook();
                case 4 -> listBooks();
                case 99 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid. Please try again.");
            }
        } while (choice != 99);
    }

    private void printMenu() {
        System.out.println("""
                ----------------
                   1. Add Book
                   2. Edit Book
                   3. Delete Book
                   4. List Books
                  99. exit
                ----------------
                Enter your choice:""");
    }

    private void addBook() {
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        long isbn = isbnValidator();
        System.out.print("Enter page count: ");
        int pages = scanner.nextInt();

        books.add(new book(title, author, isbn, pages));
    }

    private void editBook() {
        listBooks();
        System.out.print("Enter book number to edit: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < books.size()) {
            int choice;
            System.out.print("What part of book " + (index + 1) + " would you like to edit?");
            System.out.print("""
                    1. Edit Title.
                    2. Edit Author.
                    3. Edit ISBN.
                    4. Edit Page count.
                    99. Exit Editor.
                    """);
            do {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter new Title: ");
                        books.get(index).setTitle(scanner.nextLine());
                    }
                    case 2 -> {
                        System.out.print("Enter new Author: ");
                        books.get(index).setAuthor(scanner.nextLine());
                    }
                    case 3 -> books.get(index).setIsbn(isbnValidator());
                    case 4 -> books.get(index).setPageCount(pageNumValidator());
                    case 99 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid. Please try again.");
                }
            } while (choice != 99);
        } else {
            System.out.println("Invalid book number.");
        }
    }

    private void deleteBook() {
        listBooks();
        System.out.print("Enter book list number to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < books.size()) {
            System.out.println(books.get(index).getTitle() + " was deleted.");
            books.remove(index);
        } else {
            System.out.println("Invalid book number.");
        }
    }

    private void listBooks() {
        for (int i = 0; i < books.size(); i++) {
            book b = books.get(i);
            System.out.printf("%2d. Title: %-30s Author: %-20s Pages: %-4d ISBN: %-10s%n",
                    i + 1, b.getTitle(), b.getAuthor(), b.getPageCount(), b.getIsbn());
        }
    }

    private long isbnValidator() {
        long min = 1000000000000L;
        long max = 9999999999999L;
        long potentialISBN;
        while (true) {
            System.out.println("Enter ISBN: ");
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                potentialISBN = Long.parseLong(input);
                if (potentialISBN < min || max < potentialISBN) {
                    System.out.print("Invalid ISBN: A valid ISBN must be 13 digits.");
                } else if (isbnList.contains(potentialISBN)) {
                    System.out.print("Invalid ISBN: Two books CANNOT have the same ISBN");
                } else {
                    isbnList.add(potentialISBN);
                    break;
                }

            } else {
                System.out.println("Invalid: Input cannot be empty");
            }
        }
        return potentialISBN;
    }

    private int pageNumValidator() {
        int pageNum = 0;
        while (true) {
            System.out.println("Enter ISBN: ");
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                pageNum = Integer.parseInt(input);
                if (pageNum <= 0) {
                    System.out.print("Invalid: A book must have atleast 1 page");
                } else {
                    break;
                }

            } else {
                System.out.println("Invalid: Input cannot be empty");
            }
        }
        return pageNum;
    }
}
