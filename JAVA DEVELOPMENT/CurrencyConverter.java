import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    // Step 2: Define exchange rates using a HashMap
    private static HashMap<String, Double> exchangeRates = new HashMap<>();

    // Step 2: Initialize exchange rates (simulating real-time API data)
    static {
        exchangeRates.put("USD_TO_INR", 83.0);  // Example: 1 USD = 83 INR
        exchangeRates.put("USD_TO_EUR", 0.92);  // Example: 1 USD = 0.92 EUR
        exchangeRates.put("INR_TO_USD", 0.012); // Example: 1 INR = 0.012 USD
        exchangeRates.put("INR_TO_EUR", 0.011); // Example: 1 INR = 0.011 EUR
        exchangeRates.put("EUR_TO_USD", 1.09);  // Example: 1 EUR = 1.09 USD
        exchangeRates.put("EUR_TO_INR", 90.0);  // Example: 1 EUR = 90 INR
    }

    // Method to convert currency
    private static double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        // Create the key to fetch the exchange rate
        String key = baseCurrency + "_TO_" + targetCurrency;
        Double rate = exchangeRates.get(key);

        // If the rate exists, perform the conversion
        if (rate != null) {
            return amount * rate;
        } else {
            // If no rate is available, return -1 to indicate an error
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Display available currencies
        System.out.println("Welcome to the Currency Converter!");
        System.out.println("Available currencies: USD, INR, EUR");

        // Step 1: Ask the user to select the base currency
        System.out.print("Enter the base currency (USD, INR, EUR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        // Step 1: Ask the user to select the target currency
        System.out.print("Enter the target currency (USD, INR, EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Validate if the user selected valid currencies
        if (!exchangeRates.containsKey(baseCurrency + "_TO_" + targetCurrency)) {
            System.out.println("Invalid currency pair. Please try again.");
            return;
        }

        // Step 3: Input the amount to be converted
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Validate if the amount is positive
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
            return ;
        }

        // Step 4: Perform currency conversion
        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);

        if (convertedAmount == -1) {
            System.out.println("Conversion rate not available. Please try again.");
        } else {
            // Step 5: Display the result
            System.out.printf("Converted amount: %.2f %s%n", convertedAmount, targetCurrency);
        }

        // Close the scanner
        scanner.close();
    }
}
