package model.simulation;

import interfaces.Rampable;
import interfaces.Turboable;
import interfaces.SimulationObserver;
import model.vehicle.Car;
import model.vehicle.Vehicle;
import model.workshop.WorkShop;
import view.RenderItemMapper;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final RenderItemMapper mapper = new RenderItemMapper();
    private List <Vehicle> vehicles;
    private List <SimulationObserver> observers = new ArrayList();
    private final WallCollisionHandler wall;
    private final WorkShopCollisionHandler workshopCollision;
    private final List<WorkShop<? extends Car>> workShops;

    public Simulation(List<Vehicle> vehicles, List<WorkShop<? extends Car>> workShops, WallCollisionHandler wall, WorkShopCollisionHandler workshopCollision) {
        this.wall = wall;
        this.workshopCollision = workshopCollision;
        this.workShops = workShops;
        this.vehicles = vehicles;
    }

    public void addObserver(SimulationObserver observer){
        observers.add(observer);
    }

    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    public List<Vehicle> getVehicles(){
        return vehicles;
    }

    public List<WorkShop<? extends Car>> getWorkShops(){
        return workShops;
    }

    public boolean tick() {
        for (Vehicle v : vehicles) {
            wall.handle(v);
            v.move();
        }

        List<Vehicle> toRemove = workshopCollision.handle(vehicles, workShops);
        vehicles.removeAll(toRemove);
        observers.forEach(o->o.onTick(mapper.map(vehicles, workShops)));
        return true;
    }

    // gas all -actions:
    public void gasAll(double amount)   { for (Vehicle v : vehicles) v.gas(amount); }
    public void brakeAll(double amount) { for (Vehicle v : vehicles) v.brake(amount); }
    public void startAll()              { for (Vehicle v : vehicles) v.startEngine(); }
    public void stopAll()               { for (Vehicle v : vehicles) v.stopEngine(); }
    public void turnLeftAll()           { for (Vehicle v : vehicles) v.turnLeft(); }
    public void turnRightAll()          { for (Vehicle v : vehicles) v.turnRight(); }
    public void upAll()                 { for (Vehicle v : vehicles) v.up(); }
    public void downAll()               { for (Vehicle v : vehicles) v.down(); }


    // ADD/REMOVE CARS
    public void addVehicleSim(Vehicle v) {
        if (vehicles.size() < 10) {
            vehicles.add(v);
        }
    }

    public void removeVehicle() {
        if (!vehicles.isEmpty()) {
            vehicles.remove(vehicles.size() - 1);
        }
    }

    public int getVehicleCount() {
        return vehicles.size();
    }

    // instance-of things
    public void turboOn() {
        for (Vehicle v : vehicles)
            if (v instanceof Turboable t) t.turboOn();
    }

    public void turboOff() {
        for (Vehicle v : vehicles)
            if (v instanceof Turboable t) t.turboOff();
    }

    public void toggleTurbo(){
        for (Vehicle v : vehicles){
            if (v instanceof Turboable t) t.toggleTurbo();
        }
    }

    public void lowerBed() {
        for (Vehicle v : vehicles)
            if (v instanceof Rampable r) r.lowerBed();
    }

    public void raiseBed() {
        for (Vehicle v : vehicles)
            if (v instanceof Rampable r) r.raiseBed();
    }


    // Unload random car from random workshop
    public boolean unloadCarFromShopRandom() {
        for (WorkShop<? extends Car> ws : workShops) {
            if (ws.canUnload()) {
                Car car = ws.unload();
                car.setPosition(car.getX(), car.getY() - 80);
                car.stopEngine();
                vehicles.add(car);
                return true;
            }
        }
        return false;
    }
}

