package currency_exchange;

import java.util.HashMap;
import java.util.Map;

public class Exchange
{
    Map<String, Double> factor = factor();

    public double exchangeCurrency(String from, String to, double amount)
    {
        double fromValue = getValueByKey(from.strip().toUpperCase());
        double toValue = getValueByKey(to.strip().toUpperCase());

        return (double) Math.round(((toValue * amount) / fromValue) * 100) / 100;
    }

    private enum Currency
    {
        PLN("PLN"),
        EUR("EUR"),
        USD("USD"),
        GBP("GBP"),
        SHKL("SHKL");

        private String currency;

        Currency(String currency)
        {
            this.currency = currency;
        }

        public String getCurrencyName()
        {
            return currency;
        }
    }

    private double getValueByKey(String currency)
    {
        if (factor.containsKey(currency))
        {
            return factor.get(currency);
        }

        throw new IllegalArgumentException("Currency doesn't exist.");
    }

    private Map<String, Double> factor()
    {
        Map<String, Double> factor = new HashMap<>();

        factor.put(Currency.PLN.getCurrencyName(), 1.0);
        factor.put(Currency.EUR.getCurrencyName(), 0.22);
        factor.put(Currency.USD.getCurrencyName(), 0.24);
        factor.put(Currency.GBP.getCurrencyName(), 0.19);
        factor.put(Currency.SHKL.getCurrencyName(), 0.84);

        return factor;
    }
}

