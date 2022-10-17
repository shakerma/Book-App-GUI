package bookapp_gui;

/**
 *
 * @authors Joshua & Maryan
 */
public class CustomerCostScreen extends CustomerStates {

    /**
     *
     * @param price - the TOTAL price
     * @param user
     * @param isPoints
     * @return
     */
    public double pointHandle(double price, UserInfo user, boolean willRedeem) {
        int point;
        int pointI = user.getPoints();

        if (willRedeem) {
            int pointsD = (int) (price * 100);
            if (pointsD > user.getPoints()) {
                point = pointsD - user.getPoints();
                user.setPoints(0);
                return point / 100.0;
            } else if (pointsD < user.getPoints()) {
                user.setPoints(user.getPoints() - pointsD);
                return 0.0;
            } else {
                user.setPoints(0);
                return 0.0;
            }
        }

        user.setPoints(user.getPoints() + ((int) (price) * 10));
        return price;
    }
}
