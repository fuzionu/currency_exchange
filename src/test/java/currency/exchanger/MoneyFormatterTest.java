package currency.exchanger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyFormatterTest
{
    @Test
    void shouldPutComaTwoSpaceFromEnd_BigAmount()
    {
        // given
        int money = 254127;

        // when
        String actual = MoneyFormatter.formatMoney(money);

        // then
        assertEquals("2541.27", actual);
    }

    @Test
    void shouldPutComaTwoSpacesFromEnd_SmallAmount_OneDigit()
    {
        // given
        int money = 8;

        // when
        String actual = MoneyFormatter.formatMoney(money);

        // then
        assertEquals("0.08", actual);
    }

    @Test
    void shouldPutComaTwoSpacesFromEnd_SmallAmount_TwoDigits()
    {
        // given
        int money = 10;

        // when
        String actual = MoneyFormatter.formatMoney(money);

        // then    
        assertEquals("0.10", actual);
    }

    @Test
    void shouldPutComaTwoSpacesFromEnd_SmallAmount_ThreeDigits()
    {
        // given
        int money = 153;

        // when
        String actual = MoneyFormatter.formatMoney(money);

        // then
        assertEquals("1.53", actual);
    }

    @Test
    void shouldFormatZeroMoney()
    {
        // given
        int money = 0;

        // when
        String actual = MoneyFormatter.formatMoney(money);

        // then
        assertEquals("0.00", actual);
    }

    @Test
    void shouldFormatNegativeMoney()
    {
        // given
        int money = -122;

        // when
        String actual = MoneyFormatter.formatMoney(money);

        // then
        assertEquals("-1.22", actual);
    }

    @Test
    void shouldFormatNegativeMoneyTwoDigits()
    {
        // given
        int money = -12;

        // when
        String actual = MoneyFormatter.formatMoney(money);

        // then
        assertEquals("-0.12", actual);
    }

    @Test
    void shouldFormatNegativeMoneyOneDigits()
    {
        // given
        int money = -1;

        // when
        String actual = MoneyFormatter.formatMoney(money);

        // then
        assertEquals("-0.02", actual);
    }
}