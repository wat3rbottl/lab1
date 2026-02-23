public interface HasPosition {

    double getX();

    double getY();

    void setPosition(double x, double y);

    default boolean isNear(HasPosition other, double distance) {
        double dx = Math.abs(getX() - other.getX());
        double dy = Math.abs(getY() - other.getY());

        return dx <= distance && dy <= distance;
    }
}

