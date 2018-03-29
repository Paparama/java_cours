package HW4;

public class Figure {
    public static void main(String[] args) {
        Circle c = new Circle(new Point(1,1), 4);
        System.out.println(c.getPerimeter());
        System.out.println(c.getSquare());
        Rectangle r = new Rectangle(new Point(0,0), new Point(5, 2.5));
        System.out.println(r.getPerimeter());
        System.out.println(r.getSquare());
        Triangle t = new Triangle(new Point(0,0), new Point(5, 0), new Point(2, 3));
        System.out.println(t.getPerimeter());
        System.out.println(t.getSquare());
        t.getSquare();
    }
}

class Point{
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point b) {
        return Math.sqrt(Math.pow(Math.abs(this.getXdistance(b)), 2) + Math.pow(Math.abs(this.getYdistance(b)), 2));
    }

    public double getXdistance(Point b) {
        return  Math.abs(this.x - b.x);
    }

    public double getYdistance(Point b) {
        return Math.abs(this.y - b.y);
    }
}

class Circle {
    Point centre;
    double radius;

    public Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    public double getSquare() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    public double getPerimeter() {
        return 2 * this.radius * Math.PI;
    }
}


class Rectangle {
    Point coordinate1;
    Point coordinate2;

    public Rectangle(Point coordinate1, Point coordinate2) {
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
    }

    public double getSquare() {
        return this.coordinate1.getXdistance(this.coordinate2) * this.coordinate1.getYdistance(this.coordinate2);
    }

    public double getPerimeter() {
        return this.coordinate1.getXdistance(this.coordinate2) * 2 + this.coordinate1.getYdistance(this.coordinate2) *2;
    }
}

class Triangle {
    Point coordinate1;
    Point coordinate2;
    Point coordinate3;

    public Triangle(Point coordinate1, Point coordinate2, Point coordinate3) {
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
        this.coordinate3 = coordinate3;
    }

    public double getSquare() {
        double halfPerimeter = this.getPerimeter() * 0.5;
        return Math.sqrt(halfPerimeter * (halfPerimeter - this.coordinate1.getDistance(this.coordinate2)) *
                (halfPerimeter - this.coordinate2.getDistance(this.coordinate3)) *
                (halfPerimeter - this.coordinate3.getDistance(this.coordinate1)));
    }

    public double getPerimeter() {
        return  this.coordinate1.getDistance(this.coordinate2) +
                this.coordinate2.getDistance(this.coordinate3) +
                this.coordinate3.getDistance(this.coordinate1);
    }
}
