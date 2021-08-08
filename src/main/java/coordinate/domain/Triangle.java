package coordinate.domain;

import java.util.HashSet;
import java.util.List;

public class Triangle extends Shape {
    public Triangle(List<Point> points) {
        super(points);
        validateTriangle(points);
    }

    private void validateTriangle(List<Point> points) {
        if (hasSamePoint(points) || isOnSameLine(points)) {
            throw new IllegalArgumentException("삼각형이 아닙니다.");
        }
    }

    private boolean isOnSameLine(List<Point> points) {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);

        if (p1.isOnSameRow(p2) && p1.isOnSameRow(p3)) {
            return true;
        }
        if (p1.isOnSameCol(p2) && p1.isOnSameCol(p3)) {
            return true;
        }

        if (p1.getTilt(p2) == p1.getTilt(p3)) {
            return true;
        }

        return false;
    }

    private boolean hasSamePoint(List<Point> points) {
        return new HashSet<>(points).size() != 3;
    }

    @Override
    double area() {
        Point p1 = getPoints().get(0);
        Point p2 = getPoints().get(1);
        Point p3 = getPoints().get(2);

        double firstSide = p1.getDistanceFrom(p2);
        double secondSide = p2.getDistanceFrom(p3);
        double thirdSide = p3.getDistanceFrom(p1);

        return calculateByHeron(firstSide, secondSide, thirdSide);

    }

    private double calculateByHeron(double firstSide, double secondSide, double thirdSide) {
        double s = (firstSide + secondSide + thirdSide) / 2;

        return Math.sqrt(s * (s - firstSide) * (s - secondSide) * (s - thirdSide));

    }

    @Override
    String getInfo() {
        return "삼각형의 넓이는 " + area();
    }
}
