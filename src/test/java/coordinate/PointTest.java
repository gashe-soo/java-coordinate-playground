package coordinate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PointTest {


    @ParameterizedTest
    @CsvSource(value = {"0,4","25,1","4,0","1,25"})
    void 입력범위_초과시_오류발생(int x, int y){
        assertThatIllegalArgumentException().isThrownBy(()->new Point(x,y))
                .withMessageContaining("범위는 1이상 24이하의 자연수입니다.");
    }

    @Test
    void 입력범위_정상시_오류_미발생(){
        assertDoesNotThrow(()-> new Point(1,24));
    }

}
