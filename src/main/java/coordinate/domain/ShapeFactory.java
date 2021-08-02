package coordinate.domain;

import java.util.List;

public class ShapeFactory {

    private static final int LINE = 2;
    private static final int RECTANGLE = 4;


    public static Shape create(List<Point> points) {
        if (points.size() == LINE) {
            return new Line(points);
        }
        return new Rectangle(points);
    }
}
