package project4;
/**
 * This class is will be our Fish sandwich object.
 * This class extends sandwich.
 * @Authors Pujan Patel and Martin Colucci.
 */
public class Fish extends Sandwich
{
    /**
     * This constructor will use super() to set the base price for the sandwich object's constructor to 12.99.
     */
    public Fish()
    {
        super();
        basePrice = 12.99;
    }
    /**
     * This is an override method that will return the price of this specific sandwich.
     * @return Returns total price as a double.
     */
    @Override
    public double price()
    {
        return basePrice + extraPrice;
    }
    /**
     * This is an override method that will return the base price of this specific sandwich.
     * @return Returns base price as a double.
     */
    @Override
    public double getBasePrice() {
        return basePrice;
    }
    /**
     * This is an override method that will return the price of extras for this specific sandwich.
     * @return Returns total price of extras as a double.
     */
    @Override
    public double getExtraPrice() {
        return extraPrice;
    }
    /**
     * THis is an override to the toString method that will return a string containing what type of sandwich and its basic ingredients.
     * @return Returns a string of sandwich type, basic ingredients, and price.
     */
    @Override
    public String toString()
    {
        StringBuilder temp = new StringBuilder("Fish $" + String.format("%,.02f",price()) + "\n - Grilled Snapper \n - Cilantro \n - Lime");
        for (Extra choices: extras)
        {
            temp.append("\n - ").append(choices.name).append(" $1.99");
        }
        return temp.toString();
    }
}
