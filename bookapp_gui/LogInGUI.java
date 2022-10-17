package bookapp_gui;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @authors Joshua & Maryan
 */
public class LogInGUI extends GUI {

    public LogInGUI(Stage stage, Context sc, Window window) {
        super(stage, sc, window);
    }

    @Override
    protected void createGUI() {

        //TextFields - Interactive
        TextField userName = new TextField();
        userName.setId("userName");
        TextField passWord = new TextField();
        passWord.setId("passWord");

        //Text
        Text t1 = new Text("Welcome to the Bookstore App");
        Text t2 = new Text("Username:");
        Text t3 = new Text("Password:");

        //Button
        Button logIn = new Button("Login");

        //Button Handler
        logIn.setOnAction((ActionEvent actionEvent) -> {
            LogIn temp = (LogIn) (sc);

            String result = temp.loginCheck(temp.getUserList(), userName.getText(), passWord.getText());
            System.out.println(result);

            switch (result) {
                case "admin":
                    window.owner();
                    break;
                case "":
                    System.out.println("ERROR - Login failed");
                    break;
                default:
                    window.customer(result);
                    break;
            }

            System.out.println("Login \tUsername: " + userName.getText() + "\tPassword: " + passWord.getText());
        });

        //Gridpane
        GridPane gp = new GridPane();
        gp.add(t1, 0, 0, 1, 1);
        gp.add(t2, 0, 1, 1, 1);
        gp.add(userName, 1, 1, 1, 1);
        gp.add(t3, 0, 2, 1, 1);
        gp.add(passWord, 1, 2, 1, 1);
        gp.add(logIn, 1, 3, 1, 1);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setAlignment(Pos.TOP_CENTER);

        scene = new Scene(gp, stage.getWidth(), stage.getHeight());

        stage.setScene(scene);

    }

    @Override
    public void handle(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
