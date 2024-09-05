package Calculator;

import javax.swing.*;

public class Calculate {

    public void calculation(String val1, String val2, Operands operator, JLabel outputLabel) {

        int num1 = Integer.parseInt(val1, 4); //converts from base 4 to base 10
        int num2 = Integer.parseInt(val2, 4); //converts from base 4 to base 10

        switch (operator) {
            case ADD:
                int sum = num1 + num2;
                String convertedSum = Integer.toString(sum, 4); //base 10 back to 4
                System.out.println(convertedSum);
                outputLabel.setText(convertedSum);
                break;
            case SUBTRACT:
                int difference = num1 - num2;
                String convertedDifference = Integer.toString(difference, 4);
                outputLabel.setText(convertedDifference);
                break;
            case MULTIPLY:
                int product = num1 * num2;
                String convertedProduct = Integer.toString(product, 4);
                outputLabel.setText(convertedProduct);
                break;
            case DIVIDE:
                int quotient = num1 / num2;
                String convertedQuotient = Integer.toString(quotient, 4);
                outputLabel.setText(convertedQuotient);
                break;
            case SQUARE:
                int square = num1*num1;
                String convertedSquare = Integer.toString(square, 4);
                outputLabel.setText(convertedSquare);
                break;
            case SQUAREROOT:
                int squareRoot = (int) Math.sqrt(num1);
                String convertedSquareRoot = Integer.toString(squareRoot, 4);
                outputLabel.setText(convertedSquareRoot);
                break;

        }


    }

}
