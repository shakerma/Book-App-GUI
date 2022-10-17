package bookapp_gui;

/**
 *
 * @authors Joshua & Maryan
 */
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Joshu
 */
public class CustomerGUI extends GUI {

    private final String customerName;
    private final Customer customer;

    private String c_name = "<<ADD>>";
    private String c_status = "<<ADD>>";
    private int c_points = -1;

    public CustomerGUI(Stage stage, Customer sc, String customerName, Window window) {
        super(stage, sc, window);
        this.customerName = customerName;
        this.customer = new Customer();

        if (!errorCheck()) {
            Customer temp = (Customer) (sc);
            c_name = temp.getUserInfo(customerName).getUserName();
            c_points = temp.getUserInfo(customerName).getPoints();
            c_status = temp.getUserInfo(customerName).getStatus();
            createStartScreen();
        } else {
            System.out.println("ERROR - CustomerGUI problem");
        }
    }

    private boolean errorCheck() {
        Customer temp = (Customer) (sc);
        return temp.getUserInfo(customerName) == null;
    }

    @Override
    protected void createGUI() {
        createStartScreen();
    }

    private void createStartScreen() {
        double tableWidth = stage.getWidth() * 0.8;
        double tableHeight = stage.getHeight() * 0.6;

        Customer temp = (Customer) (sc);

        //Text
        Text t1 = new Text("Welcome " + c_name + "\tYou have " + c_points
                + " points\tYour status " + "is " + c_status);

        //Checkbox
        //CheckBox selected = new CheckBox();
        //Table
        TableView<Book_Table> table = new TableView();
        table.setEditable(true);
        table.setMinWidth(tableWidth);
        table.setMinHeight(tableHeight);
        table.setMaxWidth(tableWidth);
        table.setMaxHeight(tableHeight);

        //Table Columns
        TableColumn<Book_Table, String> bookName = new TableColumn("Book Name");
        bookName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Book_Table, String> bookPrice = new TableColumn("Book Price");
        bookPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Book_Table, String> select = new TableColumn<>("Select");
        select.setCellValueFactory(new PropertyValueFactory<>("select"));

        bookName.setMinWidth(tableWidth / 3);
        bookPrice.setMinWidth(tableWidth / 3);
        select.setMinWidth(tableWidth / 3);
        bookName.setMaxWidth(tableWidth / 3);
        bookPrice.setMaxWidth(tableWidth / 3);
        select.setMaxWidth(tableWidth / 3);

        //Button
        Button buy = new Button("Buy");
        Button redeemBuy = new Button("Redeem Points and Buy");
        Button logOut = new Button("Logout");

        //Button Handler
        buy.setOnAction((ActionEvent actionEvent) -> {
            CustomerCostScreen temp2 = (CustomerCostScreen) (customer.getCostScreen());

            double totalPrice = 0;
            for (Book_Table bt : table.getItems()) {
                totalPrice += bt.getSelect().isSelected() ? bt.getPrice() : 0.0;
            }

            temp2.pointHandle(totalPrice, temp.getUserInfo(c_name), false);
            createCostScreen(table, totalPrice);
        });

        redeemBuy.setOnAction((ActionEvent actionEvent) -> {
            CustomerCostScreen temp2 = (CustomerCostScreen) (customer.getCostScreen());

            double totalPrice = 0;
            for (Book_Table bt : table.getItems()) {
                totalPrice += bt.getSelect().isSelected() ? bt.getPrice() : 0.0;
            }
            totalPrice = Math.round(temp2.pointHandle(totalPrice, temp.getUserInfo(c_name), true) * 100.0) / 100.0;
            createCostScreen(table, temp2.pointHandle(totalPrice, temp.getUserInfo(c_name), true));
        });

        logOut.setOnAction((ActionEvent actionEvent) -> {
            window.logIn();
        });

        table.getColumns().addAll(bookName, bookPrice, select);

        //Gridpane
        GridPane gp = new GridPane();
        gp.add(t1, 0, 0, 5, 1);
        gp.add(table, 0, 1, 5, 1);
        gp.add(buy, 0, 2, 1, 1);
        gp.add(redeemBuy, 1, 2, 1, 1);
        gp.add(logOut, 2, 2, 1, 1);

        //Loading stuff
        for (Book book : temp.getBooks()) {
            Book_Table bt = new Book_Table(book.getName(), book.getPrice());
            table.getItems().add(bt);
        }

        scene = new Scene(gp, stage.getWidth(), stage.getHeight());
        stage.setScene(scene); // don't do this all of the time! Only when called     

    }

    private void createCostScreen(TableView<Book_Table> table, double totalPrice) {
        Customer temp = (Customer) (sc);

        Text t1 = new Text("Total Cost: " + totalPrice);
        Text t2 = new Text("Points: " + temp.getUserInfo(customerName).getPoints());
        Text t3 = new Text("Status: " + temp.getUserInfo(customerName).getStatus());

        Button logOut = new Button("Logout");

        logOut.setOnAction((ActionEvent actionEvent) -> {
            window.logIn();
        });

        //Gridpane
        GridPane gp = new GridPane();
        gp.add(t1, 0, 0, 1, 1);
        gp.add(t2, 0, 1, 1, 1);
        gp.add(t3, 1, 1, 1, 1);
        gp.add(logOut, 0, 2, 1, 1);

        scene = new Scene(gp, stage.getWidth(), stage.getHeight());
        stage.setScene(scene); // don't do this all of the time! Only when called    

    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof CheckBoxTableCell) {
            CheckBoxTableCell box = (CheckBoxTableCell) event.getSource();
            box.getSelectedStateCallback();

        }
    }

}
