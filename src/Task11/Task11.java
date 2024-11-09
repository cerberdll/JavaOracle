package Task11;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину линии: ");
        int length = scanner.nextInt();

        System.out.print("Введите направление (h для горизонтального, v для вертикального): ");
        char direction = scanner.next().charAt(0);

        System.out.print("Введите символ для линии: ");
        char symbol = scanner.next().charAt(0);

        drawLine(length, direction, symbol);

        scanner.close();
    }

    public static void drawLine(int length, char direction, char symbol) {
        if (direction == 'h') {
            for (int i = 0; i < length; i++) {
                System.out.print(symbol);
            }
            System.out.println(); // перенос строки после горизонтальной линии
        } else if (direction == 'v') {
            for (int i = 0; i < length; i++) {
                System.out.println(symbol);
            }
        } else {
            System.out.println("Ошибка: неверное направление. Используйте 'h' для горизонтального или 'v' для вертикального.");
        }
    }
}
