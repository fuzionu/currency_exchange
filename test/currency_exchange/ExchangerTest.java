package currency_exchange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static currency_exchange.Currency.*;

class ExchangerTest extends StandardInputTest
{
    @Test
    void shouldExchangePlnToPln()
    {
        // given
        double actual = new Exchanger().exchangeByCents(PLN, PLN, 100);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangePlnToEur()
    {
        // given
        double actual = new Exchanger().exchangeByCents(PLN, EUR, 10200);

        // then
        assertEquals(22.44, actual);
    }

    @Test
    void shouldExchangePlnToUsd()
    {
        // given
        double actual = new Exchanger().exchangeByCents(PLN, USD, 14400);

        // then
        assertEquals(34.56, actual);
    }

    @Test
    void shouldExchangePlnToGbp()
    {
        // given
        double actual = new Exchanger().exchangeByCents(PLN, GBP, 3100);

        // then
        assertEquals(5.89, actual);
    }

    @Test
    void shouldExchangePlnToShkl()
    {
        // given
        double actual = new Exchanger().exchangeByCents(PLN, SHKL, 6900);

        // then
        assertEquals(57.96, actual);
    }


    @Test
    void shouldExchangeEurToEur()
    {
        // given
        double actual = new Exchanger().exchangeByCents(EUR, EUR, 100);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangeEurToPln()
    {
        // given
        double actual = new Exchanger().exchangeByCents(EUR, PLN, 10000);

        // then
        assertEquals(454.54, actual);
    }

    @Test
    void shouldExchangeEurToUsd()
    {
        // given
        double actual = new Exchanger().exchangeByCents(EUR, USD, 3800);

        // then
        assertEquals(41.45, actual);
    }

    @Test
    void shouldExchangeEurToGbp()
    {
        // given
        double actual = new Exchanger().exchangeByCents(EUR, GBP, 2300);

        // then
        assertEquals(19.86, actual);
    }

    @Test
    void shouldExchangeEurToShkl()
    {
        // given
        double actual = new Exchanger().exchangeByCents(EUR, SHKL, 2700);

        // then
        assertEquals(103.09, actual);
    }


    @Test
    void shouldExchangeUsdToUsd()
    {
        // given
        input("exchange", "usd", "usd", "1", "exit");

        // when
        double actual = new Exchanger().exchangeByCents(USD, USD, 100);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangeUsdToPln()
    {
        // given
        double actual = new Exchanger().exchangeByCents(USD, PLN, 11500);

        // then
        assertEquals(479.16, actual);
    }

    @Test
    void shouldExchangeUsdToEur()
    {
        // given
        double actual = new Exchanger().exchangeByCents(USD, EUR, 4500);

        // then
        assertEquals(41.25, actual);
    }

    @Test
    void shouldExchangeUsdToGbp()
    {
        // given
        double actual = new Exchanger().exchangeByCents(USD, GBP, 1900);

        // then
        assertEquals(15.04, actual);
    }

    @Test
    void shouldExchangeUsdToShkl()
    {
        // given
        double actual = new Exchanger().exchangeByCents(USD, SHKL, 1750);

        // then
        assertEquals(61.25, actual);
    }


    @Test
    void shouldExchangeGbpToGbp()
    {
        // given
        double actual = new Exchanger().exchangeByCents(GBP, GBP, 100);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangeGbpToPln()
    {
        // given
        double actual = new Exchanger().exchangeByCents(GBP, PLN, 1300);

        // then
        assertEquals(68.42, actual);
    }

    @Test
    void shouldExchangeGbpToEur()
    {
        // given
        double actual = new Exchanger().exchangeByCents(GBP, EUR, 3100);

        // then
        assertEquals(35.89, actual);
    }

    @Test
    void shouldExchangeGbpToUsd()
    {
        // given
        double actual = new Exchanger().exchangeByCents(GBP, USD, 5000);

        // then
        assertEquals(63.15, actual);
    }

    @Test
    void shouldExchangeGbpToShkl()
    {
        // given
        double actual = new Exchanger().exchangeByCents(GBP, SHKL, 900);

        // then
        assertEquals(39.78, actual);
    }

    @Test
    void shouldExchangeShklToShkl()
    {
        // given
        double actual = new Exchanger().exchangeByCents(SHKL, SHKL, 100);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangeShklToPln()
    {
        // given
        double actual = new Exchanger().exchangeByCents(SHKL, PLN, 9900);

        // then
        assertEquals(117.85, actual);
    }

    @Test
    void shouldExchangeShklToEur()
    {
        // given
        double actual = new Exchanger().exchangeByCents(SHKL, EUR, 700);

        // then
        assertEquals(1.83, actual);
    }

    @Test
    void shouldExchangeShklToUsd()
    {
        // given
        double actual = new Exchanger().exchangeByCents(SHKL, USD, 2000);

        // then
        assertEquals(5.71, actual);
    }


    @Test
    void shouldExchangeNegative()
    {
        // given
        double actual = new Exchanger().exchangeByCents(EUR, PLN, -10000);

        // then
        assertEquals(-454.54, actual);
    }
}