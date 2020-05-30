package currency.exchanger;

import java.io.IOException;
import java.util.Map;

public interface API
{
    Map getFactors() throws IOException;
}
