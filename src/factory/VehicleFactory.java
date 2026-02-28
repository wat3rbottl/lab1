package factory;

import model.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public abstract class VehicleFactory {
    private final Map<VehicleType, Supplier<Vehicle>> registry = new HashMap<>();

    protected void register(VehicleType type, Supplier<Vehicle> supplier) {
        registry.put(type, supplier);
    }

    public Vehicle createVehicle(VehicleType type) {
        Supplier<Vehicle> supplier = registry.get(type);
        if (supplier == null) throw new IllegalArgumentException("Unknown vehicle type: " + type);
        return supplier.get();
    }
}
