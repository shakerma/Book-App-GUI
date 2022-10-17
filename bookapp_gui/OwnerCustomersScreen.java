package bookapp_gui;

import java.util.ArrayList;

/**
 *
 * @authors Joshua & Maryan
 */

public class OwnerCustomersScreen extends OwnerStates {

    public String state = "Owner Customers Screen";

    public boolean addCustomer(String userName, String passWord, ArrayList<UserInfo> userList) {
        if (!userList.isEmpty()) {
            for (UserInfo info : userList) {
                if (info.getUserName().equals(userName) || info.getUserName().equals("admin")) {
                    return false;
                }
            }
        }
        userList.add(new UserInfo(userName, passWord));
        return true;
    }

    public boolean deleteCustomer(String name, ArrayList<UserInfo> userList) {

        int i = 0;
        if (!userList.isEmpty()) {
            for (UserInfo info : userList) {
                if (info.getUserName().equals(name)) {
                    userList.remove(i);
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
