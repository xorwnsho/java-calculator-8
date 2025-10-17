package calculator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputParser {

    public String[] parse(String text) {

        if (text == null || text.isEmpty()) {
            return new String[0];
        }

        Matcher m = Pattern.compile("//(.)\\\\n(.*)").matcher(text);

        if (m.matches()) {
            String customDelimiter = m.group(1);
            String numbers = m.group(2);
            if (customDelimiter.isEmpty()) {
                return new String[]{numbers};
            }
            return numbers.split(Pattern.quote(customDelimiter));
        }

        return text.split("[,;]");
    }
}

