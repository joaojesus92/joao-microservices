package br.com.joao.utils;

import java.util.List;

public class UtilsCalculatorOperations extends UtilsCalculator {

  @Override
  public double sum(double numberOne, double numberTwo) {
    return numberOne + numberTwo;
  }

  @Override
  public double subtraction(double numberOne, double numberTwo) {
    return numberOne - numberTwo;
  }

  @Override
  public double multiplication(double numberOne, double numberTwo) {
    return numberOne * numberTwo;
  }

  @Override
  public double division(double numberOne, double numberTwo) {
    return numberOne / numberTwo;
  }

  @Override
  public double average(double numberOne, double numberTwo) {
    return sum(numberOne, numberTwo) / qtdNumbers(numberOne, numberTwo);
  }

  @Override
  public double squareRoot(double number) {
    return Math.sqrt(number);
  }

  @Override
  public int qtdNumbers(double numberOne, double numberTwo) {
    return List.of(numberOne, numberTwo).size();
  }
}
