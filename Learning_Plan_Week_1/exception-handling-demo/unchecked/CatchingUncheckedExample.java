public class CatchingUncheckedExample {

    public static void main(String[] args) {

        System.out.println("=== Catching Unchecked Exception Demo ===");
        System.out.println();

        String[] userInputs = {"42", "abc", "100", "", "7"};

        for (String input : userInputs) {
            parseAndDouble(input);
        }
    }

    static void parseAndDouble(String input) {
        try {
            int number = Integer.parseInt(input);
            System.out.println("\"" + input + "\" → " + number + " doubled is " + (number * 2));

        } catch (NumberFormatException e) {
            System.out.println("\"" + input + "\" is not a valid number. Please enter digits only.");
        }
    }
}