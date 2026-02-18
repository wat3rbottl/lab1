import java.util.ArrayList;
import java.awt.*;

public class CarRepairShop<T extends Car> implements Transporter<T>{
    private final int capacity;
    private ArrayList<T> cars = new ArrayList<>();

    private double x; // The shops x coordinate
    private double y; // The shops y coordinate

    public CarRepairShop(int maxCars, double x, double y) {
        this.x = x;
        this.y = y;
        capacity = maxCars;
    }
//    public void setPosition(double x, double y){
//        this.x = x;
//        this.y = y;
//    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
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
        return cars.remove(0);
    }

    public int newCustomerIndex(){
        return cars.size();
    }

    public Car returnCar(int index){
        return cars.remove(index);
    }
}




