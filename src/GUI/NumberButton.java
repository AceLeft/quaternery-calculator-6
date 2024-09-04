package GUI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends JButton implements ActionListener {
    private final int value;
    private final JLabel numberLabel;

    public NumberButton(int value, JLabel numberLabel){
        super(value + "");
        this.value = value;
        this.numberLabel = numberLabel;
        addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String currentText = numberLabel.getText();
        numberLabel.setText(currentText + value);
    }
}
