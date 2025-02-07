import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    
    private static HashMap<String, Double> exchangeRates = new HashMap<>();

    
    static {
        exchangeRates.put("USD_TO_INR", 83.0);  // Example: 1 USD = 83 INR
        exchangeRates.put("USD_TO_EUR", 0.92);  // Example: 1 USD = 0.92 EUR
        exchangeRates.put("INR_TO_USD", 0.012); // Example: 1 INR = 0.012 USD
        exchangeRates.put("INR_TO_EUR", 0.011); // Example: 1 INR = 0.011 EUR
        exchangeRates.put("EUR_TO_USD", 1.09);  // Example: 1 EUR = 1.09 USD
        exchangeRates.put("EUR_TO_INR", 90.0);  // Example: 1 EUR = 90 INR
    }

    
    private static double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        
        String key = baseCurrency + "_TO_" + targetCurrency;
        Double rate = exchangeRates.get(key);

        
        if (rate != null) {
            return amount * rate;
        } else {
            
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Welcome to the Currency Converter!");
        System.out.println("Available currencies: USD, INR, EUR");

        
        System.out.print("Enter the base currency (USD, INR, EUR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        
        System.out.print("Enter the target currency (USD, INR, EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        
        if (!exchangeRates.containsKey(baseCurrency + "_TO_" + targetCurrency)) {
            System.out.println("Invalid currency pair. Please try again.");
            return;
        }

        
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();


        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
            return;
        }

        
        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);

        if (convertedAmount == -1) {
            System.out.println("Conversion rate not available. Please try again.");
        } else {
            
            System.out.printf("Converted amount: %.2f %s%n", convertedAmount, targetCurrency);
        }

        scanner.close();
    }
}
