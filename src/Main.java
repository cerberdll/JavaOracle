import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();

        // Добавляем книги
        catalog.addItem(new Book("Война и мир", "Лев Толстой", "Роман", 1225));
        catalog.addItem(new Book("1984", "Джордж Оруэлл", "Антиутопия", 328));

        // Добавляем газеты
        catalog.addItem(new Newspaper("Известия", "01.11.2024", List.of("Экономика растет", "Погода ухудшается")));

        // Добавляем альманах
        catalog.addItem(new Almanac("Литературный альманах", List.of(
                new Book("Гарри Поттер", "Джоан Роулинг", "Фэнтези", 500),
                new Book("1984", "Джордж Оруэлл", "Антиутопия", 328)
        )));

        // Выводим каталог
        System.out.println("Каталог библиотеки:");
        catalog.displayCatalog();

        // Поиск по названию
        System.out.println("Поиск по названию '1984':");
        catalog.searchByTitle("1984");

        // Поиск по автору
        System.out.println("Поиск по автору 'Джордж Оруэлл':");
        catalog.searchByAuthor("Джордж Оруэлл");
    }
}