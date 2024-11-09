package Task10;

import java.util.ArrayList;
import java.util.Random;

public class Task10 {
    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();

        // Заполнение массива случайными числами
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101) - 50; // числа от -50 до 50
        }

        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        ArrayList<Integer> positiveNumbers = new ArrayList<>();

        for (int num : array) {
            if (num % 2 == 0) evenNumbers.add(num);
            else oddNumbers.add(num);

            if (num < 0) negativeNumbers.add(num);
            else if (num > 0) positiveNumbers.add(num);
        }

        System.out.println("Исходный массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println("\nЧетные числа: " + evenNumbers);
        System.out.println("Нечетные числа: " + oddNumbers);
        System.out.println("Отрицательные числа: " + negativeNumbers);
        System.out.println("Положительные числа: " + positiveNumbers);
    }
}
