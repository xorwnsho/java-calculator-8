package calculator;

import java.util.Arrays;

public class StringCalculator {

    private final InputParser parser = new InputParser();

    public int add(String text) {

        String[] numbers = parser.parse(text);

        int[] parsedNumbers = Arrays.stream(numbers)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();

        return Arrays.stream(parsedNumbers).sum();
    }
}