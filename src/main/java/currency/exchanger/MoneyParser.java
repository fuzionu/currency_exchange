package currency.exchanger;

import static java.lang.Integer.parseInt;

public class MoneyParser {
    public int parseMoney(String money) {
        if (money.matches("^\\d+$")) {
            return parse(money + "00");
        }
        if (money.matches("^\\d+[,.]?$")) {
            return parse(money.replaceAll("[.,]", "") + "00");
        }
        if (money.matches("\\d*[.,](\\d\\d)?")) {
            return parse(money.replaceAll("[.,]", ""));
        }
        throw new InvalidMoneyFormatException();
    }

    private int parse(String string) {
        if (string.isEmpty()) {
            throw new InvalidMoneyFormatException();
        }
        return parseInt(string);
    }
}
