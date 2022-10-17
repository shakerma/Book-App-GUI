package bookapp_gui;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @authors Joshua & Maryan
 */
public class BookApp_GUI extends Application {

    public static final String PATH_CUSTOMER = "customer.txt";
    public static final String PATH_BOOK = "book.txt";

    private Window window;

    /**
     * Main Application - Run this
     *
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage = new Stage();
        stage.setTitle("Book Application");
        stage.setResizable(false);
        stage.setMinWidth(800);
        stage.setMaxWidth(800);
        stage.setMinHeight(600);
        stage.setMaxHeight(600);
        stage.show();

        window = new Window(stage);
    }

    @Override
    public void stop() {

        FileWrite fw = new FileWrite();

        fw.write(BookApp_GUI.PATH_BOOK, window.getBookString());
        fw.write(BookApp_GUI.PATH_CUSTOMER, window.getCustomerString());
    }
}
