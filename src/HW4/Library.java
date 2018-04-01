package HW4;

import java.util.HashMap;
import java.util.Map;


public class Library {
    Map<Book, Integer> library = new HashMap<>();

    public void getBook(Book book, Integer quantity) {
        if (library.containsKey(book)) {
            if (library.get(book) < quantity) {
                System.out.println("Нет столько книг");
            } else {
                Integer value = library.get(book);
                library.put(book, value - quantity);
            }
        } else {
            System.out.println("Нет такой книги");
        }
    }

    public void putBook(Book book, Integer quantity) {
        if (library.containsKey(book)) {
            Integer value = library.get(book);
            library.put(book, value + quantity);
        } else {
            library.put(book, quantity);
        }
    }

}

class Book {
    String author;
    int year;
    String name;
    public Book(String name, String author, int year) {
        this.author = author;
        this.name = name;
        this.year = year;
    }
}
