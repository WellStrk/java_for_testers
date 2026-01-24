public class Geometry {
    public static void main(String[] args) {
        printSquareArea(7.0);
        printSquareArea(5.0);
        printSquareArea(3.0);
        

        printRectangleArea(15.0, 3.0);
        printRectangleArea(7.0, 5.0);
    }

    private static void printRectangleArea(double side1, double side2) {
        System.out.println("Площадь прямоугольника со сторонами " + side1 + " и " + side2 + " = " + RectangleArea(side1, side2));
    }

    private static double RectangleArea(double side1, double side2) {
        return side1 * side2;
    }

    private static double squareArea(double a) {
        return a * a;
    }

    static void printSquareArea(double side) {
        System.out.println("Площадь квадрата со стороной " + side + " = " + squareArea(side));
    }
}
