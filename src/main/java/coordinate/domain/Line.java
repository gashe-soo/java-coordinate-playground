package coordinate.domain;

import java.util.List;

public class Line extends Shape{

    public Line(List<Point> points) {
        super(points);
    }

    @Override
    double area() {
        return points.get(0).distanceFrom(points.get(1));
    }

    @Override
    String getInfo() {
        return "두 점 사이의 거리는 "+area();
    }
}
