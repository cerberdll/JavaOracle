import java.util.*;

public class SetTask {
    public static void main(String[] args) {
        // a. Создать HashSet<String> (set1)
        HashSet<String> set1 = new HashSet<>();

        // b. Вставить в set 2 произвольные строки
        set1.add("Hello");
        set1.add("World");

        // c. Вставить в set все элементы из list1 и list2
        set1.addAll(Arrays.asList("Apple", "Banana", "Cherry", "Date"));
        set1.addAll(Arrays.asList("Elderberry", "Fig", "Grape"));

        // d. Вывести на экран значения set-a
        System.out.println("set1: " + set1);

        // e. Создать LinkedHashSet<String> (set2)
        LinkedHashSet<String> set2 = new LinkedHashSet<>();

        // f. Вставить в set все элементы из list2 и list3
        set2.addAll(Arrays.asList("Apple", "Cherry", "Fig", "Elderberry"));
        set2.addAll(Arrays.asList("Date", "Grape", "Banana"));

        // g. Вывести на экран значения set-a
        System.out.println("set2: " + set2);
    }
}