import java.util.List;

public class Newspaper extends Publication {
    private String releaseDate;
    private List<String> headlines;

    public Newspaper(String title, String releaseDate, List<String> headlines) {
        super(title);
        this.releaseDate = releaseDate;
        this.headlines = headlines;
    }

    @Override
    public void displayInfo() {
        System.out.println("Газета: " + title + ", Дата выхода: " + releaseDate);
        System.out.println("Заголовки: " + headlines);
    }
}