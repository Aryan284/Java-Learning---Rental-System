package services;

import Exceptions.InvalidVehicleException;
import Exceptions.ReservationNotFoundException;
import Exceptions.VehicleBookedException;
import Reservation.VehicleReservation;
import Vehicle.HireableVehicle;
import Vehicle.VehicleLocation;
import Vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface UserService {
    VehicleReservation scanToReserve(String qrCode, String userId) throws InvalidVehicleException, VehicleBookedException;
//    VehicleReservation remoteReserve(VehicleReservation vehicleReservation);
    VehicleReservation cancel(String reservationId);
//    HireableVehicle pickupVehicle(VehicleReservation vehicleReservation);
//    void returnVehicle(String reservationId, VehicleLocation vehicleLocation) throws ReservationNotFoundException;
//    ArrayList<HireableVehicle> getHiredVehicles(String userId);
//
//    ArrayList<HireableVehicle> getHiredVehicles(String userId, LocalDateTime startDate,
//                                           LocalDateTime endDate);

}
