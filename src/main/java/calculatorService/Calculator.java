package calculatorService;

import java.math.BigDecimal;

public class Calculator {

    private static BigDecimal[] numbers = new BigDecimal[3];
    private static BigDecimal total;

    public static BigDecimal calculate(String firstNumber, String operator, String secondNumber) {
        numbers[0] = new BigDecimal(firstNumber);
        BigDecimal second = new BigDecimal(secondNumber);
        if (second.compareTo(BigDecimal.ZERO) > 0 || secondNumber.contains("-") || firstNumber.equals("0")) {
            numbers[1] = second;
        } else {
            throw new IllegalArgumentException("Division by zero error");
        }
        total = CalculatorHelper.process(numbers, operator);
        return total.setScale(7, BigDecimal.ROUND_CEILING).stripTrailingZeros();
    }
}