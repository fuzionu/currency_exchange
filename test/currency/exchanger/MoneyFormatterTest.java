package currency.exchanger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyFormatterTest
{
    @Test
    void shouldPutComaTwoSpaceFromEnd()
    {
        // given
        int number = 254127;

        // when
        String actual = MoneyFormatter.formatMoney(number);

        // then
        assertEquals("2541.27", actual);
    }
}