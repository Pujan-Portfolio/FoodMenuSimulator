package project4;

/**
 * This will be our OrderLine object.
 * Every orderline added to the orders list will contain a line number, sandwich type, and total price of the sandwich.
 * @Authors Pujan Patel and Martin Colucci.
 */
public class OrderLine
{
    private int lineNumber;
    private Sandwich sandwich;
    private double price;

    /**
     * Constructor to set the line number, sandwich type, and total price.
     * @param line Current order number.
     * @param san Current sandwich we are adding.
     * @param total Total price of the sandwich we are adding.
     */
    public OrderLine(int line, Sandwich san, double total)
    {
        lineNumber = line;
        sandwich = san;
        price = total;
    }

    /**
     * This method will return the line number of the current orderLine.
     * @return Returns line number as an int.
     */
    public int getIndex()
    {
        return lineNumber;
    }

    /**
     * Sets the current line number to the input.
     * @param index The line number we want to set our current to.
     */
    public void setIndex(int index)
    {
        lineNumber = index;
    }

    /**
     * It will return the current price so we can output it.
     * @return Returns the outputPrice as double.
     */
    public double outputPrice()
    {
        return price;
    }

    /**
     * This will return the current sandwich we are working with.
     * @return The current sandwich we are using.
     */
    public Sandwich getSandwich()
    {
        return sandwich;
    }
}

