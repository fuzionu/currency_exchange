package currency_exchange;

import org.junit.jupiter.api.Test;

class TextInterfaceTest extends StandardInputTest
{
    @Test
    void shouldShowWelcomeMessageAndExit()
    {
        // given
        input("exit");

        // when
        new TextInterface().start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type 'exchange' or 'exit'",
                "-> Closing..."
        );
    }

    @Test
    void shouldExchangeCurrency()
    {
        // given
        input("exchange", "EUR", "PLN", "100", "exit");

        // when
        new TextInterface().start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type 'exchange' or 'exit'",
                "-> Choose currency:",
                "PLN, EUR, USD, GBP, SHKL.",
                "From: To: Amount: 100.0 EUR is 454.55 PLN.",
                "",
                "Currency exchanger v. 0.3.1",
                "Type 'exchange' or 'exit'",
                "-> Closing..."
        );
    }

    @Test
    void shouldNotAllowInvalidInput()
    {
        // given
        input("wtf", "exit");

        // when
        new TextInterface().start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type 'exchange' or 'exit'",
                "-> Wrong command.",
                "-> Closing..."
        );
    }

    @Test
    void shouldContinueWithBlankInput()
    {
        // given
        input("", "  ", " ", "exit");

        // when
        new TextInterface().start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type 'exchange' or 'exit'",
                "-> -> -> -> Closing..."
        );
    }

    @Test
    void shouldStripInput()
    {
        // given
        input("  exit ");

        // when
        new TextInterface().start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type 'exchange' or 'exit'",
                "-> Closing..."
        );
    }
}