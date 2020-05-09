package currency_exchange;

import java.util.Scanner;

public class TextInterface
{
    private Scanner scanner = new Scanner(System.in);
    Exchange exchange = new Exchange();

    public void start()
    {
        System.out.println("\nCurrency exchanger v. 0.3.1\nType 'exchange' or 'exit'");
        do
        {
            System.out.print("-> ");
            String command = scanner.nextLine();
            command = command.strip();

            if (command.isEmpty())
            {
                continue;
            }

            if (command.equalsIgnoreCase("exchange"))
            {
                System.out.println(exchange());
                System.out.println("\nCurrency exchanger v. 0.3.1\nType 'exchange' or 'exit'");
            }

            else if (command.equalsIgnoreCase("exit"))
            {
                System.out.println("Closing...");
                break;
            }

            else if (!command.equalsIgnoreCase("exchange") && !command.equalsIgnoreCase("exit"))
            {
                System.out.println("Wrong command.");
            }

        }
        while (true);
    }

    private String exchange()
    {
        System.out.println("Choose currency:\nPLN, EUR, USD, GBP, SHKL.");

        System.out.print("From: ");
        String from = getStringInput("From: ");

        System.out.print("To: ");
        String to = getStringInput("To: ");

        System.out.print("Amount: ");
        double amount = getDoubleInput();

        return amount + " " + from.toUpperCase() + " is " + exchange.exchangeCurrency(from, to, amount) + " " + to.toUpperCase() + ".";
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

    private String getStringInput(String fromOrTo)
    {
        do
        {
            String input = scanner.nextLine().toUpperCase().strip();

            for (int x = 0; x < exchange.currencies.size(); x++)
            {
                if (exchange.currencies.containsKey(input))
                {
                    return input;
                }
            }

            if (input.isEmpty())
            {
                System.out.print(fromOrTo);
            }

            else if (!exchange.currencies.containsKey(input))
            {
                System.out.print("Currency doesn't exist.\n");
                System.out.print(fromOrTo);
            }
        } while (true);
    }
}
