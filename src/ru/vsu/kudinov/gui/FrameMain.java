package ru.vsu.kudinov.gui;

import javax.swing.*;

public class FrameMain
{
    private JFrame frame;

    public FrameMain()
    {
        frame = new JFrame("Calculator");
        frame.setSize(255, 400);
        frame.add(new MainPanel());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
