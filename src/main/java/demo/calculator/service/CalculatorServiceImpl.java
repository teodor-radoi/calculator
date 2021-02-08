package demo.calculator.service;

import demo.calculator.api.CalculatorService;
import demo.calculator.exception.OperationException;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double calculate(String operation, double number1, double number2) throws OperationException {
        switch (operation) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case ":":
                if (number2 != 0) {
                    return number1 / number2;
                } else {
                    throw new OperationException("Cannot divide by 0");
                }
            default:
                throw new OperationException(format("Operation %s not supported", operation));
        }
    }
}
