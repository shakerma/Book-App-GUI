package bookapp_gui;

import java.util.ArrayList;

/**
 *
 * @authors Joshua & Maryan
 */

public abstract class SecondaryContext extends Context {

    private static ArrayList<Book> books = new ArrayList<>();
    private String bookName;
    private double bookPrice;
    private String secondaryState;

    public void setBookList(ArrayList<Book> books) {
        this.books = books;
    }

    public String getState() {
        return secondaryState;
    }

    public void setState(String state) {
        secondaryState = state;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void makeNewBookList() {
        books = new ArrayList<>();
    }

    public Book getBook(String name) {
        for (Book book : books) {
            if (name.equals(book.getName())) {
                return book;
            }
        }
        return null;
    }
}
