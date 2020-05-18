package currency.exchanger;

public class MoneyFormatter
{
    public static String formatMoney(int money)
    {
        if (money == 0)
        {
            return "0.00";
        }

        else if (money >= 10 && money < 100)
        {
            return "0." + money;
        }

        else if (money < 10 && money > 0)
        {
            return "0.0" + money;
        }

        return formatMoneyString(money);
    }

    private static String formatMoneyString(int money)
    {
        String stringResult = Integer.toString(money);
        StringBuilder stringBuilder = new StringBuilder(stringResult);
        stringBuilder.insert(stringResult.length() - 2, ".");

        return stringBuilder.toString();
    }
}
