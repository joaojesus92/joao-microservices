package br.com.joao;

import br.com.joao.exception.UnsupportedMathOperationException;
import br.com.joao.utils.UtilsCalculatorOperations;
import br.com.joao.utils.UtilsConvert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

  private final UtilsCalculatorOperations calculatorOperations = new UtilsCalculatorOperations();

  @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
  public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
    if (!UtilsConvert.isNumeric(numberOne) || !UtilsConvert.isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }
    return calculatorOperations.sum(UtilsConvert.convertToDouble(numberOne), UtilsConvert.convertToDouble(numberTwo));
  }

  @GetMapping(value = "/sub/{numberOne}/{numberTwo}")
  public Double subtract(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
    if (!UtilsConvert.isNumeric(numberOne) || !UtilsConvert.isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }
    return calculatorOperations.subtraction(UtilsConvert.convertToDouble(numberOne), UtilsConvert.convertToDouble(numberTwo));
  }

  @GetMapping(value = "/mult/{numberOne}/{numberTwo}")
  public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
    if (!UtilsConvert.isNumeric(numberOne) || !UtilsConvert.isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }
    return calculatorOperations.multiplication(UtilsConvert.convertToDouble(numberOne), UtilsConvert.convertToDouble(numberTwo));
  }

  @GetMapping(value = "/div/{numberOne}/{numberTwo}")
  public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
    if (!UtilsConvert.isNumeric(numberOne) || !UtilsConvert.isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }
    return calculatorOperations.division(UtilsConvert.convertToDouble(numberOne), UtilsConvert.convertToDouble(numberTwo));
  }

  @GetMapping(value = "/avg/{numberOne}/{numberTwo}")
  public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
    if (!UtilsConvert.isNumeric(numberOne) || !UtilsConvert.isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }

    return calculatorOperations.average(UtilsConvert.convertToDouble(numberOne), UtilsConvert.convertToDouble(numberTwo));
  }

  @GetMapping(value = "/squareRoot/{number}")
  public Double squareRoot(@PathVariable("number") String number) {
    if (!UtilsConvert.isNumeric(number)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }

    return calculatorOperations.squareRoot(UtilsConvert.convertToDouble(number));
  }
}
