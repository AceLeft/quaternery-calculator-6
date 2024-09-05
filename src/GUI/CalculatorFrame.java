package GUI;

import Calculator.Calculate;
import Calculator.Operands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class CalculatorFrame {
    private String firstNumber = "0";
    private String secondNumber = "0";
    private Operands currentlySelectedOperand = null;
    private final JLabel outputLabel;
    private final Calculate calc;

    public CalculatorFrame(){
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,50,10,50));
        mainPanel.setLayout(new GridLayout(2,1));
        calc = new Calculate();

        outputLabel = new JLabel();
        outputLabel.setBorder(BorderFactory.createEtchedBorder());
        mainPanel.add(outputLabel);

        NumberButton zero = new NumberButton(0);
        NumberButton one = new NumberButton(1);
        NumberButton two = new NumberButton(2);
        NumberButton three = new NumberButton(3);
        NumberButton[] numberButtons = {zero,one,two,three};


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,4));

        for(NumberButton button : numberButtons){
            button.addActionListener(e -> appendToOutputLabel(button.getValue()));
            buttonPanel.add(button);
        }

        OperandButton addButton = new OperandButton(Operands.ADD, "+");
        OperandButton subtractButton = new OperandButton(Operands.SUBTRACT, "-");
        OperandButton multiplyButton = new OperandButton(Operands.MULTIPLY, "*");
        OperandButton divideButton = new OperandButton(Operands.DIVIDE, "/");

        OperandButton[] operandButtons = {addButton, subtractButton, multiplyButton, divideButton};


        for( OperandButton button : operandButtons){
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
        clearButton.addActionListener((e) -> { this.clearCalculator();  // Method to clear the state and reset
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

    private void performEquals(String command) {
        storeOutput();
        String result = String.valueOf((1+2));
        System.out.println(command);
        //above, put the connection to calculator, sending firstNumber, currentOperand, and  secondNumber
        if (Objects.equals(command, "x²")) {
            currentlySelectedOperand = Operands.SQUARE;
        }
        else if (Objects.equals(command, "√")) {
            currentlySelectedOperand = Operands.SQUAREROOT;
        }
        System.out.println("FIRSTNUMBER " + firstNumber);
        System.out.println("SECONDNUMBER " + secondNumber);
        System.out.println("OPERAND " + currentlySelectedOperand);
        calc.calculation(firstNumber, secondNumber, currentlySelectedOperand, outputLabel);
        //System.out.println(calculation);

        currentlySelectedOperand = null;
        firstNumber = result;
        secondNumber = "0";
    }


    private void storeOutput() {
        if(currentlySelectedOperand != null){
            secondNumber = outputLabel.getText();
        }
        else{
            firstNumber = outputLabel.getText();
            secondNumber = "0";
        }
        //Clear the output label?
        outputLabel.setText("");


    }

    private void appendToOutputLabel(int numberAppended){
        String currentText = outputLabel.getText();
        outputLabel.setText(currentText + numberAppended);
    }

    private void clearCalculator() {
        this.firstNumber = "0";
        this.secondNumber = "0";
        this.currentlySelectedOperand = null;
        this.outputLabel.setText("");
    }
}