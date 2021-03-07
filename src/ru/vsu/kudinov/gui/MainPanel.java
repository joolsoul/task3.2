package ru.vsu.kudinov.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainPanel extends JPanel
{
    private JButton numbers[] = new JButton[10];
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton multiply = new JButton("*");
    private JButton divide = new JButton("/");
    private JButton oParenthesis = new JButton("(");
    private JButton cParenthesis = new JButton(")");
    private JButton clear = new JButton("C");
    private JButton calculate = new JButton("=");
    private JTextField textField = new JTextField();
    private Font font = new Font("SanSerif", Font.BOLD, 20);

    public MainPanel()
    {
        setLayout(null);
        setFocusable(true);
        grabFocus();

        textField.setBounds(10, 10, 230, 50);
        textField.setFont(font);
        add(textField);

        addButton(plus, 190, 70, 50, Color.PINK.darker());
        addButton(minus, 190, 130, 50, Color.PINK.darker());
        addButton(multiply,190, 190, 50, Color.PINK.darker());
        addButton(divide, 190, 250, 50, Color.PINK.darker());
        addButton(oParenthesis, 10, 250, 50,  Color.PINK);
        addButton(cParenthesis, 130, 250, 50,  Color.PINK);
        addButton(clear, 10, 310, 110, Color.GRAY.darker());
        addButton(calculate, 130, 310, 110, Color.CYAN.darker());


        numbers[0] = new JButton("0");
        numbers[0].setBounds(70, 250, 50, 50);
        numbers[0].setFont(font);
        numbers[0].setBackground(Color.LIGHT_GRAY);
        numbers[0].addActionListener(new ButtonListener(textField, numbers[0]));
        add(numbers[0]);

        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                numbers[x * 3 + y + 1] = new JButton((x * 3 + y + 1) + "");
                numbers[x * 3 + y + 1].setBounds(x * 60 + 10, y * 60 + 70, 50, 50);
                numbers[x * 3 + y + 1].setFont(font);
                numbers[x * 3 + y + 1].setBackground(Color.LIGHT_GRAY);
                numbers[x * 3 + y + 1].addActionListener(new ButtonListener(textField, numbers[x * 3 + y + 1]));
                add(numbers[x * 3 + y + 1]);
            }
        }

        addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                char symbol = e.getKeyChar();

                if(!Character.isDigit(symbol))
                    return;

                textField.setText(textField.getText() + symbol);
            }
        });
    }

    private void addButton(JButton button, int x, int y, int width, Color color)
    {
        if(button != calculate && button != clear)
        {
            button.setBounds(x, y, width, 50);
            button.setFont(font);
            button.setBackground(color);
            button.addActionListener(new ButtonListener(textField, button));
            add(button);
        }

        if(button == clear)
        {
            button.setBounds(x, y, width, 50);
            button.setFont(font);
            button.setBackground(color);
            button.addActionListener(new ClearButtonListener(textField));
            add(button);
        }

        if(button == calculate)
        {
            button.setBounds(x, y, width, 50);
            button.setFont(font);
            button.setBackground(color);
            button.addActionListener(new CalculateButtonListener(textField));
            add(button);
        }
    }
}
