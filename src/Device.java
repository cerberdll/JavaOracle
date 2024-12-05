import java.util.*;
import java.util.stream.Collectors;

public class Device {
    private final String name;
    private final int year;
    private final double price;
    private final String color;
    private final String type;

    public Device(String name, int year, double price, String color, String type) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.color = color;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Device{name='" + name + "', year=" + year + ", price=" + price + ", color='" + color + "', type='" + type + "'}";
    }

    public static void main(String[] args) {
        List<Device> devices = Arrays.asList(
                new Device("Phone", 2023, 699.99, "Black", "Smartphone"),
                new Device("Tablet", 2020, 499.99, "White", "Tablet"),
                new Device("Laptop", 2022, 1299.99, "Gray", "Laptop"),
                new Device("Smartwatch", 2021, 199.99, "Black", "Wearable")
        );

        System.out.println("Все устройства:");
        devices.forEach(System.out::println);

        System.out.println("\nУстройства черного цвета:");
        devices.stream().filter(d -> d.getColor().equalsIgnoreCase("Black")).forEach(System.out::println);

        System.out.println("\nУстройства 2021 года:");
        devices.stream().filter(d -> d.getYear() == 2021).forEach(System.out::println);

        System.out.println("\nУстройства дороже 500:");
        devices.stream().filter(d -> d.getPrice() > 500).forEach(System.out::println);

        System.out.println("\nУстройства типа 'Tablet':");
        devices.stream().filter(d -> d.getType().equalsIgnoreCase("Tablet")).forEach(System.out::println);

        System.out.println("\nУстройства с годом выпуска от 2020 до 2023:");
        devices.stream().filter(d -> d.getYear() >= 2020 && d.getYear() <= 2023).forEach(System.out::println);
    }
}