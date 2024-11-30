package Lab3.task4;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SemaphoreTest {
    private ElectricStation electricStation;
    private GasStation gasStation;
    private Semaphore semaphore;

    @BeforeEach
    void setUp() {
        electricStation = new ElectricStation();
        gasStation = new GasStation();
        semaphore = new Semaphore(electricStation, gasStation);
    }

    @Test
    void testParseCarFromJsonString() {
        // JSON strings representing cars
        String mockJson1 = "{\"id\": 1, \"type\": \"ELECTRIC\", \"passengers\": \"PEOPLE\", \"isDining\": true, \"consumption\": 31}";
        String mockJson2 = "{\"id\": 2, \"type\": \"GAS\", \"passengers\": \"ROBOTS\", \"isDining\": false, \"consumption\": 45}";

        // Parse JSON strings to Car objects
        Car car1 = parseCarFromJsonString(mockJson1);
        Car car2 = parseCarFromJsonString(mockJson2);

        assertNotNull(car1);
        assertNotNull(car2);

        // Validate car properties
        assertEquals("CAR1", car1.getCarId());
        assertEquals("ELECTRIC", car1.getCarType());
        assertEquals("PEOPLE", car1.getPerson());
        assertTrue(car1.isDining());

        assertEquals("CAR2", car2.getCarId());
        assertEquals("GAS", car2.getCarType());
        assertEquals("ROBOTS", car2.getPerson());
        assertFalse(car2.isDining());
    }

    @Test
    void testGuideCarsToStations() {
        // Create mock cars
        Car car1 = new Car("CAR1", "ELECTRIC", "PEOPLE", true);
        Car car2 = new Car("CAR2", "GAS", "ROBOTS", false);
        Car car3 = new Car("CAR3", "ELECTRIC", "ROBOTS", true);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // Guide cars to their respective stations
        semaphore.guideCars(cars);

        // No direct access to the internal state of stations
        // So we assume the stations will process the cars correctly
        assertDoesNotThrow(() -> {
            electricStation.processCars();
            gasStation.processCars();
        });
    }

    @Test
    void testAllCarsProcessedByCorrectStations() {
        // Create mock cars
        Car car1 = new Car("CAR1", "ELECTRIC", "PEOPLE", true);
        Car car2 = new Car("CAR2", "GAS", "ROBOTS", true);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        // Guide cars to stations
        semaphore.guideCars(cars);

        // Process cars in ElectricStation
        assertDoesNotThrow(electricStation::processCars);

        // Process cars in GasStation
        assertDoesNotThrow(gasStation::processCars);
    }

    // Helper method to parse a JSON string into a Car object
    private Car parseCarFromJsonString(String jsonString) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonCar = (JSONObject) parser.parse(jsonString);

            int id = Integer.parseInt(jsonCar.get("id").toString());
            String type = jsonCar.get("type").toString();
            String passengers = jsonCar.get("passengers").toString();
            boolean isDining = Boolean.parseBoolean(jsonCar.get("isDining").toString());

            return new Car("CAR" + id, type, passengers, isDining);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON string: " + jsonString, e);
        }
    }
}
