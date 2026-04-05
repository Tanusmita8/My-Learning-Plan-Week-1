public class UncheckedExceptionExample {

    public static void main(String[] args) {

        System.out.println("=== Unchecked Exception Demo ===");
        System.out.println();

        System.out.println("--- Example 1: ArithmeticException ---");
        divideNumbers(10, 2);
        divideNumbers(10, 0);

        System.out.println();

        System.out.println("--- Example 2: NullPointerException ---");
        printLength("Hello");
        printLength(null);

        System.out.println();

        System.out.println("--- Example 3: ArrayIndexOutOfBoundsException ---");
        accessArray(new int[]{10, 20, 30}, 1);
        accessArray(new int[]{10, 20, 30}, 10);
    }

    static void divideNumbers(int a, int b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero!");
            return;
        }
        System.out.println(a + " / " + b + " = " + (a / b));
    }

    static void printLength(String text) {
        if (text == null) {
            System.out.println("Cannot get length — the string is null!");
            return;
        }
        System.out.println("Length of \"" + text + "\" = " + text.length());
    }

    static void accessArray(int[] numbers, int index) {
        if (index < 0 || index >= numbers.length) {
            System.out.println("Index " + index + " is out of bounds! Array size is " + numbers.length + ".");
            return;
        }
        System.out.println("Element at index " + index + " = " + numbers[index]);
    }
}