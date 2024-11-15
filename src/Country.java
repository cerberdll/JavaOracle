import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Country {
    private String name;
    private String continent;
    private int population;
    private String phoneCode;
    private String capital;
    private List<String> cities = new ArrayList<>();

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название страны: ");
        name = scanner.nextLine();

        System.out.print("Введите континент: ");
        continent = scanner.nextLine();

        System.out.print("Введите количество жителей: ");
        population = scanner.nextInt();
        scanner.nextLine(); // Сброс буфера

        System.out.print("Введите телефонный код страны: ");
        phoneCode = scanner.nextLine();

        System.out.print("Введите название столицы: ");
        capital = scanner.nextLine();

        System.out.print("Введите города страны (через запятую): ");
        String[] cityArray = scanner.nextLine().split(",");
        for (String city : cityArray) {
            cities.add(city.trim());
        }
    }

    public void displayData() {
        System.out.println("Страна: " + name);
        System.out.println("Континент: " + continent);
        System.out.println("Население: " + population);
        System.out.println("Телефонный код: " + phoneCode);
        System.out.println("Столица: " + capital);
        System.out.println("Города: " + cities);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Аналогично можно реализовать методы доступа для других полей
}