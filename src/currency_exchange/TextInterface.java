package currency_exchange;

import java.util.Scanner;

import static currency_exchange.Currencies.*;

public class TextInterface
{
    private Scanner scanner;
    private Exchanger exchanger;

    public void start(Scanner scanner, Exchanger exchanger)
    {
        final String welcomeMessage = "\nCurrency exchanger v. 0.3.1\nType `exchange` or `exit`";
        this.scanner = scanner;
        this.exchanger = exchanger;

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

            else if (!command.equalsIgnoreCase("exchange") && !command.equalsIgnoreCase("exit"))
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
        double amount = getDoubleInput();

        return amount + " " + from + " is " + exchanger.exchange(from, to, amount) + " " + to + ".";
    }

    private double getDoubleInput()
    {
        do
        {
            String input = scanner.nextLine().strip();

            if (input.isEmpty())
            {
                System.out.print("Amount: ");
            }

            else
            {
                try
                {
                    return Double.parseDouble(input);
                }
                catch (NumberFormatException exc)
                {
                    System.out.print("Not a number.\nAmount: ");
                }
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
