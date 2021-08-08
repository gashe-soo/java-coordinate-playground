package coordinate.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rectangle extends Shape {
    public Rectangle(List<Point> points) {
        super(points);
        validateRectangle(points);
    }

    private void validateRectangle(List<Point> points) {
        points.stream().forEach(this::validateIsVertex);
    }

    private void validateIsVertex(Point point) {
        if (!isOnlyOneExistsOnSameRow(point) || !isOnlyOneExistsOnSameCol(point)) {
            throw new IllegalArgumentException("사각형이 아닙니다.");
        }
    }

    private boolean isOnlyOneExistsOnSameCol(Point point) {
        return getPoints().stream()
                .filter(p -> p.isOnSameCol(point))
                .count() == 1;
    }

    private boolean isOnlyOneExistsOnSameRow(Point point) {
        return getPoints().stream()
                .filter(p -> p.isOnSameRow(point))
                .count() == 1;
    }


    @Override
    double area() {
        Point p1 = getPoints().get(0);
        double height = getHeight(p1);
        double width = getWidth(p1);
        return height * width;
    }

    private double getWidth(Point point) {
        Point sameRowPoint = getPoints().stream().filter(p -> p.isOnSameRow(point)).findFirst().get();
        return point.getDistanceFrom(sameRowPoint);
    }

    private double getHeight(Point point) {
        Point sameColPoint = getPoints().stream().filter(p -> p.isOnSameCol(point)).findFirst().get();
        return point.getDistanceFrom(sameColPoint);
    }


    @Override
    String getInfo() {
        return null;
    }
}
