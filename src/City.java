import java.util.Scanner;

public class City {
    private String name;
    private String region;
    private String country;
    private int population;
    private String postalCode;
    private String phoneCode;

    // Конструкторы
    public City() {}

    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public City(String name, String region, String country, int population, String postalCode, String phoneCode) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.population = population;
        this.postalCode = postalCode;
        this.phoneCode = phoneCode;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    // Метод для изменения популяции
    public void updatePopulation(int newPopulation, String reason) {
        this.population = newPopulation;
        System.out.println("Население обновлено. Причина: " + reason);
    }

    // Метод для ввода данных
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название города: ");
        this.name = scanner.nextLine();

        System.out.print("Введите название региона: ");
        this.region = scanner.nextLine();

        System.out.print("Введите название страны: ");
        this.country = scanner.nextLine();

        System.out.print("Введите количество жителей: ");
        this.population = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите почтовый индекс: ");
        this.postalCode = scanner.nextLine();

        System.out.print("Введите телефонный код города: ");
        this.phoneCode = scanner.nextLine();
    }

    // Метод для вывода данных
    public void displayData() {
        System.out.println("Город: " + name);
        System.out.println("Регион: " + region);
        System.out.println("Страна: " + country);
        System.out.println("Население: " + population);
        System.out.println("Почтовый индекс: " + postalCode);
        System.out.println("Телефонный код: " + phoneCode);
    }
}