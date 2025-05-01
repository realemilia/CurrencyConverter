import java.util.HashMap;

class Converter {
    private HashMap<String, Double> rates;

    public Converter() {
        rates = new HashMap<>();
        // Rates relative to USD
        rates.put("INR", 1.0);        // 1 INR = 1 INR
        rates.put("USD", 0.012);      // 1 INR = 0.012 USD
        rates.put("EUR", 0.011);      // 1 INR = 0.011 EUR
        rates.put("GBP", 0.0095);     // 1 INR = 0.0095 GBP
        rates.put("JPY", 1.82);       // 1 INR = 1.82 JPY
    }

    public double convert(double amount, String from, String to) {
        if (!rates.containsKey(from) || !rates.containsKey(to)) {
            throw new IllegalArgumentException("Unsupported currency.");
        }
        double amountInUSD = amount / rates.get(from); // Convert to base (USD)
        return amountInUSD * rates.get(to);            // Convert to target
    }

    public void showSupportedCurrencies() {
        System.out.println("Supported Currencies:");
        for (String currency : rates.keySet()) {
            System.out.println("- " + currency);
        }
    }
}
