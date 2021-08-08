package coordinate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @Test
    void 좌표가_2개이면서_직선이_아닐경우_오류발생(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->new Line(Arrays.asList(new Point(1,1),new Point(1,1)))
        ).withMessageContaining("직선이 아닙니다.");
    }

}
