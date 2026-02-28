package factory;
import model.vehicle.*;

public class StandardVehicleFactory extends VehicleFactory{
    public StandardVehicleFactory(){
        register(VehicleType.SAAB95, Saab95::new);
        register(VehicleType.VOLVO240, Volvo240::new);
        register(VehicleType.VOLKSWAGEN_UNICORN, VolkswagenUnicorn::new);
        register(VehicleType.SCANIA, Scania::new);
    }
}
