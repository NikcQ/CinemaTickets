/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.ProjectionDAO;
import DAO.TicketDAO;
import entity.Movie;
import entity.Projection;
import entity.Screen;
import entity.Ticket;
//import entity.Theater;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class ManageProjection {

    private static final String PROJECTION_SUCCESS = "Projection successfully created.";

    //public static Theater theater = mainFrame.theater;
    // Traer 1 película
    public static Movie traerPeli(String titulo) {
        //cinemapp.setListings(movieDAO.readTable());
        Movie peli = new Movie();
        for (Movie mov : CinemApp.getListings()) {
            if (mov.getTitle().equals(titulo)) {
                peli = mov;
            }
        }
        return peli;
    }

    public static Screen traerScreen(String nomScr) {
        Screen pant = new Screen();
        //cinemapp.getCinema().setScreens(screenDAO.readTable());
        for (Screen scr : CinemApp.getScreens()) {
            if (scr.getName().equals(nomScr)) {
                pant = scr;
            }
        }
        return pant;
    }

    // RETRIEVAL METHODS
    public static ArrayList<Projection> getAllProjections() {
        return CinemApp.getProjections();
    }

    public static Projection getProjection(int index) {
        Projection projection = new Projection();
        for (Projection proj : getAllProjections()) {
            if (proj.getId() == index) {
                projection = proj;
            }
        }
        return projection;
    }

    public static Projection getProjection(String desc) {
        for (Projection proj : getAllProjections()) {
            if (proj.getDescription(true).equals(desc) || proj.getDescription(false).equals(desc)) {
                return proj;
            }
        }
        System.out.println("getProjection(String desc): projection not found.");
        return null;
    }

    public static ArrayList<Projection> filterProjectionsByDate(ArrayList<Projection> theProjections, LocalDate date) {
        ArrayList<Projection> sameDate = new ArrayList<Projection>();
        for (Projection p : theProjections) {
            if (p.getDate().isEqual(date)) {
                sameDate.add(p);
            }
        }

        return sameDate;
    }

    public static ArrayList<Projection> filterProjectionsByDate(ArrayList<Projection> theProjections, LocalDate start, LocalDate end) {
        ArrayList<Projection> validDate = new ArrayList<Projection>();
        for (Projection p : theProjections) {
            if (p.getDate().isEqual(start)
                    || (p.getDate().isAfter(start) && p.getDate().isBefore(end))
                    || p.getDate().isEqual(end)) {
                validDate.add(p);
            }
        }

        return validDate;
    }

    public static ArrayList<Projection> filterProjectionsByTitle(ArrayList<Projection> theProjections, String title) {
        ArrayList<Projection> sameTitle = new ArrayList<Projection>();
        for (Projection p : theProjections) {
            if (p.getMovie().getTitle().equals(title)) {
                sameTitle.add(p);
            }
        }

        return sameTitle;
    }

    public static ArrayList<String> getProjectionTitles(ArrayList<Projection> theProjections) {
        ArrayList<String> titles = new ArrayList<String>();
        for (Projection p : theProjections) {
            titles.add(p.getMovie().getTitle());
        }
        return titles;
    }

    public static ArrayList<String> getProjectionDescriptions(ArrayList<Projection> theProjections, boolean withDate) {
        ArrayList<String> descs = new ArrayList<String>();
        for (Projection p : theProjections) {
            descs.add(p.getDescription(withDate));
        }
        return descs;
    }

    public static boolean[][] getSeatBlock(Projection proj, String categ) {
        if (categ.equals("GA")) {
            return proj.getBlockGA();
        } else if (categ.equals("VIP")) {
            return proj.getBlockVIP();
        } else if (categ.equals("4DX")) {
            return proj.getBlock4DX();
        } else {
            return null;
        }
    }

    public static int getNumRowsFromBlock(boolean[][] block) {
        return block.length;
    }

    public static ArrayList<int[]> getEmptySeatsFromBlock(boolean[][] block, int row, int numSeats) {
        ArrayList<int[]> theSeats = new ArrayList<int[]>();
        for (int i = 0; i < block[row].length - numSeats + 1; i++) {
            int[] currentSeats = new int[numSeats];
            boolean flag = true;
            for (int j = 0; j < numSeats; j++) {
                if (!block[row][i + j]) {
                    currentSeats[j] = i + j + 1;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                theSeats.add(currentSeats);
            }
        }
        return theSeats;
    }

    // VERIFICATION METHODS BELOW
    public static String verifyProjection(String time, String date, boolean is3D, boolean is4D, String movieName, String screenName) {
        Movie peli = traerPeli(movieName);
        Screen pant = traerScreen(screenName);

        // Check  movie 3D
        if (is3D && !peli.isIs3D()) {
            return "The movie is not avaliable in 3D.";
        }
        // Check movie 4D and screen 4D
        if (is4D) {
            if (!peli.isIs4D()) {
                return "The movie is not avaliable in 4D.";
            } else if (pant.getCol4DX() == 0) {
                return "The screen does not have 4DX seats.";
            }
        }

        LocalDate pDate = LocalDate.parse(date);
        LocalTime pTime = LocalTime.parse(time);

        // Check if date is in past
        if (pDate.isBefore(LocalDate.now())) {
            return "The projection date has passed";
        } else if (pDate.isEqual(LocalDate.now()) && pTime.isBefore(LocalTime.now())) {
            return "The projection time has passed";

        } else if (pDate.isBefore(peli.getReleaseDate())) { // Check release date
            return "The projection date is before the movie release date";
        }
        Projection proj = new Projection(peli, pant, pDate, pTime, is3D, is4D);
        if (checkProjectionOverlap(proj)) {
            return "Projection overlapping";
        }
        if (!checkScreen(proj)) {
            return "This kind of projection is not allowed on this screen";
        }
        //mainFrame.cinemapp.getCinema().addProjection(proj);
        //ProjectionDAO pdao = new ProjectionDAO();
        ProjectionDAO.create(proj);
        return PROJECTION_SUCCESS;
    }

    //Verify if there is a projection in the same screen at the same time
    private static boolean checkProjectionOverlap(Projection projectiontocheck) {
        LocalTime initHour = LocalTime.parse("10:00");
        LocalTime finHour = LocalTime.parse("22:00");
        if (projectiontocheck.getTime().isBefore(initHour) || (projectiontocheck.getTime().isAfter(finHour))) {
            return true;
        }
        for (Projection proj : CinemApp.getProjections()) {
            if ((projectiontocheck.getScreen().getName().equals(proj.getScreen().getName())) && (projectiontocheck.getDate().equals(proj.getDate()))) {
                if (projectiontocheck.getTime().equals(proj.getTime()) || ((projectiontocheck.getTime().plusMinutes(projectiontocheck.getMovie().getRuntime())).isAfter(proj.getTime()) && (proj.getTime().isAfter(projectiontocheck.getTime())))) {
                    return true;
                }
                if (((proj.getTime().plusMinutes(proj.getMovie().getRuntime())).isAfter(projectiontocheck.getTime())) && (projectiontocheck.getTime().isAfter(proj.getTime()))) {
                    return true;
                }
            }
        }
        return false;
    }

    //Verify if this kind of projection is allowed
    private static boolean checkScreen(Projection projectiontocheck) {

        if (projectiontocheck.isIs3D() && !projectiontocheck.getScreen().isIs3D()) {
            // If proj is 3D and Screen isn't 3D
            return false;
        } else if (projectiontocheck.isIs4D() && projectiontocheck.getScreen().getRow4DX() == 0) {
            // If proj is 4D and 
            return false;
        }
        return true;
    }

    public static int[] fetchStats(Projection proj) {
        // {sold, total, soldGA, totalGA, soldVIP, totalVIP, sold4DX, total4DX}
        int[] stats = new int[8];

        Screen s = proj.getScreen();
        stats[3] = s.getColGA() * s.getRowGA();
        stats[5] = s.getColVIP() * s.getRowVIP();
        stats[7] = s.getCol4DX() * s.getRow4DX();
        stats[1] = stats[3] + stats[5] + stats[7];
        

        ArrayList<Ticket> tix = TicketDAO.readByProjection(proj);
        for (Ticket tick : tix) {
            switch (tick.getCategory()) {
                case "GA":
                    stats[3] += tick.getSeats().length; 
                    break;
                case "VIP":
                    stats[5] += tick.getSeats().length;
                    break;
                case "4DX":
                    stats[7] += tick.getSeats().length;
                    break;
            }
        }
        return stats;
    }
    
    
    public static int[] fetchStats(ArrayList<Projection> projs) {
        // {sold, total, soldGA, totalGA, soldVIP, totalVIP, sold4DX, total4DX}
        int[] totalStats = new int[8];
        for (Projection p: projs) {
            int[] stats = fetchStats(p);
            for (int i = 0; i < totalStats.length; i++) {
                totalStats[i] += stats[i];
            }
        }
        return totalStats;
    }

    public static String formatStats(int[] stats) {
        return "";

    }

    public static String getReport(ArrayList<Projection> filteredProj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String getReport(Projection proj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int[] stats = fetchStats(proj);
        return "\nSINGLE PROJECTION REPORT:\n\n" + formatStats(stats);
    }

}
