package currency_exchange;

import java.util.HashMap;
import java.util.Map;

import static currency_exchange.Currencies.*;
import static currency_exchange.Currencies.Currency.*;

public class Exchanger
{
    Map<Currency, Integer> factor = factor();

    public double exchangeByCents(Currency inFactor, Currency outFactor, int amount)
    {
        int fromValue = getFactor(inFactor);
        int toValue = getFactor(outFactor);

        return calculateExchange(amount, fromValue, toValue);
    }

    private double calculateExchange(int amount, int fromValue, int toValue)
    {
        return (double) (toValue * amount / fromValue) / 100;
    }

    private int getFactor(Currency factor)
    {
        return this.factor.get(factor);
    }

    private Map<Currency, Integer> factor()
    {
        Map<Currency, Integer> factor = new HashMap<>();

        factor.put(PLN, 100);
        factor.put(EUR, 22);
        factor.put(USD, 24);
        factor.put(GBP, 19);
        factor.put(SHKL, 84);

        return factor;
    }
}

