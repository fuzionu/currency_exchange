package currency.exchanger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyParserTest
{
    @Test
    void shouldAddTwoZerosWhenNoDotOrComma()
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
    void shouldAddTwoZerosWhenDotIsAtTheEnd()
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
    void shouldAddTwoZerosWhenCommaIsAtTheEnd()
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
    void shouldParseMoneyWithDot()
    {
        // given
        String money = "10.29";
        MoneyParser moneyParser = new MoneyParser();

        // when
        int actual = moneyParser.parseInt(money);

        // then
        assertEquals(1029, actual);
    }

    @Test
    void shouldParseMoneyWithComma()
    {
        // given
        String money = "15,21";
        MoneyParser moneyParser = new MoneyParser();

        // when
        int actual = moneyParser.parseInt(money);

        // then
        assertEquals(1521, actual);
    }

    @Test
    void shouldNotAllowCommaOnly()
    {
        // given
        String money = ",";
        MoneyParser moneyParser = new MoneyParser();

        // then
        assertThrows(InvalidMoneyFormatException.class, () -> moneyParser.parseInt(money));
    }

    @Test
    void shouldNotAllowEmptyString()
    {
        // given
        String money = "";
        MoneyParser moneyParser = new MoneyParser();

        // then
        assertThrows(InvalidMoneyFormatException.class, () -> moneyParser.parseInt(money));
    }

    @Test
    void shouldNotAllowDotOnly()
    {
        // given
        String money = ".";
        MoneyParser moneyParser = new MoneyParser();

        // then
        assertThrows(InvalidMoneyFormatException.class, () -> moneyParser.parseInt(money));
    }

    @Test
    void shouldNotAllowWhitespace()
    {
        // given
        String money = " ";
        MoneyParser moneyParser = new MoneyParser();

        // then
        assertThrows(InvalidMoneyFormatException.class, () -> moneyParser.parseInt(money));
    }

    @Test
    void shouldNotAllowNonDigitString()
    {
        // given
        String money = "!@#$%";
        MoneyParser moneyParser = new MoneyParser();

        // then
        assertThrows(InvalidMoneyFormatException.class, () -> moneyParser.parseInt(money));
    }

    @Test
    void shouldNotAllowMoreThanTwoDigitsAfterComma()
    {
        // given
        String money = "13,123";
        MoneyParser moneyParser = new MoneyParser();

        // then
        assertThrows(InvalidMoneyFormatException.class, () -> moneyParser.parseInt(money));
    }
}