package bookapp_gui;

import javafx.stage.Stage;

/**
 *
 * @authors Joshua & Maryan
 */

public class Window {

    private final LogIn CNT1;
    private LogInGUI GUI1;

    private final Owner CNT2;
    private OwnerGUI GUI2;

    private final Customer CNT3;
    private CustomerGUI GUI3;

    private final Stage stage;

    public Window(Stage stage) {
        CNT1 = new LogIn();
        CNT2 = new Owner();
        CNT3 = new Customer();
        this.stage = stage;

        load();
        logIn();
    }

    public String getBookString() {
        String books = "";
        for (Book book : CNT2.getBooks()) {
            books += book.toString() + "\n";
        }
        return books;
    }

    public String getCustomerString() {
        String user = "";
        for (UserInfo info : CNT2.getUserList()) {
            user += info.toString() + "\n";
        }
        return user;
    }

    private void load() {
        FileParser fp = new FileParser();
        CNT2.setBookList(fp.getBooks());
        CNT2.setUserList(fp.getUserList());
    }

    public void logIn() {
        GUI1 = new LogInGUI(stage, CNT1, this);
    }

    public void owner() {
        GUI2 = new OwnerGUI(stage, CNT2, this);
    }

    public void customer(String customerName) {
        GUI3 = new CustomerGUI(stage, CNT3, customerName, this);
    }
}
