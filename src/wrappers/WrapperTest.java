package wrappers;

public class WrapperTest {
    public static void main(String[] args) {
        // 1. Инициализация переменных разных типов
        Integer i1 = 10; // автоупаковка
        Integer i2 = Integer.valueOf(10); // valueOf
        // Устаревший конструктор new Integer заменяем на автоупаковку
        Integer i3 = Integer.valueOf(10); // Альтернативный подход
        Integer i4 = Integer.parseInt("10"); // из строки

        System.out.println("Integer переменные:");
        System.out.println("i1: " + i1);
        System.out.println("i2: " + i2);
        System.out.println("i3: " + i3);
        System.out.println("i4: " + i4);

        // Double с дробной частью
        Double doubleValue = 15.75;

        // Примитивные типы
        byte byteValue = doubleValue.byteValue();
        short shortValue = doubleValue.shortValue();
        int intValue = doubleValue.intValue();
        float floatValue = doubleValue.floatValue();
        long longValue = doubleValue.longValue();

        System.out.println("\nDouble to primitives:");
        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);
        System.out.println("float: " + floatValue);
        System.out.println("long: " + longValue);

        // Проверка NaN и Infinity
        Double nonZero = 5.0;
        Double zero = 0.0;
        Double nanValue = nonZero / zero;
        Double infinityValue = zero / zero;

        System.out.println("\nNaN и Infinity:");
        System.out.println("nanValue: " + nanValue);
        System.out.println("infinityValue: " + infinityValue);

        if (nanValue.isNaN()) {
            System.out.println("Переменная nanValue = NaN");
        }
        if (infinityValue.isInfinite()) {
            System.out.println("Переменная infinityValue = Infinity");
        }

        // Сравнение Long переменных
        Long long1 = 120L;
        Long long2 = 120L;

        System.out.println("\nLong сравнение (120): " + (long1 == long2));

        long1 = 1200L;
        long2 = 1200L;

        System.out.println("Long сравнение (1200): " + (long1 == long2));
    }
}