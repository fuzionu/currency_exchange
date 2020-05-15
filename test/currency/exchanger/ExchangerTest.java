package currency.exchanger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static currency.exchanger.Currency.*;

class ExchangerTest extends StandardInputTest
{
    @Test
    void shouldExchangePlnToPln()
    {
        // given
        double actual = new Exchanger().exchangeByCents(PLN, PLN, 100);

        // then
        assertEquals(100, actual);
    }

    @Test
    void shouldExchangePlnToEur()
    {
        // given
        double actual = new Exchanger().exchangeByCents(PLN, EUR, 10200);

        // then
        assertEquals(2244, actual);
    }

    @Test
    void shouldExchangePlnToUsd()
    {
        // given
        double actual = new Exchanger().exchangeByCents(PLN, USD, 14400);

        // then
        assertEquals(3456, actual);
    }

    @Test
    void shouldExchangePlnToGbp()
    {
        // given
        double actual = new Exchanger().exchangeByCents(PLN, GBP, 3100);

        // then
        assertEquals(589, actual);
    }

    @Test
    void shouldExchangePlnToShkl()
    {
        // given
        double actual = new Exchanger().exchangeByCents(PLN, SHKL, 6900);

        // then
        assertEquals(5796, actual);
    }


    @Test
    void shouldExchangeEurToEur()
    {
        // given
        double actual = new Exchanger().exchangeByCents(EUR, EUR, 100);

        // then
        assertEquals(100, actual);
    }

    @Test
    void shouldExchangeEurToPln()
    {
        // given
        double actual = new Exchanger().exchangeByCents(EUR, PLN, 10000);

        // then
        assertEquals(45454, actual);
    }

    @Test
    void shouldExchangeEurToUsd()
    {
        // given
        double actual = new Exchanger().exchangeByCents(EUR, USD, 3800);

        // then
        assertEquals(4145, actual);
    }

    @Test
    void shouldExchangeEurToGbp()
    {
        // given
        double actual = new Exchanger().exchangeByCents(EUR, GBP, 2300);

        // then
        assertEquals(1986, actual);
    }

    @Test
    void shouldExchangeEurToShkl()
    {
        // given
        double actual = new Exchanger().exchangeByCents(EUR, SHKL, 2700);

        // then
        assertEquals(10309, actual);
    }


    @Test
    void shouldExchangeUsdToUsd()
    {
        // given
        input("exchange", "usd", "usd", "1", "exit");

        // when
        double actual = new Exchanger().exchangeByCents(USD, USD, 100);

        // then
        assertEquals(100, actual);
    }

    @Test
    void shouldExchangeUsdToPln()
    {
        // given
        double actual = new Exchanger().exchangeByCents(USD, PLN, 11500);

        // then
        assertEquals(47916, actual);
    }

    @Test
    void shouldExchangeUsdToEur()
    {
        // given
        double actual = new Exchanger().exchangeByCents(USD, EUR, 4500);

        // then
        assertEquals(4125, actual);
    }

    @Test
    void shouldExchangeUsdToGbp()
    {
        // given
        double actual = new Exchanger().exchangeByCents(USD, GBP, 1900);

        // then
        assertEquals(1504, actual);
    }

    @Test
    void shouldExchangeUsdToShkl()
    {
        // given
        double actual = new Exchanger().exchangeByCents(USD, SHKL, 1750);

        // then
        assertEquals(6125, actual);
    }


    @Test
    void shouldExchangeGbpToGbp()
    {
        // given
        double actual = new Exchanger().exchangeByCents(GBP, GBP, 100);

        // then
        assertEquals(100, actual);
    }

    @Test
    void shouldExchangeGbpToPln()
    {
        // given
        double actual = new Exchanger().exchangeByCents(GBP, PLN, 1300);

        // then
        assertEquals(6842, actual);
    }

    @Test
    void shouldExchangeGbpToEur()
    {
        // given
        double actual = new Exchanger().exchangeByCents(GBP, EUR, 3100);

        // then
        assertEquals(3589, actual);
    }

    @Test
    void shouldExchangeGbpToUsd()
    {
        // given
        double actual = new Exchanger().exchangeByCents(GBP, USD, 5000);

        // then
        assertEquals(6315, actual);
    }

    @Test
    void shouldExchangeGbpToShkl()
    {
        // given
        double actual = new Exchanger().exchangeByCents(GBP, SHKL, 900);

        // then
        assertEquals(3978, actual);
    }

    @Test
    void shouldExchangeShklToShkl()
    {
        // given
        double actual = new Exchanger().exchangeByCents(SHKL, SHKL, 100);

        // then
        assertEquals(100, actual);
    }

    @Test
    void shouldExchangeShklToPln()
    {
        // given
        double actual = new Exchanger().exchangeByCents(SHKL, PLN, 9900);

        // then
        assertEquals(11785, actual);
    }

    @Test
    void shouldExchangeShklToEur()
    {
        // given
        double actual = new Exchanger().exchangeByCents(SHKL, EUR, 700);

        // then
        assertEquals(183, actual);
    }

    @Test
    void shouldExchangeShklToUsd()
    {
        // given
        double actual = new Exchanger().exchangeByCents(SHKL, USD, 2000);

        // then
        assertEquals(571, actual);
    }


    @Test
    void shouldExchangeNegative()
    {
        // given
        double actual = new Exchanger().exchangeByCents(EUR, PLN, -10000);

        // then
        assertEquals(-45454, actual);
    }
}