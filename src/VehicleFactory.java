import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

abstract class VehicleFactory {
    Map<VehicleType, Supplier<Vehicle>> vehicleMap= new HashMap<>();

    Vehicle createVehicle() {
        return new Vehicle() {

        }
        };
    }

}
