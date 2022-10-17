package bookapp_gui;

/**
 *
 * @authors Joshua & Maryan
 */

public class Owner extends SecondaryContext {

    private final OwnerStates bookScreen = new OwnerBooksScreen();
    private final OwnerStates startScreen = new OwnerStartScreen();
    private final OwnerStates customerScreen = new OwnerCustomersScreen();

    public OwnerStates getBookScreen() {
        return bookScreen;
    }

    public OwnerStates getStartScreen() {
        return startScreen;
    }

    public OwnerStates getCustomerScreen() {
        return customerScreen;
    }
}
