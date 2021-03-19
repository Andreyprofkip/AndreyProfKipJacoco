package org.javacalculator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;


public class AppTest {

    @RunWith(Parameterized.class)
    public static class ParameterizeSumTest {


        private final double valueA;
        private final double valueB;
        private final double expected;
        private String expression;
        private double answer = 0;


        public ParameterizeSumTest(double valueA, double valueB, double expected) {
            this.valueA = valueA;
            this.valueB = valueB;
            this.expected = expected;
        }

        @Parameterized.Parameters(name = "{index}:sumOf({0}+{1})={2}")
        public static Iterable<Object[]> dataForTest() {
            return Arrays.asList(new Object[][]{
                    {1, 1, 2},
                    {2, 6, 8},
                    {18, 2, 20},
                    {13, 15, 28},
                    {1, 5, 6}
            });
        }

        @Test
        public void paramSumTest() {
            expression = valueA + "+" + valueB;
            String postfixExpression = InfixToPostfix.infixToPostfix(TransformatorWithNegativeNumbersInfixExpression.preparingExpression(expression));
            answer = CalculatorPostFixExpression.PostfixToAnswer(postfixExpression);

            assertThat(expected, equalTo(answer));
        }
    }

    @RunWith(Parameterized.class)
    public static class ParameterizeSubTest {

        private final double valueA;
        private final double valueB;
        private final double expected;
        private String expression;
        private double answer = 0;

        public ParameterizeSubTest(double valueA, double valueB, double expected) {
            this.valueA = valueA;
            this.valueB = valueB;
            this.expected = expected;
        }

        @Parameterized.Parameters(name = "{index}:subOf({0}-{1})={2}")
        public static Iterable<Object[]> dataForTest1() {
            return Arrays.asList(new Object[][]{
                    {1, 1, 0},
                    {2, 6, -4},
                    {18, 2, 16},
                    {13, 15, -2},
                    {1, 5, -4}
            });
        }

        @Test
        public void paramSubTest() {
            expression = valueA + "-" + valueB;
            String postfixExpression = InfixToPostfix.infixToPostfix(TransformatorWithNegativeNumbersInfixExpression.preparingExpression(expression));
            answer = CalculatorPostFixExpression.PostfixToAnswer(postfixExpression);

            assertThat(expected, equalTo(answer));
        }
    }

    @RunWith(Parameterized.class)
    public static class ParameterizeMulTest {

        private final double valueA;
        private final double valueB;
        private final double expected;
        private String expression;
        private double answer = 0;

        public ParameterizeMulTest(double valueA, double valueB, double expected) {
            this.valueA = valueA;
            this.valueB = valueB;
            this.expected = expected;
        }

        @Parameterized.Parameters(name = "{index}:Mul({0}*{1})={2}")
        public static Iterable<Object[]> dataForTest2() {
            return Arrays.asList(new Object[][]{
                    {1, 1, 1},
                    {2, 6, 12},
                    {18, 2, 36},
                    {13, 15, 195},
                    {1, 5, 5}
            });
        }

        @Test
        public void paramMulTest() {
            expression = valueA + "*" + valueB;
            String postfixExpression = InfixToPostfix.infixToPostfix(TransformatorWithNegativeNumbersInfixExpression.preparingExpression(expression));
            answer = CalculatorPostFixExpression.PostfixToAnswer(postfixExpression);

            assertThat(expected, equalTo(answer));
        }
    }

    @RunWith(Parameterized.class)
    public static class ParameterizeDivTest {

        private final double valueA;
        private final double valueB;
        private final double expected;
        private String expression;
        private double answer = 0;

        public ParameterizeDivTest(double valueA, double valueB, double expected) {
            this.valueA = valueA;
            this.valueB = valueB;
            this.expected = expected;
        }

        @Parameterized.Parameters(name = "{index}:Div({0}/{1})={2}")
        public static Iterable<Object[]> dataForTest3() {
            return Arrays.asList(new Object[][]{
                    {1, 1, 1},
                    {3, 6, 0.5},
                    {18, 2, 9},
                    {130, 2, 65},
                    {1500000, 5, 300000}
            });
        }

        @Test
        public void paramDivTest() {
            expression = valueA + "/" + valueB;
            String postfixExpression = InfixToPostfix.infixToPostfix(TransformatorWithNegativeNumbersInfixExpression.preparingExpression(expression));
            answer = CalculatorPostFixExpression.PostfixToAnswer(postfixExpression);

            assertThat(expected, equalTo(answer));
        }
    }
}

