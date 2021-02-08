package demo.calculator.rest;

import demo.calculator.api.CalculatorService;
import demo.calculator.dto.ResultDTO;
import demo.calculator.exception.OperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/api/operation/{operation}/{number1}/{number2}")
    public ResponseEntity<ResultDTO> performOperation(@PathVariable("operation") String operation,
                                                      @PathVariable double number1,
                                                      @PathVariable double number2) throws OperationException {
        return new ResponseEntity<>(new ResultDTO(calculatorService.calculate(operation, number1, number2)), OK);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(OperationException.class)
    public String handleOperationException(OperationException e) {
        return e.getMessage();
    }
}
