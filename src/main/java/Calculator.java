public class Calculator {
    public int add(int firstNum, int secondNum) {

        long result = (long) firstNum+ secondNum ;
        if(result> Integer.MAX_VALUE){

            throw new IllegalArgumentException("Your values are too large");
        }
        return (int) result;

    }
    public int subtract(int firstNum, int secondNum) {
        long result = (long) firstNum - secondNum;
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Your values are too large");
        }
        return (int) result;
    }
    public int multiply(int firstNum, int secondNum) {
        long result = (long) firstNum * secondNum;
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Your values are too large");
        }
        return (int) result;
    }
    public int divide(int numerator, int denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        // Check for overflow: Integer.MIN_VALUE / -1
        if(numerator == Integer.MIN_VALUE && denominator == -1) {
            throw new IllegalArgumentException("Your values are too large");
        }
        return numerator / denominator;
    }
}
