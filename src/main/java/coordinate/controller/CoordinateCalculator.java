package coordinate.controller;

import coordinate.domain.Point;
import coordinate.domain.Shape;
import coordinate.domain.ShapeFactory;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateCalculator {
    public static void run() {
        List<Point> points = InputView.readCoordinate();
        OutputView.printCoordinates(points);

        try{
            Shape shape = ShapeFactory.create(points).apply(points);
            OutputView.printResult(shape);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }
}
