import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Лабораторна робота №1.
 * Варіант: заштрихована область — клин справа з вершиною в центрі.
 *
 * @author Malynovskiy
 * @version 1.1
 */
public class Lab1MalynovskiyKI305 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Введіть розмір квадратної матриці N (N ≥ 1): ");
            if (!sc.hasNextInt()) {
                System.err.println("Помилка: потрібно ввести ціле число.");
                return;
            }
            int n = sc.nextInt();
            if (n < 1) {
                System.err.println("Помилка: N має бути ≥ 1.");
                return;
            }
            sc.nextLine(); // з'їдаємо Enter

            System.out.print("Введіть один символ-заповнювач: ");
            String token = sc.nextLine().trim();
            if (token.length() != 1) {
                System.err.println("Помилка: потрібно ввести рівно один символ.");
                return;
            }
            char fill = token.charAt(0);

            // Виводимо на екран і у файл
            Path out = Path.of("output.txt");
            try (BufferedWriter bw = Files.newBufferedWriter(out)) {
                for (int i = 0; i < n; i++) {
                    int jLeft = Math.max(i, (n - 1) - i);
                    int width = n - jLeft;

                    // Формуємо рядок
                    String line = " ".repeat(jLeft) + String.valueOf(fill).repeat(width);

                    System.out.println(line);
                    bw.write(line);
                    bw.newLine();
                }
            }

            System.out.println("\nРезультат збережено у файл: " + out.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Помилка при записі у файл: " + e.getMessage());
        }
    }
}
