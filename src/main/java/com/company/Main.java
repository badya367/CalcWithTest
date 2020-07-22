package com.company;

import java.math.BigDecimal;

import java.util.Scanner;

/**
 * Класс Main
 * В классе реализация консольного калькулятора
 * ЭТО НЕ ОБРАЗЦОВЫЙ КАЛЬКУЛЯТОР!!!
 * Он умеет: складывать, вычитать, умножать, делить (читать п. "в нём нет")
 * В нём нет: исключения, если результат выходит за диапозон значений int
 *            правильной реализации деления с остатком
 * Цель: изучение фреймворка TestNG, покрытие операций позитивными и негативными тестами
 * @author Badikov Dmitriy
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BigDecimal num1 = getInt();
        char operation = getOperation();
        BigDecimal num2 = getInt();
        String result = calc(num1, num2, operation);
        System.out.println("Результат: " + result);

    }

    public static BigDecimal getInt() {
        System.out.println("Введите число");
        BigDecimal maxValue = BigDecimal.valueOf(Integer.MAX_VALUE);
        BigDecimal minValue = BigDecimal.valueOf(Integer.MIN_VALUE);

        BigDecimal number;

        if (scanner.hasNextBigDecimal()) {
            number = scanner.nextBigDecimal();
        }
        else {
            System.out.println("Допущена ошибка при вводе числа. Попробуйте ещё раз");
            scanner.next();
            return getInt();
        }
        if (number.compareTo(maxValue)<=0 && number.compareTo(minValue)>=0) {
            return number;
        }
        else {
            System.out.println("число больше максимального значения");
            return getInt();
        }
    }

    public static char getOperation() {
        System.out.println("Введите операцию: ");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Допущена ошибка при вводе операции. Попробуйте ещё раз");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static String calc(BigDecimal num1, BigDecimal num2, char operation) {


        switch (operation) {
            case '+':
                return num1.add(num2).toString();
            case '-':
                return num1.subtract(num2).toString();
            case '*':
                return num1.multiply(num2).toString();
            case '/':
                return BigDecimal.valueOf(num1.doubleValue()/num2.doubleValue()).toString();
            default:
                System.out.println("Неизвестная операция. Попробуйте снова ('+', '-', '*', '/')");
                return calc(num1, num2, getOperation());
        }

    }
}

