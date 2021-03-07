package ru.vsu.kudinov.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonListener implements ActionListener
{
    private JTextField textField;

    public ClearButtonListener(JTextField textField)
    {
        this.textField = textField;

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        textField.setText(null);
    }
}
