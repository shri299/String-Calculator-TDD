public class StringCalculatorApp {
    public static void main(String[] args) {
        String[] testInputs = {
                "",
                "1",
                "1,5",
                "1,2,3,4",
                "1\n2,3",
                "//;\n1;2",
                "1,-2,3",
                "1,-2,-3"
        };

        for (String input : testInputs) {
            try {
                int result = StringCalculator.add(input);
                System.out.println("Input: \"" + input + "\" => Output: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Input: \"" + input + "\" => Exception: " + e.getMessage());
            }
        }

    }
}