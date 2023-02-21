package services;

import Exceptions.InvalidVehicleException;
import Exceptions.VehicleBookedException;
import Reservation.ReservationStatus;
import Reservation.VehicleInventory;
import Reservation.VehicleReservation;
import Reservation.VehicleReservationType;
import Vehicle.HireableVehicle;
import Vehicle.VehicleStatus;
import repository.UserRepository;
import repository.VehicleInventoryRepository;
import repository.VehicleRepository;
import repository.VehicleReservationRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserServiceImpl implements UserService{
    UserRepository userRepository = new UserRepository();
    VehicleReservationRepository vehicleReservationRepository = new
            VehicleReservationRepository();

    VehicleReservationService vehicleReservationService = new
            VehicleReservationServiceImpl();

    VehicleInventoryRepository vehicleInventoryRepository = new VehicleInventoryRepository();
    public VehicleReservation scanToReserve(String qrCode, String userId) throws InvalidVehicleException, VehicleBookedException{
        if (VehicleRepository.vehicleMap.get(qrCode) == null){
            throw new InvalidVehicleException("Invalid Qrcode");
        }
        if(vehicleReservationService.isVehicleBooked(qrCode, LocalDateTime.now(), LocalDateTime.now().plusHours(2))){
            throw  new VehicleBookedException("Already Booked");
        }
        VehicleReservation vehicleReservation = buildQuickReservation(qrCode, userId);
        vehicleReservation = vehicleReservationRepository.reserve(vehicleReservation);
        updateVehicleInventory(vehicleReservation);
        return vehicleReservation;


    }
    private VehicleReservation buildQuickReservation(String qrCode, String userId) {

        HireableVehicle vehicle = VehicleRepository.vehicleMap.get(qrCode);
        vehicle.setVehicleStatus(VehicleStatus.Booked);
        VehicleReservation vehicleReservation = new VehicleReservation();
        vehicleReservation.setUsrId(userId);
        vehicleReservation.setReservationId(UUID.randomUUID().toString());
        vehicleReservation.setFromDate(LocalDateTime.now());
        vehicleReservation.setDueDate(LocalDateTime.now().plusHours(2));
        vehicleReservation.setStatus(ReservationStatus.Active);
        vehicleReservation.setVehicleReservationType(VehicleReservationType.Hourly);
        vehicleReservation.setVehicleType(vehicle.getVehicleType());
        vehicleReservation.setStartMileage(vehicle.getMileage());
        vehicleReservation.setPickupLocation(
                vehicle.getParkedLocation().getAddress());

        HireableVehicle hireableVehicle = VehicleRepository.vehicleMap.get(qrCode);
        vehicleReservation.setAccocatedVehicleId(hireableVehicle.getId());
        vehicleReservation.setVehicleReservationType(VehicleReservationType.Hourly);
        return vehicleReservation;
    }
    public VehicleReservation cancel(String reservationId){
        VehicleReservation vehicleReservation = VehicleReservationRepository.vehicleReservationMap.get(reservationId);
        HireableVehicle hireableVehicle = VehicleRepository.vehicleMap.get(vehicleReservation.getAccocatedVehicleId());
        vehicleReservation.setStatus(ReservationStatus.Cancelled);
        updateVehicleInventory(vehicleReservation);
        vehicleReservation.setDropLocation(hireableVehicle.getParkedLocation().getAddress());
        vehicleReservation.setReturnDate(LocalDateTime.now());
        vehicleReservation.setEndMileage(hireableVehicle.getMileage());
        return vehicleReservation;


    }
    private VehicleInventory buildVehicleInventory(VehicleReservation vehicleReservation) {
        HireableVehicle hireableVehicle = VehicleRepository.vehicleMap
                .get(vehicleReservation.getAccocatedVehicleId());
        VehicleInventory vehicleInventory = new VehicleInventory(vehicleReservation,
                hireableVehicle);
        return vehicleInventory;
    }
    private void updateVehicleInventory(VehicleReservation vehicleReservation) {
        VehicleInventory vehicleInventory = buildVehicleInventory(vehicleReservation);
        vehicleInventoryRepository.addToInventory(vehicleInventory);

    }
}
