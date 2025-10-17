package calculator;

public class StringCalculator {
    public int add(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int sum = 0;
        String[] nums = str.split("[,:]");
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
