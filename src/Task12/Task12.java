package Task12;

import java.util.Arrays;
import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = {34, 7, 23, 32, 5, 62}; // Пример массива для сортировки

        System.out.print("Выберите порядок сортировки (1 для возрастания, 2 для убывания): ");
        int choice = scanner.nextInt();

        sortArray(array, choice == 1);

        System.out.println("Отсортированный массив: " + Arrays.toString(array));

        scanner.close();
    }

    public static void sortArray(int[] array, boolean ascending) {
        if (ascending) {
            Arrays.sort(array); // Сортировка по возрастанию
        } else {
            Arrays.sort(array); // Сначала сортируем по возрастанию
            for (int i = 0; i < array.length / 2; i++) {
                // Переворачиваем массив для убывающего порядка
                int temp = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            }
        }
    }
}
