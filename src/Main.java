public class Main {
    public static void main(String[] args) {
        InputContainer inputContainer = FileRead.Parse();

        System.out.println("All Inputs with Classification:");
        inputContainer.printAllInputs();
    }
}
