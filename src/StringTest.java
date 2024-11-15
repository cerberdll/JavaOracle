import java.util.Arrays;
import java.util.Scanner;

public class StringTest {
    public static void main(String[] args) {
        // Создание строк
        String literalString = "Литерал";
        String newString = new String("Через new");
        char[] charArray = {'С', 'т', 'р', 'о', 'к', 'а'};
        String fromCharArray = new String(charArray);
        byte[] byteArray = {65, 66, 67};
        String fromByteArray = new String(byteArray);
        String stringBuilderString = new StringBuilder("Через StringBuilder").toString();

        System.out.println("Созданные строки:");
        System.out.println(literalString);
        System.out.println(newString);
        System.out.println(fromCharArray);
        System.out.println(fromByteArray);
        System.out.println(stringBuilderString);

        // Работа со строкой
        String fruits = "Апельсин,Яблоко,Гранат,Груша";
        String[] fruitArray = fruits.split(",");
        System.out.println("\nФрукты: " + Arrays.toString(fruitArray));

        // Самое длинное название
        String longestFruit = Arrays.stream(fruitArray)
                .max((a, b) -> Integer.compare(a.length(), b.length()))
                .orElse("");
        System.out.println("Самое длинное название (в нижнем регистре): " + longestFruit.toLowerCase());

        // Сокращенные названия
        System.out.println("\nСокращенные названия:");
        for (String fruit : fruitArray) {
            System.out.println(fruit.substring(0, 3));
        }

        // Работа с пробелами
        String spacedString = "   Я_новая_строка      ";
        spacedString = spacedString.trim().replace('_', ' ');
        System.out.println("\nПреобразованная строка: " + spacedString);

        // Работа с Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите текст: ");
        String inputText = scanner.nextLine();
        System.out.println("Вы ввели: " + inputText);

        if (inputText.startsWith("Запуск")) {
            System.out.println("Запускаем процесс");
        }
        if (inputText.endsWith("завершен")) {
            System.out.println("Процесс завершен");
        }
        if (inputText.toLowerCase().contains("ошибка")) {
            System.out.println("Произошла ошибка");
        }

        // Работа с StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append(literalString).append("\n").append(newString).append("\n")
                .append(fromCharArray).append("\n").append(fromByteArray).append("\n")
                .append(stringBuilderString).append("\n");

        sb.reverse();
        System.out.println("\nРазвернутая строка:");
        System.out.println(sb.toString());
    }
}