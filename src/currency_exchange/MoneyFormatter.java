package currency_exchange;

public class MoneyFormatter
{
    public static String addComa(int result)
    {
        String stringResult = Integer.toString(result);
        StringBuilder stringBuilder = new StringBuilder(stringResult);

        stringBuilder.insert(stringResult.length() - 2, ".");

        return stringBuilder.toString();
    }
}
