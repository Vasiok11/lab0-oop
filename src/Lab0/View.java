package Lab0;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class View {

    public void groupAndWriteToFiles(InputContainer inputContainer) {
        Map<String, List<Input>> groupedByUniverse = groupByUniverse(inputContainer.getAllInputs());

        for (Map.Entry<String, List<Input>> entry : groupedByUniverse.entrySet()) {
            String universeFileName = entry.getKey().replace(" ", "_").toLowerCase() + ".json";
            List<Input> inputs = entry.getValue();
            writeToFile(universeFileName, inputs);
        }
    }

    private Map<String, List<Input>> groupByUniverse(List<Input> inputs) {
        Map<String, List<Input>> grouped = new HashMap<>();

        for (Input input : inputs) {
            String mainUniverse = getMainUniverse(input.getClassification());
            grouped.computeIfAbsent(mainUniverse, k -> new ArrayList<>()).add(input);
        }
        return grouped;
    }

    private String getMainUniverse(String classification) {
        if (classification.contains("Star Wars")) return "Star Wars Universe";
        if (classification.contains("Marvel")) return "Marvel Universe";
        if (classification.contains("Hitchhiker")) return "Hitchhiker's Universe";
        if (classification.contains("Lord of the Rings")) return "Lord of the Rings Universe";
        return "Unknown Universe";
    }

    private void writeToFile(String filename, List<Input> inputs) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("[\n");
            for (int i = 0; i < inputs.size(); i++) {
                writer.write(inputs.get(i).toJson());
                if (i < inputs.size() - 1) writer.write(",\n");
            }
            writer.write("\n]");
            System.out.println("Successfully wrote to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
