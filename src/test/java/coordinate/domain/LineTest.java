package coordinate.domain;

import coordinate.domain.Line;
import coordinate.domain.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    void 좌표가_2개이면서_직선이_아닐경우_오류발생() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Line(Arrays.asList(new Point(1, 1), new Point(1, 1)))
        ).withMessageContaining("직선이 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,4,1,1,3", "1,1,5,6,6.403124"})
    void 직선_두_점사이의_거리_계산(int x1, int y1, int x2, int y2, double distance) {
        Line line = new Line(Arrays.asList(new Point(x1, y1), new Point(x2, y2)));
        assertThat(line.area()).isEqualTo(distance,offset(0.00099));
    }
}
