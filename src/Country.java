import java.util.List;

public class Country {
    private String name;
    private String continent;
    private int population;
    private String phoneCode;
    private String capital;
    private List<String> cities;

    // Конструкторы
    public Country() {}

    public Country(String name, String continent, int population, String phoneCode, String capital, List<String> cities) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.phoneCode = phoneCode;
        this.capital = capital;
        this.cities = cities;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    // Метод для добавления города
    public void addCity(String city, boolean isCapital) {
        cities.add(city);
        if (isCapital) {
            capital = city;
        }
    }

    // Метод для вывода данных
    public void displayData() {
        System.out.println("Страна: " + name);
        System.out.println("Континент: " + continent);
        System.out.println("Население: " + population);
        System.out.println("Телефонный код: " + phoneCode);
        System.out.println("Столица: " + capital);
        System.out.println("Города: " + cities);
    }
}