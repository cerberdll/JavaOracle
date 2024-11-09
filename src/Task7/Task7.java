package Task7;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число диапазона: ");
        int start = scanner.nextInt();
        System.out.print("Введите второе число диапазона: ");
        int end = scanner.nextInt();

        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        System.out.println("Нечетные числа в диапазоне:");
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}
