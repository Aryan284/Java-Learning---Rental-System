package tests;

import Reservation.ReservationStatus;
import Reservation.VehicleInventory;
import Reservation.VehicleReservation;
import Reservation.VehicleReservationType;
import Vehicle.*;
import main.model.Address;
import main.model.Contact;
import main.model.User;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class TestData {
    public static HireableVehicle getBike(){
    HireableVehicle bike = new Bike();
    String id = UUID.randomUUID().toString();
    bike.setId(id);
    bike.setLicensePlateNumber("k1k2kdh");
    bike.setQrCode(id);
    bike.setModel("yamaha");
    bike.setNumberOfSeats(2);
    bike.setModel("i7");
    bike.setMileage(30);
    bike.setVehicleType(VehicleType.Bike);
    bike.setVehicleCategory(VehicleCategory.Passenger);
    bike.setVehicleStatus(VehicleStatus.Available);
    VehicleLocation vehicleLocation = new VehicleLocation();
    vehicleLocation.setAddress(getAddress());
    vehicleLocation.setCoordinates(getCoordinates());
    bike.setParkedLocation(vehicleLocation);

    return bike;
    }
    public static HireableVehicle getHatchBack() {
        HireableVehicle car = new Car();
        String id = UUID.randomUUID().toString();
        car.setId(id);
        car.setLicensePlateNumber("ka51ca8344");
        car.setQrCode(id);
        car.setMake("Hyundai");
        car.setMake("i20");
        car.setYearOfManufacture(2018);
        car.setMileage(15010);
        car.setNumberOfSeats(5);
        car.setVehicleCategory(VehicleCategory.Passenger);
        car.setVehicleStatus(VehicleStatus.Available);
        car.setVehicleType(VehicleType.HatchBack);
        VehicleLocation vehicleLocation = new VehicleLocation();
        vehicleLocation.setAddress(getAddress());
        vehicleLocation.setCoordinates(getCoordinates());
        car.setParkedLocation(vehicleLocation);
        return car;
    }

    public static HireableVehicle getMarutiHatchBack() {
        HireableVehicle car = new Car();
        String id = UUID.randomUUID().toString();
        car.setId(id);
        car.setLicensePlateNumber("ka02ca7416");
        car.setQrCode(id);
        car.setMake("Maruti");
        car.setModel("Swift");
        car.setYearOfManufacture(2015);
        car.setMileage(55010);
        car.setNumberOfSeats(5);
        car.setVehicleCategory(VehicleCategory.Passenger);
        car.setVehicleStatus(VehicleStatus.Available);
        car.setVehicleType(VehicleType.HatchBack);
        VehicleLocation vehicleLocation = new VehicleLocation();
        vehicleLocation.setAddress(getAddress());
        vehicleLocation.setCoordinates(getCoordinates());
        car.setParkedLocation(vehicleLocation);
        return car;
    }
    public static VehicleReservation buildHatchbackReservation() {
        HireableVehicle vehicle = getHatchBack();
        vehicle.setVehicleStatus(VehicleStatus.Booked);
        VehicleReservation vehicleReservation = new VehicleReservation();
        vehicleReservation.setUsrId("user1");
        vehicleReservation.setReservationId(UUID.randomUUID().toString());
        vehicleReservation.setFromDate(LocalDateTime.now());
        vehicleReservation.setDueDate(LocalDateTime.now().plusDays(2));
        vehicleReservation.setStatus(ReservationStatus.Active);
        vehicleReservation.setStartMileage(vehicle.getMileage());
        vehicleReservation.setPickupLocation(
                vehicle.getParkedLocation().getAddress());

        vehicleReservation.setAccocatedVehicleId(vehicle.getId());
        vehicleReservation.setVehicleReservationType(VehicleReservationType.Day);
        return vehicleReservation;
    }
    public static User getUser(String email) {
        User user = new User();
        user.setEmail(email);
        user.setId(UUID.randomUUID().toString());

//        user.setUserName("testusername" + abc);
        user.setPassword("testuserwpd");
        user.setLastAccessed(LocalDateTime.now().minusDays(2));
        user.setContact(getContact(email));
        return user;
    }
    public static Contact getContact(String email) {
        Contact contact = new Contact();
        contact.setEmail(email);
        contact.setPhone("8745828882");
        contact.setAddress(getAddress());
        return contact;
    }
    public static ArrayList<HireableVehicle> getHireableVehicles() {
        ArrayList<HireableVehicle> hireableVehicles = new ArrayList<>();
        hireableVehicles.add(getHatchBack());
        hireableVehicles.add(getMarutiHatchBack());
        return hireableVehicles;
    }

    public static VehicleReservation buildMarutiHatchbackReservation() {
        HireableVehicle vehicle = getMarutiHatchBack();
        vehicle.setVehicleStatus(VehicleStatus.Booked);
        VehicleReservation vehicleReservation = new VehicleReservation();
        vehicleReservation.setUsrId("user1");
        vehicleReservation.setReservationId(UUID.randomUUID().toString());
        vehicleReservation.setFromDate(LocalDateTime.now().plusDays(20));
        vehicleReservation.setDueDate(LocalDateTime.now().plusDays(25));
        vehicleReservation.setStatus(ReservationStatus.Active);
        vehicleReservation.setStartMileage(vehicle.getMileage());
        vehicleReservation.setPickupLocation(
                vehicle.getParkedLocation().getAddress());

        vehicleReservation.setAccocatedVehicleId(vehicle.getId());
        vehicleReservation.setVehicleReservationType(VehicleReservationType.Day);
        return vehicleReservation;
    }
    public static VehicleReservation buildBikeReservation() {
        HireableVehicle vehicle = getBike();
        vehicle.setVehicleStatus(VehicleStatus.Booked);
        VehicleReservation vehicleReservation = new VehicleReservation();
        vehicleReservation.setUsrId("user1");
        vehicleReservation.setReservationId(UUID.randomUUID().toString());
        vehicleReservation.setFromDate(LocalDateTime.now());
        vehicleReservation.setDueDate(LocalDateTime.now().plusDays(2));
        vehicleReservation.setStatus(ReservationStatus.Active);
        vehicleReservation.setStartMileage(vehicle.getMileage());
        vehicleReservation.setPickupLocation(
                vehicle.getParkedLocation().getAddress());

        vehicleReservation.setAccocatedVehicleId(vehicle.getId());
        vehicleReservation.setVehicleReservationType(VehicleReservationType.Day);
        return vehicleReservation;
    }
    public static Address getAddress() {
        Address address = new Address();
        address.setAddressLine1("Bannerghatta road parking");
        address.setAddressLine2("Bilekkahalli");
        address.setCity("Bangalore");
        address.setState("Karnataka");
        address.setCountry("India");
        address.setPinCode("600071");
        return address;
    }
    public static Coordinates getCoordinates() {
        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude(12.459454);
        coordinates.setLatitude(79.459454);
        return coordinates;
    }
    public static ArrayList<VehicleInventory> buildVehicleInventory() {
        ArrayList<VehicleInventory> vehicleInventories = new ArrayList<>();
        vehicleInventories.add(new VehicleInventory(buildHatchbackReservation(),
                getHatchBack()));
        vehicleInventories.add(new VehicleInventory(buildMarutiHatchbackReservation(),
                getMarutiHatchBack()));

        return vehicleInventories;
    }
}
