package coordinate.domain;

import java.util.Objects;

public class Point {

    private static final int MAX = 24;
    private static final int MIN = 1;

    private int x;
    private int y;

    public Point(int x, int y) {
        validateRange(x, y);
        this.x = x;
        this.y = y;
    }

    private void validateRange(int x, int y) {
        checkRange(x);
        checkRange(y);
    }

    private void checkRange(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException("범위는 1이상 24이하의 자연수입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double getDistanceFrom(Point point) {
        return Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2));
    }
}
