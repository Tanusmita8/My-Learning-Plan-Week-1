import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionExample {

    public static void main(String[] args) {

        System.out.println("=== Checked Exception Demo ===");
        System.out.println();

        System.out.println("--- Example 1: Handle with try-catch ---");
        readFileSafely("nonexistent_file.txt");

        System.out.println();

        System.out.println("--- Example 2: Caller handles the exception ---");
        try {
            readFileWithThrows("another_missing_file.txt");
        } catch (IOException e) {
            System.out.println("Caught in main: " + e.getMessage());
        }
    }

    static void readFileSafely(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            System.out.println("File opened successfully.");
            reader.close();

        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }

    static void readFileWithThrows(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName);
        System.out.println("File opened.");
        reader.close();
    }
}
