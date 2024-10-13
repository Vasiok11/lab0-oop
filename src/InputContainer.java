import java.util.ArrayList;
import java.util.List;

public class InputContainer {
    private List<Input> inputs;

    // Constructor
    public InputContainer() {
        this.inputs = new ArrayList<>();
    }

    // Method to add an Input object
    public void addInput(Input input) {
        inputs.add(input);
    }

    // Method to filter by age above 50
    public List<Input> filterByAgeAbove50() {
        List<Input> filtered = new ArrayList<>();
        for (Input input : inputs) {
            if (input.getAge() != null && input.getAge() > 50) {
                filtered.add(input);
            }
        }
        return filtered;
    }

    // Method to get all IDs (optional, if you still want to keep it)
    public List<Long> getAllIds() {
        List<Long> ids = new ArrayList<>();
        for (Input input : inputs) {
            ids.add(input.getId());
        }
        return ids;
    }
}
