package currency.exchanger;

import java.util.HashMap;
import java.util.Map;

import static currency.exchanger.Currency.EUR;
import static currency.exchanger.Currency.GBP;
import static currency.exchanger.Currency.PLN;
import static currency.exchanger.Currency.SHKL;
import static currency.exchanger.Currency.USD;

public class FakeAPI implements API
{
    @Override
    public Map getFactors()
    {
        Map<Currency, Double> factor = new HashMap<>();

        factor.put(PLN, 100.00);
        factor.put(EUR, 22.00);
        factor.put(USD, 24.00);
        factor.put(GBP, 19.00);
        factor.put(SHKL, 84.00);

        return factor;
    }
}
