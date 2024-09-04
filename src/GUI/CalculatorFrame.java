package GUI;


import Calculator.Operands;

import javax.swing.*;
import java.awt.*;


public class CalculatorFrame {
    private String firstNumber = "0";
    private String secondNumber = "0";
    private Operands currentlySelectedOperand = null;
    private final JLabel outputLabel;

    public CalculatorFrame(){
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,50,10,50));
        mainPanel.setLayout(new GridLayout(2,1));

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

        for( NumberButton button : numberButtons){
            button.addActionListener(e -> appendToOutputLabel(button.getValue()));
            buttonPanel.add(button);
        }

        OperandButton addButton = new OperandButton(Operands.ADD, "+");

        OperandButton[] operandButtons = {addButton};

        for( OperandButton button : operandButtons){
            button.addActionListener(e -> {
                storeOutput();
                currentlySelectedOperand = button.getOperand();
            });
            buttonPanel.add(button);
        }

        JButton equals = new JButton("=");
        equals.addActionListener(e -> performEquals());

        buttonPanel.add(equals);

        mainPanel.add(buttonPanel);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quaternary Calculator");
        frame.pack();
        frame.setVisible(true);
    }

    private void performEquals() {
        storeOutput();
        String result = String.valueOf((1+2));
        //above, put the connection to calculator, sending firstNumber, currentOperand, and  secondNumber
        System.out.println("FIRSTNUMBER" + firstNumber);
        System.out.println("SECONDNUMBER" + secondNumber);
        System.out.println("OPERAND" + currentlySelectedOperand);
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
}
