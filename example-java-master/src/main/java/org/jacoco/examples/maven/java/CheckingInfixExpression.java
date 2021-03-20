package org.jacoco.examples.maven.java;

import org.jacoco.examples.maven.java.MyExceptions.IncorrectExpressionException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckingInfixExpression {

    public static void checking(String expression) throws IncorrectExpressionException{
        String regex1 = "[^0-9-+\\()\\/*]";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(expression);
        if(matcher1.find()) throw new IncorrectExpressionException("Expression contains invalid characters");
        String regex2 = "[*+-\\/]{2}";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(expression);
        if(matcher2.find()) throw new IncorrectExpressionException("Expression contains repetition of operators");

        if(expression.equals("")) throw new IncorrectExpressionException("String is null");
    }


}
