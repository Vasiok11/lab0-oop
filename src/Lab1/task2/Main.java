package Lab1.task2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = args[0];
        try {
            String text = FileReader.fileToString(filePath);
            TextData textData = new TextData(filePath, text);
            System.out.println(textData);
        } catch (IOException e) {
            System.err.println("Couldn't read file: " + e.getMessage());
        }
    }
}
