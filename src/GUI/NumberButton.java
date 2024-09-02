package GUI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends JButton implements ActionListener {
    private final int value;


    public NumberButton(int value){
        super(value + "");
        this.value = value;
        addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed " + value);
        //send to the CalulatorFrame that this value was pressed
    }
}
