package Lab3.task4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create stations
        ElectricStation electricStation = new ElectricStation();
        GasStation gasStation = new GasStation();

        // Create a Semaphore
        Semaphore semaphore = new Semaphore(electricStation, gasStation);

        // Parse and sort cars from JSON files in the "resources" folder
        String resourcesFolderPath = "D:\\OOP\\lab0-oop\\src\\Lab3\\resources";
        List<Car> cars = semaphore.parseCarsFromJson(resourcesFolderPath);

        // Guide cars to respective stations
        semaphore.guideCars(cars);

        // Process cars at each station
        System.out.println("\n=== Processing Electric Station ===");
        electricStation.processCars();

        System.out.println("\n=== Processing Gas Station ===");
        gasStation.processCars();

        System.out.println("\n=== All Cars Processed ===");
    }
}
