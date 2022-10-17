package bookapp_gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @authors Joshua & Maryan
 */

public abstract class GUI implements EventHandler<ActionEvent> {

    protected Stage stage;
    protected Scene scene;
    protected Context sc;

    protected Window window;

    public GUI(Stage stage, Context sc, Window window) {
        this.stage = stage;
        this.sc = sc;

        this.window = window;

        createGUI();
    }

    /**
     * Creates the UI (class specific)
     *
     * @param stage
     */
    protected abstract void createGUI();

}
