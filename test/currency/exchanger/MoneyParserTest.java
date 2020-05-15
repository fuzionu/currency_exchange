package currency.exchanger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyParserTest
{
    @Test
    void shouldAddTwoZerosWhenNoDotOrComma()
    {
        // given
        String string = "13";

        // when
        int actual = MoneyParser.parseInt(string);

        // then
        assertEquals(1300, actual);
    }

    @Test
    void shouldAddTwoZerosWhenDotIsAtTheEnd()
    {
        // given
        String stringDot = "13.";

        // when
        int actualDot = MoneyParser.parseInt(stringDot);

        // then
        assertEquals(1300, actualDot);
    }

    @Test
    void shouldAddTwoZerosWhenCommaIsAtTheEnd()
    {
        // given
        String stringDot = "12,";

        // when
        int actualDot = MoneyParser.parseInt(stringDot);

        // then
        assertEquals(1200, actualDot);
    }

    @Test
    void shouldReplaceDot()
    {
        // given
        String string = "10.00";

        // when
        int actual = MoneyParser.parseInt(string);

        // then
        assertEquals(1000, actual);
    }

    @Test
    void shouldReplaceComma()
    {
        // given
        String string = "15,00";

        // when
        int actual = MoneyParser.parseInt(string);

        // then
        assertEquals(1500, actual);
    }
}