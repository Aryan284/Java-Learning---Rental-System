package services;
import java.util.*;
import Vehicle.HireableVehicle;
import Vehicle.VehicleType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface VehicleSearchService {
    List<HireableVehicle> searchByType(VehicleType vehicleType, String city, LocalDateTime fromDate, LocalDateTime endTime);
    List<HireableVehicle> searchByModel(String make, String city, String model, LocalDateTime fromDate, LocalDateTime endTime);
    List<HireableVehicle> search(int seats, String city, LocalDateTime fromDate, LocalDateTime endTime);
}
