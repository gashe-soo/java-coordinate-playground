package coordinate.domain;

import java.util.List;

public class Line {
    public Line(List<Point> points) {
        validateLine(points);
    }

    private void validateLine(List<Point> points) {
        Point firstPoint = points.get(0);
        Point secondPoint = points.get(1);
        if(firstPoint.equals(secondPoint)){
            throw new IllegalArgumentException("직선이 아닙니다.");
        }
    }
}
