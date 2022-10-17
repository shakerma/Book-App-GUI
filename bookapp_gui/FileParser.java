package bookapp_gui;

/**
 *
 * @authors Joshua & Maryan
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList; // import the ArrayList class

public class FileParser {

    private ArrayList<UserInfo> users = new ArrayList<>(); // Create an ArrayList object
    private ArrayList<Book> books = new ArrayList<>(); // Create an ArrayList object
    private BufferedReader bookReader = null;
    private BufferedReader userReader = null;

    public ArrayList<UserInfo> getUserList() {
        try {
            userReader = new BufferedReader(new FileReader(BookApp_GUI.PATH_CUSTOMER));

            System.out.println("Reading the file using readLine() method:");
            String contentLine = userReader.readLine();
            while (contentLine != null) {
                String[] array = contentLine.split(" ");
                String username = array[0];
                String password = array[1];
                int points = Integer.parseInt(array[2]);
                UserInfo newUser = new UserInfo(username, password);
                newUser.setPoints(points);
                users.add(newUser);
                contentLine = userReader.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (userReader != null) {
                    userReader.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error in closing the BufferedReader");
            }
        }
        return users;
    }

    public ArrayList<Book> getBooks() {
        try {
            bookReader = new BufferedReader(new FileReader(BookApp_GUI.PATH_BOOK));

            System.out.println("Reading the file using readLine() method:");
            String contentLine = bookReader.readLine();
            while (contentLine != null) {
                String[] array = contentLine.split(" ");
                String name = "";
                for (int i = 0; i < array.length - 1; i++) {
                    name += array[i] + " ";
                }
                double price = Double.parseDouble(array[array.length - 1]);
                Book newBook = new Book(name, price);
                books.add(newBook);
                contentLine = bookReader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bookReader != null) {
                    bookReader.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error in closing the BufferedReader");
            }
        }
        return books;
    }
}
