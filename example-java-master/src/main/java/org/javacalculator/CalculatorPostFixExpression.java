package org.javacalculator;

import java.util.Stack;

public class CalculatorPostFixExpression {
    public static double PostfixToAnswer(String postFixExpression){
        String operand = new String();
        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < postFixExpression.length(); i++){
            if(postFixExpression.charAt(i) == ' ') continue;

            if(getPriority(postFixExpression.charAt(i)) == 0 ) {
                while (postFixExpression.charAt(i) != ' ' && getPriority(postFixExpression.charAt(i)) == 0) {
                    operand += postFixExpression.charAt(i++);
                    if (i == postFixExpression.length()) break;
                }
                stack.push(Double.parseDouble(operand));
                operand  = new String();
            }

            if(getPriority(postFixExpression.charAt(i)) > 1){
                double a = stack.pop(), b = stack.pop();
                if(postFixExpression.charAt(i) == '+')stack.push(b+a);
                if(postFixExpression.charAt(i) == '-')stack.push(b-a);
                if(postFixExpression.charAt(i) == '*')stack.push(b*a);
                if(postFixExpression.charAt(i) == '/')stack.push(b/a);

            }
        }
        return stack.pop();
    }
    public static int getPriority(char charFromExpression){
        if(charFromExpression == '*' || charFromExpression == '/') return 3;
        else if(charFromExpression == '+' || charFromExpression == '-') return 2;
        else if(charFromExpression == '(') return 1;
        else if(charFromExpression == ')') return -1;
        else return 0;
    }
}
