package ru.vsu.kudinov.console;

import ru.vsu.kudinov.common.Calculator;
import java.util.Scanner;

public class ConsoleMain
{
    public static void main(String[] args)
    {
        String expression = readExpression();
        String answer = new Calculator().calculateExpression(expression);
        System.out.println(answer);
    }

    private static String readExpression()
    {
        System.out.print("Input an expression: ");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

}

