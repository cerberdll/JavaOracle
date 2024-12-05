import exceptions.ATMException;
import exceptions.InsufficientFundsException;
import exceptions.ExceedsBanknoteLimitException;
import exceptions.InvalidAmountException;

public class Bank {
    private String name;
    private ATM[] atms;

    public Bank(String name, int numberOfATMs) {
        this.name = name;
        this.atms = new ATM[numberOfATMs];
    }

    public void initializeATM(int index, ATM atm) throws InvalidAmountException {
        if (index < 0 || index >= atms.length) {
            throw new InvalidAmountException("Неверный индекс банкомата.");
        }
        atms[index] = atm;
    }

    public ATM getATM(int index) throws InvalidAmountException {
        if (index < 0 || index >= atms.length) {
            throw new InvalidAmountException("Неверный индекс банкомата.");
        }
        if (atms[index] == null) {
            throw new InvalidAmountException("Банкомат не инициализирован.");
        }
        return atms[index];
    }

    public int getTotalMoneyInNetwork() {
        int total = 0;
        for (ATM atm : atms) {
            if (atm != null) {
                total += atm.getTotalMoney();
            }
        }
        return total;
    }

    public void displayBankInfo() {
        System.out.println("Банк: " + name);
        System.out.println("Общая сумма в сети банкоматов: " + getTotalMoneyInNetwork() + " грн");
        for (int i = 0; i < atms.length; i++) {
            System.out.println("Банкомат " + (i + 1) + ":");
            if (atms[i] != null) {
                atms[i].displayATMInfo();
            } else {
                System.out.println("Не инициализирован.");
            }
        }
    }
}