package currency_exchange;

public class TextInterface
{
    public void start()
    {
        System.out.println("\nCurrency exchanger v. 0.3.0\nType 'exchange' or 'exit'");
    }

    private void currenciesMessage()
    {
        System.out.println("Choose currencies to exchange:\n" +
                "PLN, EUR, USD, GBP, SHKL.");
    }
}
