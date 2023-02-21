package services;

import Reservation.VehicleReservation;
import Vehicle.VehicleType;
import repository.VehicleInventoryRepository;
import repository.VehicleReservationRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VehicleReservationServiceImpl implements VehicleReservationService{
    VehicleReservationRepository vehicleReservationRepository = new VehicleReservationRepository();
    public List<VehicleReservation> getReservation(VehicleType vehicleType){
        return vehicleReservationRepository.getVehicleReservation(vehicleType);
    }

    @Override
    public ArrayList<VehicleReservation> getReservations(VehicleType vehicleType) {
        return null;
    }

    public boolean isVehicleBooked(String qrCode, LocalDateTime fromDate, LocalDateTime endTime){
        return VehicleInventoryRepository.vehicleInventoryList
                .stream().anyMatch(vehicleInventory ->
                        vehicleInventory.getVehicle().getId().equalsIgnoreCase(qrCode) &&
                                ((vehicleInventory.getDueDate() != null &&
                                        fromDate.isBefore(vehicleInventory.getDueDate()))
                                        && (vehicleInventory.getFromDate() != null
                                        && endTime.isAfter(vehicleInventory.getFromDate()))));
    }

}
