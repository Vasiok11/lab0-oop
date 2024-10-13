import java.util.List; // Add this import statement

public class Main {
    public static void main(String[] args) {

        InputContainer inputContainer = FileRead.Parse();


        System.out.println("All IDs: " + inputContainer.getAllIds());


        List<Input> inputsAbove50 = inputContainer.filterByAgeAbove50();
        System.out.println("Inputs with age above 50:");
        for (Input input : inputsAbove50) {
            System.out.println(input);
        }
    }
}
