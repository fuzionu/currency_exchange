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
                "Type `exchange` or `exit`",
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
                "Type `exchange` or `exit`",
                "-> Choose currency:",
                "PLN, EUR, USD, GBP, SHKL.",
                "From: To: Amount: 100.0 EUR is 454.55 PLN.",
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
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
                "Type `exchange` or `exit`",
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
                "Type `exchange` or `exit`",
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
                "Type `exchange` or `exit`",
                "-> Closing..."
        );
    }

    @Test
    void shouldNotAllowWrongCurrencyInput()
    {
        // given
        input("exchange", "wtf", "shkl", "asd", "gbp", "100", "exit");

        // when
        new TextInterface().start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Choose currency:",
                "PLN, EUR, USD, GBP, SHKL.",
                "From: Currency doesn't exist.",
                "From: To: Currency doesn't exist.",
                "To: Amount: 100.0 SHKL is 22.62 GBP.",
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Closing..."
        );
    }

    @Test
    void shouldContinueWithBlankCurrencyInput()
    {
        // given
        input("exchange", " ", "usd", "shkl", "2", "exit");

        // when
        new TextInterface().start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Choose currency:",
                "PLN, EUR, USD, GBP, SHKL.",
                "From: From: To: Amount: 2.0 USD is 7.0 SHKL.",
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Closing..."
        );
    }

    @Test
    void shouldNotAllowWrongCurrencyAmount()
    {
        // given
        input("exchange", "eur", "pln", "asd", "50", "exit");

        // when
        new TextInterface().start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Choose currency:",
                "PLN, EUR, USD, GBP, SHKL.",
                "From: To: Amount: Not a number.",
                "Amount: 50.0 EUR is 227.27 PLN.",
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Closing..."
        );
    }

    @Test
    void shouldContinueWithBlankCurrencyAmount()
    {
        // given
        input("exchange", "gbp", "pln", " ", "1024", "exit");

        // when
        new TextInterface().start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Choose currency:",
                "PLN, EUR, USD, GBP, SHKL.",
                "From: To: Amount: Amount: 1024.0 GBP is 5389.47 PLN.",
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Closing..."
        );
    }
}