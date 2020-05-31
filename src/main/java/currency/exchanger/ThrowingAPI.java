package currency.exchanger;

import java.io.IOException;
import java.util.Map;

public class ThrowingAPI implements API
{
    @Override
    public Map getFactors() throws IOException
    {
        throw new IOException();
    }
}
