package coordinate.domain;

import java.util.List;

public class Trianlge extends Shape {

    public Trianlge(List<Point> points) {
        super(points);
    }

    @Override
    double area() {
        double first = points.get(0).distanceFrom(points.get(1));
        double second = points.get(1).distanceFrom(points.get(2));
        double third = points.get(2).distanceFrom(points.get(0));

        return calculateByHeron(first, second, third);
    }

    private double calculateByHeron(double first, double second, double third) {
        double s = (first + second + third) / 2;

        return Math.sqrt(s * (s - first) * (s - second) * (s - third));
    }

    @Override
    String getInfo() {
        return null;
    }
}
