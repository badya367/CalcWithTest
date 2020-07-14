package com.company;

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
        int num1 = getInt();
        char operation = getOperation();
        int num2 = getInt();
        int result = calc(num1, num2, operation);
        System.out.println("Результат: " + result);

    }

    public static int getInt() {
        System.out.println("Введите число");
        int number;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
        } else {
            System.out.println("Допущена ошибка при вводе числа. Попробуйте ещё раз");
            scanner.next();
            number = getInt();
        }
        return number;
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

    public static int calc(int num1, int num2, char operation) {
        int result;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Неизвестная операция. Попробуйте снова ('+', '-', '*', '/')");
                result = calc(num1, num2, getOperation());
        }

        return result;

    }
}

