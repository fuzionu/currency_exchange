package currency.exchanger;

import java.util.Scanner;

import static currency.exchanger.MoneyParser.parseInt;
import static currency.exchanger.MoneyFormatter.formatMoney;

public class TextInterface
{
    private final Scanner scanner;
    private final Exchanger exchanger;

    public TextInterface(Scanner scanner, Exchanger exchanger)
    {
        this.scanner = scanner;
        this.exchanger = exchanger;
    }

    public void start()
    {
        final String welcomeMessage = "\nCurrency exchanger v. 0.3.1\nType `exchange` or `exit`";

        System.out.println(welcomeMessage);

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
                System.out.println(welcomeMessage);
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

    private String exchange()
    {
        System.out.println("Choose currency:\nPLN, EUR, USD, GBP, SHKL.");

        Currency from = getCurrency("From: ");
        Currency to = getCurrency("To: ");
        int amount = getAmount();

        return formatMoney(amount) + " " + from + " is " + formatMoney(exchanger.exchangeByCents(from, to, amount)) + " " + to + ".";
    }

    private int getAmount()
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
                return parseInt(input);
            }

            catch (NumberFormatException exc)
            {
                System.out.print("Not a number. Amount: ");
            }

        } while (true);
    }

    private Currency getCurrency(String promptTitle)
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