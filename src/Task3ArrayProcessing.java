import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Task3ArrayProcessing {
    public static void main(String[] args) {
        System.out.println("Введите путь к файлу с массивами:");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int globalMin = Integer.MAX_VALUE;
            int globalMax = Integer.MIN_VALUE;
            int globalSum = 0;

            int arrayIndex = 1;

            while ((line = reader.readLine()) != null) {
                int[] array = Arrays.stream(line.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                int arrayMin = Arrays.stream(array).min().orElse(Integer.MAX_VALUE);
                int arrayMax = Arrays.stream(array).max().orElse(Integer.MIN_VALUE);
                int arraySum = Arrays.stream(array).sum();

                globalMin = Math.min(globalMin, arrayMin);
                globalMax = Math.max(globalMax, arrayMax);
                globalSum += arraySum;

                System.out.println("Массив " + arrayIndex + ": " + Arrays.toString(array));
                System.out.println("Минимум: " + arrayMin + ", Максимум: " + arrayMax + ", Сумма: " + arraySum);
                arrayIndex++;
            }

            System.out.println("Глобальный минимум: " + globalMin);
            System.out.println("Глобальный максимум: " + globalMax);
            System.out.println("Общая сумма: " + globalSum);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}