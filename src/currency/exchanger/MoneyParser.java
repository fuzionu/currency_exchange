package currency.exchanger;

public class MoneyParser
{
    public static int parseInt(String string)
    {
        if (!string.contains(".") && !string.contains(","))
        {
            return Integer.parseInt(string + "00");
        }

        else if (string.substring(string.length() - 1).equals(".") || string.substring(string.length() - 1).equals(","))
        {
            return Integer.parseInt(string.replace(",", "").replace(".", "") + "00");
        }

        return Integer.parseInt(string.replace(",", "").replace(".", ""));
    }
}
