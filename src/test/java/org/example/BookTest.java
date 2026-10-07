package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void getters() {
        Book book = new Book("Pride and Prejudice", "Jane Austen", 1813);
        assertEquals("Pride and Prejudice", book.getTitle());
        assertEquals("Jane Austen", book.getAuthor());
        assertEquals(1813, book.getYear());
    }

    @Test
    public void sameBookIsEqual() {
        Book b1 = new Book("Pride and Prejudice", "Jane Austen", 1813);
        Book b2 = new Book("Pride and Prejudice", "Jane Austen", 1813);
        assertEquals(b1, b2);
        assertEquals(b1.hashCode(), b2.hashCode());
    }

    @Test
    public void differentYearIsNotEqual() {
        Book b1 = new Book("Pride and Prejudice", "Jane Austen", 1813);
        Book b2 = new Book("Pride and Prejudice", "Jane Austen", 1814);
        assertNotEquals(b1, b2);
    }

    @Test
    public void differentTitleIsNotEqual() {
        Book b1 = new Book("Pride and Prejudice", "Jane Austen", 1813);
        Book b2 = new Book("Emma", "Jane Austen", 1813);
        assertNotEquals(b1, b2);
    }

    @Test
    public void notEqualToNull() {
        Book b1 = new Book("Pride and Prejudice", "Jane Austen", 1813);
        assertNotEquals(b1, null);
    }

    @Test
    public void testToString() {
        Book book = new Book("Pride and Prejudice", "Jane Austen", 1813);
        assertEquals("Pride and Prejudice - Jane Austen (1813)", book.toString());
    }
}
