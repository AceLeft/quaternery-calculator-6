package Calculator;


import javax.swing.*;

public class Calculate {

    public void calculation(String val1, String val2, Operands operator, JLabel outputLabel) {

        int num1 = base4ToBase10(val1);
        int num2 = base4ToBase10(val2);

        switch (operator) {
            case ADD -> {
                int sum = addition(num1, num2);
                String convertedSum = base10ToBase4(sum);
                outputLabel.setText(convertedSum);
            }
            case SUBTRACT -> {
                int difference = subtraction(num1, num2);
                String convertedDifference = base10ToBase4(difference);
                outputLabel.setText(convertedDifference);
            }
            case MULTIPLY -> {
                int product = multiplication(num1, num2);
                String convertedProduct = base10ToBase4(product);
                outputLabel.setText(convertedProduct);
            }
            case DIVIDE -> {
                int quotient = division(num1, num2);
                String convertedQuotient = base10ToBase4(quotient);
                outputLabel.setText(convertedQuotient);
            }
            case SQUARE -> {
                int square = multiplication(num1, num1);
                String convertedSquare = base10ToBase4(square);
                outputLabel.setText(convertedSquare);
            }
            case SQUAREROOT -> {
                int squareRoot = squareRoot(num1);
                String convertedSquareRoot = base10ToBase4(squareRoot);
                outputLabel.setText(convertedSquareRoot);
            }
        }

    }


    public int base4ToBase10(String value){
        return Integer.parseInt(value, 4);
    }


    public String base10ToBase4(int value){
        return Integer.toString(value, 4);
    }


    public int addition (int val1, int val2){
        return (val1 + val2);
    }


    public int subtraction(int val1, int val2){
        return (val1 - val2);
    }


    public int multiplication(int val1, int val2){
        return (val1 * val2);
    }


    public int division(int val1, int val2){
        return (val1/val2);
    }


    public int squareRoot(int value){
        return (int) Math.sqrt(value);
    }
}
