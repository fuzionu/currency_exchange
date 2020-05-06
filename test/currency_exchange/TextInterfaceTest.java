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
                "-> Closing ..."
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
                "-> ",
                "Choose currencies to exchange:",
                "PLN, EUR, USD, GBP, SHKL.",
                "From: ",
                "To: ",
                "100 EUR is 455.13 PLN.",
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
                "-> ",
                "Wrong command.",
                "-> Closing"
        );
    }
}