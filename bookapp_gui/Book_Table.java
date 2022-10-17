package bookapp_gui;

import javafx.scene.control.CheckBox;

/**
 *
 * @authors Joshua & Maryan
 */
public class Book_Table extends Book {

    private CheckBox select;

    public Book_Table(String name, double price) {
        super(name, price);
        this.select = new CheckBox();
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }

}
