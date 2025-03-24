import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
Calculator myCalc;

@BeforeEach
    void setup(){
    myCalc = new Calculator ();

}

@Test
void testAddSuccess(){

    assertEquals(8,myCalc.add(4,4));
}

@Test
void testAddFail() {

    Exception ex = assertThrows(IllegalArgumentException.class, ()->{myCalc.add(Integer.MAX_VALUE,4);} );
    assertEquals("Your values are too large", ex.getMessage());
}
    @Test
    void testSubtractSuccess(){
        // 8 - 4 should equal 4
        assertEquals(4, myCalc.subtract(8,4));
    }

    @Test
    void testSubtractFail(){

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            myCalc.subtract(Integer.MIN_VALUE, 4);
        });
        assertEquals("Your values are too large", ex.getMessage());
    }
    @Test
    void testSubtractOverflow() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            myCalc.subtract(Integer.MAX_VALUE, -1);
        });
        assertEquals("Your values are too large", ex.getMessage());
    }
    @Test
    void testMultiplySuccess(){
        // 4 * 5 should equal 20
        assertEquals(20, myCalc.multiply(4,5));
    }
    @Test
    void testMultiplyOverflow() {
        // Forces result > Integer.MAX_VALUE
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            myCalc.multiply(Integer.MAX_VALUE, 2);
        });
        assertEquals("Your values are too large", ex.getMessage());
    }

    @Test
    void testMultiplyUnderflow() {
        // Forces result < Integer.MIN_VALUE
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            myCalc.multiply(Integer.MIN_VALUE, 2);
        });
        assertEquals("Your values are too large", ex.getMessage());
    }
    @Test
    void testDivideSuccess(){
        // 8 / 4 should equal 2
        assertEquals(2, myCalc.divide(8,4));
    }

    @Test
    void testDivideByZero(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            myCalc.divide(4, 0);
        });
        assertEquals("Cannot divide by zero", ex.getMessage());
    }

    @Test
    void testDivideOverflow(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            myCalc.divide(Integer.MIN_VALUE, -1);
        });
        assertEquals("Your values are too large", ex.getMessage());
    }
    @Test
    void testDivideMinValueNoOverflow() {
        // This ensures numerator == Integer.MIN_VALUE, but denominator != -1
        // so the "if" check is false overall
        assertEquals(Integer.MIN_VALUE, myCalc.divide(Integer.MIN_VALUE, 1));
    }
}
