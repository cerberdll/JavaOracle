public class Fraction {
    private int numerator;
    private int denominator;

    // Конструкторы
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
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

    // Геттеры и сеттеры
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            System.out.println("Знаменатель не может быть равен нулю. Установлено значение 1.");
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
    }

    // Арифметические операции
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

    // Метод для вывода данных
    public void displayData() {
        System.out.println("Дробь: " + numerator + "/" + denominator);
    }
}