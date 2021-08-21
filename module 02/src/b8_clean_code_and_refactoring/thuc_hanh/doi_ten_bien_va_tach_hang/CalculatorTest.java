package b8_clean_code_and_refactoring.thuc_hanh.doi_ten_bien_va_tach_hang;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    public static final char ADDITION = '+';
    public static final char SUBTRACTION  = '-';
    public static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';

    @Test
        @DisplayName("Testing addition")
        public void testCalculateAdd() {
            int firstOperand  = 1;
            int secondOperand  = 1;
            char o = ADDITION;
            int expected = 2;

            int result = Calculator.calculate(firstOperand , secondOperand , o);
            assertEquals(expected, result);
        }

        @Test

        @DisplayName("Testing subtraction")
        void testCalculateSub() {
            int firstOperand = 2;
            int secondOperand = 1;
            char o = SUBTRACTION ;
            int expected = 1;

            int result = Calculator.calculate(firstOperand, secondOperand, o);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Testing multiplication")
        void testCalculateMul() {
            int firstOperand = 2;
            int secondOperand = 2;
            char o = MULTIPLICATION;
            int expected = 4;

            int result = Calculator.calculate(firstOperand, secondOperand, o);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Testing division")
        void testCalculateDiv() {
            int firstOperand = 6;
            int secondOperand = 3;
            char o = DIVISION;
            int expected = 2;

            int result = Calculator.calculate(firstOperand, secondOperand, o);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Testing division by zero")
        void testCalculateDivByZero() {
            int firstOperand = 2;
            int secondOperand = 0;
            char o = DIVISION;

            assertThrows(RuntimeException.class,
                    ()-> {Calculator.calculate(firstOperand, secondOperand, o);});
        }

        @Test
        @DisplayName("Testing wrong operator")
        void testCalculateWrongOperator() {
            int firstOperand = 2;
            int secondOperand = 0;
            char o = '=';

            assertThrows(RuntimeException.class,
                    ()-> {Calculator.calculate(firstOperand, secondOperand, o);});
        }
}
