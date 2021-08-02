package coordinate.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rectangle extends Shape {

    public Rectangle(List<Point> points) {
        super(points);
        checkRectangle();
    }

    private void checkRectangle() {
        if (!isRectangle()) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private boolean isRectangle() {
        return checkLine(points.get(0)) && checkLine(points.get(1));
    }

    private boolean checkLine(Point point) {
        return getSameRow(point).size() == 2 && getSameCol(point).size() == 2;
    }

    private List<Point> getSameRow(Point point) {
        return points.stream()
                .filter(p -> p.isOnSameRow(point))
                .collect(Collectors.toList());
    }

    private List<Point> getSameCol(Point point) {
        return points.stream()
                .filter(p -> p.isOnSameCol(point))
                .collect(Collectors.toList());
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
