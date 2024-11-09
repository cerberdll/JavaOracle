public class Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        catalog.initializeCatalog();

        System.out.println("Каталог библиотеки:");
        catalog.displayCatalog();

        System.out.println("Поиск по названию: 'Война и мир'");
        catalog.searchByTitle("Война и мир");

        System.out.println("Поиск по автору: 'Джоан Роулинг'");
        catalog.searchByAuthor("Джоан Роулинг");
    }
}