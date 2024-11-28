package Lab3.task3;

public class GasStation implements Refuelable{
    private static int count = 0;
    public void refuel(String carId){
        System.out.println("carId: " + carId+ " GasStation: Your car has been refueled. Thank you!");
        count++;
        System.out.println("GasStation Count: "+ count +"\n_________________________");
    }
}
