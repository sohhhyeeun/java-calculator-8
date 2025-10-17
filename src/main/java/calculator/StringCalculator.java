package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";
        String numString = str;

        Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(str);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            numString = matcher.group(2);
        }

        String[] nums = numString.split(delimiter);

        int sum = 0;
        for (String num : nums) {
            int number = Integer.parseInt(num);

            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }

            sum += number;
        }

        return sum;
    }
}
