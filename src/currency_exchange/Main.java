package currency_exchange;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        new TextInterface().start(new Scanner(System.in), new Exchanger());
    }
}
