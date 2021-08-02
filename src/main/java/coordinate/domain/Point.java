package coordinate.domain;

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

    private void validateRange(int number){
        if(number < MIN || number > MAX){
            throw new IllegalArgumentException("좌표의 값은 1이상 24이하입니다.");
        }
    }

}
