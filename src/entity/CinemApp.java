package entity;

import java.util.ArrayList;

/**
 *
 * @author juanc
 */
public class CinemApp {

    public static int[] getPrices2D() {
        return prices2D;
    }

    public static int[] getPrices3D() {
        return prices3D;
    }

    /**
     * @param args the command line arguments
     */
    private Theater cinema;
    private ArrayList<Movie> listings;

    private final static int[] prices2D = {10000, 12500, 15000};
    private final static int[] prices3D = {15000, 20000, 25000}; // {PRICE_GA, PRICE_VIP, PRICE_4DX}

    public CinemApp() {
        // THEATER_NUKE
        this.cinema = new Theater();
    }

    public Theater getCinema() {
        return cinema;
    }

    public void setCinema(Theater cinema) {
        this.cinema = cinema;
    }

    public ArrayList<Movie> getListings() {
        return listings;
    }

    public void setListings(ArrayList<Movie> listings) {
        this.listings = listings;
    }

    public void addMovie(Movie u) {
        listings.add(u);
    }

}
