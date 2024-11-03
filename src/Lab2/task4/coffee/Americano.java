package Lab2.task4.coffee;

class Americano extends Coffee {
    private int mlOfWater;

    public int getMlOfWater() {
        return mlOfWater;
    }

    public Americano(int mlOfWater, Intensity intensity) {
        super(intensity, "Americano");
        this.mlOfWater = mlOfWater;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Ml of water:" + mlOfWater + "\n");
    }

    public static Americano makeAmericano(int mlOfWater, Intensity intensity) {
        Americano coffee = new Americano(mlOfWater, intensity);
        coffee.makeCoffeeBase();
        System.out.println("Amount of water:" + mlOfWater + " ml\n");
        return coffee;
    }
}
