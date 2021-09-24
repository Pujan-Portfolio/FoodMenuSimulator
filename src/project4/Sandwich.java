package project4;

import java.util.ArrayList;

/**
 * This is a class for our sandwich object.
 * Every sandwich stores a base price, extraPrice, MAX_EXTRAS, PER_EXTRA, and a list of extras.
 */
public abstract class Sandwich implements Customizable
{
    double basePrice;
    double extraPrice = 0;
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extra> extras;

    public abstract double price();
    public abstract double getBasePrice();
    public abstract double getExtraPrice();

    /**
     * A constructor to set extraPrice to 0 and initialize our extras list.
     */
    public Sandwich()
    {
        extraPrice = 0;
        extras = new ArrayList<Extra>();
    }

    /**
     * An override method to return sandwich.
     * This will never be called and will be overwritten by its children.
     * @return Returns sandwich as a string.
     */
    @Override
    public String toString()
    {
        return "sandwich";
    }

    /**
     * This is an ovverride method that will be used to add an extra to the extras list for the sandwich.
     * @param obj This obj will be an Extra object that will be used to put into the extra list.
     * @return Returns a boolean depending on if the extra was added to the list.
     */
    @Override
    public boolean add(Object obj)
    {
        if (obj instanceof Extra)
        {
            if (!extras.contains((Extra)obj) && extras.size() < MAX_EXTRAS)
            {
                extras.add((Extra)obj);
                updateExtraPrice();
                return true;
            }
        }
        return false;
    }
    /**
     * This is an ovverride method that will be used to remove an extra from extras list for the sandwich.
     * @param obj This obj will be an Extra object that will be used find in the extra list.
     * @return Returns a boolean depending on if the extra was remove from the list.
     */
    @Override
    public boolean remove(Object obj)
    {
        if (obj instanceof Extra)
        {
            if (extras.contains((Extra)obj))
            {
                extras.remove((Extra)obj);
                updateExtraPrice();
                return true;
            }
        }
        return false;
    }

    /**
     * This method will update the pride depending on the base price and amount of extras.
     */
    public void updateExtraPrice()
    {
        extraPrice = PER_EXTRA * extras.size();
    }

    /**
     * This method will return the extras list to be used elsewhere.
     * @return Returns the extras list from the object.
     */
    public ArrayList<Extra> getList()
    {
        return extras;
    }

    /**
     * This will set the extras list to a temporary one inputted from another class.
     * @param temp A separate list that will replace the current one.
     */
    public void setList(ArrayList<Extra> temp)
    {
        extras = temp;
        updateExtraPrice();
    }
}

