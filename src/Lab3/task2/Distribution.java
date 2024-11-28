package Lab3.task2;

public class Distribution {
    public void servePerson(String carId, String carType, String person, boolean isDining){
        if(carType == "Gas") {
            Refuelable GasStation = new GasStation();
            GasStation.refuel(carId);
        }

        else if(carType == "Electric"){
            Refuelable ElectricStation = new ElectricStation();
            ElectricStation.refuel(carId);
        }

        if (isDining){
            if (person=="Human"){
                Dineable PeopleDinner = new PeopleDinner();
                PeopleDinner.serveDinner(carId);
            }

            else if (person=="Robot"){
                Dineable RobotDinner = new RobotDinner();
                RobotDinner.serveDinner(carId);
            }
        }
        else System.out.println("Does not want to dine");

    }
}
