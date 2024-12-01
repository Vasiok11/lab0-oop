package Lab2.task2;

public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity intensity, int mgOfPumpkinSpice,int mlOfMilk){
        super(intensity,"Pumpking spice latte",mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }
    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Mg of Pumpkin Spice:" + mgOfPumpkinSpice + "\n");
    }
}
