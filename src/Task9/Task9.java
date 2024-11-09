package Task9;

import java.util.Random;

public class Task9 {
    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();

        // Заполнение массива случайными числами
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101) - 50; // числа от -50 до 50
        }

        int min = array[0];
        int max = array[0];
        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;

        for (int num : array) {
            if (num < min) min = num;
            if (num > max) max = num;
            if (num < 0) negativeCount++;
            if (num > 0) positiveCount++;
            if (num == 0) zeroCount++;
        }

        System.out.println("Массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println("\nМинимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Количество отрицательных элементов: " + negativeCount);
        System.out.println("Количество положительных элементов: " + positiveCount);
        System.out.println("Количество нулей: " + zeroCount);
    }
}
