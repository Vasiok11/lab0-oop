package Lab3.task2;

public class RobotDinner implements Dineable{
    private static int count = 0;
    public void serveDinner(String carId){
        System.out.println("carId: " + carId+ " RobotDinner: Dinner is being server. Thank you!");
        count++;
        System.out.println("Count: "+ count + "\n");
    }
    }

