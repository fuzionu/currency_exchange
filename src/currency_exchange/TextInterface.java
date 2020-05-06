package currency_exchange;

import java.util.Scanner;

public class TextInterface
{
    private Scanner scanner = new Scanner(System.in);

    public void start()
    {
        do
        {
            welcomeMessage();

            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit"))
            {
                System.out.println("Closing...");
                break;
            }

            else if (command.equalsIgnoreCase("exchange"))
            {
                System.out.println("Money will be exchanged soon...");
            }
        }
        while (true);
    }

    private void welcomeMessage()
    {
        System.out.println("\nCurrency exchanger v. 0.3.1\nType 'exchange' or 'exit'");
        System.out.print("-> ");
    }
}
