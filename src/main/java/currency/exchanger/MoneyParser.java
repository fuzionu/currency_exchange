package currency.exchanger;

import java.util.ArrayList;
import java.util.List;

public class MoneyParser
{
    private final List<String> invalidMarks = getInvalidMarks();

    public int parseMoney(String money)
    {
        try
        {
            return tryParseMoney(money);
        }
        catch (NumberFormatException exc)
        {
            throw new InvalidMoneyFormatException();
        }
    }

    private int tryParseMoney(String money)
    {
        if (containsForbiddenMarks(money))
        {
            throw new InvalidMoneyFormatException();
        }

        if (!money.contains(".") && !money.contains(","))
        {
            return Integer.parseInt(money + "00");
        }

        if (money.substring(money.length() - 1).equals(".") || money.substring(money.length() - 1).equals(","))
        {
            return Integer.parseInt(money.replace(",", "").replace(".", "") + "00");
        }

        if (!validMoneyFormat(money))
        {
            throw new InvalidMoneyFormatException();
        }

        return Integer.parseInt(money.replace(",", "").replace(".", ""));
    }

    private boolean validMoneyFormat(String string)
    {
        return string.matches("\\d*([.,]\\d\\d)?");
    }

    private List<String> getInvalidMarks()
    {
        List<String> invalidMarks = new ArrayList<>();

        invalidMarks.add(",");
        invalidMarks.add(".");
        invalidMarks.add("");
        invalidMarks.add(" ");

        return invalidMarks;
    }

    private boolean containsForbiddenMarks(String money)
    {
        return invalidMarks.contains(money);
    }
}
