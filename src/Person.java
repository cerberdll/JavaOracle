import java.util.Scanner;

public class Person {
    private String fullName;
    private String dateOfBirth;
    private String phoneNumber;
    private String city;
    private String country;
    private String homeAddress;

    // Конструкторы
    public Person() {}

    public Person(String fullName, String dateOfBirth) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String fullName, String dateOfBirth, String phoneNumber, String city, String country, String homeAddress) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.country = country;
        this.homeAddress = homeAddress;
    }

    // Геттеры и сеттеры
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    // Метод для изменения адреса
    public void updateAddress(String newCity, String newCountry, String newHomeAddress) {
        this.city = newCity;
        this.country = newCountry;
        this.homeAddress = newHomeAddress;
        System.out.println("Адрес обновлен.");
    }

    // Метод для ввода данных
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ФИО: ");
        this.fullName = scanner.nextLine();

        System.out.print("Введите дату рождения: ");
        this.dateOfBirth = scanner.nextLine();

        System.out.print("Введите номер телефона: ");
        this.phoneNumber = scanner.nextLine();

        System.out.print("Введите город: ");
        this.city = scanner.nextLine();

        System.out.print("Введите страну: ");
        this.country = scanner.nextLine();

        System.out.print("Введите домашний адрес: ");
        this.homeAddress = scanner.nextLine();
    }

    // Метод для вывода данных
    public void displayData() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Дата рождения: " + dateOfBirth);
        System.out.println("Телефон: " + phoneNumber);
        System.out.println("Город: " + city);
        System.out.println("Страна: " + country);
        System.out.println("Домашний адрес: " + homeAddress);
    }
}