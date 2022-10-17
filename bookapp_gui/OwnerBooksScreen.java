package bookapp_gui;

import java.util.ArrayList;

/**
 *
 * @authors Joshua & Maryan
 */

public class OwnerBooksScreen extends OwnerStates {

    public String state = "Owner Books Screen";

    public boolean addBook(String name, String price, ArrayList<Book> books) {
        //does the book already exist?
        if (!books.isEmpty()) {
            for (Book book : books) {
                if (book.getName().equals(name)) {
                    return false;
                }
            }
        }

        //price check
        if (!price.matches("\\d+(.\\d{1,2})?")) { // is it a valid price?
            return false;
        }

        books.add(new Book(name, Double.parseDouble(price)));
        return true;
    }

    public boolean deleteBook(String name, ArrayList<Book> books) {
        int i = 0;
        for (Book info : books) {
            if (info.getName().equals(name)) {
                books.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }
}
