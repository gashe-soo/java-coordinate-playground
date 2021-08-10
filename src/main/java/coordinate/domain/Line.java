package coordinate.domain;

import java.util.List;

public class Line extends Shape {

    public static final String IS_NOT_LINE = "직선이 아닙니다.";
    public static final String LINE_RESULT = "두 점 사이 거리는 ";

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
    public String getInfo() {
        return LINE_RESULT + area();
    }

    private void validateLine(List<Point> points) {
        Point firstPoint = points.get(0);
        Point secondPoint = points.get(1);
        if (firstPoint.equals(secondPoint)) {
            throw new IllegalArgumentException(IS_NOT_LINE);
        }
    }
}
