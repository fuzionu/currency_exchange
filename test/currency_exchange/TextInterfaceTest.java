package currency_exchange;

import org.junit.jupiter.api.Test;

class TextInterfaceTest extends StandardInputTest
{
    TextInterface textInterface = new TextInterface();

    @Test
    void shouldShowWelcomeMessage()
    {
        //given
        input();

        // when
        textInterface.start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type 'exchange' or 'exit'",
                "-> "
        );
    }

    @Test
    void shouldExit()
    {
        // given
        input("exit");

        // when
        textInterface.start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type 'exchange' or 'exit'",
                "-> Closing..."
        );
    }

    @Test
    void shouldShowCurrenciesMessage()
    {
        // given
        input();

        // when
        textInterface.start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type 'exchange' or 'exit'",
                "-> ",
                "Choose currencies to exchange:",
                "PLN, EUR, USD, GBP, SHKL.",
                "-> "
        );
    }

    @Test
    void shouldNotAllowInvalidInput()
    {
        // given
        input("wtf");

        // when
        textInterface.start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type 'exchange' or 'exit'",
                "-> ",
                "Wrong command.",
                "-> "
        );
    }
}