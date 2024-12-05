import java.util.*;

public class ListTask {
    public static void main(String[] args) {
        // a. Создать ArrayList<String> (list1)
        ArrayList<String> list1 = new ArrayList<>();

        // b. Создать массив строк. Добавить в список все элементы массива (одним методом)
        String[] array = {"Apple", "Banana", "Cherry", "Date"};
        list1.addAll(Arrays.asList(array));

        // c. Создать новый (list2) ArrayList<String>, принициализировав его предыдущим списком
        ArrayList<String> list2 = new ArrayList<>(list1);

        // d. Создать список (list3) используя Arrays.asList(…)
        List<String> list3 = Arrays.asList("Elderberry", "Fig", "Grape");

        // e. Вставить list3 в середину list2
        list2.addAll(list2.size() / 2, list3);

        // f. Отсортировать список по убыванию
        list2.sort(Collections.reverseOrder());

        // g. Удалить каждый второй элемент списка используя ListIterator
        ListIterator<String> iterator = list2.listIterator();
        boolean remove = false;
        while (iterator.hasNext()) {
            iterator.next();
            if (remove) {
                iterator.remove();
            }
            remove = !remove;
        }

        System.out.println("list2 после всех операций: " + list2);
    }
}