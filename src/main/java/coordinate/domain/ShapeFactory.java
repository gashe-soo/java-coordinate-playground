package coordinate.domain;

import java.util.List;

public class ShapeFactory {

    private static final int LINE = 2;

    public static Shape create(List<Point> points){
        return new Line(points);
    }
}
