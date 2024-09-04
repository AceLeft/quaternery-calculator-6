package GUI;


import Calculator.Operands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame {
    private String firstNumber = "0";
    private String secondNumber = "0";
    private final JLabel outputLabel;

    public CalculatorFrame(){
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        mainPanel.setLayout(new GridLayout(1,4));

        outputLabel = new JLabel();
        outputLabel.setBorder(BorderFactory.createEtchedBorder());
        mainPanel.add(outputLabel);

        NumberButton zero = new NumberButton(0);
        NumberButton one = new NumberButton(1);
        NumberButton two = new NumberButton(2);
        NumberButton three = new NumberButton(3);
        NumberButton[] numberButtons = {zero,one,two,three};

        for( NumberButton button : numberButtons){
            button.addActionListener(e -> appendToOutputLabel(button.getValue()));
            mainPanel.add(button);
        }

        OperandButton addButton = new OperandButton(Operands.ADD, "+");

        mainPanel.add(addButton);
//        mainPanel.add(subtractButton);
//        mainPanel.add(divideButton);
//        mainPanel.add(multiplyButton);
//        mainPanel.add(equalsButton);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quaternary Calculator");
        frame.pack();
        frame.setVisible(true);
    }

    private void appendToOutputLabel(int numberAppended){
        String currentText = outputLabel.getText();
        outputLabel.setText(currentText + numberAppended);
    }
}
