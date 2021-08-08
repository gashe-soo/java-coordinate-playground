package coordinate.domain;

import java.util.List;

public class Line extends Shape {
    public Line(List<Point> points) {
        super(points);
        validateLine(points);
    }

    @Override
    double area() {
        Point firstPoint = getPoints().get(0);
        Point secondPoint = getPoints().get(1);
        return firstPoint.getDistanceFrom(secondPoint);
    }

    @Override
    String getInfo() {
        return "두 점 사이 거리는 " + area();
    }

    private void validateLine(List<Point> points) {
        Point firstPoint = points.get(0);
        Point secondPoint = points.get(1);
        if (firstPoint.equals(secondPoint)) {
            throw new IllegalArgumentException("직선이 아닙니다.");
        }
    }
}
