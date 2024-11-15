public class Book {
    private String title;
    private String author;
    private int year;
    private String publisher;
    private String genre;
    private int pages;

    // Конструкторы
    public Book() {}

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, int year, String publisher, String genre, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.pages = pages;
    }

    // Геттеры и сеттеры
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    // Методы
    public void displayInfo() {
        System.out.println("Книга: " + title + ", Автор: " + author + ", Год выпуска: " + year + ", Издательство: " + publisher + ", Жанр: " + genre + ", Страниц: " + pages);
    }
}