package ru.vsu.kudinov.common;

import java.util.Stack;

public class Calculator
{
    public String calculateExpression(String expression)
    {
        try
        {
            String preparedExpression = prepareExpression(expression);
            String RPN = convertExpressionToRPN(preparedExpression);
            Double answer = convertRPNToAnswer(RPN);
            return answer.toString();
        }
        catch (NumberFormatException e)
        {
            return "Expression is not correct. Please try again";
        }
    }

    private String prepareExpression(String expression)
    {
        StringBuilder preparedExpression = new StringBuilder();

        for (int i = 0; i < expression.length(); i++)
        {
            char symbol = expression.charAt(i);

            if (symbol == '-')
            {
                if (i == 0)
                {
                    preparedExpression.append('0');
                }

                else if (expression.charAt(i - 1) == '(')
                {
                    preparedExpression.append('0');
                }
            }
            preparedExpression.append(symbol);
        }
        return preparedExpression.toString();
    }


    private String convertExpressionToRPN(String expression) throws NumberFormatException
    {
        StringBuilder currentExpression = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++)
        {
            int priority = getPriority(expression.charAt(i));

            if (priority == 0)
            {
                currentExpression.append(expression.charAt(i));
            }

            if (priority == 1)
            {
                stack.push(expression.charAt(i));
            }

            if (priority > 1)
            {
                currentExpression.append(' ');

                while (!stack.empty())
                {
                    if (getPriority(stack.peek()) >= priority)
                    {
                        currentExpression.append(stack.pop());
                    }
                    else break;
                }
                stack.push(expression.charAt(i));
            }

            if (priority == -1)
            {
                currentExpression.append(' ');

                while (getPriority(stack.peek()) != 1)
                {
                    currentExpression.append(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.empty())
        {
            currentExpression.append(stack.pop());
        }
        return currentExpression.toString();
    }

    private double convertRPNToAnswer(String RPN)
    {
        StringBuilder operand = new StringBuilder();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < RPN.length(); i++)
        {
            if (RPN.charAt(i) == ' ')
                continue;

            if (getPriority(RPN.charAt(i)) == 0)
            {
                while (RPN.charAt(i) != ' ' && getPriority(RPN.charAt(i)) == 0)
                {
                    operand.append(RPN.charAt(i++));

                    if (i == RPN.length())
                        break;
                }
                stack.push(Double.parseDouble(operand.toString()));
                operand = new StringBuilder();
            }

            if (getPriority(RPN.charAt(i)) > 1)
            {
                double firstNumber = stack.pop();
                double secondNumber = stack.pop();

                if (RPN.charAt(i) == '+')
                {
                    stack.push(secondNumber + firstNumber);
                }

                if (RPN.charAt(i) == '-')
                {
                    stack.push(secondNumber - firstNumber);
                }

                if (RPN.charAt(i) == '*')
                {
                    stack.push(secondNumber * firstNumber);
                }

                if (RPN.charAt(i) == '/')
                {
                    stack.push(secondNumber / firstNumber);
                }
            }
        }
        return stack.pop();
    }

    private int getPriority(char token)
    {
        int priority = 0;

        switch (token)
        {
            case '*':
            case '/':
                priority = 3;
                break;

            case '+':
            case '-':
                priority = 2;
                break;

            case '(':
                priority = 1;
                break;

            case ')':
                priority = -1;
                break;
        }
        return priority;
    }
}