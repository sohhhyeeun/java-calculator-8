package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("빈 문자열 또는 null을 입력할 경우, 0 반환")
    void func01() {
        String emptyInput = "";
        String nullInput = null;

        int emptyOutput = stringCalculator.add(emptyInput);
        int nullOutput = stringCalculator.add(nullInput);

        assertThat(emptyOutput).isEqualTo(0);
        assertThat(nullOutput).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 입력할 경우, 해당 숫자 반환")
    void func02() {
        String input = "5";

        int output = stringCalculator.add(input);

        assertThat(output).isEqualTo(5);
    }

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 입력할 경우, 구분자를 기준으로 분리한 각 숫자의 합 반환")
    void func03() {
        String input = "1,2:3";

        int output = stringCalculator.add(input);

        assertThat(output).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치하는 문자를 구분자로 가지는 문자열을 입력할 경우, 구분자를 기준으로 분리한 각 숫자의 합 반환")
    void func04() {
        String input = "//;\n1;2;3";

        int output = stringCalculator.add(input);

        assertThat(output).isEqualTo(6);
    }

    @Test
    @DisplayName("입력 문자열에 음수가 포함된 경우, IllegalArgumentException 발생")
    void func05() {
        String input = "1,-2:3";

        assertThatThrownBy(() -> stringCalculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("입력 문자열에 숫자 이외의 문자가 포함된 경우, IllegalArgumentException 발생")
    void func06() {
        String input = "1,a:3";

        assertThatThrownBy(() -> stringCalculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 이외의 문자는 입력할 수 없습니다.");
    }
}
