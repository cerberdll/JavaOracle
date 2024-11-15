import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Тестируем Country
        List<String> cities = new ArrayList<>();
        cities.add("Москва");
        cities.add("Санкт-Петербург");

        Country country = new Country("Россия", "Евразия", 146000000, "+7", "Москва", cities);
        country.displayData();

        // Тестируем Fraction
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);
        Fraction sum = fraction1.add(fraction2);
        System.out.print("Сумма дробей: ");
        sum.displayData();
    }
}