package currency_exchange;

import java.util.Scanner;

public class TextInterface
{
    private Scanner scanner = new Scanner(System.in);
    Exchange exchange = new Exchange();

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
        String from = getStringInput("From: ");

        System.out.print("To: ");
        String to = getStringInput("To: ");

        System.out.print("Amount: ");
        double amount = getDoubleInput();

        return amount + " " + from + " is " + exchange.exchangeCurrency(from, to, amount) + " " + to + ".";
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
            String input = scanner.nextLine().strip().toUpperCase();

            for (int x = 0; x < exchange.currencies.size(); x++)
            {
                if (exchange.currencies.containsKey(input))
                {
                    return input.toUpperCase();
                }
            }

            if (input.isEmpty())
            {
                System.out.print(fromOrTo);
            }

            else if (!exchange.currencies.containsKey(input))
            {
                System.out.print("Currency doesn't exist.\n" + fromOrTo);
            }
        } while (true);
    }
}
