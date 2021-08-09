package coordinate.view;


import coordinate.domain.Point;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_COMMAND = "좌표를 입력하세요";
    private static final String ERROR_INVALID = "올바르지 않은 입력 값입니다.";

    private static Scanner scanner = new Scanner(System.in);

    public static List<Point> readCoordinate() {
        System.out.println(INPUT_COMMAND);
        return transformToPoints(scanner.nextLine());
    }

    private static List<Point> transformToPoints(String input) {

        try {
            String trimmedInput = input.replace(" ", "");
            validateInput(trimmedInput);
            return makePoints(trimmedInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCoordinate();
        }

    }

    private static List<Point> makePoints(String trimmedInput) {
        return Arrays.stream(trimmedInput.split("-"))
                .map(str -> str.substring(1, str.length() - 1).split(","))
                .map(str -> new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1])))
                .collect(Collectors.toList());
    }

    private static void validateInput(String input) {
        Pattern pattern = Pattern.compile("(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,5}");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_INVALID);
        }
    }

}
