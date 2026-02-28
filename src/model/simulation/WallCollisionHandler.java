package model.simulation;

import model.vehicle.Vehicle;

public class WallCollisionHandler {
    private final int minX;
    private final int minY;
    private final int maxX;
    private final int maxY;

    public WallCollisionHandler(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void handle(Vehicle v) {
        int x = (int) Math.round(v.getX());
        int y = (int) Math.round(v.getY());

        if (x >= maxX && v.getDirection() == Vehicle.Direction.EAST) {
            v.setDirection(Vehicle.Direction.WEST);
        } else if (x <= minX && v.getDirection() == Vehicle.Direction.WEST) {
            v.setDirection(Vehicle.Direction.EAST);
        }
        if (y >= maxY && v.getDirection() == Vehicle.Direction.SOUTH) {
            v.setDirection(Vehicle.Direction.NORTH);
        } else if (y <= minY && v.getDirection() == Vehicle.Direction.NORTH) {
            v.setDirection(Vehicle.Direction.SOUTH);
        }

        v.setPosition(
                Math.max(minX, Math.min(maxX, v.getX())),
                Math.max(minY, Math.min(maxY, v.getY()))
        );      // make sure car doesn't get stuck out of bounds

    }
}

