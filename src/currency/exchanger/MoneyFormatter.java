package currency.exchanger;

public class MoneyFormatter
{
    public static String formatMoney(int money)
    {
        String stringResult = Integer.toString(money);
        StringBuilder stringBuilder = new StringBuilder(stringResult);

        stringBuilder.insert(stringResult.length() - 2, ".");

        return stringBuilder.toString();
    }
}
