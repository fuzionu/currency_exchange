package currency.exchanger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyParserTest
{
    @Test
    void shouldAddTwoZerosWhenNoDotOrComma() throws InvalidMoneyFormatException
    {
        // given
        String money = "13";
        MoneyParser moneyParser = new MoneyParser();

        // when
        int actual = moneyParser.parseInt(money);

        // then
        assertEquals(1300, actual);
    }

    @Test
    void shouldAddTwoZerosWhenDotIsAtTheEnd() throws InvalidMoneyFormatException
    {
        // given
        String money = "13.";
        MoneyParser moneyParser = new MoneyParser();

        // when
        int actualDot = moneyParser.parseInt(money);

        // then
        assertEquals(1300, actualDot);
    }

    @Test
    void shouldAddTwoZerosWhenCommaIsAtTheEnd() throws InvalidMoneyFormatException
    {
        // given
        String money = "12,";
        MoneyParser moneyParser = new MoneyParser();

        // when
        int actualDot = moneyParser.parseInt(money);

        // then
        assertEquals(1200, actualDot);
    }

    @Test
    void shouldReplaceDot() throws InvalidMoneyFormatException
    {
        // given
        String money = "10.00";
        MoneyParser moneyParser = new MoneyParser();

        // when
        int actual = moneyParser.parseInt(money);

        // then
        assertEquals(1000, actual);
    }

    @Test
    void shouldReplaceComma() throws InvalidMoneyFormatException
    {
        // given
        String money = "15,00";
        MoneyParser moneyParser = new MoneyParser();

        // when
        int actual = moneyParser.parseInt(money);

        // then
        assertEquals(1500, actual);
    }

    @Test
    void shouldParseMoney() throws InvalidMoneyFormatException
    {
        // given
        String money = "13,14";
        MoneyParser moneyParser = new MoneyParser();

        // when
        int actual = moneyParser.parseInt(money);

        // then
        assertEquals(1314, actual);
    }

    @Test
    void shouldNotAllowCommaOnly()
    {
        // given
        String money = ",";
        MoneyParser moneyParser = new MoneyParser();

        // then
        assertThrows(NumberFormatException.class, () -> moneyParser.parseInt(money));
    }

    @Test
    void shouldNotAllowEmptyString()
    {
        // given
        String money = "";
        MoneyParser moneyParser = new MoneyParser();

        // then
        assertThrows(NumberFormatException.class, () -> moneyParser.parseInt(money));
    }

    @Test
    void shouldNotAllowDotOnly()
    {
        // given
        String money = ".";
        MoneyParser moneyParser = new MoneyParser();

        // then
        assertThrows(NumberFormatException.class, () -> moneyParser.parseInt(money));
    }

    @Test
    void shouldNotAllowWhitespace()
    {
        // given
        String money = " ";
        MoneyParser moneyParser = new MoneyParser();

        // then
        assertThrows(NumberFormatException.class, () -> moneyParser.parseInt(money));
    }

    @Test
    void shouldNotAllowNonDigitString()
    {
        // given
        String money = "!@#$%";
        MoneyParser moneyParser = new MoneyParser();

        // then
        assertThrows(NumberFormatException.class, () -> moneyParser.parseInt(money));
    }

    @Test
    void shouldNotAllowMoreThanTwoDigitsAfterComma()
    {
        // given
        String money = "13,123456";
        MoneyParser moneyParser = new MoneyParser();

        // then
        assertThrows(InvalidMoneyFormatException.class, () -> moneyParser.parseInt(money));
    }
}