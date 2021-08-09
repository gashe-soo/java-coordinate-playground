package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ShapeFactoryTest {

    @Test
    void 좌표_2개일때_직선_반환() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(14, 15));
        Function<List<Point>, Shape> constructor = ShapeFactory.create(points);
        assertThat(constructor.apply(points).getClass()).isEqualTo(Line.class);
    }

    @Test
    void 좌표_3개일때_삼각형_반환() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(14, 15), new Point(20, 8));
        Function<List<Point>, Shape> constructor = ShapeFactory.create(points);
        assertThat(constructor.apply(points).getClass()).isEqualTo(Triangle.class);
    }

    @Test
    void 좌표_4개일때_사각형_반환() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(22, 10), new Point(22, 18), new Point(10,18));
        Function<List<Point>, Shape> constructor = ShapeFactory.create(points);
        assertThat(constructor.apply(points).getClass()).isEqualTo(Rectangle.class);
    }

    @Test
    void 좌표_수가_1개일경우_오류발생(){
        List<Point> points = Arrays.asList(new Point(1,1));
        assertThatIllegalArgumentException().isThrownBy(
                ()->ShapeFactory.create(points)
        ).withMessageContaining("지원하지 않는 도형입니다.");
    }

    @Test
    void 좌표_수가_5개_이상_일경우_오류발생(){
        List<Point> points = Arrays.asList(new Point(1,1), new Point(2,2), new Point(3,3), new Point(4,4),new Point(5,5));
        assertThatIllegalArgumentException().isThrownBy(
                ()->ShapeFactory.create(points)
        ).withMessageContaining("지원하지 않는 도형입니다.");
    }




}
