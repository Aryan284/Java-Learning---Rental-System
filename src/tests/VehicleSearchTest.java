package tests;

import Vehicle.HireableVehicle;
import Vehicle.VehicleType;
import org.junit.Test;
import repository.VehicleInventoryRepository;
import services.VehicleSearchService;
import services.VehicleSearchServiceImpl;
import java.util.List;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleSearchTest {
    @Test
    public void ShouldFindByType(){
        VehicleInventoryRepository.vehicleInventoryList = TestData.buildVehicleInventory();
        VehicleSearchService vehicleSearchService = new VehicleSearchServiceImpl();
        List<HireableVehicle> vehicleList = vehicleSearchService.searchByType(VehicleType.HatchBack,
                "Bangalore", LocalDateTime.now().plusDays(3), LocalDateTime.now().plusDays(4));
        assertEquals(2, vehicleList.size());
    }
    @Test
    public void ShouldFind1VehicleBySeats() {
        VehicleInventoryRepository.vehicleInventoryList = TestData.buildVehicleInventory();
        VehicleSearchService vehicleSearchService = new VehicleSearchServiceImpl();
        List<HireableVehicle> vehicleList = vehicleSearchService.search(5,
                "Bangalore", LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(3));
        assertEquals(1, vehicleList.size());
    }
}
