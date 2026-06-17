import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CurrencyService {

    private final Map<String, Double> rates = new HashMap<>();

    public CurrencyService() {
        rates.put("USD", 1.0);
        rates.put("INR", 83.0);
        rates.put("EUR", 0.92);
        rates.put("GBP", 0.78);
        rates.put("JPY", 150.0);
    }

    public double convert(String from, String to, double amount) {

        if (!rates.containsKey(from) || !rates.containsKey(to)) {
            throw new IllegalArgumentException("Unsupported currency!");
        }

        double usd = amount / rates.get(from);

        return usd * rates.get(to);
    }

    public void showCurrencies() {

        System.out.println("\nSupported Currencies:");

        for (String currency : rates.keySet()) {
            System.out.println("- " + currency);
        }
    }
}

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CurrencyService service = new CurrencyService();

        System.out.println("===== CURRENCY CONVERTER =====");

        while (true) {

            System.out.println("\n1. Convert Currency");
            System.out.println("2. Show Supported Currencies");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("From Currency: ");
                    String from = sc.next().toUpperCase();

                    System.out.print("To Currency: ");
                    String to = sc.next().toUpperCase();

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    try {

                        double result = service.convert(from, to, amount);

                        System.out.printf("Converted Amount: %.2f%n", result);

                    } catch (Exception e) {

                        System.out.println("Error: " + e.getMessage());

                    }

                    break;

                case 2:

                    service.showCurrencies();

                    break;

                case 3:

                    System.out.println("Thank you!");

                    sc.close();

                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}