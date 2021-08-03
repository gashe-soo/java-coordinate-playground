package coordinate.domain;

import java.util.Objects;

public class Point {

    private static final int MAX = 24;
    private static final int MIN = 1;

    private int x;
    private int y;

    public Point(int x, int y) {
        validateRange(x);
        validateRange(y);
        this.x = x;
        this.y = y;
    }

    private void validateRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("좌표의 값은 1이상 24이하입니다.");
        }
    }

    public double distanceFrom(Point point) {
        return Math.sqrt(square(point.minusX(x)) + square(point.minusY(y)));
    }

    private double square(int number) {
        return Math.pow(number, 2);
    }

    public boolean isOnSameCol(Point point) {

        return this.equals(point) || (point.compareX(x) && !point.compareY(y));
    }

    public boolean isOnSameRow(Point point) {
        return this.equals(point) || (!point.compareX(x) && point.compareY(y));
    }

    public boolean compareX(int x) {
        return this.x == x;
    }

    public boolean compareY(int y) {
        return this.y == y;
    }

    public int minusX(int value) {
        this.x -= value;
        return x;
    }

    public int minusY(int value) {
        this.y -= value;
        return y;
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
}
