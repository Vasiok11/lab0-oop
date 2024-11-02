package Lab2.task1;

public class SyrupCappuccino extends Coffee{
     enum SyrupType{
        MACADAMIA,
        VANILLA,
        COCONUT,
        CARAMEL,
        CHOCOLATE,
        POPCORN
    }
    private Intensity intensityCoffee;
    int mltrOfMilk;
    private SyrupType syrup;
    private static final String coffee = "SyrupCappuccino";
}
