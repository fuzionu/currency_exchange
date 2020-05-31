package currency.exchanger;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class API
{
    public Map<Currency, Double> getFactors() throws IOException
    {
        Map map = new ObjectMapper().readValue(new URL("https://api.exchangeratesapi.io/latest"), Map.class);
        return (Map) map.get("rates");
    }
}
