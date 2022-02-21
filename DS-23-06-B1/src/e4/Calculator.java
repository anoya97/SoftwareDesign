package e4;

import java.util.Arrays;

public class Calculator {
    private float total = 0;
    private final String[] calculator = new String[100];
    private int g = 0;

    public Calculator() {

    }

    public void cleanOperations() {
        Arrays.fill(calculator, null);
        calculator[0] = "[STATE:";
        g = 0;
    }

    public void addOperation(String operation, float... values) {
        int j;
        for (j = 0; calculator[j] != null; j++);

        switch (operation) {
            case "+" -> {
                for (int i = 0; i < values.length; i++) {
                    if (calculator[j] == null) {
                        calculator[j] = "[+]";
                        if (values.length == 2 && g == 0) {
                            calculator[j + 1] = values[0] + "_";
                            calculator[j + 2] = String.valueOf(values[1]);
                        } else {
                            calculator[j + 1] = String.valueOf(values[0]);
                        }

                    }
                }
                if (values.length == 2 && g == 0) {
                    total = values[0] + values[1];
                } else {
                    total += values[0];
                }
            }
            case "-" -> {
                for (int i = 0; i < values.length; i++) {
                    if (calculator[j] == null) {
                        calculator[j] = "[-]";
                        if (values.length == 2 && g == 0) {
                            calculator[j + 1] = values[0] + "_";
                            calculator[j + 2] = String.valueOf(values[1]);
                        } else {
                            calculator[j + 1] = String.valueOf(values[0]);
                        }

                    }
                }
                if (values.length == 2 && g == 0) {
                    total = values[0] - values[1];
                } else {
                    total -= values[0];
                }
            }
            case "*" -> {
                for (int i = 0; i < values.length; i++) {
                    if (calculator[j] == null) {
                        calculator[j] = "[*]";
                        calculator[j + 1] = String.valueOf(values[0]);
                    }
                }
                total *= values[0];
            }
            case "/" -> {
                for (int i = 0; i < values.length; i++) {
                    if (calculator[j] == null) {
                        calculator[j] = "[/]";
                        if (values.length == 2 && g == 0) {
                            calculator[j + 1] = values[0] + "_";
                            calculator[j + 2] = String.valueOf(values[1]);
                        } else {
                            calculator[j + 1] = String.valueOf(values[0]);
                        }
                    }
                }
                if (values.length == 2 && g == 0) {
                    total = values[0] / values[1];
                } else {
                    total /= values[0];
                }
            }
            default -> throw new IllegalArgumentException();
        }
        g++;

    }

    public float executeOperations() {
        if(total == Float.POSITIVE_INFINITY || total == Float.NEGATIVE_INFINITY || Float.isNaN(total)){
            cleanOperations();
            throw new ArithmeticException();
        }
        cleanOperations();
        return total;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        for (String value : calculator) {
            if (value != null) {
                sb.append(value);
            }
        }
        return sb + "]";
    }
}

