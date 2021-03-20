package org.jacoco.examples.maven.java.MyExceptions;

public class IncorrectExpressionException extends Exception{
    public IncorrectExpressionException(String message){
        super(message);
    }
}
