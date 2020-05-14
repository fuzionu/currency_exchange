package currency_exchange;

import java.util.HashMap;
import java.util.Map;

import static currency_exchange.Currency.*;

public class Exchanger
{
    Map<Currency, Integer> factors = getFactors();

    public int exchangeByCents(Currency inFactor, Currency outFactor, int amount)
    {
        int fromValue = this.factors.get(inFactor);
        int toValue = this.factors.get(outFactor);

        return calculateExchange(amount, fromValue, toValue);
    }

    private int calculateExchange(int amount, int fromValue, int toValue)
    {
        return toValue * amount / fromValue;
    }

    private Map<Currency, Integer> getFactors()
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

