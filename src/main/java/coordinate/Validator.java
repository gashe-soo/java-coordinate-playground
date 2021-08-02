package coordinate;

public class Validator {

    private static final char OPEN_PARENTHESES = '(';
    private static final char CLOSE_PARENTHESES = ')';

    public static void validate(String input) {
        for (String point : input.split("-")) {
            checkParentheses(point);
        }
    }

    private static void checkParentheses(String point){
        if(point.charAt(0) != OPEN_PARENTHESES || point.charAt(point.length()-1) != CLOSE_PARENTHESES){
            throw new IllegalArgumentException("좌표의 값은 1이상 24이하입니다.");
        }
    }

}
