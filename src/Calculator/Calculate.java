package Calculator;

import javax.swing.*;

public class Calculate {

    public boolean allowInput = true;
    public boolean canInput() {
        return allowInput;
    }//used to prevent user input after result (except clear)
    public void calculation(String val1, String val2, Operands operator, JLabel outputLabel) {

        int num1 = Integer.parseInt(val1, 4); //converts from base 4 to base 10
        int num2 = Integer.parseInt(val2, 4);

        switch (operator) {
            case ADD:
                int sum = num1 + num2;
                String convertedSum = Integer.toString(sum, 4); //base 10 back to 4
                outputLabel.setText(convertedSum);
                allowInput = false;
                break;
            case SUBTRACT:
                int difference = num1 - num2;
                String convertedDifference = Integer.toString(difference, 4);
                outputLabel.setText(convertedDifference);
                allowInput = false;
                break;
            case MULTIPLY:
                int product = num1 * num2;
                String convertedProduct = Integer.toString(product, 4);
                outputLabel.setText(convertedProduct);
                allowInput = false;
                break;
            case DIVIDE:
                int quotient = num1 / num2;
                String convertedQuotient = Integer.toString(quotient, 4);
                outputLabel.setText(convertedQuotient);
                allowInput = false;
                break;
            case SQUARE:
                int square = num1*num1;
                String convertedSquare = Integer.toString(square, 4);
                outputLabel.setText(convertedSquare);
                allowInput = false;
                break;
            case SQUAREROOT:
                int squareRoot = (int) Math.sqrt(num1);
                String convertedSquareRoot = Integer.toString(squareRoot, 4);
                outputLabel.setText(convertedSquareRoot);
                allowInput = false;
                break;

        }


    }

}
