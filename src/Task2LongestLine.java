import java.io.*;
import java.util.Scanner;

public class Task2LongestLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String longestLine = "";
            int maxLength = 0;

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.length() > maxLength) {
                    maxLength = currentLine.length();
                    longestLine = currentLine;
                }
            }

            System.out.println("Длина самой длинной строки: " + maxLength);
            System.out.println("Сама строка: " + longestLine);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}