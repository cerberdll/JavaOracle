import java.util.List;

public class Almanac extends Publication {
    private List<Book> books;

    public Almanac(String title, List<Book> books) {
        super(title);
        this.books = books;
    }

    @Override
    public void displayInfo() {
        System.out.println("Альманах: " + title);
        System.out.println("Произведения:");
        for (Book book : books) {
            System.out.println(" - " + book.getTitle() + " (Автор: " + book.getAuthor() + ")");
        }
    }
}