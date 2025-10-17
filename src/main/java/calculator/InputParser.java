package calculator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputParser {

    public String[] parse(String text) {

        // 1번 기능 : text가 null이거나 비어있을 시에 0을 반환
        if (text == null || text.isEmpty()) {
            return new String[0];
        }

        // 2번 기능 : 커스텀 구분자를 사용하여 문자열 계산기 사용
        Matcher m = Pattern.compile("//(.)\\\\n(.*)").matcher(text);

        if (m.matches()) {
            String customDelimiter = m.group(1);
            String numbers = m.group(2);
            if (customDelimiter.isEmpty()) {
                return new String[]{numbers};
            }
            return numbers.split(Pattern.quote(customDelimiter));
        }


        // 1번 기능 : ,과 : 구분자를 사용하여 배열을 반환
        return text.split("[,:]");
    }
}

