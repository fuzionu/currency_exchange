package currency.exchanger;

import java.util.HashMap;
import java.util.Map;

import static currency.exchanger.Currency.*;

public class Exchanger
{
    private final Map<Currency, Integer> factors = getFactors();

    public int exchangeByCents(Currency inFactor, Currency outFactor, int amount)
    {
        int fromValue = factors.get(inFactor);
        int toValue = factors.get(outFactor);

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

