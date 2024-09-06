package GUI;

import Calculator.Calculate;
import Calculator.Operands;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class CalculatorFrame {
    private String firstNumber = "0";
    private String secondNumber = "0";
    private Operands currentlySelectedOperand = null;
    private final JLabel outputLabel;
    private final Calculate calc;

    public CalculatorFrame() {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,50,10,50));
        mainPanel.setLayout(new GridLayout(0, 1));
        calc = new Calculate();

        outputLabel = new JLabel();
        outputLabel.setBorder(BorderFactory.createEtchedBorder());
        mainPanel.add(outputLabel);

        JToggleButton conversionToggle = new JToggleButton("Base 4 <-> Base 10");
        conversionToggle.addActionListener( e -> convertLabel(!conversionToggle.isSelected()));
        mainPanel.add(conversionToggle);

        NumberButton zero = new NumberButton(0);
        NumberButton one = new NumberButton(1);
        NumberButton two = new NumberButton(2);
        NumberButton three = new NumberButton(3);
        NumberButton[] numberButtons = {zero, one, two, three};


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 4));

        for(NumberButton button : numberButtons) {
            button.addActionListener(e -> {
                //Disabling of conversion must happen first
                if(conversionToggle.isSelected()){
                    conversionToggle.setSelected(false);
                    convertLabel(true);
                }
                appendToOutputLabel(button.getValue());
            });
            buttonPanel.add(button);


        }

        OperandButton addButton = new OperandButton(Operands.ADD, "+");
        OperandButton subtractButton = new OperandButton(Operands.SUBTRACT, "-");
        OperandButton multiplyButton = new OperandButton(Operands.MULTIPLY, "*");
        OperandButton divideButton = new OperandButton(Operands.DIVIDE, "/");


        OperandButton[] operandButtons = {addButton, subtractButton, multiplyButton, divideButton};


        for (OperandButton button : operandButtons) {
            button.addActionListener(e -> {
                storeOutput();
                currentlySelectedOperand = button.getOperand();
            });
            buttonPanel.add(button);
        }

        JButton equals = new JButton("=");
        JButton square = new JButton("x²");
        JButton squareRoot = new JButton("√");
        JButton clearButton = new JButton("Clear All");


        equals.addActionListener(e -> performEquals(e.getActionCommand())); //sends actionCommand to performEquals method
        square.addActionListener(e -> performEquals(e.getActionCommand()));
        squareRoot.addActionListener(e -> performEquals(e.getActionCommand()));
        clearButton.addActionListener((e) -> {
            this.clearCalculator();  // Method to clear the state and reset
        });


        buttonPanel.add(equals);
        buttonPanel.add(square);
        buttonPanel.add(squareRoot);
        buttonPanel.add(clearButton);

        mainPanel.add(buttonPanel);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quaternary Calculator");
        frame.pack();
        frame.setVisible(true);
    }

    private void convertLabel(boolean intoBase4) {
        String label = outputLabel.getText();
        if(label.equals("")) {
            return;
        }
        if(intoBase4) {
            int base4 = Integer.parseInt(label);
           outputLabel.setText(Integer.toString(base4, 4));
        }
        else {
            int base10 = Integer.parseInt(label, 4);
            outputLabel.setText(String.valueOf(base10));
        }

    }

    private void performEquals(String command) {
        if (calc.canInput() && currentlySelectedOperand != null) { //if false then you won't be able to click '=', 'x²', or '√' after getting result
            storeOutput();
            String result = String.valueOf((1 + 2));
            //above, put the connection to calculator, sending firstNumber, currentOperand, and  secondNumber
            if (Objects.equals(command, "x²")) {
                currentlySelectedOperand = Operands.SQUARE;
            } else if (Objects.equals(command, "√")) {
                currentlySelectedOperand = Operands.SQUAREROOT;
            }
            //System.out.println("FIRSTNUMBER " + firstNumber);
            //System.out.println("SECONDNUMBER " + secondNumber);
            //System.out.println("OPERAND " + currentlySelectedOperand);
            calc.calculation(firstNumber, secondNumber, currentlySelectedOperand, outputLabel);


            currentlySelectedOperand = null;
            firstNumber = result;
            secondNumber = "0";
        }
    }

    private void storeOutput() {
        if (currentlySelectedOperand != null) {
            secondNumber = outputLabel.getText();
            if(secondNumber.equals("")) {
                secondNumber = "0";
            }
        } else {
            firstNumber = outputLabel.getText();
            secondNumber = "0";
        }
        //Clear the output label?
        if (calc.canInput()) { //if false then you can't click operand buttons after result
            outputLabel.setText("");
        }
    }

    private void appendToOutputLabel(int numberAppended) {
        if (calc.canInput()) { //if false then you can't click number buttons after getting result
            String currentText = outputLabel.getText();
            outputLabel.setText(currentText + numberAppended);
        }
    }

    private void clearCalculator() {
        calc.allowInput = true; //allows input again
        this.firstNumber = "0";
        this.secondNumber = "0";
        this.currentlySelectedOperand = null;
        this.outputLabel.setText("");
    }
}
