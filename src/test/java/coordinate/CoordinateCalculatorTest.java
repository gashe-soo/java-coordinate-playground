package coordinate;

import coordinate.domain.CoordinateCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

}
