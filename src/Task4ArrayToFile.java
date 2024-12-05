import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Task4ArrayToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу для сохранения массива:");
        String filePath = scanner.nextLine();

        System.out.println("Введите элементы массива через пробел:");
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Исходный массив: " + Arrays.toString(array));
            writer.newLine();

            writer.write("Четные элементы: " + Arrays.toString(Arrays.stream(array).filter(n -> n % 2 == 0).toArray()));
            writer.newLine();

            writer.write("Нечетные элементы: " + Arrays.toString(Arrays.stream(array).filter(n -> n % 2 != 0).toArray()));
            writer.newLine();

            writer.write("Перевернутый массив: " + Arrays.toString(reverseArray(array)));
            writer.newLine();

            System.out.println("Массивы сохранены в файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

    private static int[] reverseArray(int[] array) {
        int[] reversed = Arrays.copyOf(array, array.length);
        for (int i = 0; i < reversed.length / 2; i++) {
            int temp = reversed[i];
            reversed[i] = reversed[reversed.length - i - 1];
            reversed[reversed.length - i - 1] = temp;
        }
        return reversed;
    }
}