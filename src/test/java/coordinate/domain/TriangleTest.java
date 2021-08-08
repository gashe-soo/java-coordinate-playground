package coordinate.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TriangleTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1,2,2,3,3", "1,1,1,1,2,2"})
    void 삼각형이_아닐_경우_오류_발생(int x1, int y1, int x2, int y2, int x3, int y3) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Triangle(Arrays.asList(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3)))
        ).withMessageContaining("삼각형이 아닙니다.");
    }
}
