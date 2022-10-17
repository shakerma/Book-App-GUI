/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookapp_gui;

/**
 *
 * @authors Joshua & Maryan
 */
public class Customer extends SecondaryContext {

    private final CustomerStates costScreen = new CustomerCostScreen();
    private final CustomerStates startScreen = new CustomerStartScreen();

    public CustomerStates getCostScreen() {
        return costScreen;
    }

    public CustomerStates getStartScreen() {
        return startScreen;
    }

}
