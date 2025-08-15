package calculatorService;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void testAddition() {
        assertEquals(new BigDecimal("5"), Calculator.calculate("2", "+", "3"));
    }

    @Test
    void testSubtraction() {

        assertEquals(new BigDecimal("-1"), Calculator.calculate("2", "-", "3"));
    }

    @Test
    void testMultiplication() {

        assertEquals(new BigDecimal("6"), Calculator.calculate("2", "*", "3"));
    }

    @Test
    void testDivision() {

        assertEquals(new BigDecimal("2"), Calculator.calculate("6", "/", "3"));
    }

    @Test
    void testModulo() {

        assertEquals(new BigDecimal("1"), Calculator.calculate("10", "%", "3"));
    }

    @Test
    void testDivisionByZero() {

        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate("5", "/", "0"));
    }

    @Test
    void testFirstNumberIsANegativeNumber() {

        assertEquals(new BigDecimal("-3"), Calculator.calculate("-5", "+", "2"));
    }

    @Test
    void testDecimalNumbers() {

        assertEquals(new BigDecimal("5.6"), Calculator.calculate("2.5", "+", "3.1"));
    }

    @Test
    void testFirstNumberIsANegativeDecimalNumber() {

        assertEquals(new BigDecimal("0.6"), Calculator.calculate("-2.5", "+", "3.1"));
    }


    @Test
    void testLargeNumbers() {
        assertEquals(new BigDecimal("1000000000000").toPlainString(), Calculator.calculate("1000000", "*", "1000000").toPlainString());
    }

    @Test
    void testZeroInput() {

        assertEquals(new BigDecimal("0"), Calculator.calculate("0", "+", "0"));
    }

    @Test
    void testInvalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate("2", "?", "2"));
    }

    @Test
    void testRoundingToSevenDigits() {
        assertEquals(new BigDecimal("0.3333334"), Calculator.calculate("1", "/", "3"));
    }
}