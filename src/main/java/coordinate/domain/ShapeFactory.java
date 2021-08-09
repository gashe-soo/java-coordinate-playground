package coordinate.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ShapeFactory {

    private static final int NUM_OF_LINE = 2;
    private static final int NUM_OF_TRIANGLE = 3;
    private static final int NUM_OF_RECTANGLE = 4;

    private static final Map<Integer, Function<List<Point>, Shape>> classifier = new HashMap<>();

    static {
        classifier.put(NUM_OF_LINE, Line::new);
        classifier.put(NUM_OF_TRIANGLE, Triangle::new);
        classifier.put(NUM_OF_RECTANGLE, Rectangle::new);
    }

    public static Function<List<Point>, Shape> create(List<Point> points) {
        if(!classifier.containsKey(points.size())){
            throw new IllegalArgumentException("지원하지 않는 도형입니다.");
        }
        return classifier.get(points.size());
    }
}
