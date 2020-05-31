package currency.exchanger;

import com.fasterxml.jackson.core.JsonParseException;
import currency.exchanger.InternetExchanger.InternetConnectionFailException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import static currency.exchanger.Currency.EUR;
import static currency.exchanger.Currency.GBP;
import static currency.exchanger.Currency.PLN;
import static currency.exchanger.Currency.SHKL;
import static currency.exchanger.Currency.USD;
import static currency.exchanger.InternetExchanger.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InternetExchangerTest
{
    @Test
    void shouldExchangePlnToPln()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(PLN, PLN, 100);

        // then
        assertEquals(100, actual);
    }

    @Test
    void shouldExchangePlnToEur()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(PLN, EUR, 10200);

        // then
        assertEquals(2244, actual);
    }

    @Test
    void shouldExchangePlnToUsd()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(PLN, USD, 14400);

        // then
        assertEquals(3456, actual);
    }

    @Test
    void shouldExchangePlnToGbp()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(PLN, GBP, 3100);

        // then
        assertEquals(589, actual);
    }

    @Test
    void shouldExchangePlnToShkl()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(PLN, SHKL, 6900);

        // then
        assertEquals(5796, actual);
    }


    @Test
    void shouldExchangeEurToEur()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(EUR, EUR, 100);

        // then
        assertEquals(100, actual);
    }

    @Test
    void shouldExchangeEurToPln()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(EUR, PLN, 10000);

        // then
        assertEquals(45455, actual);
    }

    @Test
    void shouldExchangeEurToUsd()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(EUR, USD, 3800);

        // then
        assertEquals(4145, actual);
    }

    @Test
    void shouldExchangeEurToGbp()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(EUR, GBP, 2300);

        // then
        assertEquals(1986, actual);
    }

    @Test
    void shouldExchangeEurToShkl()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(EUR, SHKL, 2700);

        // then
        assertEquals(10309, actual);
    }


    @Test
    void shouldExchangeUsdToUsd()
    {
        // when
        double actual = new InternetExchanger(mockApi()).exchange(USD, USD, 100);

        // then
        assertEquals(100, actual);
    }

    @Test
    void shouldExchangeUsdToPln()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(USD, PLN, 11500);

        // then
        assertEquals(47917, actual);
    }

    @Test
    void shouldExchangeUsdToEur()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(USD, EUR, 4500);

        // then
        assertEquals(4125, actual);
    }

    @Test
    void shouldExchangeUsdToGbp()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(USD, GBP, 1900);

        // then
        assertEquals(1504, actual);
    }

    @Test
    void shouldExchangeUsdToShkl()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(USD, SHKL, 1750);

        // then
        assertEquals(6125, actual);
    }


    @Test
    void shouldExchangeGbpToGbp()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(GBP, GBP, 100);

        // then
        assertEquals(100, actual);
    }

    @Test
    void shouldExchangeGbpToPln()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(GBP, PLN, 1300);

        // then
        assertEquals(6842, actual);
    }

    @Test
    void shouldExchangeGbpToEur()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(GBP, EUR, 3100);

        // then
        assertEquals(3589, actual);
    }

    @Test
    void shouldExchangeGbpToUsd()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(GBP, USD, 5000);

        // then
        assertEquals(6316, actual);
    }

    @Test
    void shouldExchangeGbpToShkl()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(GBP, SHKL, 900);

        // then
        assertEquals(3979, actual);
    }

    @Test
    void shouldExchangeShklToShkl()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(SHKL, SHKL, 100);

        // then
        assertEquals(100, actual);
    }

    @Test
    void shouldExchangeShklToPln()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(SHKL, PLN, 9900);

        // then
        assertEquals(11786, actual);
    }

    @Test
    void shouldExchangeShklToEur()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(SHKL, EUR, 700);

        // then
        assertEquals(183, actual);
    }

    @Test
    void shouldExchangeShklToUsd()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(SHKL, USD, 2000);

        // then
        assertEquals(571, actual);
    }


    @Test
    void shouldExchangeNegative()
    {
        // given
        double actual = new InternetExchanger(mockApi()).exchange(EUR, PLN, -10000);

        // then
        assertEquals(-45455, actual);
    }

    @Test
    void shouldThrowInternetConnectionFailException()
    {
        // given
        InternetExchanger exchanger = new InternetExchanger(mockApi(IOException.class));

        // when
        assertExactThrows(InternetConnectionFailException.class, () -> exchanger.exchange(PLN, EUR, 100));
    }

    @Test
    void shouldThrowMalformedJsonException()
    {
        // given
        InternetExchanger exchanger = new InternetExchanger(mockApi(JsonParseException.class));

        // when
        assertExactThrows(MalformedJsonException.class, () -> exchanger.exchange(PLN, EUR, 100));
    }

    @Test
    void shouldThrowRuntimeException()
    {
        // given
        InternetExchanger exchanger = new InternetExchanger(mockApi(MalformedURLException.class));

        // when
        assertExactThrows(RuntimeException.class, () -> exchanger.exchange(PLN, EUR, 100));
    }

    private void assertExactThrows(Class<? extends Exception> exceptionClass, Runnable runnable)
    {
        Exception exception = assertThrows(exceptionClass, runnable::run);
        assertEquals(exceptionClass, exception.getClass());
    }

    private API mockApi()
    {
        API api = mock(API.class);
        try
        {
            when(api.getFactors()).thenReturn(factors());
        }
        catch (IOException ignored)
        {

        }

        return api;
    }

    private API mockApi(Class<? extends Exception> exception)  {
        API api = mock(API.class);
        try
        {
            when(api.getFactors()).thenThrow(exception);
        }
        catch (IOException ignored) {
        }
        return api;
    }

    private Map<Currency, Double> factors()
    {
        Map<Currency, Double> factor = new HashMap<>();

        factor.put(PLN, 100.00);
        factor.put(EUR, 22.00);
        factor.put(USD, 24.00);
        factor.put(GBP, 19.00);
        factor.put(SHKL, 84.00);

        return factor;
    }
}