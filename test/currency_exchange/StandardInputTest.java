package currency_exchange;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static java.lang.String.join;
import static java.lang.System.setIn;
import static java.lang.System.setOut;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardInputTest
{
    private ByteArrayOutputStream stream;

    protected void input(String... lines)
    {
        setIn(toStream(asList(lines)));
        stream = new ByteArrayOutputStream();
        setOut(new PrintStream(stream));
    }

    private ByteArrayInputStream toStream(List<String> text)
    {
        return new ByteArrayInputStream(join("\n", text).getBytes(UTF_8));
    }

    protected void assertPrinted(String... lines)
    {
        assertEquals(asList(lines), getPrintedLines());
    }

    private List<String> getPrintedLines()
    {
        String printedString = getPrintedString();
        return asList(printedString.split("\r?\n"));
    }

    private String getPrintedString()
    {
        try
        {
            stream.flush();
            return new String(stream.toByteArray());
        }
        catch (IOException exception)
        {
            throw new RuntimeException(exception);
        }
    }
}
