import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {

    public static void main(String[] args) {

        System.out.println("=== Try-With-Resources Demo ===");
        System.out.println();

        readFile("sample.txt");
    }

    static void readFile(String fileName) {
        System.out.println("Trying to open file: " + fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line = reader.readLine();
            System.out.println("First line: " + line);

        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        System.out.println("The file is now closed — Java did it for us.");
    }
}