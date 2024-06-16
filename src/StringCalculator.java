import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }


        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] numArray = numbers.split("\\"+delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String num : numArray) {
            if (!num.trim().isEmpty()) {
                int number = Integer.parseInt(num.trim());
                if (number < 0) {
                    negatives.add(number);
                }
                sum += number;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed: " + negatives.toString().replace("[", "").replace("]", ""));
        }

        return sum;
    }
}
