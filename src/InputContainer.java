import java.util.ArrayList;
import java.util.List;

public class InputContainer {
    protected List<Input> inputs;

    public InputContainer() {
        this.inputs = new ArrayList<>();
    }

    public void addInput(Input input) {
        inputs.add(input);
    }


    public void printAllInputs() {
        for (Input input : inputs) {
            System.out.println(input);
        }
    }
}
