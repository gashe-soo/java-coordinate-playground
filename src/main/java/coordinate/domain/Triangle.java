package coordinate.domain;

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
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);

        if (p1.equals(p2) || p2.equals(p3) || p3.equals(p1)) {
            return true;
        }
        return false;
    }

    @Override
    double area() {
        return 0;
    }

    @Override
    String getInfo() {
        return null;
    }
}
