package Lab0;

public class Main {
    public static void main(String[] args) {
        InputContainer inputContainer = FileRead.Parse();

        View view = new View();
        view.groupAndWriteToFiles(inputContainer);

        System.out.println("Processing complete. JSON files have been generated.");
    }
}
