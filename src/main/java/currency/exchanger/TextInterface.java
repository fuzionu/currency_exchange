package currency.exchanger;

import java.util.Scanner;

import static currency.exchanger.MoneyFormatter.formatMoney;

public class TextInterface
{
    private final Scanner scanner;
    private final Exchanger exchanger;
    private final MoneyParser moneyParser;

    public TextInterface(Scanner scanner, Exchanger exchanger, MoneyParser moneyParser)
    {
        this.scanner = scanner;
        this.exchanger = exchanger;
        this.moneyParser = moneyParser;
    }

    public void start()
    {
        System.out.println(welcomeMessage());

        do
        {
            System.out.print("-> ");
            String command = scanner.nextLine().strip();

            if (command.isEmpty())
            {
                continue;
            }

            if (command.equalsIgnoreCase("exchange"))
            {
                System.out.println(exchange());
                System.out.println(welcomeMessage());
            }

            else if (command.equalsIgnoreCase("exit"))
            {
                System.out.println("Closing...");
                break;
            }

            else
            {
                System.out.println("Wrong command.\nUsable commands: `exchange` or `exit`.");
            }
        }
        while (true);
    }

    private String welcomeMessage() {
        return "\nCurrency exchanger v. 0.3.1\nType `exchange` or `exit`";
    }

    private String exchange()
    {
        System.out.println("Choose currency:\nPLN, EUR, USD, GBP, SHKL.");

        Currency from = promptCurrency("From: ");
        Currency to = promptCurrency("To: ");
        int amount = promptAmount();

        return formatMoney(amount) + " " + from + " is " + formatMoney(exchanger.exchange(from, to, amount)) + " " + to + ".";
    }

    private int promptAmount()
    {
        System.out.print("Amount: ");

        do
        {
            String input = scanner.nextLine().strip();

            if (input.isEmpty())
            {
                System.out.print("Amount: ");
                continue;
            }

            try
            {
                return moneyParser.parseMoney(input);
            }

            catch (InvalidMoneyFormatException exc)
            {
                System.out.print("Invalid number format.\nAmount: ");
            }

        } while (true);
    }

    private Currency promptCurrency(String promptTitle)
    {
        System.out.print(promptTitle);

        do
        {
            String input = scanner.nextLine().strip().toUpperCase();

            if (input.isEmpty())
            {
                System.out.print(promptTitle);
                continue;
            }

            try
            {
                return Currency.valueOf(input);
            }

            catch (IllegalArgumentException exc)
            {
                System.out.print("Currency doesn't exist.\n" + promptTitle);
            }

        } while (true);
    }
}
