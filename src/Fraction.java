import java.util.Scanner;

public class Fraction {
    private int numerator;
    private int denominator;

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите числитель: ");
        numerator = scanner.nextInt();

        System.out.print("Введите знаменатель: ");
        denominator = scanner.nextInt();

        if (denominator == 0) {
            System.out.println("Знаменатель не может быть равен нулю. Установлено значение 1.");
            denominator = 1;
        }
    }

    public void displayData() {
        System.out.println("Дробь: " + numerator + "/" + denominator);
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction other) {
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            System.out.println("Знаменатель не может быть равен нулю. Установлено значение 1.");
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }
}