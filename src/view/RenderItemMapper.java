package view;

import model.workshop.WorkShop;
import model.vehicle.Car;
import model.vehicle.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class RenderItemMapper {
    public List<RenderItem> map(List<Vehicle> vehicles, List<WorkShop<? extends Car>> shops) {
        List<RenderItem> items = new ArrayList<>();

        for (Vehicle v : vehicles) {
            items.add(new RenderItem(
                    v.getClass().getSimpleName(),
                    (int) Math.round(v.getX()),
                    (int) Math.round(v.getY()),
                    v.getDirection() == Vehicle.Direction.WEST
            ));
        }

        for (WorkShop<? extends Car> ws : shops) {
            String imageId = ws.getAcceptedType() == Car.class
                    ? "GeneralShop"
                    : ws.getAcceptedType().getSimpleName() + "Shop";
            items.add(new RenderItem(imageId, (int) Math.round(ws.getX()), (int) Math.round(ws.getY()), false));
        }

        return items;
    }
}