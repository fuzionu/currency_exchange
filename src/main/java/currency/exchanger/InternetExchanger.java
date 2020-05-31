package currency.exchanger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class InternetExchanger implements Exchanger
{
    private final API api;

    public InternetExchanger(API api)
    {
        this.api = api;
    }

    @Override
    public int exchange(Currency from, Currency to, int amount)
    {
        try
        {
            return tryExchange(from, to, amount);
        }
        catch (MalformedURLException | JsonMappingException exc)
        {
            throw new RuntimeException();
        }
        catch (JsonParseException e)
        {
            throw new MalformedJsonException(e);
        }
        catch (IOException e)
        {
            throw new InternetConnectionFailException(e);
        }
    }

    private int tryExchange(Currency from, Currency to, int amount) throws IOException
    {
        Map factors = api.getFactors();

        double fromValue = (double) factors.get(from);
        double toValue = (double) factors.get(to);

        return (int) Math.round(toValue * amount / fromValue);
    }

    public static class InternetConnectionFailException extends RuntimeException
    {
        public InternetConnectionFailException(Throwable throwable)
        {
             super(throwable);
        }
    }

    public static class MalformedJsonException extends RuntimeException
    {
        public MalformedJsonException(Throwable throwable)
        {
            super(throwable);
        }
    }
}