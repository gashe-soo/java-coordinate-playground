package coordinate.domain;

import coordinate.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoordinateCalculator {
    public double calculate(String input) {
        Shape shape = ShapeFactory.create(makePoints(input));
        return shape.area();
    }

    private List<Point> makePoints(String input){
        Validator.validate(input);
        return Arrays.stream(input.split("-"))
                .map(point -> point.substring(1,point.length()-1).split(","))
                .map(pointArr -> new Point(toInt(pointArr[0]),toInt(pointArr[1])))
                .collect(Collectors.toList());
    }

    private int toInt(String s) {
        return Integer.parseInt(s);
    }


}
