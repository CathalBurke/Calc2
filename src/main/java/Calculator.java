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
}
