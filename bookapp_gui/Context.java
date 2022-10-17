package bookapp_gui;

import java.util.ArrayList;

/**
 *
 * @authors Joshua & Maryan
 */
public abstract class Context {

    private static ArrayList<UserInfo> userList = new ArrayList<>();

    public ArrayList<UserInfo> getUserList() {
        return userList;
    }

    public UserInfo getUserInfo(String name) {
        for (UserInfo info : userList) {
            if (name.equals(info.getUserName())) {
                return info;
            }
        }
        return null;
    }

    public void setUserList(ArrayList<UserInfo> userList) {
        this.userList = userList;
    }
}
