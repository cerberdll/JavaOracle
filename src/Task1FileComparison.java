import java.io.*;
import java.util.Scanner;

public class Task1FileComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к первому файлу:");
        String filePath1 = scanner.nextLine();
        System.out.println("Введите путь ко второму файлу:");
        String filePath2 = scanner.nextLine();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
             BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {

            String line1, line2;
            int lineNumber = 1;

            while ((line1 = reader1.readLine()) != null | (line2 = reader2.readLine()) != null) {
                if (line1 == null || line2 == null || !line1.equals(line2)) {
                    System.out.println("Несовпадение в строке " + lineNumber + ":");
                    System.out.println("Файл 1: " + (line1 != null ? line1 : "нет строки"));
                    System.out.println("Файл 2: " + (line2 != null ? line2 : "нет строки"));
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файлов: " + e.getMessage());
        }
    }
}