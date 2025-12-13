public class Main {

    public static void main(String[] args) {

        Shape rectangle = new Rectangle(5, 10);
        Shape circle = new Circle(7);
        Shape triangle = new Triangle(3, 4, 5);

        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Rectangle perimeter: " + rectangle.perimeter());

        System.out.println("Circle area: " + circle.area());
        System.out.println("Circle perimeter: " + circle.perimeter());

        System.out.println("Triangle area: " + triangle.area());
        System.out.println("Triangle perimeter: " + triangle.perimeter());
    }

    interface Shape {
        double area();
        double perimeter();
    }

    static class Rectangle implements Shape {

        private final double width;
        private final double height;

        public Rectangle(double width, double height) {
            if (width <= 0 || height <= 0) {
                throw new RuntimeException("There is no figure with such parameters.");
            }
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }

        @Override
        public double perimeter() {
            return 2 * (width + height);
        }
    }

    static class Circle implements Shape {

        private final double radius;

        public Circle(double radius) {
            if (radius <= 0) {
                throw new RuntimeException("There is no figure with such parameters.");
            }
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public double perimeter() {
            return 2 * Math.PI * radius;
        }
    }

    static class Triangle implements Shape {

        private final double a;
        private final double b;
        private final double c;

        public Triangle(double a, double b, double c) {
            if (a <= 0 || b <= 0 || c <= 0 ||
                a + b <= c || a + c <= b || b + c <= a) {
                throw new RuntimeException("There is no figure with such parameters.");
            }
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double area() {
            double p = perimeter() / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        @Override
        public double perimeter() {
            return a + b + c;
        }
    }
}
