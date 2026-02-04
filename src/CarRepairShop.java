import java.util.ArrayList;
import java.awt.*;

public class CarRepairShop<T extends Car> implements Transporter<T>{
    private final int capacity;
    private ArrayList<T> cars = new ArrayList<>();

    public CarRepairShop(int maxCars){
        capacity = maxCars;
    }

    public int getCapacity(){
        return capacity;
    }

    public int numCars(){
        return cars.size();
    }

    @Override
    public void load(T car){
        if(cars.size() < capacity){
            cars.add(car);
        }
    }

    @Override
    public T unload(){
        if(cars.isEmpty()){
            return null;
        }
        return cars.removeFirst();
    }

    public int newCustomerIndex(){
        return cars.size();
    }

    public Car returnCar(int index){
        return cars.remove(index);
    }
}




