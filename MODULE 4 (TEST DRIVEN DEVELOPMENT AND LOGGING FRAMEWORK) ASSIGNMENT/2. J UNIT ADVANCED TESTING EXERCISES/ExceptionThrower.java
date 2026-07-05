public class ExceptionThrower {

    public void throwException(String input) {
        if (input == null) {
            throw new NullPointerException("Input cannot be null");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        if (input.equals("runtime")) {
            throw new RuntimeException("Runtime error triggered");
        }
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
