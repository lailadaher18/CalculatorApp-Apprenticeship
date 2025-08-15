package calculatorService;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorHelper {


    public static BigDecimal process(BigDecimal[] numbers, String operator) throws IllegalArgumentException {
        return switch (operator) {
            case "+" -> addition(numbers);
            case "-" -> subtraction(numbers);
            case "*" -> multiplication(numbers);
            case "/" -> division(numbers);
            case "%" -> modulus(numbers);
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }

    public static BigDecimal addition(BigDecimal[] numbers) {
        BigDecimal result = numbers[0].add(numbers[1]);
        return result;
    }

    public static BigDecimal subtraction(BigDecimal[] numbers) {
        BigDecimal result = numbers[0].subtract(numbers[1]);
        return result;
    }

    public static BigDecimal multiplication(BigDecimal[] numbers) {
        BigDecimal result = numbers[0].multiply(numbers[1]);
        return result;
    }

    public static BigDecimal division(BigDecimal[] numbers) {
        BigDecimal result = numbers[0].divide(numbers[1], 10, RoundingMode.HALF_UP);
        return result;
    }

    public static BigDecimal modulus(BigDecimal[] numbers) {
        BigDecimal result = numbers[0].remainder(numbers[1]);
        return result;
    }
}