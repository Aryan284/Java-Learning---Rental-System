package repository;

import Vehicle.HireableVehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VehicleRepository {
    public static HashMap<String, HireableVehicle> vehicleMap = new HashMap<>();
    public static List<HireableVehicle> vehicles = new ArrayList<>();
    public HireableVehicle addVehicle(HireableVehicle hireableVehicle){
        vehicleMap.putIfAbsent(hireableVehicle.getId(), hireableVehicle);
        vehicles.add(hireableVehicle);
        return hireableVehicle;
    }
}
