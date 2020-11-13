/**
 * An app for a mobile device
 * 
 * Modifications:
 * CL: replaced rating = appRating by calling method setRating and passing appRating
 * CL: updated setPrice to be greater than or equal to zero
 * CL: updated isFree() to return true if free, false if otherwise
 * CL: updated setRating() to a value between 0 and 5
 * CL: updated increaseRating to increase rating value by 1 if rating is lesser than 4
 * CL: updated decreaseRating to decrease rating value by 1 if rating is greater than 1
 * CL: updated printAppInfo() to include if the app is free or rated
 * 
 * @author Cara Tang and Caleb Lindley
 * @version 07.13.2020
 */
public class App
{
    private String name;
    private String author;
    private double price;
    private int rating; // valid ratings are 1-4 or 0 meaning not rated
    
    /**
     * Create an app with the given name, author, price, and rating
     * @param appName the app name
     * @param appAuthor the app author
     * @param appPrice the price of the app (0 if the app is free)
     * @call method setRating and pass appRating
     */
    public App(String appName, String appAuthor, double appPrice, int appRating)
    {
        name = appName;
        author = appAuthor;
        price = appPrice;
        setRating(appRating);

        // Question: Why do you think we want to replace the assignment statement with a call to setRating?
        // Your Answer: I think we needed to replace the assignment statement with a call to the setRating method to take an input from the user
        // with parameters. If I try and start with a rating of 5, it defaults to zero and prompts for a rating between 1 and 4. This makes it 
        // so the program doesn't crash when a number lower than one and higher than 5 is entered.
    }
    
    /**
     * Create an app with the given name, author, and price that is not rated
     * @param appName the app name
     * @param appAuthor the app author
     * @param appPrice the price of the app (0 if the app is free)
     */
    public App(String appName, String appAuthor, double appPrice)
    {
        name = appName;
        author = appAuthor;
        price = appPrice;
        rating = 0;
    }

    /**
     * @return the app name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return the app author
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * @return the app price
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * Set the price of this app to the value given
     * @if newPrice is greater than or equal to zero
     * @param newPrice new price for this app
     * @else print display "Error: Price must be greater than or equal to 0"
     */
    public void setPrice(double newPrice)
    {
        if (newPrice >= 0) {
            price = newPrice;
        }
        else {
            System.out.println("Error: Price must be greater than or equal to 0");
        }
    }
    
    /**
     * @return true if this app is free, false otherwise
     */
    public boolean isFree()
    {
        if (price == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @return the app rating
     */
    public int getRating()
    {
        return rating;
    }
    
    /**
     * Set the rating of this app to the value given
     * @if newRating is greater than 0 AND newRating is less than 5
     * @param newRating new rating for this app
     * @else print display "Rating must be an integer between 1 and 4."
     */
    public void setRating(int newRating)
    {
        if (newRating > 0 && newRating < 5) {
        rating = newRating;
        } else {
            System.out.println("Rating must be an integer between 1 and 4.");
        }
    }
    
    /**
     * Reset the rating of this app to not rated
     */
    public void resetRating()
    {
        rating = 0;
    }
    
    /**
     * Increase the rating of this app by 1
     */
    public void increaseRating()
    {
        if (rating < 4) {
        rating = rating + 1;
        }
    }
    
    /**
     * Decrease the rating of this app by 1
     */
    public void decreaseRating()
    {
        if (rating > 1) {
        rating = rating - 1;
        }
    }
    
    /**
     * Print information on this app
     */
    public void printAppInfo()
    {
        System.out.println("---------------------------------");
        System.out.println("App: " + name);
        System.out.println("Author: " + author);
        if (price == 0) {
            System.out.println("Price: FREE");
        } else {
        System.out.println("Price: $" + price);
        }
        if (rating == 0) {
            System.out.println("Rating: (not rated)");
        } else {
        System.out.println("Rating: " + rating);
        }
        System.out.println("---------------------------------");
    }
}
