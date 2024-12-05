import java.util.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserTask {
    public static void main(String[] args) {
        // a. Создать класс User с полями name, old и phone
        class User {
            private String name;
            private int old;
            private String phone;

            public User(String name, int old, String phone) {
                this.name = name;
                this.old = old;
                this.phone = phone;
            }

            @Override
            public String toString() {
                return "User{name='" + name + "', old=" + old + ", phone='" + phone + "'}";
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, old, phone);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                User user = (User) o;
                return old == user.old && Objects.equals(name, user.name) && Objects.equals(phone, user.phone);
            }
        }

        // b. Создать userSet (HashSet<User>)
        Set<User> userSet = new HashSet<>();

        // c. Создать экземпляры класса User
        User user1 = new User("Alice", 25, "123-456-7890");
        User user2 = new User("Alice", 25, "123-456-7890");
        User user3 = new User("Bob", 30, "987-654-3210");

        // d. Добавить пользователей в userSet
        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);

        // e. Вывести пользователей на экран
        System.out.println("userSet после добавления пользователей: " + userSet);
    }
}