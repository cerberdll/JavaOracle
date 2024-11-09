package Task3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую цифру: ");
        int digit1 = scanner.nextInt();
        System.out.print("Введите вторую цифру: ");
        int digit2 = scanner.nextInt();
        System.out.print("Введите третью цифру: ");
        int digit3 = scanner.nextInt();

        int result = digit1 * 100 + digit2 * 10 + digit3;
        System.out.println("Сформированное число: " + result);

        scanner.close();
    }
}
