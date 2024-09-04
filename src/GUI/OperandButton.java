package GUI;

import Calculator.Operands;

import javax.swing.*;


public class OperandButton extends JButton {
    private final Operands operand;

    public OperandButton(Operands operand, String label){
        super(label);
        this.operand = operand;
    }

    public Operands getOperand() {
        return operand;
    }
}
