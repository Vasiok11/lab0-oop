package Lab2.task3;

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
    public static PumpkinSpiceLatte makeLatte(int mlOfMilk, int mgOfPumpkinSpice, Intensity intensity){
        PumpkinSpiceLatte coffee = new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
        coffee.makeCoffeeBase();
        System.out.println("Amount of milk:" + mlOfMilk + " ml");
        System.out.println("Amount of pumpkin spice:" + mgOfPumpkinSpice + " mg\n");
        return coffee;
    }
}
