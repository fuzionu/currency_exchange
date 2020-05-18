package currency.exchanger;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

class TextInterfaceTest extends StandardInputTest
{
    @Test
    void shouldShowWelcomeMessageAndExit()
    {
        // given
        input("exit");
        TextInterface textInterface = new TextInterface(new Scanner(System.in), new Exchanger(), new MoneyParser());

        // when
        textInterface.start();
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
        TextInterface textInterface = new TextInterface(new Scanner(System.in), new Exchanger(), new MoneyParser());

        // when
        textInterface.start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Choose currency:",
                "PLN, EUR, USD, GBP, SHKL.",
                "From: To: Amount: 100.00 EUR is 454.54 PLN.",
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
        TextInterface textInterface = new TextInterface(new Scanner(System.in), new Exchanger(), new MoneyParser());

        // when
        textInterface.start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Wrong command.",
                "Usable commands: `exchange` or `exit`.",
                "-> Closing..."
        );
    }

    @Test
    void shouldContinueWithBlankInput()
    {
        // given
        input("", "  ", " ", "exit");
        TextInterface textInterface = new TextInterface(new Scanner(System.in), new Exchanger(), new MoneyParser());

        // when
        textInterface.start();

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
        TextInterface textInterface = new TextInterface(new Scanner(System.in), new Exchanger(), new MoneyParser());

        // when
        textInterface.start();

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
        TextInterface textInterface = new TextInterface(new Scanner(System.in), new Exchanger(), new MoneyParser());

        // when
        textInterface.start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Choose currency:",
                "PLN, EUR, USD, GBP, SHKL.",
                "From: Currency doesn't exist.",
                "From: To: Currency doesn't exist.",
                "To: Amount: 100.00 SHKL is 22.61 GBP.",
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
        TextInterface textInterface = new TextInterface(new Scanner(System.in), new Exchanger(), new MoneyParser());

        // when
        textInterface.start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Choose currency:",
                "PLN, EUR, USD, GBP, SHKL.",
                "From: From: To: Amount: 2.00 USD is 7.00 SHKL.",
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
        TextInterface textInterface = new TextInterface(new Scanner(System.in), new Exchanger(), new MoneyParser());

        // when
        textInterface.start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Choose currency:",
                "PLN, EUR, USD, GBP, SHKL.",
                "From: To: Amount: Not a number.",
                "Amount: 50.00 EUR is 227.27 PLN.",
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
        TextInterface textInterface = new TextInterface(new Scanner(System.in), new Exchanger(), new MoneyParser());

        // when
        textInterface.start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Choose currency:",
                "PLN, EUR, USD, GBP, SHKL.",
                "From: To: Amount: Amount: 1024.00 GBP is 5389.47 PLN.",
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Closing..."
        );
    }

    @Test
    void shouldExchangeValueWithComma()
    {
        // given
        input("exchange", "eur", "pln", "12.34", "exit");
        TextInterface textInterface = new TextInterface(new Scanner(System.in), new Exchanger(), new MoneyParser());

        // when
        textInterface.start();

        // then
        assertPrinted(
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Choose currency:",
                "PLN, EUR, USD, GBP, SHKL.",
                "From: To: Amount: 12.34 EUR is 56.09 PLN.",
                "",
                "Currency exchanger v. 0.3.1",
                "Type `exchange` or `exit`",
                "-> Closing...");
    }
}