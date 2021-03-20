package org.jacoco.examples.maven.java;

import java.util.Stack;

import static org.jacoco.examples.maven.java.CalculatorPostFixExpression.getPriority;

public class InfixToPostfix {

    public static String infixToPostfix(String expression){
        String currentexpression = "";
        Stack<Character> stack = new Stack<>();
        int priority;

        for(int i = 0; i < expression.length(); i++){
            priority = getPriority(expression.charAt(i));
            if(priority == 0) currentexpression += expression.charAt(i);
            if(priority == 1) stack.push(expression.charAt(i));

            if(priority > 1){
                currentexpression += ' ';
                while(!stack.empty()){
                    if(getPriority(stack.peek()) >= priority) currentexpression += stack.pop();
                    else break;
                }
                stack.push(expression.charAt(i));
            }
            if(priority == -1){
                currentexpression += ' ';
                while (getPriority(stack.peek()) != 1) currentexpression +=stack.pop();
                stack.pop();
            }
        }
        while (!stack.empty()) currentexpression += stack.pop();
        return currentexpression;
    }
}
