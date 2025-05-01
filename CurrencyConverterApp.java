import java.util.Scanner;

public class CurrencyConverterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();

        System.out.println("=== Currency Converter ===");
        converter.showSupportedCurrencies();

        System.out.print("Enter source currency (e.g., USD): ");
        String from = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g., INR): ");
        String to = scanner.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        try {
            double result = converter.convert(amount, from, to);
            System.out.printf("Converted amount: %.2f %s%n", result, to);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
