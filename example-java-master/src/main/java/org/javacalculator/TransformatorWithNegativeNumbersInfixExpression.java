package org.javacalculator;

public class TransformatorWithNegativeNumbersInfixExpression {
    public static String preparingExpression(String expression) {
        String preparedExpression = new String();
        for(int token = 0; token < expression.length(); token ++ ){
            char symbol = expression.charAt(token);
            if(symbol == '-'){
                if(token == 0)
                    preparedExpression += 0;
                else if(expression.charAt(token-1) == '(')
                    preparedExpression += '0';
            }
            preparedExpression += symbol;
        }
        return preparedExpression;
    }
}
