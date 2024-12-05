import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // a. Создать LinkedHashMap<Integer, String> (map1)
        LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>();

        // b. Добавить в map значения всех месяцев года
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < months.length; i++) {
            map1.put(i + 1, months[i]);
        }

        // c. Вывести на экран первый и последний месяц года
        System.out.println("Первый месяц: " + map1.get(1));
        System.out.println("Последний месяц: " + map1.get(12));

        // d. Вставить на место 6-го месяца слово ‘ОТПУСК’, вывести на экран
        map1.put(6, "ОТПУСК");
        System.out.println("map1 после замены 6-го месяца: " + map1);

        // e. Создать HashMap<Integer, String> (map2)
        HashMap<Integer, String> map2 = new HashMap<>(map1);

        // g. Создать метод для вывода всех элементов map
        printMap(map1);
        printMap(map2);

        // h. Создать map3 (ключ – имя студента, значение - контакты)
        Map<String, Set<String>> map3 = new HashMap<>();
        map3.put("Alice", new HashSet<>(Arrays.asList("123-456-7890", "alice@gmail.com", "alice_skype")));
        map3.put("Bob", new HashSet<>(Arrays.asList("987-654-3210", "bob@gmail.com", "bob_skype")));
        System.out.println("map3: " + map3);
    }

    public static void printMap(Map<Integer, String> map) {
        System.out.println("Содержимое карты:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}