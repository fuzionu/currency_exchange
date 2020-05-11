package currency_exchange;

import java.util.HashMap;
import java.util.Map;

import static currency_exchange.Currencies.*;
import static currency_exchange.Currencies.Currency.*;

public class Exchange
{
    Map<Currency, Double> factor = factor();

    public double exchange(Currency inFactor, Currency outFactor, double amount)
    {
        double fromValue = getFactor(inFactor);
        double toValue = getFactor(outFactor);

        return (double) Math.round(toValue * amount / fromValue * 100) / 100;
    }

    private double getFactor(Currency factor)
    {
        return this.factor.get(factor);
    }

    private Map<Currency, Double> factor()
    {
        Map<Currency, Double> factor = new HashMap<>();

        factor.put(PLN, 1.0);
        factor.put(EUR, 0.22);
        factor.put(USD, 0.24);
        factor.put(GBP, 0.19);
        factor.put(SHKL, 0.84);

        return factor;
    }
}

