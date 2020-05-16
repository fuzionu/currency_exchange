package currency.exchanger;

public class MoneyFormatter
{
    public static String formatMoney(int money)
    {
        String stringResult = Integer.toString(money);
        StringBuilder stringBuilder = new StringBuilder(stringResult);

        if (money == 0)
        {
            stringBuilder.insert(stringResult.length(), "00");
            stringBuilder.insert(stringResult.length(), ".");
            return stringBuilder.toString();
        }

        else if (money >= 10 && money < 100)
        {
            stringBuilder.insert(0, "0.");
            return stringBuilder.toString();
        }

        else if (money < 10 && money > 0)
        {
            stringBuilder.insert(0, "0.0");
            return stringBuilder.toString();
        }

        stringBuilder.insert(stringResult.length() - 2, ".");
        return stringBuilder.toString();
    }
}
