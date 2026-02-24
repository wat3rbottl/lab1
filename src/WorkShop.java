import java.util.ArrayList;
import java.util.List;

public class WorkShop<T extends Car> implements HasPosition, Loader<T> {

    private final int capacity;
    private final List<T> cars = new ArrayList<>();
    private final Class<T> acceptedType;

    private double x;
    private double y;
    private final String imageId;

    public WorkShop(int capacity, double x, double y, String imageId, Class<T> acceptedType) {
        this.x = x;
        this.y = y;
        this.capacity = capacity;
        this.imageId = imageId;
        this.acceptedType = acceptedType;
    }

    @Override // Override from HasPosition
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int getCapacity() {
        return capacity;
    }

    public int numCars() {
        return cars.size();
    }

    public boolean hasSpace() { return cars.size() < capacity; }

    public Class<T> getAcceptedType() { return acceptedType; }

    @Override
    public boolean canLoad(T car) {
        return hasSpace();
    }

    @Override
    public boolean canUnload() {
        return !cars.isEmpty();
    }

    @Override
    public void load(T car) {
        if (canLoad(car)) cars.add(car);
    }

    @Override
    public T unload() {
        if (!canUnload()) return null;
        return cars.remove(0);
    }

    public boolean accepts(Car car) {
        return acceptedType.isInstance(car);
    }

    public boolean tryLoad(Car car) {
        if (!hasSpace()) return false;
        if (!accepts(car)) return false;

        // safe cast using the class token
        T accepted = acceptedType.cast(car);
        load(accepted);

        System.out.println("Loaded " + car.getImageId() + " into " + imageId);

        return true;
    }

// Används ej, men tanken var att man skulle kunna hämta ut
// specifik bil m.h.a. customerIndex (nummerlapp typ)
// ---------------------------------------------------------------------------------
//    public int newCustomerIndex() {
//        return cars.size();
//    }
//
//    public Vehicle returnVehicle(int index) {
//        return cars.remove(index);
//    }

    public String getImageId() {
        return imageId;
    }

}




