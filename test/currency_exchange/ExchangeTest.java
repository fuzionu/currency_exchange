package currency_exchange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static currency_exchange.Currencies.Currency.*;

class ExchangeTest extends StandardInputTest
{
    @Test
    void shouldExchangePlnToPln()
    {
        // given
        double actual = new Exchange().exchange(PLN, PLN, 1);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangePlnToEur()
    {
        // given
        double actual = new Exchange().exchange(PLN, EUR, 102);

        // then
        assertEquals(22.44, actual);
    }

    @Test
    void shouldExchangePlnToUsd()
    {
        // given
        double actual = new Exchange().exchange(PLN, USD, 144);

        // then
        assertEquals(34.56, actual);
    }

    @Test
    void shouldExchangePlnToGbp()
    {
        // given
        double actual = new Exchange().exchange(PLN, GBP, 31);

        // then
        assertEquals(5.89, actual);
    }

    @Test
    void shouldExchangePlnToShkl()
    {
        // given
        double actual = new Exchange().exchange(PLN, SHKL, 69);

        // then
        assertEquals(57.96, actual);
    }


    @Test
    void shouldExchangeEurToEur()
    {
        // given
        double actual = new Exchange().exchange(EUR, EUR, 1);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangeEurToPln()
    {
        // given
        double actual = new Exchange().exchange(EUR, PLN, 100);

        // then
        assertEquals(454.55, actual);
    }

    @Test
    void shouldExchangeEurToUsd()
    {
        // given
        double actual = new Exchange().exchange(EUR, USD, 38);

        // then
        assertEquals(41.45, actual);
    }

    @Test
    void shouldExchangeEurToGbp()
    {
        // given
        double actual = new Exchange().exchange(EUR, GBP, 23);

        // then
        assertEquals(19.86, actual);
    }

    @Test
    void shouldExchangeEurToShkl()
    {
        // given
        double actual = new Exchange().exchange(EUR, SHKL, 27);

        // then
        assertEquals(103.09, actual);
    }


    @Test
    void shouldExchangeUsdToUsd()
    {
        // given
        input("exchange", "usd", "usd", "1", "exit");

        // when
        double actual = new Exchange().exchange(USD, USD, 1);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangeUsdToPln()
    {
        // given
        double actual = new Exchange().exchange(USD, PLN, 115);

        // then
        assertEquals(479.17, actual);
    }

    @Test
    void shouldExchangeUsdToEur()
    {
        // given
        double actual = new Exchange().exchange(USD, EUR, 45);

        // then
        assertEquals(41.25, actual);
    }

    @Test
    void shouldExchangeUsdToGbp()
    {
        // given
        double actual = new Exchange().exchange(USD, GBP, 19);

        // then
        assertEquals(15.04, actual);
    }

    @Test
    void shouldExchangeUsdToShkl()
    {
        // given
        double actual = new Exchange().exchange(USD, SHKL, 17.5);

        // then
        assertEquals(61.25, actual);
    }


    @Test
    void shouldExchangeGbpToGbp()
    {
        // given
        double actual = new Exchange().exchange(GBP, GBP, 1);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangeGbpToPln()
    {
        // given
        double actual = new Exchange().exchange(GBP, PLN, 13);

        // then
        assertEquals(68.42, actual);
    }

    @Test
    void shouldExchangeGbpToEur()
    {
        // given
        double actual = new Exchange().exchange(GBP, EUR, 31);

        // then
        assertEquals(35.89, actual);
    }

    @Test
    void shouldExchangeGbpToUsd()
    {
        // given
        double actual = new Exchange().exchange(GBP, USD, 50);

        // then
        assertEquals(63.16, actual);
    }

    @Test
    void shouldExchangeGbpToShkl()
    {
        // given
        double actual = new Exchange().exchange(GBP, SHKL, 9);

        // then
        assertEquals(39.79, actual);
    }

    @Test
    void shouldExchangeShklToShkl()
    {
        // given
        double actual = new Exchange().exchange(SHKL, SHKL, 1);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangeShklToPln()
    {
        // given
        double actual = new Exchange().exchange(SHKL, PLN, 99);

        // then
        assertEquals(117.86, actual);
    }

    @Test
    void shouldExchangeShklToEur()
    {
        // given
        double actual = new Exchange().exchange(SHKL, EUR, 7);

        // then
        assertEquals(1.83, actual);
    }

    @Test
    void shouldExchangeShklToUsd()
    {
        // given
        double actual = new Exchange().exchange(SHKL, USD, 20);

        // then
        assertEquals(5.71, actual);
    }


    @Test
    void shouldExchangeNegative()
    {
        // given
        double actual = new Exchange().exchange(EUR, PLN, -100);

        // then
        assertEquals(-454.55, actual);
    }
}