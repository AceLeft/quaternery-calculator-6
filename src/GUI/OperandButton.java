package GUI;

import Calculator.Operands;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperandButton extends JButton implements ActionListener {
    private final Operands operand;
    private final String label;

    public OperandButton(Operands operand, String label){
        super(label);
        this.operand = operand;
        this.label = label;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("here i should send the temp stored firstNumber to Storage class");
        System.out.println("And other things too.");
    }
}
