package model.simulation;

import model.vehicle.Car;
import model.vehicle.Vehicle;
import model.workshop.WorkShop;

import java.util.ArrayList;
import java.util.List;

public class WorkShopCollisionHandler {

    private final double distance;

    public WorkShopCollisionHandler(double distance) {
        this.distance = distance;
    }

    public List<Vehicle> handle(List<Vehicle> vehicles, List<WorkShop<? extends Car>> shops) {
        List<Vehicle> toRemove = new ArrayList<>();

        for (Vehicle v : vehicles) {
            if (!(v instanceof Car car)) continue;

            for (WorkShop<? extends Car> shop : shops) {
                if (!car.isNear(shop, distance)) continue;
                if (!shop.hasSpace()) continue;

                if (shop.tryLoad(car)) {
                    toRemove.add(v);
                    break;
                }
            }
        }
        return toRemove;
    }
}