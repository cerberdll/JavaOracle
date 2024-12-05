import java.util.*;
import java.util.stream.Collectors;

public class Projector {
    private final String name;
    private final int year;
    private final double price;
    private final String manufacturer;

    public Projector(String name, int year, double price, String manufacturer) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.manufacturer = manufacturer;
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

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Projector{name='" + name + "', year=" + year + ", price=" + price + ", manufacturer='" + manufacturer + "'}";
    }

    public static void main(String[] args) {
        List<Projector> projectors = Arrays.asList(
                new Projector("Epson X1", 2023, 599.99, "Epson"),
                new Projector("Sony P3", 2022, 699.99, "Sony"),
                new Projector("LG Beam", 2021, 499.99, "LG"),
                new Projector("BenQ Z4", 2023, 399.99, "BenQ")
        );

        System.out.println("Все проекторы:");
        projectors.forEach(System.out::println);

        System.out.println("\nПроекторы от Sony:");
        projectors.stream().filter(p -> p.getManufacturer().equalsIgnoreCase("Sony")).forEach(System.out::println);

        System.out.println("\nПроекторы текущего года:");
        projectors.stream().filter(p -> p.getYear() == 2023).forEach(System.out::println);

        System.out.println("\nПроекторы дороже 500:");
        projectors.stream().filter(p -> p.getPrice() > 500).forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по цене (по возрастанию):");
        projectors.stream().sorted(Comparator.comparingDouble(Projector::getPrice)).forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по цене (по убыванию):");
        projectors.stream().sorted(Comparator.comparingDouble(Projector::getPrice).reversed()).forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по году выпуска (по возрастанию):");
        projectors.stream().sorted(Comparator.comparingInt(Projector::getYear)).forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по году выпуска (по убыванию):");
        projectors.stream().sorted(Comparator.comparingInt(Projector::getYear).reversed()).forEach(System.out::println);
    }
}