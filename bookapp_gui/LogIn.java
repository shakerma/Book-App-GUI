package bookapp_gui;

import java.util.ArrayList;

/**
 *
 * @authors Joshua & Maryan
 */

public class LogIn extends Context {

    private String currentName = "";

    /**
     * Returns 1 if Owner, 2 if User, 0 if ERRORF
     *
     * @param userList
     * @param userName
     * @param passWord
     * @return
     */
    public String loginCheck(ArrayList<UserInfo> userList, String userName, String passWord) {

        if (userName.equals("admin") && passWord.equals("admin")) {
            return "admin";
        }
        for (UserInfo info : userList) {
            if (info.getUserName().equals(userName)) {
                if (info.getPassWord().equals(passWord)) {
                    currentName = info.getUserName();
                    System.out.println("Logging in as a customer");
                    return currentName;
                }
            }
        }
        return "";
    }

    public String getCurrentUser() {
        if (currentName.equals("")) {
            System.out.println("There is no current user");
        }
        return currentName;
    }
}
