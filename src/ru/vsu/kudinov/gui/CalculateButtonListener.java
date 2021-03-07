package ru.vsu.kudinov.gui;

import ru.vsu.kudinov.common.Calculator;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateButtonListener implements ActionListener
{
    private JTextField textField;

    public CalculateButtonListener(JTextField textField)
    {
        this.textField = textField;

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String expression = textField.getText();
        String answer = new Calculator().calculateExpression(expression);
        textField.setText(answer);
    }
}
