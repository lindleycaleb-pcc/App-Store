import java.util.ArrayList;
import java.util.Iterator;
import java.util.*; 
    
    /**
     * An app store containing apps
     * 
     * Modifications:
     * CT: Create AppStore with a list of apps and basic methods to add, clear, and print apps
     *
     * @author Cara Tang
     * @version 2018.02.17
     */
    public class AppStore
    {
    private String appStoreName;
    private ArrayList<App> appList;
    
    /**
     * Create an app store with the given name
     * @param name the name of this app store
     */
    public AppStore(String name)
    {
        appStoreName = name;
        appList = new ArrayList<App>();
    }
    
    /**
     * Populate the store with a few apps.
     * Use this method to make testing easier. After creating an AppStore,
     * call this method to populate the apps, and then test your methods.
     */
    public void populateApps()
    {
        addApp("Pandora Music", "Pandora", 0);
        addApp(new App("Minecraft", "Mojang", 6.99, 3));
        // TODO: ------------------------ 1 --------------------------
        // TODO: Add a few more apps.
        addApp(new App("Instagram", "Facebook", 4.99, 2));
        addApp(new App("Tiny Tower", "NimbleBit", 0, 1));
        addApp(new App("Gmail", "Google", 0, 4));
    }
    
    /**
     * Add the given app to the app store
     * @param anApp an app to add
     */
    public void addApp(App anApp)
    {
        appList.add(anApp);
    }
    
    /**
     * Create an app with the given name, author, and price and add it to the store.
     * The app starts out unrated.
     * @param name name of the app
     * @param author the app author
     * @param price the price of the app
     */
    public void addApp(String name, String author, double price)
    {
        appList.add(new App(name, author, price));
    }
    
    /**
     * @return the number of apps in the store
     */
    public int getNumberOfApps()
    {
        return appList.size();
    }
    
    /**
     * Removes all the apps from the store
     */
    public void clearAppStore()
    {
        appList.clear();
    }
    
    /**
     * Print all the apps in the store
     */
    public void printAppList()
    {
        System.out.println("============= " + appStoreName + " =============");
        if (appList.size() == 0) {
            System.out.println("No apps in the store");
        }
        else {
            for (App currentApp : appList) {
                currentApp.printAppInfo();
            }
        }
        System.out.println("===========================================");
    }

    /**
     * Find an app based on its name
     * @param name the name of the app to search for
     * @return the app with the given name
     *         or null if there is no app with that name
     */
    public App findApp(String name)
    {
        App result = null;
        Iterator i = appList.iterator();
        while (result == null && i.hasNext())
        {
            App temp = (App) i.next();
            if (temp.getName() == name) 
            {
                result = temp;
            }
        }
        return result;
    }
        
    /**
     * Remove an app based on its name
     * @param name the name of the app to remove
     * @return the app removed with the given name 
     *         or return null if there is no app with that name
     */
    public App removeApp(String removeApp)
    {
        App app = null;
        app = findApp(removeApp);
        if (app != null) {
            appList.remove(app);
        }
        return app;
    }   
    
    /**
     * Gets apps sorted by author name
     * @param name the authors name to sort
     * @return the new list of apps sorted by author name
     */
    public ArrayList<App> getAppsByAuthor(String authorName)
    {
        ArrayList<App> byAuthor = new ArrayList<App>();
        for (App app : appList) {
            if (app.getAuthor() == authorName ) {
            byAuthor.add(app);
            } 
        }
        return byAuthor;
    }
    
    /**
     * Takes a rating parameter and returns number of apps with rating
     * @param integer rating to compare with appList
     * @return the new list of apps returned by rating
     */
    public ArrayList<App> getNumAppsWithRating(int rating)
    {
        ArrayList<App> byRating = new ArrayList<App>();
        for (App app : appList) {
            if (app.getRating() == rating ) {
            byRating.add(app);
            } 
        }
        return byRating;
    }
    
    /**
     * Print method to display AppStore information
     */
    public void printAppStoreSummaryStats()
    {
        System.out.println("======== SUMMARY STATS for " + appStoreName + " App Store ========");
        System.out.println("Total # of apps: " + appList.size());
        System.out.println("# apps rated 4: " + getNumAppsWithRating(4).size());
        System.out.println("# apps rated 3: " + getNumAppsWithRating(3).size());
        System.out.println("# apps rated 2: " + getNumAppsWithRating(2).size());
        System.out.println("# apps rated 1: " + getNumAppsWithRating(1).size());
        System.out.println("# of unrated apps: " + getNumAppsWithRating(0).size());
        System.out.println("===========================================");
    }
}
