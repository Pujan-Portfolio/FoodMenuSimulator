package project4;
/**
 * This class is will be our Chicken sandwich object.
 * This class extends sandwich.
 * @Authors Pujan Patel and Martin Colucci.
 */
public class Chicken extends Sandwich
{
    /**
     * This constructor will use super() to set the base price for the sandwich object's constructor to 8.99.
     */
    public Chicken()
    {
        super();
        basePrice = 8.99;
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
        StringBuilder temp = new StringBuilder("Chicken $" + String.format("%,.02f",price()) + "\n - Fried Chicken \n - Spicy Sauce \n - Pickles");
        for (Extra choices: extras)
        {
            temp.append("\n - ").append(choices.name).append(" $1.99");
        }
        return temp.toString();





select destination.trainID, destination.stopStation, destination.stopNumber from trainStops as destination
inner join (select trainID, max(stopNumber) as stopNo from trainStops group by trainID) as temp
on destination.trainID = temp.trainID
and destination.stopNumber = temp.stopNo;


select * from (select transitLineName, ts.trainID, stopStation as originID, st.stationName as originName, st.city as originCity, st.state as originState, destination as destinationID,  destination.stationName as destinationName, destination.city as destinationCity, destination.state as destinationState,  cast(date_sub(arrivalTime, interval travelTime minute) as date) as departureDate,  cast(date_sub(arrivalTime, interval travelTime minute) as time) as departureTime,  cast(arrivalTime as date) as arrivalDate,  cast(arrivalTime as time) as arrivalTime,  travelTime, fare from trainSchedules ts  inner join trainStops s  on ts.trainID = s.trainID  inner join (	select * from stations  inner join (select destination.trainID, stopStation as destination from trainStops as destination  inner join (select trainID, max(stopNumber) as stopNo from trainStops group by trainID) as temp  on destination.trainID = temp.trainID and destination.stopNumber = temp.stopNo) as dest  on  stations.stationID = dest.destination ) as destination  on  ts.trainID = destination.trainID  inner join stations st  on s.stopStation = st.stationID  where s.stopNumber = 1 ) as schedules  where  originCity like + originCityVal + and destinationCity like + destinationCityVal + and departureDate like + departureDateVal +  order by fare

    }
}
