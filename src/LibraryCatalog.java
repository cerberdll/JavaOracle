import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
    private List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void displayCatalog() {
        for (LibraryItem item : items) {
            item.displayInfo();
            System.out.println();
        }
    }

    public void searchByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                item.displayInfo();
                return;
            }
        }
        System.out.println("Издание с названием '" + title + "' не найдено.");
    }

    public void searchByAuthor(String author) {
        for (LibraryItem item : items) {
            if (item instanceof Book && ((Book) item).getAuthor().equalsIgnoreCase(author)) {
                item.displayInfo();
            }
        }
    }

    // Метод для тестовой инициализации каталога
    public void initializeCatalog() {
        addItem(new Book("Война и мир", "Лев Толстой", "Роман", 1225));
        addItem(new Newspaper("Известия", "01.10.2024", List.of("Экономика растет", "Погода ухудшается")));
        addItem(new Almanac("Литературный альманах", List.of(
                new Book("Гарри Поттер", "Джоан Роулинг", "Фэнтези", 500),
                new Book("1984", "Джордж Оруэлл", "Антиутопия", 328)
        )));
    }
}