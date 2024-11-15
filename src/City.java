import java.util.Scanner;

public class City {
    private String name;
    private String region;
    private String country;
    private int population;
    private String postalCode;
    private String phoneCode;

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название города: ");
        name = scanner.nextLine();

        System.out.print("Введите название региона: ");
        region = scanner.nextLine();

        System.out.print("Введите название страны: ");
        country = scanner.nextLine();

        System.out.print("Введите количество жителей: ");
        population = scanner.nextInt();
        scanner.nextLine(); // Сброс буфера

        System.out.print("Введите почтовый индекс: ");
        postalCode = scanner.nextLine();

        System.out.print("Введите телефонный код города: ");
        phoneCode = scanner.nextLine();
    }

    public void displayData() {
        System.out.println("Город: " + name);
        System.out.println("Регион: " + region);
        System.out.println("Страна: " + country);
        System.out.println("Население: " + population);
        System.out.println("Почтовый индекс: " + postalCode);
        System.out.println("Телефонный код: " + phoneCode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Аналогично можно реализовать методы доступа для других полей
}