package demo.calculator.api;

import demo.calculator.exception.OperationException;

public interface CalculatorService {
    double calculate(String operation, double number1, double number2) throws OperationException;
}
