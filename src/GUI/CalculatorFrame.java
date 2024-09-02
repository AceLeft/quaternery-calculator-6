package GUI;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame {
    public CalculatorFrame(){
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        mainPanel.setLayout(new GridLayout());

        NumberButton zero = new NumberButton(0);
        NumberButton one = new NumberButton(1);
        NumberButton two = new NumberButton(2);
        NumberButton three = new NumberButton(3);

        mainPanel.add(zero);
        mainPanel.add(one);
        mainPanel.add(two);
        mainPanel.add(three);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quaternary Calculator");
        frame.pack();
        frame.setVisible(true);
    }
}
