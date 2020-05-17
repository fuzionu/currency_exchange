package currency.exchanger;

import java.util.ArrayList;

public class MoneyParser
{
    private final ArrayList<String> forbiddenMarks = getForbiddenMarks();

    public int parseInt(String money) throws InvalidMoneyFormatException
    {
        if (containsForbiddenMarks(money))
        {
            throw new NumberFormatException();
        }

        else if (!money.contains(".") && !money.contains(","))
        {
            return Integer.parseInt(money + "00");
        }

        else if (money.substring(money.length() - 1).equals(".") || money.substring(money.length() - 1).equals(","))
        {
            return Integer.parseInt(money.replace(",", "").replace(".", "") + "00");
        }

        else if (money.contains(".") || money.contains(","))
        {
            if (countCharactersAfterComma(money))
            {
                throw new InvalidMoneyFormatException();
            }
        }

        return Integer.parseInt(money.replace(",", "").replace(".", ""));
    }

    private boolean countCharactersAfterComma(String string)
    {
        String[] arrOfStr = string.split("[.,]", 2);

        return arrOfStr[1].length() > 2;
    }

    private ArrayList<String> getForbiddenMarks()
    {
        ArrayList<String> arr = new ArrayList<>();

        arr.add(",");
        arr.add(".");
        arr.add("");
        arr.add(" ");

        return arr;
    }

    private boolean containsForbiddenMarks(String money)
    {
        return forbiddenMarks.contains(money);
    }
}
