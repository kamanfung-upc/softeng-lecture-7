package org.example;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Book> getBooksByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> getBooksByYear(int year) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                result.add(book);
            }
        }
        return result;
    }
}
