public class Main {
    public static void main(String[] args) {
        // Тестируем Person
        Person person = new Person();
        person.inputData();
        person.displayData();

        // Тестируем City
        City city = new City();
        city.inputData();
        city.displayData();

        // Тестируем Country
        Country country = new Country();
        country.inputData();
        country.displayData();

        // Тестируем Fraction
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();

        System.out.println("Введите первую дробь:");
        fraction1.inputData();

        System.out.println("Введите вторую дробь:");
        fraction2.inputData();

        Fraction sum = fraction1.add(fraction2);
        System.out.print("Сумма: ");
        sum.displayData();
    }
}