package Lab1.task2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class FileReader {
    public static String fileToString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}