package GUI;


import javax.swing.*;


public class NumberButton extends JButton {
    private final int value;

    public NumberButton(int value){
        super(value + "");
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}