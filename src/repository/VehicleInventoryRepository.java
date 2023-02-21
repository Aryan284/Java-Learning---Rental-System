package repository;

import Reservation.VehicleInventory;
import Vehicle.HireableVehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventoryRepository {
    public static ArrayList<VehicleInventory> vehicleInventoryList = new ArrayList<>();
    public VehicleInventory addToInventory(VehicleInventory vehicleInventory){
        vehicleInventoryList.add(vehicleInventory);
        return vehicleInventory;
    }

    public void removeFromInventory(VehicleInventory vehicleInventory){
        vehicleInventoryList.removeIf(vi-> vi.getVehicle().getQrCode().equalsIgnoreCase(vehicleInventory.getVehicle().getQrCode()));
    }



}
