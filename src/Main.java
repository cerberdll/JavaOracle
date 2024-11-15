import wrappers.WrapperTest;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Запуск WrapperTest ===");
        WrapperTest.main(args); // Запуск тестов для wrapper классов

        System.out.println("\n=== Запуск StringTest ===");
        StringTest.main(args); // Запуск тестов для строк
    }
}