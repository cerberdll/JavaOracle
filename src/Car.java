import java.util.Scanner;

public class Car {
    private String name;
    private String manufacturer;
    private int year;
    private double engineVolume;

    // Конструкторы
    public Car() {}

    public Car(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public Car(String name, String manufacturer, int year, double engineVolume) {
        this(name, manufacturer);
        this.year = year;
        this.engineVolume = engineVolume;
    }

    // Перегруженные методы
    public void displayInfo() {
        System.out.println("Автомобиль: " + name + ", Производитель: " + manufacturer);
    }

    public void displayInfo(boolean fullDetails) {
        if (fullDetails) {
            System.out.println("Автомобиль: " + name + ", Производитель: " + manufacturer +
                    ", Год выпуска: " + year + ", Объем двигателя: " + engineVolume);
        } else {
            displayInfo();
        }
    }
}