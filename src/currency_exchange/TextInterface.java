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
        String from = scanner.nextLine();

        System.out.print("To: ");
        String to = scanner.nextLine();

        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        return amount + " " + from.toUpperCase() + " is " + exchange.exchangeCurrency(from, to, amount) + " " + to.toUpperCase() + ".";
    }
}
