package com.company;
import java.util.Scanner;

/**
 * Класс Main
 * Точка запуска калькулятора
 *
 * Он умеет: складывать, вычитать, умножать, делить
 *
 * Цель: изучение фреймворка TestNG, покрытие операций позитивными и негативными тестами
 * @author Badikov Dmitriy
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("Калькулятор");
        System.out.println("--------------------------------");
        System.out.println("Я умею: складывать, вычитать \n " +
                           "        умножать, делить \n" +
                "Но у меня есть ограничение. \n" +
                "Не пытайтесь вводить числа \n" +
                ">2147483647 и <(-2147483648)\n" +
                "Для того, чтобы выполнить операцию \n" +
                "просто используйте символы с клавиатуры \n" +
                "'+', '-', '*', '/");


        while (true) {
            System.out.println("Введите первое число:");
            String arg1 = scanner.next();
            System.out.println("Введите операцию:");
            char operation = scanner.next().charAt(0);
            System.out.println("Введите второе число:");
            String arg2 = scanner.next();
            String result = Calc.start(arg1, arg2, operation);
            System.out.println("результат: " + result);
            System.out.println("Хотите продолжить y/n");
            String yesNo = scanner.next();
            if (yesNo.equals("y")) {
                continue;
            } else {
                break;
            }
        }

        System.out.println("До свидания!");
    }
}

