import java.util.List;

public class Newspaper extends Publication {
    private String issueDate;
    private List<String> headlines;

    public Newspaper(String title, String issueDate, List<String> headlines) {
        super(title);
        this.issueDate = issueDate;
        this.headlines = headlines;
    }

    @Override
    public void displayInfo() {
        System.out.println("Газета: " + title + ", Дата выхода: " + issueDate);
        System.out.println("Заголовки: " + headlines);
    }
}