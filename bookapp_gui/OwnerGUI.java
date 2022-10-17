package bookapp_gui;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @authors Joshua & Maryan
 */

public class OwnerGUI extends GUI {

    private final Owner owner;

    public OwnerGUI(Stage stage, Owner sc, Window window) {
        super(stage, sc, window);
        owner = new Owner();
    }

    @Override
    protected void createGUI() {
        createStartScreen();
    }

    private void createStartScreen() {
        //Buttons
        Button books = new Button("Books");
        books.setId("Books");
        Button customers = new Button("Customers");
        customers.setId("Customers");
        Button logOut = new Button("Logout");
        logOut.setId("Logout");

        //Button Handlers
        books.setOnAction((ActionEvent actionEvent) -> {
            createBookScreen();
            System.out.println("Books");
        });
        customers.setOnAction((ActionEvent actionEvent) -> {
            createCustomerScreen();
            System.out.println("Customers");
        });
        logOut.setOnAction((ActionEvent actionEvent) -> {
            createLogoutScreen();
            System.out.println("Logout");
        });

        //Gridpane
        GridPane gp = new GridPane();
        gp.add(books, 0, 0, 1, 1);
        gp.add(customers, 0, 1, 1, 1);
        gp.add(logOut, 0, 2, 1, 1);

        scene = new Scene(gp, stage.getWidth(), stage.getHeight());
        stage.setScene(scene); // don't do this all of the time! Only when called
    }

    private void createBookScreen() {
        double tableWidth = stage.getWidth() * 0.8;
        double tableHeight = stage.getHeight() * 0.6;

        //Table
        TableView<Book> table = new TableView();
        table.setEditable(false);
        table.setMinWidth(tableWidth);
        table.setMinHeight(tableHeight);
        table.setMaxWidth(tableWidth);
        table.setMaxHeight(tableHeight);

        //Columns
        TableColumn<Book, String> bookName = new TableColumn("Book Name");
        bookName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Book, String> bookPrice = new TableColumn("Book Price");
        bookPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        bookName.setMinWidth(tableWidth / 2);
        bookPrice.setMinWidth(tableWidth / 2);
        bookName.setMaxWidth(tableWidth / 2);
        bookPrice.setMaxWidth(tableWidth / 2);

        //Text
        Text t1 = new Text("Name:");
        Text t2 = new Text("Price:");

        //TextFields - Interactive
        TextField name = new TextField();
        name.setId("name");
        TextField price = new TextField();
        price.setId("price");

        //Button
        Button add = new Button("Add");
        Button delete = new Button("Delete");
        Button back = new Button("Back");

        //Button Handler
        add.setOnAction((ActionEvent actionEvent) -> {
            Owner temp = (Owner) (sc);
            OwnerBooksScreen temp2 = (OwnerBooksScreen) (owner.getBookScreen());

            boolean result = temp2.addBook(name.getText(), price.getText(), temp.getBooks());

            if (result) {
                Book book = new Book(name.getText(), Double.parseDouble(price.getText()));
                table.getItems().add(book);
                table.refresh();
                System.out.println("Adding \tName: " + name.getText() + "\tPrice: " + price.getText());
            } else {
                System.out.println("ERROR - Can't add book\tName: " + name.getText() + "\tPrice: " + price.getText());
            }
        });

        back.setOnAction((ActionEvent actionEvent) -> {
            createStartScreen();
        });

        delete.setOnAction((ActionEvent actionEvent) -> {
            Owner temp = (Owner) (sc);
            OwnerBooksScreen temp2 = (OwnerBooksScreen) (owner.getBookScreen());
            Book temp3 = table.getSelectionModel().getSelectedItem();
            boolean result = temp2.deleteBook(temp3.getName(), temp.getBooks());

            if (result) {
                table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
                System.out.println("Deleting Book");
            } else {
                System.out.println("ERROR - Can't delete book");
            }
        });

        table.getColumns().addAll(bookName, bookPrice);

        //Gridpane
        GridPane gp = new GridPane();
        gp.add(table, 0, 0, 5, 1);
        gp.add(t1, 0, 1, 1, 1);
        gp.add(name, 1, 1, 1, 1);
        gp.add(t2, 2, 1, 1, 1);
        gp.add(price, 3, 1, 1, 1);
        gp.add(add, 4, 1, 1, 1);
        gp.add(delete, 0, 2, 1, 1);
        gp.add(back, 1, 2, 1, 1);

        //Loading stuff
        Owner temp = (Owner) (sc);

        for (Book book : temp.getBooks()) {
            table.getItems().add(book);
        }

        scene = new Scene(gp, stage.getWidth(), stage.getHeight());
        stage.setScene(scene); // don't do this all of the time! Only when called
    }

