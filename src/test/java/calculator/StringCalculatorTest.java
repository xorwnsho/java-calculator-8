package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("null일 때는 0을 반환")
    @Test
    void string_is_null() {
        //given
        String text = null;

        //when
        int result = stringCalculator.add(text);

        //then
        assertEquals(0, result);
    }

    @DisplayName("빈 문자열일 때는 0을 반환")
    @Test
    void string_is_empty() {
        //given
        String text = "";

        //when
        int result = stringCalculator.add(text);

        //then
        assertEquals(0, result);
    }
}