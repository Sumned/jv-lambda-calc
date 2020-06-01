package core.basesyntax;

public class Calculator {

    private Calculator() {

    }

    public static Double calculate(double x, double y, Character operator) {
        try {
            return operator == '+' ? x + y : operator == '-'
                    ? x - y : operator == '*'
                    ? x * y : operator == '/'
                    ? x / y : operator == '^'
                    ? Math.pow(x, y) : null;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Operation is not supported!");
        }
    }
}
