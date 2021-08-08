package coordinate.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RectangleTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1,2,2,3,3,4,4", "1,1,1,1,1,1,1,1", "6,6,10,6,8,4,8,8"})
    void 사각형이_아닌_경우_오류_발생(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Rectangle(Arrays.asList(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), new Point(x4, y4)))
        ).withMessageContaining("사각형이 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"10,10,22,10,22,18,10,18,96", "1,1,6,4,1,4,6,1,15"})
    void 사각형_면적_계산(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, double expected) {
        Rectangle rectangle = new Rectangle(Arrays.asList(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), new Point(x4, y4)));

        assertThat(rectangle.area()).isEqualTo(expected,offset(0.00099));
    }


}
