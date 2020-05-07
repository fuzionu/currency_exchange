package currency_exchange;

import java.util.HashMap;
import java.util.Map;

public class Exchange
{
    Map<String, Double> currencies = currency();

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
        if (currencies.containsKey(currency))
        {
            return currencies.get(currency);
        }

        throw new IllegalArgumentException("Currency doesn't exist.");
    }

    private Map<String, Double> currency()
    {
        Map<String, Double> currency = new HashMap<>();

        currency.put(Currency.PLN.getCurrencyName(), 1.0);
        currency.put(Currency.EUR.getCurrencyName(), 0.22);
        currency.put(Currency.USD.getCurrencyName(), 0.24);
        currency.put(Currency.GBP.getCurrencyName(), 0.19);
        currency.put(Currency.SHKL.getCurrencyName(), 0.84);

        return currency;
    }
}

