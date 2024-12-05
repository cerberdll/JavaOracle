import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberTask {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(-1000, 1000)
                .limit(200) // Берем первые 200 случайных чисел
                .boxed()
                .collect(Collectors.toList());

        long positiveCount = numbers.stream().filter(n -> n > 0).count();
        long negativeCount = numbers.stream().filter(n -> n < 0).count();
        long twoDigitCount = numbers.stream().filter(n -> Math.abs(n) >= 10 && Math.abs(n) < 100).count();
        long mirroredCount = numbers.stream()
                .filter(n -> {
                    String str = String.valueOf(Math.abs(n));
                    return str.equals(new StringBuilder(str).reverse().toString());
                })
                .count();

        System.out.println("Количество положительных: " + positiveCount);
        System.out.println("Количество отрицательных: " + negativeCount);
        System.out.println("Количество двухзначных: " + twoDigitCount);
        System.out.println("Количество зеркальных чисел: " + mirroredCount);
    }
}