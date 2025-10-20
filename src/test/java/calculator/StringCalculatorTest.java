package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private Parser parser;
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        parser = new InputParser();
        stringCalculator = new StringCalculator(parser);
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

    @DisplayName(",또는 : 구분자로 분리된 숫자의 합을 반환")
    @Test
    void add_with_basic_delimiters(){
        //given
        String text = "1,2:3";
        //when
        int result = stringCalculator.add(text);
        //then
        assertEquals(6, result);
    }

    @DisplayName("커스텀 구분자를 사용했을 때 성공해야 한다.")
    @Test
    void custom_delimiter(){
        //given
        String text = "//;\\n1;2;3";
        //when
        int result = stringCalculator.add(text);
        //then
        assertEquals(6, result);
    }
}