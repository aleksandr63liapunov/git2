import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;
import java.lang.NumberFormatException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.ArithmeticException;
import java.util.Scanner;

public class RomArab {

    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main(String[] args) {
        System.out.println("Введите выражение ");
        String userInput = scanner.nextLine();
        char[] under_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);


            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }

        }
        String under_charString = String.valueOf(under_char);
        String[] symbols = under_charString.split("[+-/*]");


        String symbol1 = symbols[0];
        String symbol2 = symbols[1];


        String string1 = symbol1.trim();
        String string2 = symbol2.trim();
        number1 = romanToNumber(string1);
        number2 = romanToNumber(string2);


        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {


            try {
                result = calculated(number1, number2, operation);
                String resultRoman = convertNumToRoman(result);
                System.out.println(resultRoman);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("exeptoin" + e);
                System.out.println("в римской системе нет отриц чисел");
            }

        }
        try {
            number1 = Integer.parseInt(string1);
            number2 = Integer.parseInt(string2);
            result = calculated(number1, number2, operation);
            System.out.println(result);
        } catch (NumberFormatException e) {

        }
    }

    private static String convertNumToRoman(int numArabian) {


        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        return roman[numArabian];

    }

    private static int romanToNumber(String roman) {
        try {
            if (roman.equals("0")) {
                return 0;
            } else if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");

        }
        return -1;
    }

    public static int calculated(int num1, int num2, char op) {


        if (0 <= num1 && num1 <= 10 && 0 <= num2 && num2 <= 10) {
            int result = 0;
            switch (op) {
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
                    try {
                        result = num1 / num2;
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Exception : " + e);
                        System.out.println("ДЕЛИТЬ НА НОЛЬ НЕЛЬЗЯ");
                        break;
                    }
                    break;


                default:

                    throw new IllegalArgumentException("Не верный знак операции");

            }
            return result;
        }
        return result;
    }
}





