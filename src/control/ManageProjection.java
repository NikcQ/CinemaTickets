/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Movie;
import entity.Projection;
import entity.Screen;
import entity.Ticket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public final class ManageProjection {

    private static final String PROJECTION_SUCCESS = "Projection successfully created.";

    private static boolean checkProjectionOverlap(Projection projectiontocheck) {
        //Verify if there is a projection in the same screen at the same time
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

    private static boolean checkScreen(Projection projectiontocheck) {
        //Verify if this kind of projection is allowed
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
        // Stats builder for a projection
        int[] stats = new int[8];
        // {sold, total, soldGA, totalGA, soldVIP, totalVIP, sold4DX, total4DX}
        Screen s = proj.getScreen();
        stats[3] = s.getColGA() * s.getRowGA();
        stats[5] = s.getColVIP() * s.getRowVIP();
        stats[7] = s.getCol4DX() * s.getRow4DX();
        stats[1] = stats[3] + stats[5] + stats[7];

        ArrayList<Ticket> tix = CinemApp.rTicket(proj);
        for (Ticket tick : tix) {
            int l = tick.getSeats().length;
            stats[0] += l;
            switch (tick.getCategory()) {
                case "GA":
                    stats[2] += l;
                    break;
                case "VIP":
                    stats[4] += l;
                    break;
                case "4DX":
                    stats[6] += l;
                    break;
            }
        }
        return stats;
    }

    public static int[] fetchStats(ArrayList<Projection> projs) {
        // Stats builder for a projection list
        int[] totalStats = new int[8];
        // {sold, total, soldGA, totalGA, soldVIP, totalVIP, sold4DX, total4DX}
        for (Projection p : projs) {
            int[] stats = fetchStats(p);
            for (int i = 0; i < totalStats.length; i++) {
                totalStats[i] += stats[i];
            }
        }
        return totalStats;
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

    public static String formatStats(int[] stats) {
        // Statistics string printer
        //System.out.println(Arrays.toString(stats));
        return "SOLD SEATS: " + (stats[1] == 0 ? "N/A"
                : trim(100.0 * stats[0] / stats[1]) + "%" + " (" + stats[0] + "/" + stats[1] + ")" + "\n"
                + "GA : " + (stats[3] == 0 ? "N/A"
                        : trim(100.0 * stats[2] / stats[3]) + "%" + " (" + stats[2] + "/" + stats[3] + ")") + "\n"
                + "VIP: " + (stats[5] == 0 ? "N/A"
                        : trim(100.0 * stats[4] / stats[5]) + "%" + " (" + stats[4] + "/" + stats[5] + ")") + "\n"
                + "4DX: " + (stats[7] == 0 ? "N/A"
                        : trim(100.0 * stats[6] / stats[7]) + "%" + " (" + stats[6] + "/" + stats[7] + ")") + "\n");

    }

    // RETRIEVAL METHODS
    public static ArrayList<Projection> getAllProjections() {
        return CinemApp.getProjections();
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

    public static ArrayList<String> getProjectionDescriptions(ArrayList<Projection> theProjections, boolean withDate) {
        ArrayList<String> descs = new ArrayList<String>();
        for (Projection p : theProjections) {
            descs.add(p.getDescription(withDate));
        }
        return descs;
    }

    public static ArrayList<String> getProjectionTitles(ArrayList<Projection> theProjections) {
        ArrayList<String> titles = new ArrayList<String>();
        for (Projection p : theProjections) {
            titles.add(p.getMovie().getTitle());
        }
        return titles;
    }

    public static String getReport(ArrayList<Projection> filteredProj) {
        if (filteredProj.size() == 1) {
            return getReport(filteredProj.get(0));
        }
        // Report of a projection list
        String projList = "";
        for (Projection proj : filteredProj) {
            projList += proj + "\n";
        }
        return "\nSALES REPORT:\n"
                + filteredProj.size() + " projections selected \n"
                + projList + "\n"
                + formatStats(fetchStats(filteredProj));
    }

    public static String getReport(Projection proj) {
        // Report of a projection
        return "\nSINGLE PROJECTION REPORT:\n"
                + proj + "\n"
                + formatStats(fetchStats(proj));
    }

    public static boolean[][] getSeatBlock(Projection proj, String categ) {
        switch (categ) {
            case "GA":
                return proj.getBlockGA();
            case "VIP":
                return proj.getBlockVIP();
            case "4DX":
                return proj.getBlock4DX();
            default:
                return null;
        }
    }

    //public static Theater theater = mainFrame.theater;
    // Traer 1 película
    public static Movie traerPeli(String titulo) {
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
        for (Screen scr : CinemApp.getScreens()) {
            if (scr.getName().equals(nomScr)) {
                pant = scr;
            }
        }
        return pant;
    }

    public static double trim(double value) {
        // Trim to two decimal places
        return ((double) ((int) (value * 100.0))) / 100.0;
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
        CinemApp.cProjection(proj);
        return PROJECTION_SUCCESS;
    }

    private ManageProjection() {
    }

}
