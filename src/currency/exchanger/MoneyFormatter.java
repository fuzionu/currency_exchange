package currency.exchanger;

public class MoneyFormatter
{
    public static String formatMoney(int integer)
    {
        String stringResult = Integer.toString(integer);
        StringBuilder stringBuilder = new StringBuilder(stringResult);

        stringBuilder.insert(stringResult.length() - 2, ".");

        return stringBuilder.toString();
    }
}
