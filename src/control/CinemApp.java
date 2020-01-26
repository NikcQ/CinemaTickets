package control;

import DAO.ClientDAO;
import DAO.MovieDAO;
import DAO.ProjectionDAO;
import DAO.ScreenDAO;
import DAO.TicketDAO;
import entity.Client;
import entity.Movie;
import entity.Projection;
import entity.Screen;
import entity.Ticket;
import java.util.ArrayList;

/**
 *
 * @author juanc
 */
public final class CinemApp {

    // {PRICE_GA, PRICE_VIP, PRICE_4DX}
    private final static int[] prices2D = {10000, 12500, 15000};
    private final static int[] prices3D = {15000, 20000, 25000};

    public static void cClient(Client c) {
        ClientDAO.create(c);
    }

    public static void cMovie(Movie m) {
        MovieDAO.create(m);
    }

    public static void cProjection(Projection p) {
        ProjectionDAO.create(p);
    }

    public static void cScreen(Screen s) {
        ScreenDAO.create(s);
    }

    public static void cTicket(Ticket t) {
        TicketDAO.create(t);
    }

    public static int[] get2DPrices() {
        return prices2D;
    }

    public static int[] get3DPrices() {
        return prices3D;
    }

    public static ArrayList<Client> getClients() {
        return ClientDAO.readTable();
    }

    public static ArrayList<Movie> getListings() {
        return MovieDAO.readTable();
    }

    public static ArrayList<Projection> getProjections() {
        return ProjectionDAO.readTable();
    }

    public static ArrayList<Screen> getScreens() {
        return ScreenDAO.readTable();
    }

    public static ArrayList<Ticket> getTickets() {
        return TicketDAO.readTable();
    }

    public static Client rClient(String ic) {
        return ClientDAO.read(ic);
    }

    public static Projection rProjection(Projection p) {
        return ProjectionDAO.read(p);
    }

    public static ArrayList<Ticket> rTicket(Projection p) {
        return TicketDAO.read(p);
    }

    public static boolean uClient(Client c, Client d) {
        return ClientDAO.update(c, d);
    }

    public static boolean uProjection(Projection p, Projection q) {
        return ProjectionDAO.update(p, q);
    }

    private CinemApp() {
    }

}
