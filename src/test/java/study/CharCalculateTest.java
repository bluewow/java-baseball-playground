package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CharCalculateTest {

    @DisplayName("사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 + 2 * 3 / 3:3"}, delimiter = ':')
    void test(String input, int expected) {
        //given
        String[] values = input.split(" ");

        //when
        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i++) {
            switch (values[i]) {
                case "+":
                    result += Integer.parseInt(values[i + 1]);
                    break;
                case "-":
                    result -= Integer.parseInt(values[i + 1]);
                    break;
                case "*":
                    result *= Integer.parseInt(values[i + 1]);
                    break;
                case "/":
                    result /= Integer.parseInt(values[i + 1]);
                    break;
            }
        }

        //then
        assertThat(result).isEqualTo(expected);
    }
}