package currency.exchanger;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        new TextInterface(new Scanner(System.in), new ConstantExchanger(), new MoneyParser()).start();
    }
}
