package bookapp_gui;

/**
 *
 * @authors Joshua & Maryan
 */

public class UserInfo {

    // Login info , ,
    // User's Real Name ,
    // Either be Gold or Silver ;
    private String userName, passWord, status;
    private int points;

    public UserInfo(String userName, String passWord) {

        this.userName = userName;
        this.passWord = passWord;
        this.status = "Silver";
        this.points = 0;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getStatus() {
        return status;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
        // Gold >= 1000 Points, Silver < 1000 points
        if (this.points < 1000) {
            status = "Silver";
        } else {
            status = "Gold";
        }
    }

    @Override
    public String toString() {
        return userName + " " + passWord + " " + points;
    }
}
