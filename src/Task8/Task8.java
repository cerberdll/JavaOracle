package Task8;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начало диапазона для таблицы умножения: ");
        int start = scanner.nextInt();
        System.out.print("Введите конец диапазона для таблицы умножения: ");
        int end = scanner.nextInt();

        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}
