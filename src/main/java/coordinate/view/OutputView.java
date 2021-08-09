package coordinate.view;

import coordinate.domain.Point;
import coordinate.domain.Shape;

import java.util.List;

public class OutputView {

    private static final int MAX = 24;
    private static final int MIN = 1;
    private static final String TWO_BLANK = "  ";
    private static final String VERTICAL_AXIS = "|";
    private static final String MARK = "*";
    private static final String ORIGIN = "+";
    private static final String BASELINE = "--";

    public static void printCoordinates(List<Point> points) {
        printRow(points);
        printBaseLine();
        printBaseNumber();
        emptyLine();
    }

    public static void printResult(Shape shape) {
        System.out.println(shape.getInfo());
    }

    private static void emptyLine(){
        System.out.println();
    }

    private static void printBaseNumber() {
        System.out.print(String.format("%2d", 0));
        for (int idx = MIN; idx <= MAX; idx++) {
            System.out.print(printAxisNumber(idx));
        }
        emptyLine();
    }

    private static void printBaseLine() {
        System.out.print(TWO_BLANK+ ORIGIN);
        for (int idx = MIN; idx <= MAX; idx++) {
            System.out.print(BASELINE);
        }
        emptyLine();
    }

    private static void printRow(List<Point> points) {
        for (int idx = MAX; idx >= MIN; idx--) {
            printAxis(idx);
            printPoint(idx, points);
        }
    }

    private static void printPoint(int y, List<Point> points) {
        for (int x = MIN; x <= MAX; x++) {
            System.out.print(isMark(points, new Point(x, y)));
        }
        emptyLine();
    }

    private static String isMark(List<Point> points, Point point) {
        if (points.contains(point)) {
            return MARK;
        }
        return TWO_BLANK;
    }

    private static void printAxis(int idx) {
        System.out.print(printAxisNumber(idx) + VERTICAL_AXIS);
    }

    private static String printAxisNumber(int idx) {
        if (idx % 2 == 0) {
            return String.format("%2d", idx);
        }
        return TWO_BLANK;
    }


}
