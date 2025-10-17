package calculator;

import java.util.Arrays;

public class StringCalculator {

    private Parser parser;

    public StringCalculator(Parser parser){
        this.parser = parser;
    }

    public int add(String text) {

        String[] numbers = parser.parse(text);

        try {
            int[] parsedNumbers = Arrays.stream(numbers)
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .toArray();
            // 3번 기능 : 음수를 넣을 시에 IllegalArgumentException을 터트림
            if (Arrays.stream(parsedNumbers).anyMatch(n -> n < 0)) {
                throw new IllegalArgumentException();
            }

            return Arrays.stream(parsedNumbers).sum();

        } catch (NumberFormatException e) {
            // 4번 기능 : 숫자가 아닌 값을 넣을 시에 IllegalArgumentException을 터트림
            throw new IllegalArgumentException();
        }
    }
}