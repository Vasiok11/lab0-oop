package Lab2.task4.coffee;

class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    public PumpkinSpiceLatte(Intensity intensity, int mgOfPumpkinSpice, int mlOfMilk) {
        super(intensity, "Pumpkin spice latte", mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Mg of Pumpkin Spice:" + mgOfPumpkinSpice + "\n");
    }

    public static PumpkinSpiceLatte makeLatte(int mlOfMilk, int mgOfPumpkinSpice, Intensity intensity) {
        PumpkinSpiceLatte coffee = new PumpkinSpiceLatte(intensity, mgOfPumpkinSpice, mlOfMilk);
        coffee.makeCoffeeBase();
        System.out.println("Amount of milk:" + mlOfMilk + " ml");
        System.out.println("Amount of pumpkin spice:" + mgOfPumpkinSpice + " mg\n");
        return coffee;
    }
}
