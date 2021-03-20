package org.jacoco.examples.maven.java;

import org.jacoco.examples.maven.java.MyExceptions.IncorrectExpressionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Nested
@DisplayName("Should to throw")
public class CheckingInfixExpressionTest {


    @ParameterizedTest
    @ValueSource(strings = { "H", ","," ", "@", "&", "!",".","%" })
    void checkingIncorrectSymbols(String expression) {
        Assertions.assertThrows(IncorrectExpressionException.class, () ->
                CheckingInfixExpression.checking(expression));
    }
}

