package com.company;

import java.math.BigDecimal;

/**
 * Класс Calc
 * Реализация калькулятора
 * @author Badikov Dmitriy
 */

public class Calc {
    private static final BigDecimal maxValue = BigDecimal.valueOf(Integer.MAX_VALUE);
    private static final BigDecimal minValue = BigDecimal.valueOf(Integer.MIN_VALUE);

    public static String start(String arg1, String arg2, Character operation) {
        boolean isValid = validate(arg1) && validate(arg2) && validateOperation(operation);
        if (!isValid) {
            System.out.println("что то пошло не так");
            if (!validateOperation(operation)) {
                System.out.println("нет такой операции");
            }
            if (!validate(arg1)) {
                System.out.println("некорректное первое число");
            }
            if (!validate(arg2)) {
                System.out.println("некорректное второе число");
            }
            return "";
        }
        BigDecimal result = null;
        switch (operation){
            case '+' : result = new BigDecimal(arg1).add(new BigDecimal(arg2));
                break;
            case '-' : result = new BigDecimal(arg1).subtract(new BigDecimal(arg2));
                break;
            case '/' : result = BigDecimal.valueOf(Double.parseDouble(arg1)/Double.parseDouble(arg2));
                break;
            case '*' : result = new BigDecimal(arg1).multiply(new BigDecimal(arg2));
                break;
        }
        if (result!=null){
            return result.toString();
        }
        return "SYSTEM ERROR 404";
    }

    public static boolean validateOperation(Character character) {
        switch (character) {
            case '+':
            case '*':
            case '/':
            case '-':
                return true;
            default:
                return false;
        }
    }

    public static boolean validate(String argument) {

        try {
            BigDecimal value = new BigDecimal(argument);
            if (value.compareTo(maxValue) <= 0 && value.compareTo(minValue) >= 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex){
            System.out.println(ex);
            return false;
        }

    }
}