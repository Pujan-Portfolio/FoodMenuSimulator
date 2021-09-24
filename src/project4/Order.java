package project4;

import java.util.ArrayList;

/**
 * This class will be used as an object to store our "Order".
 * Every order will contain an array list of separate sandwiches.
 * It will also store the different line numbers of each sandwich.
 */
public class Order implements Customizable
{
    public static int lineNumber;
    private ArrayList<OrderLine> orderlines;

    /**
     * This is a constructor to initialize the orderLines orderlist and set the linenumber to 1.
     */
    public Order( )
    {
        orderlines = new ArrayList<OrderLine>();
        lineNumber = 1;
    }

    /**
     * This method will take in a sandwich passed in as an object.
     * Check to see if it is a sandwich object.
     * It will then add it to the ArrayList of orderlines and update the lineNumber value.
     * @param obj This will be our sandwiches passed in.
     * @return This will return a boolean depending on if we added the sandwich to the list.
     */
    @Override
    public boolean add(Object obj)
    {
        if (!(obj instanceof OrderLine))
        {
            return false;
        }
        else
        {
            ((OrderLine) obj).setIndex(lineNumber);
            lineNumber++;
            orderlines.add((OrderLine)obj);
        }
        return true;
    }

    /**
     * This method will take in a sandwich passed in as an object.
     * Check to see if it is a sandwich object.
     * It will then check to see if the specific sandwich is in the list and remove it if it is.
     * @param obj This will be our sandwiches passed in.
     * @return This will return a boolean depending on if we removed the sandwich to the list.
     */
    @Override
    public boolean remove(Object obj)
    {
        int index = 0;
        if (!(obj instanceof OrderLine))
        {
            return false;
        }
        else if ((index = orderlines.indexOf((OrderLine)obj) ) != -1)
        {
            orderlines.remove(obj);
            for (int i = index; i < orderlines.size(); i++)
            {
                OrderLine temp = orderlines.get(i);
                temp.setIndex(temp.getIndex()-1);
                orderlines.set(i, temp);
            }
            lineNumber--;
        }
        return true;
    }

    /**
     * This is a helper method to return out list.
     * @return Returns the current order list.
     */
    public ArrayList<OrderLine> getList()
    {
        return orderlines;
    }
}
