package tests;

import Exceptions.InvalidVehicleException;
import Exceptions.VehicleBookedException;
import Reservation.VehicleInventory;
import Reservation.VehicleReservation;
import Vehicle.HireableVehicle;
import main.model.User;
import org.junit.Test;
import repository.UserRepository;
import repository.VehicleInventoryRepository;
import repository.VehicleRepository;
import services.UserService;
import services.UserServiceImpl;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class UserServiceTest {
    @Test
    public void scanToReserveFunc() throws VehicleBookedException, InvalidVehicleException{
        VehicleRepository vehicleRepository = new VehicleRepository();
        ArrayList<HireableVehicle> vehicleList = TestData.getHireableVehicles();
        for(HireableVehicle hireableVehicle: vehicleList){
            vehicleRepository.addVehicle(hireableVehicle);
            VehicleInventoryRepository.vehicleInventoryList.add(new VehicleInventory(hireableVehicle));

        }
        User user = TestData.getUser("user@gmail");
        UserRepository.userMap.putIfAbsent("user@gmail", user);
        UserRepository.userUserIdMap.putIfAbsent(user.getId(), user);
        UserService userService = new UserServiceImpl();
        VehicleReservation vehicleReservation =userService.scanToReserve(vehicleList.get(1).getQrCode(), user.getId());

        assertNotNull(vehicleReservation);


    }
}
