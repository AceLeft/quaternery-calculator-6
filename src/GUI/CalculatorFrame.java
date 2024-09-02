package GUI;

import Calculator.GUITest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame {
    public CalculatorFrame(){
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        mainPanel.setLayout(new GridLayout(1,4));

        NumberButton zero = new NumberButton(0);
        NumberButton one = new NumberButton(1);
        NumberButton two = new NumberButton(2);
        NumberButton three = new NumberButton(3);

        mainPanel.add(zero);
        mainPanel.add(one);
        mainPanel.add(two);
        mainPanel.add(three);

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            /*While these _can_ be replaced with Lambda,
              I'm going to forgoe that until we figure out how
              we get the number AFTER add is pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                GUITest.print("add");
            }
        });
        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUITest.print("sub");
            }
        });
        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUITest.print("times");
            }
        });
        JButton divideButton = new JButton("/");
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUITest.print("div");
            }
        });
        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUITest.print("equals");
            }
        });

        mainPanel.add(addButton);
        mainPanel.add(subtractButton);
        mainPanel.add(divideButton);
        mainPanel.add(multiplyButton);
        mainPanel.add(equalsButton);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quaternary Calculator");
        frame.pack();
        frame.setVisible(true);
    }
}
