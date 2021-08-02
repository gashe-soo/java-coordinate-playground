package coordinate;

import coordinate.domain.CoordinateCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CoordinateCalculatorTest {

    private CoordinateCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new CoordinateCalculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"(10,1)-(1,0)", "(25,1)-(10,10)", "(-1,0)-(10,100)"})
    void 좌표의_값이_범위를_초과할경우_오류발생(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input))
                .withMessageContaining("좌표의 값은 1이상 24이하입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"'(1,1)-(2,1)',1", "'(10,10)-(13,14)',5", "'(10,10)-(14,15)',6.403124"})
    void 직선의_거리_계산(String input, double expected){
        assertThat(calculator.calculate(input)).isEqualTo(expected, offset(0.00099));
    }

    @ParameterizedTest
    @ValueSource(strings = {"(1,1)-(1,3)-(3,10)-(3,1)","(1,7)-(3,7)-(1,1)-(3,2)"})
    void 직사각형이_아닐때_오류발생(String input){
        assertThatIllegalArgumentException().isThrownBy(()->calculator.calculate(input))
                .withMessageContaining("직사각형이 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"'(1,1)-(1,3)-(3,3)-(3,1)',4","'(1,7)-(3,7)-(1,2)-(3,2)',10"})
    void 직사각형의_면적_계산(String input, double expected){

    }


}
