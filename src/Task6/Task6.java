package Task6;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество метров: ");
        double meters = scanner.nextDouble();

        System.out.println("Выберите единицу измерения для перевода: ");
        System.out.println("1 - Мили");
        System.out.println("2 - Дюймы");
        System.out.println("3 - Ярды");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> System.out.println(meters + " метров = " + meters * 0.000621371 + " миль");
            case 2 -> System.out.println(meters + " метров = " + meters * 39.3701 + " дюймов");
            case 3 -> System.out.println(meters + " метров = " + meters * 1.09361 + " ярдов");
            default -> System.out.println("Ошибка: неверный выбор.");
        }

        scanner.close();
    }
}
