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

        return formatMoneyString(Integer.toString(money));
    }

    private static String formatMoneyString(String money)
    {
        StringBuilder stringBuilder = new StringBuilder(money);
        stringBuilder.insert(money.length() - 2, ".");

        return stringBuilder.toString();
    }
}
