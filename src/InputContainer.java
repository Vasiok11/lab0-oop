import java.util.ArrayList;
import java.util.List;

public class InputContainer {
    private final List<Input> inputs;

    public InputContainer() {
        this.inputs = new ArrayList<>();
    }

    public void addInput(Input input) {
        inputs.add(input);
    }

    public List<Input> getAllInputs() {
        return inputs;
    }
}
