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
}
