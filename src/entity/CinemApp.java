package entity;

import java.util.ArrayList;

/**
 *
 * @author juanc
 */
public class CinemApp {

    /**
     * @param args the command line arguments
     */
    private Theater cinema;
    private ArrayList<Movie> listings;

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
