package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    Library library;
    Book prideAndPrejudice;
    Book emma;
    Book frankenstein;

    // Runs before each test, so every test starts with the same 3 books
    @BeforeEach
    public void setUp() {
        library = new Library();
        prideAndPrejudice = new Book("Pride and Prejudice", "Jane Austen", 1813);
        emma = new Book("Emma", "Jane Austen", 1815);
        frankenstein = new Book("Frankenstein", "Mary Shelley", 1818);
        library.addBook(prideAndPrejudice);
        library.addBook(emma);
        library.addBook(frankenstein);
    }

    @Test
    public void addBook() {
        Book newBook = new Book("Neuromancer", "William Gibson", 1984);
        library.addBook(newBook);
        assertEquals(4, library.getBooks().size());
        assertTrue(library.getBooks().contains(newBook));
    }

    @Test
    public void removeBook() {
        boolean removed = library.removeBook(frankenstein);
        assertTrue(removed);
        assertEquals(2, library.getBooks().size());
        assertFalse(library.getBooks().contains(frankenstein));
    }

    @Test
    public void removeBookWithANewObject() {
        // A different object with the same data must remove the book (this needs equals in Book)
        boolean removed = library.removeBook(new Book("Frankenstein", "Mary Shelley", 1818));
        assertTrue(removed);
        assertEquals(2, library.getBooks().size());
    }

    @Test
    public void removeBookNotInLibrary() {
        boolean removed = library.removeBook(new Book("Missing", "Nobody", 2000));
        assertFalse(removed);
        assertEquals(3, library.getBooks().size());
    }

    @Test
    public void getBooksByAuthor() {
        ArrayList<Book> result = library.getBooksByAuthor("Jane Austen");
        assertEquals(2, result.size());
        assertTrue(result.contains(prideAndPrejudice));
        assertTrue(result.contains(emma));
        assertFalse(result.contains(frankenstein));
    }

    @Test
    public void getBooksByAuthorIgnoresCase() {
        ArrayList<Book> result = library.getBooksByAuthor("mary shelley");
        assertEquals(1, result.size());
        assertEquals(frankenstein, result.get(0));
    }

    @Test
    public void getBooksByAuthorNotFound() {
        ArrayList<Book> result = library.getBooksByAuthor("Isaac Asimov");
        assertTrue(result.isEmpty());
    }

    @Test
    public void getBooksByYear() {
        ArrayList<Book> result = library.getBooksByYear(1813);
        assertEquals(1, result.size());
        assertEquals(prideAndPrejudice, result.get(0));
    }

    @Test
    public void getBooksByYearNotFound() {
        ArrayList<Book> result = library.getBooksByYear(2020);
        assertTrue(result.isEmpty());
    }

    @Test
    public void emptyLibrary() {
        Library empty = new Library();
        assertTrue(empty.getBooks().isEmpty());
        assertTrue(empty.getBooksByAuthor("Jane Austen").isEmpty());
        assertTrue(empty.getBooksByYear(1813).isEmpty());
        assertFalse(empty.removeBook(prideAndPrejudice));
    }
}
