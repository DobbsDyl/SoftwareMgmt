package ca.sheridan;

import java.util.HashMap;
import java.util.Map;

public class BookManager {

    private Map<String, Book> books = new HashMap<String, Book>();

    public boolean addBook(Book book) {
        if (book == null || books.containsKey(book.getIsbn())) {
            return false;
        } else {
            books.put(book.getIsbn(), book);
            return true;
        }
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public Book getBook(String bookIsbn) {
        Book retreivedBook = books.get(bookIsbn);
        return retreivedBook;
    }

    public boolean updateBook(Book book) {
        if (book == null) {
            return false;
        } else {
            if (books.containsKey(book.getIsbn())) {
                books.replace(book.getIsbn(), book);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean removeBook(Book book) {
        if (book == null) {
            return false;
        } else {
            if (books.containsKey(book.getIsbn())) {
                books.remove(book.getIsbn());
                return true;
            } else {
                return false;
            }
        }
    }
}
