package ru.vsu.kudinov.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener
{
    private JTextField textField;
    private JButton button;

    public ButtonListener(JTextField textField, JButton button)
    {
        this.textField = textField;
        this.button = button;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        textField.setText(textField.getText() + button.getText());
    }
}
