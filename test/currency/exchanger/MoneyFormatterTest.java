package currency.exchanger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyFormatterTest
{
    @Test
    void shouldPutComaTwoSpaceFromEnd_BigAmount()
    {
        // given
        int groshen = 254127;

        // when
        String actual = MoneyFormatter.formatMoney(groshen);

        // then
        assertEquals("2541.27", actual);
    }

    @Test
    void shouldPutComaTwoSpacesFromEnd_SmallAmount_OneDigit()
    {
        // given
        int groshen = 8;

        // when
        String actual = MoneyFormatter.formatMoney(groshen);

        // then
        assertEquals("0.08", actual);
    }

    @Test
    void shouldPutComaTwoSpacesFromEnd_SmallAmount_TwoDigits()
    {
        // given
        int groshen = 10;

        // when
        String actual = MoneyFormatter.formatMoney(groshen);

        // then    
        assertEquals("0.10", actual);
    }

    @Test
    void shouldPutComaTwoSpacesFromEnd_SmallAmount_ThreeDigits()
    {
        // given
        int groshen = 153;

        // when
        String actual = MoneyFormatter.formatMoney(groshen);

        // then
        assertEquals("1.53", actual);
    }

    @Test
    void shouldFormatZeroMoney()
    {
        // given
        int groshen = 0;

        // when
        String actual = MoneyFormatter.formatMoney(groshen);

        // then
        assertEquals("0.00", actual);
    }

    @Test
    void shouldFormatNegativeMoney()
    {
        // given
        int groshen = -122;

        // when
        String actual = MoneyFormatter.formatMoney(groshen);

        // then
        assertEquals("-1.22", actual);
    }
}