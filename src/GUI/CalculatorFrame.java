package GUI;

import Calculator.GUITest;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CalculatorFrame {

    private String op = "";
    private String firstNumber = "";
    private String secondNumber = "";
    public CalculatorFrame(){
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        JTextField textField = new JTextField(16);
        JButton[] numberButtons = new JButton[9];

        JButton zero = new JButton(String.valueOf(0));
        JButton one = new JButton(String.valueOf(1));
        JButton two = new JButton(String.valueOf(2));
        JButton three = new JButton(String.valueOf(3));

        mainPanel.add(textField);

        mainPanel.add(zero);
        mainPanel.add(one);
        mainPanel.add(two);
        mainPanel.add(three);

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton equalsButton = new JButton("=");

        mainPanel.add(addButton);
        mainPanel.add(subtractButton);
        mainPanel.add(divideButton);
        mainPanel.add(multiplyButton);
        mainPanel.add(equalsButton);

        numberButtons[0] = zero;
        numberButtons[1] = one;
        numberButtons[2] = two;
        numberButtons[3] = three;

        numberButtons[4] = addButton;
        numberButtons[5] = subtractButton;
        numberButtons[6] = multiplyButton;
        numberButtons[7] = divideButton;
        numberButtons[8] = equalsButton;


        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String command = e.getActionCommand();

                    if (Objects.equals(command, "0") || Objects.equals(command, "1") || Objects.equals(command, "2") || Objects.equals(command, "3")) {

                        if (op.isEmpty()) {
                            secondNumber = textField.getText() + command;
                            textField.setText(secondNumber); //gets second # input

                        }
                        else {
                            firstNumber = textField.getText() + command;
                            textField.setText(firstNumber); //gets first # input
                        }

                        System.out.println("First Number: " + firstNumber);
                        System.out.println("Second Number: " + secondNumber);

                    }
                    else  {
                        if (command != "=") {
                            op = command;
                            System.out.println(op);
                            textField.setText("");
                        }
                    }

                    if (command == "=") {
                        System.out.println(op);
                        Calculate(firstNumber ,secondNumber, op);
                    }
                }});
        }

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quaternary Calculator");
        frame.pack();
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    public void Calculate(String val1, String val2, String operator) {

        if (Objects.equals(operator, "+")) {
            int intVal1 = Integer.parseInt(val1);
            int intVal2 = Integer.parseInt(val2);
            System.out.println("Sum: " + (intVal1 + intVal2));
        }
        else {
            System.out.println("WRONG");
            System.out.println(val1);
            System.out.println(val2);
            System.out.println(operator);
        }
    }
}
