package currency.exchanger;

interface Exchanger
{
    int exchange(Currency from, Currency to, int amount);
}
