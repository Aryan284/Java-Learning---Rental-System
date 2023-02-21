package services;

import Reservation.VehicleReservation;
import Vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface VehicleReservationService {
    ArrayList<VehicleReservation> getReservations(VehicleType vehicleType);

    boolean isVehicleBooked(String qrCode, LocalDateTime fromDate, LocalDateTime toDate);
}
