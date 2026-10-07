package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("--- Library ---");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search books by author");
            System.out.println("4. Search books by year");
            System.out.println("5. List all books");
            System.out.println("0. Exit");
            System.out.print("Option: ");
            String option = scanner.nextLine();

            if (option.equals("1")) {
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Author: ");
                String author = scanner.nextLine();
                int year = readYear(scanner);
                library.addBook(new Book(title, author, year));
                System.out.println("Book added.");

            } else if (option.equals("2")) {
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Author: ");
                String author = scanner.nextLine();
                int year = readYear(scanner);
                boolean removed = library.removeBook(new Book(title, author, year));
                if (removed) {
                    System.out.println("Book removed.");
                } else {
                    System.out.println("Book not found.");
                }

            } else if (option.equals("3")) {
                System.out.print("Author: ");
                String author = scanner.nextLine();
                printBooks(library.getBooksByAuthor(author));

            } else if (option.equals("4")) {
                int year = readYear(scanner);
                printBooks(library.getBooksByYear(year));

            } else if (option.equals("5")) {
                printBooks(library.getBooks());

            } else if (option.equals("0")) {
                running = false;
                System.out.println("Bye!");

            } else {
                System.out.println("Unknown option.");
            }
        }
        scanner.close();
    }

    private static int readYear(Scanner scanner) {
        while (true) {
            System.out.print("Year: ");
            String text = scanner.nextLine();
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("The year must be a number.");
            }
        }
    }

    private static void printBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
