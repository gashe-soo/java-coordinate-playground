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
        boolean result = true;
        for(Point point : points){
            result &= checkLine(point);
        }
        return result;
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

    private double calculateDistance(List<Point> line) {
        return line.get(0).distanceFrom(line.get(1));
    }

    @Override
    double area() {
        double height = calculateDistance(getSameCol(points.get(0)));
        double width = calculateDistance(getSameRow(points.get(0)));
        return height * width;
    }

    @Override
    String getInfo() {
        return null;
    }
}
