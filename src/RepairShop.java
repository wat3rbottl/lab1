import java.util.ArrayList;

public class RepairShop<T extends Vehicle & Loadable> implements Loader<T> {
    private final int capacity;
    private ArrayList<T> vehicles = new ArrayList<>();

    private double x; // The shops x coordinate
    private double y; // The shops y coordinate
    private String modelName;

    public RepairShop(int capacity, double x, double y, String modelName) {
        this.x = x;
        this.y = y;
        this.capacity = capacity;
        this.modelName = modelName;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getCapacity() {
        return capacity;
    }

    public int numCars() {
        return vehicles.size();
    }

    @Override
    public void load(T vehicle) {
        if (vehicles.size() < capacity) {
            vehicles.add(vehicle);
        }
    }

    @Override
    public T unload() {
        if (vehicles.isEmpty()) {
            return null;
        }
        return vehicles.remove(0);
    }

    public int newCustomerIndex() {
        return vehicles.size();
    }

    public Vehicle returnVehicle(int index) {
        return vehicles.remove(index);
    }

    public String getImageId(){
        return modelName;
    }

}




