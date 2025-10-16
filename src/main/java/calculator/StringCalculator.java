package calculator;

import java.util.Arrays;

public class StringCalculator {

    public int add(String text) {
        // 입력값이 null 이거나 비어있는 경우 0을 반환.
        if (text == null || text.isEmpty()) {
            return 0;
        }

        // 쉼표(,) 또는 콜론(:)을 기준으로 문자열을 분리.
        String[] numbers = text.split("[,:]");

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}