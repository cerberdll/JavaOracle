package Task4;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите шестизначное число: ");
        String number = scanner.nextLine();

        if (number.length() == 6) {
            char[] digits = number.toCharArray();
            // Меняем местами нужные цифры
            char temp = digits[0];
            digits[0] = digits[5];
            digits[5] = temp;

            temp = digits[1];
            digits[1] = digits[4];
            digits[4] = temp;

            String result = new String(digits);
            System.out.println("Измененное число: " + result);
        } else {
            System.out.println("Ошибка: число должно быть шестизначным.");
        }

        scanner.close();
    }
}