    private void createCustomerScreen() {
        double tableWidth = stage.getWidth() * 0.8;
        double tableHeight = stage.getHeight() * 0.6;

        //Table
        TableView<UserInfo> table = new TableView();
        table.setEditable(false);
        table.setMinWidth(tableWidth);
        table.setMinHeight(tableHeight);
        table.setMaxWidth(tableWidth);
        table.setMaxHeight(tableHeight);

        //Table Columns
        TableColumn<UserInfo, String> userName = new TableColumn("Username");
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        TableColumn<UserInfo, String> passWord = new TableColumn("Password");
        passWord.setCellValueFactory(new PropertyValueFactory<>("passWord"));
        TableColumn<UserInfo, String> points = new TableColumn("Points");
        points.setCellValueFactory(new PropertyValueFactory<>("points"));

        userName.setMinWidth(tableWidth / 3);
        passWord.setMinWidth(tableWidth / 3);
        points.setMinWidth(tableWidth / 3);
        userName.setMaxWidth(tableWidth / 3);
        passWord.setMaxWidth(tableWidth / 3);
        points.setMaxWidth(tableWidth / 3);

        //Text
        Text t1 = new Text("UserName:");
        Text t2 = new Text("PassWord:");

        //TextFields - Interactive
        TextField name = new TextField();
        name.setId("name");
        TextField password = new TextField();
        password.setId("password");

        //Button
        Button add = new Button("Add");
        Button delete = new Button("Delete");
        Button back = new Button("Back");

        //Button Handler
        add.setOnAction((ActionEvent actionEvent) -> {

            Owner temp = (Owner) (sc);
            OwnerCustomersScreen temp2 = (OwnerCustomersScreen) (owner.getCustomerScreen());

            boolean result = temp2.addCustomer(name.getText(), password.getText(), temp.getUserList());

            if (result) {
                UserInfo customer = new UserInfo(name.getText(), password.getText());
                table.getItems().add(customer);
                table.refresh();
                System.out.println("Adding \tUserName: " + name.getText() + "\tPassWord: " + password.getText());
            } else {
                System.out.println("ERROR - Cannot add customer");
            }

        });

        back.setOnAction((ActionEvent actionEvent) -> {
            createStartScreen();
        });

        delete.setOnAction((ActionEvent actionEvent) -> {

            Owner temp = (Owner) (sc);
            OwnerCustomersScreen temp2 = (OwnerCustomersScreen) (owner.getCustomerScreen());
            UserInfo temp3 = table.getSelectionModel().getSelectedItem();
            boolean result = temp2.deleteCustomer(temp3.getUserName(), temp.getUserList());

            if (result) {
                table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
                System.out.println("Deleting Book");
            } else {
                System.out.println("ERROR - Can't delete book");
            }

        });

        table.getColumns().addAll(userName, passWord, points);

        //Gridpane
        GridPane gp = new GridPane();
        gp.add(table, 0, 0, 5, 1);
        gp.add(t1, 0, 1, 1, 1);
        gp.add(name, 1, 1, 1, 1);
        gp.add(t2, 2, 1, 1, 1);
        gp.add(password, 3, 1, 1, 1);
        gp.add(add, 4, 1, 1, 1);
        gp.add(delete, 0, 2, 1, 1);
        gp.add(back, 1, 2, 1, 1);

        //Loading stuff
        Owner temp = (Owner) (sc);

        for (UserInfo info : temp.getUserList()) {
            table.getItems().add(info);
        }

        scene = new Scene(gp, stage.getWidth(), stage.getHeight());
        stage.setScene(scene); // don't do this all of the time! Only when called
    }

    private void createLogoutScreen() {
        window.logIn();
    }

    @Override
    public void handle(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
