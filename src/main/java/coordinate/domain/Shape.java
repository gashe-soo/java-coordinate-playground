package coordinate.domain;

import java.util.List;

public abstract class Shape {

    protected List<Point> points;

    public Shape(List<Point> points) {
        this.points = points;
    }

    abstract double area();

    abstract String getInfo();

}
