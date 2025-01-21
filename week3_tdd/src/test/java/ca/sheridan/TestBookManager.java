package ca.sheridan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class TestBookManager {

    @Test
    public void testDuplicateBook() {
        BookManager bm = new BookManager();
        Book book1 = new Book("Harry Potter", "J.K Rowling", 99.99, "101");
        Book book2 = new Book("Harry Potter", "J.K Rowling", 99.99, "101");
        bm.addBook(book1);
        assertFalse(bm.addBook(book2));
    }
    
    @Test
    public void testAddBook() {
        BookManager bm = new BookManager();
        Book book = new Book("Harry Potter", "J.K Rowling", 99.99, "101");
        assertTrue(bm.addBook(book));
    }

    @Test
    public void testGetBook() {
        BookManager bm = new BookManager();
        Book book = new Book("Harry Potter", "J.K Rowling", 99.99, "101");
        bm.addBook(book);
        Book retreivedbook = null;
        retreivedbook = bm.getBook(book.getIsbn());
        assertNotNull(retreivedbook);
    }

    @Test
    public void testUpdateBook() {
        BookManager bm = new BookManager();
        Book book = new Book("Art of War", "Unkown", 99.99, "101");
        bm.addBook(book);
        book.setAuthor("Sun Tsu");
        assertTrue(bm.updateBook(book));
        Book updatedBook = bm.getBook(book.getIsbn());
        assertEquals("Sun Tsu", updatedBook.getAuthor());
    }

    @Test
    public void testRemoveBook() {
        BookManager bm = new BookManager();
        Book book = new Book("Art of War", "Unkown", 99.99, "101");
        bm.addBook(book);
        assertTrue(bm.removeBook(book));
        assertNull(bm.getBook(book.getIsbn()));
    }
}
