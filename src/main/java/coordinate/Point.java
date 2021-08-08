package coordinate;

public class Point {

    private static final int MAX = 24;
    private static final int MIN = 1;

    public Point(int x, int y) {
        validateRange(x, y);
    }

    private void validateRange(int x, int y) {
        checkRange(x);
        checkRange(y);
    }

    private void checkRange(int value) {
        if (value < MIN || value > MAX){
            throw new IllegalArgumentException("범위는 1이상 24이하의 자연수입니다.");
        }
    }
}
