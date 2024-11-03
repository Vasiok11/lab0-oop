package Lab2.task2;

public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(int mgOfPumpkinSpice,int mlOfMilk){
        super(mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
        getName("Pumpkin Spice Latte");
    }
    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Mg of Pumpkin Spice:" + mgOfPumpkinSpice + "\n");
    }
}
