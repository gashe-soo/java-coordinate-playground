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
        return 0;
    }

    @Override
    String getInfo() {
        return null;
    }
}
