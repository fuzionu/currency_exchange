package currency_exchange;

import java.util.Scanner;

import static currency_exchange.MoneyFormatter.*;

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

        System.out.print("From: ");
        Currency from = getCurrency("From: ");

        System.out.print("To: ");
        Currency to = getCurrency("To: ");

        System.out.print("Amount: ");
        int amount = getAmount();

        return addComa(amount) + " " + from + " is " + addComa(exchanger.exchangeByCents(from, to, amount)) + " " + to + ".";
    }

    private int parseInt(String string)
    {
        if (!string.contains(".") && !string.contains(","))
        {
            return Integer.parseInt(string + "00");
        }

        else if (string.substring(string.length() - 1).equals(".") || string.substring(string.length() - 1).equals(","))
        {
            return Integer.parseInt(string.replace(",", "").replace(".", "") + "00");
        }

        return Integer.parseInt(string.replace(",", "").replace(".", ""));
    }

    private int getAmount()
    {
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

    private Currency getCurrency(String fromOrTo)
    {
        do
        {
            String input = scanner.nextLine().strip().toUpperCase();

            if (input.isEmpty())
            {
                System.out.print(fromOrTo);
                continue;
            }

            try
            {
                return Currency.valueOf(input);
            }
            catch (IllegalArgumentException exc)
            {
                System.out.print("Currency doesn't exist.\n" + fromOrTo);
            }

        } while (true);
    }
}
