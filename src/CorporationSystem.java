import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CorporationSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Employee> employees = new ArrayList<>();
    private static File dataFile;

    public static void main(String[] args) {
        System.out.println("Введите путь к файлу для загрузки/сохранения данных сотрудников:");
        String filePath = scanner.nextLine();
        dataFile = new File(filePath);

        if (dataFile.exists()) {
            loadEmployees();
        }

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить сотрудника");
            System.out.println("2. Редактировать сотрудника");
            System.out.println("3. Удалить сотрудника");
            System.out.println("4. Найти сотрудника по фамилии");
            System.out.println("5. Показать сотрудников по возрасту или букве фамилии");
            System.out.println("6. Сохранить список сотрудников в файл");
            System.out.println("0. Выйти");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> editEmployee();
                case 3 -> deleteEmployee();
                case 4 -> findEmployeeBySurname();
                case 5 -> showEmployeesByCriteria();
                case 6 -> saveEmployees();
                case 0 -> {
                    saveEmployees();
                    System.out.println("Программа завершена.");
                    return;
                }
                default -> System.out.println("Неверный выбор.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите должность: ");
        String position = scanner.nextLine();

        employees.add(new Employee(name, surname, age, position));
        System.out.println("Сотрудник добавлен.");
    }

    private static void editEmployee() {
        System.out.print("Введите фамилию сотрудника для редактирования: ");
        String surname = scanner.nextLine();

        List<Employee> results = employees.stream()
                .filter(e -> e.getSurname().equalsIgnoreCase(surname))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            System.out.println("Сотрудники с такой фамилией не найдены.");
            return;
        }

        Employee employee = results.get(0);
        System.out.println("Редактируем данные для: " + employee);

        System.out.print("Новое имя (оставьте пустым для пропуска): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) employee.setName(name);

        System.out.print("Новая фамилия (оставьте пустым для пропуска): ");
        String newSurname = scanner.nextLine();
        if (!newSurname.isEmpty()) employee.setSurname(newSurname);

        System.out.print("Новый возраст (оставьте пустым для пропуска): ");
        String age = scanner.nextLine();
        if (!age.isEmpty()) employee.setAge(Integer.parseInt(age));

        System.out.print("Новая должность (оставьте пустым для пропуска): ");
        String position = scanner.nextLine();
        if (!position.isEmpty()) employee.setPosition(position);

        System.out.println("Данные сотрудника обновлены.");
    }

    private static void deleteEmployee() {
        System.out.print("Введите фамилию сотрудника для удаления: ");
        String surname = scanner.nextLine();

        employees.removeIf(e -> e.getSurname().equalsIgnoreCase(surname));
        System.out.println("Сотрудник(и) с фамилией \"" + surname + "\" удален(ы).");
    }

    private static void findEmployeeBySurname() {
        System.out.print("Введите фамилию для поиска: ");
        String surname = scanner.nextLine();

        employees.stream()
                .filter(e -> e.getSurname().equalsIgnoreCase(surname))
                .forEach(System.out::println);
    }

    private static void showEmployeesByCriteria() {
        System.out.print("Введите возраст или букву фамилии: ");
        String input = scanner.nextLine();

        if (input.matches("\\d+")) {
            int age = Integer.parseInt(input);
            employees.stream()
                    .filter(e -> e.getAge() == age)
                    .forEach(System.out::println);
        } else {
            char letter = input.charAt(0);
            employees.stream()
                    .filter(e -> e.getSurname().startsWith(String.valueOf(letter)))
                    .forEach(System.out::println);
        }
    }

    private static void saveEmployees() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {
            for (Employee employee : employees) {
                writer.write(employee.toString());
                writer.newLine();
            }
            System.out.println("Данные сотрудников сохранены.");
        } catch (IOException e) {
            System.out.println("Ошибка сохранения данных: " + e.getMessage());
        }
    }

    private static void loadEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String name = parts[0].split("=")[1];
                String surname = parts[1].split("=")[1];
                int age = Integer.parseInt(parts[2].split("=")[1]);
                String position = parts[3].split("=")[1].replace("}", "");

                employees.add(new Employee(name, surname, age, position));
            }
            System.out.println("Данные сотрудников загружены.");
        } catch (IOException e) {
            System.out.println("Ошибка загрузки данных: " + e.getMessage());
        }
    }
}