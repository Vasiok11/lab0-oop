package Lab2.task2;

public class Americano extends Coffee {
    private int mlOfWater;

    public Americano(int mlOfWater) {
        super(Intensity.STRONG, "Americano");
        this.mlOfWater = mlOfWater;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Ml of water:" + mlOfWater +"\n");
    }
}


