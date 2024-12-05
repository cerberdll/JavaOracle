import java.util.Scanner;
import exceptions.ATMException;
import exceptions.InsufficientFundsException;
import exceptions.ExceedsBanknoteLimitException;
import exceptions.InvalidAmountException;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("ПримерБанк", 2);
        Scanner scanner = new Scanner(System.in);

        try {
            // Инициализация банкоматов
            ATM atm1 = new ATM(50, 30);
            atm1.initializeATM(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10});
            bank.initializeATM(0, atm1);

            ATM atm2 = new ATM(20, 50);
            atm2.initializeATM(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5});
            bank.initializeATM(1, atm2);

            while (true) {
                System.out.println("\nМеню:");
                System.out.println("1. Вывести информацию о банке");
                System.out.println("2. Снять деньги из банкомата");
                System.out.println("0. Выход");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> bank.displayBankInfo();
                    case 2 -> {
                        System.out.print("Выберите банкомат (1 или 2): ");
                        int atmIndex = scanner.nextInt() - 1;

                        System.out.print("Введите сумму для снятия: ");
                        int amount = scanner.nextInt();

                        try {
                            ATM atm = bank.getATM(atmIndex);
                            int totalBanknotes = atm.withdrawMoney(amount);
                            System.out.println("Снято " + totalBanknotes + " банкнот.");
                        } catch (ATMException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                    }
                    case 0 -> {
                        System.out.println("Выход.");
                        return;
                    }
                    default -> System.out.println("Неверный выбор.");
                }
            }
        } catch (ATMException e) {
            System.out.println("Ошибка при инициализации: " + e.getMessage());
        }
    }
}