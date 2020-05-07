package currency_exchange;

import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeTest extends StandardInputTest
{
    @Test
    void shouldExchangePlnToPln()
    {
        // given
        double actual = new Exchange().exchangeCurrency("pln", "pln", 1);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangePlnToEur()
    {
        // given
        double actual = new Exchange().exchangeCurrency("pln", "eur", 102);

        // then
        assertEquals(22.44, actual);
    }

    @Test
    void shouldExchangePlnToUsd()
    {
        // given
        double actual = new Exchange().exchangeCurrency("pln", "usd", 144);

        // then
        assertEquals(34.56, actual);
    }

    @Test
    void shouldExchangePlnToGbp()
    {
        // given
        double actual = new Exchange().exchangeCurrency("pln", "gbp", 31);

        // then
        assertEquals(5.89, actual);
    }

    @Test
    void shouldExchangePlnToShkl()
    {
        // given
        double actual = new Exchange().exchangeCurrency("pln", "shkl", 69);

        // then
        assertEquals(57.96, actual);
    }


    @Test
    void shouldExchangeEurToEur()
    {
        // given
        double actual = new Exchange().exchangeCurrency("eur", "eur", 1);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangeEurToPln()
    {
        // given
        double actual = new Exchange().exchangeCurrency("eur", "pln", 100);

        // then
        assertEquals(454.55, actual);
    }

    @Test
    void shouldExchangeEurToUsd()
    {
        // given
        double actual = new Exchange().exchangeCurrency("eur", "usd", 38);

        // then
        assertEquals(41.45, actual);
    }

    @Test
    void shouldExchangeEurToGbp()
    {
        // given
        double actual = new Exchange().exchangeCurrency("eur", "gbp", 23);

        // then
        assertEquals(19.86, actual);
    }

    @Test
    void shouldExchangeEurToShkl()
    {
        // given
        double actual = new Exchange().exchangeCurrency("eur", "shkl", 27);

        // then
        assertEquals(103.09, actual);
    }


    @Test
    void shouldExchangeUsdToUsd()
    {
        // given
        input("exchange", "usd", "usd", "1", "exit");

        // when
        double actual = new Exchange().exchangeCurrency("usd", "usd", 1);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangeUsdToPln()
    {
        // given
        double actual = new Exchange().exchangeCurrency("usd", "pln", 115);

        // then
        assertEquals(479.17, actual);
    }

    @Test
    void shouldExchangeUsdToEur()
    {
        // given
        double actual = new Exchange().exchangeCurrency("usd", "eur", 45);

        // then
        assertEquals(41.25, actual);
    }

    @Test
    void shouldExchangeUsdToGbp()
    {
        // given
        double actual = new Exchange().exchangeCurrency("usd", "gbp", 19);

        // then
        assertEquals(15.04, actual);
    }

    @Test
    void shouldExchangeUsdToShkl()
    {
        // given
        double actual = new Exchange().exchangeCurrency("usd", "shkl", 17.5);

        // then
        assertEquals(61.25, actual);
    }


    @Test
    void shouldExchangeGbpToGbp()
    {
        // given
        double actual = new Exchange().exchangeCurrency("gbp", "gbp", 1);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangeGbpToPln()
    {
        // given
        double actual = new Exchange().exchangeCurrency("gbp", "pln", 13);

        // then
        assertEquals(68.42, actual);
    }

    @Test
    void shouldExchangeGbpToEur()
    {
        // given
        double actual = new Exchange().exchangeCurrency("gbp", "eur", 31);

        // then
        assertEquals(35.89, actual);
    }

    @Test
    void shouldExchangeGbpToUsd()
    {
        // given
        double actual = new Exchange().exchangeCurrency("gbp", "usd", 50);

        // then
        assertEquals(63.16, actual);
    }

    @Test
    void shouldExchangeGbpToShkl()
    {
        // given
        double actual = new Exchange().exchangeCurrency("gbp", "shkl", 9);

        // then
        assertEquals(39.79, actual);
    }

    @Test
    void shouldExchangeShklToShkl()
    {
        // given
        double actual = new Exchange().exchangeCurrency("shkl", "shkl", 1);

        // then
        assertEquals(1, actual);
    }

    @Test
    void shouldExchangeShklToPln()
    {
        // given
        double actual = new Exchange().exchangeCurrency("shkl", "pln", 99);

        // then
        assertEquals(117.86, actual);
    }

    @Test
    void shouldExchangeShklToEur()
    {
        // given
        double actual = new Exchange().exchangeCurrency("shkl", "eur", 7);

        // then
        assertEquals(1.83, actual);
    }

    @Test
    void shouldExchangeShklToUsd()
    {
        // given
        double actual = new Exchange().exchangeCurrency("shkl", "usd", 20);

        // then
        assertEquals(5.71, actual);
    }


    @Test
    void shouldExchangeNegative()
    {
        // given
        double actual = new Exchange().exchangeCurrency("eur", "pln", -100);

        // then
        assertEquals(-454.55, actual);
    }

    @Test
    void shouldThrowIllegalArgumentException()
    {
        // given
        assertThrows(IllegalArgumentException.class, () -> new Exchange().exchangeCurrency("xD", "pln", 5));
    }
}