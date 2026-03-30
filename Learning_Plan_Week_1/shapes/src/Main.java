import interfaces.Shape;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Triangle;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which shape do you want?");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.print("Enter choice (1/2/3): ");

        int choice = scanner.nextInt();
        Shape shape;

        if (choice == 1) {
            System.out.print("Enter radius: ");
            shape = new Circle(scanner.nextDouble());

        } else if (choice == 2) {
            System.out.print("Enter width: ");
            double width = scanner.nextDouble();
            System.out.print("Enter height: ");
            shape = new Rectangle(width, scanner.nextDouble());

        } else if (choice == 3) {
            System.out.print("Enter side a: ");
            double a = scanner.nextDouble();
            System.out.print("Enter side b: ");
            double b = scanner.nextDouble();
            System.out.print("Enter side c: ");
            shape = new Triangle(a, b, scanner.nextDouble());

        } else {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.printf("Area      : %.2f%n", shape.calculateArea());
        System.out.printf("Perimeter : %.2f%n", shape.calculatePerimeter());

        scanner.close();
    }
}