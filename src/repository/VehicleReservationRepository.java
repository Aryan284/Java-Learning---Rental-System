package repository;

import Reservation.VehicleReservation;
import Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleReservationRepository {
    public static HashMap<String, VehicleReservation>vehicleReservationMap = new HashMap<>();
    public static ArrayList<VehicleReservation> vehicleReservations = new ArrayList<>();
    public List<VehicleReservation> getVehicleReservation(VehicleType vehicleType){
        return vehicleReservations.stream().filter(vehicleReservation ->
                vehicleReservation.getVehicleType() == vehicleType)
                .collect(Collectors.toList());
    }
    public VehicleReservation reserve(VehicleReservation vehicleReservation){
        VehicleReservationRepository.vehicleReservationMap.put(vehicleReservation.getReservationId(), vehicleReservation);
        vehicleReservations.add(vehicleReservation);
        return vehicleReservation;
    }
    public VehicleReservation getVehicleReservation(String reservationId){
        return vehicleReservationMap.get(reservationId);
    }
}
