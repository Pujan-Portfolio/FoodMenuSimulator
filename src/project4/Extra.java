package project4;

/**
 * This class is used as an object for our extras object.
 */
public class Extra
{
    String name;

    /**
     * This constructor will set the name for the extra.
     * @param input The input name given for the extra.
     */
    public Extra(String input)
    {
        name = input;
    }

    /**
     * Checks to see if we have already  added the chosen extra to the list.
     * @param o Another extra object to check for duplication.
     * @return Returns a boolean on whether the extras are the same.
     */
    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Extra)
        {
            return ((Extra) o).name.equals(this.name);
        }
        return false;
    }
}
