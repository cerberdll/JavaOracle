import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
    private List<LibraryItem> items;

    public LibraryCatalog() {
        items = new ArrayList<>();
    }

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
        boolean found = false;
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                item.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Издание с названием \"" + title + "\" не найдено.");
        }
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (LibraryItem item : items) {
            if (item instanceof Book && ((Book) item).getAuthor().equalsIgnoreCase(author)) {
                item.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Книги автора \"" + author + "\" не найдены.");
        }
    }
}