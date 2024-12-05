import exceptions.ATMException;
import exceptions.InsufficientFundsException;
import exceptions.ExceedsBanknoteLimitException;
import exceptions.InvalidAmountException;

public class ATM {
    private int[] denominations = {500, 200, 100, 50, 20, 10, 5, 2, 1};
    private int[] banknoteCounts = new int[denominations.length];
    private int minWithdrawal;
    private int maxBanknotes;

    public ATM(int minWithdrawal, int maxBanknotes) {
        this.minWithdrawal = minWithdrawal;
        this.maxBanknotes = maxBanknotes;
    }

    public void initializeATM(int[] initialCounts) throws InvalidAmountException {
        if (initialCounts.length != denominations.length) {
            throw new InvalidAmountException("Неверное количество номиналов.");
        }
        System.arraycopy(initialCounts, 0, banknoteCounts, 0, denominations.length);
    }

    public void depositMoney(int denomination, int count) throws InvalidAmountException {
        int index = findDenominationIndex(denomination);
        if (index == -1) {
            throw new InvalidAmountException("Неверный номинал.");
        }
        banknoteCounts[index] += count;
    }

    public int withdrawMoney(int amount) throws ATMException {
        if (amount < minWithdrawal) {
            throw new InvalidAmountException("Сумма меньше минимальной для выдачи.");
        }

        int[] withdrawal = new int[denominations.length];
        int totalBanknotes = 0;

        for (int i = 0; i < denominations.length; i++) {
            int count = Math.min(amount / denominations[i], banknoteCounts[i]);
            withdrawal[i] = count;
            amount -= count * denominations[i];
            totalBanknotes += count;

            if (totalBanknotes > maxBanknotes) {
                throw new ExceedsBanknoteLimitException("Превышено максимальное количество банкнот.");
            }
        }

        if (amount > 0) {
            throw new InsufficientFundsException("Невозможно выдать запрошенную сумму.");
        }

        // Обновление остатка
        for (int i = 0; i < denominations.length; i++) {
            banknoteCounts[i] -= withdrawal[i];
        }

        return totalBanknotes;
    }

    public int getTotalMoney() {
        int total = 0;
        for (int i = 0; i < denominations.length; i++) {
            total += denominations[i] * banknoteCounts[i];
        }
        return total;
    }

    public void displayATMInfo() {
        System.out.println("Информация о банкомате:");
        for (int i = 0; i < denominations.length; i++) {
            System.out.println(denominations[i] + " грн: " + banknoteCounts[i]);
        }
        System.out.println("Итого: " + getTotalMoney() + " грн");
    }

    private int findDenominationIndex(int denomination) {
        for (int i = 0; i < denominations.length; i++) {
            if (denominations[i] == denomination) {
                return i;
            }
        }
        return -1;
    }
}