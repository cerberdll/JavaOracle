import java.util.*;
import java.util.stream.Collectors;

public class ProductTask {
    public static void main(String[] args) {
        List<String> products = Arrays.asList("Milk", "Bread", "Cheese", "Apple", "Milk", "Banana", "Milk");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Все продукты: ");
        products.stream().distinct().forEach(System.out::println);

        System.out.println("\nПродукты с названием меньше 5 символов:");
        products.stream().filter(p -> p.length() < 5).distinct().forEach(System.out::println);

        System.out.print("\nВведите название продукта для подсчета: ");
        String input = scanner.nextLine();
        long count = products.stream().filter(p -> p.equalsIgnoreCase(input)).count();
        System.out.println("Количество продукта \"" + input + "\": " + count);

        System.out.print("\nВведите букву для фильтрации: ");
        char letter = scanner.nextLine().charAt(0);
        products.stream().filter(p -> p.startsWith(String.valueOf(letter))).distinct().forEach(System.out::println);

        System.out.println("\nПродукты из категории \"Молоко\":");
        products.stream().filter(p -> p.equalsIgnoreCase("Milk")).distinct().forEach(System.out::println);
    }
}