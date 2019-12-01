/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.ProjectionDAO;
import boundary.mainFrame;
import entity.Movie;
import entity.Projection;
import entity.Screen;
import entity.Theater;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class ManageProjection {

    //MovieDAO movdao = mainFrame.pelicula;
    //CinemApp cinemapp = mainFrame.cinemapp;
    public static Theater theater = mainFrame.theater;

    // Traer 1 película
    public static Movie traerPeli(String titulo) {
        Movie peli = new Movie();
        for (Movie mov : mainFrame.cinemapp.getListings()) {
            if (mov.getTitle().equals(titulo)) {
                peli = mov;
            }
        }
        return peli;
    }

    public static Screen traerScreen(String nomScr) {
        Screen pant = new Screen();
        for (Screen scr : mainFrame.cinemapp.getCinema().getScreens()) {
            if (scr.getName().equals(nomScr)) {
                pant = scr;
            }
        }
        return pant;
    }
    
    // RETRIEVAL METHODS
    public static ArrayList<Projection> getAllProjections(){
        return mainFrame.cinemapp.getCinema().getProjections();
    }
    
    
    public static ArrayList<Projection> filterProjectionsByDate(ArrayList<Projection> theProjections, LocalDate date){
        ArrayList<Projection> sameDate = new ArrayList<Projection>();
        
        for(Projection p: theProjections){
            if(p.getDate().isEqual(date)){
                sameDate.add(p);
            }
        }
        
        return sameDate;
    }
    
    public static ArrayList<Projection> filterProjectionsByTitle(ArrayList<Projection> theProjections, String title){
        ArrayList<Projection> sameTitle = new ArrayList<Projection>();
        
        for(Projection p: theProjections){
            if(p.getMovie().getTitle().equals(title)){
                sameTitle.add(p);
            }
        }
        
        return sameTitle;
    }
    
    public static ArrayList<String> getProjectionTitles(ArrayList<Projection> theProjections){
        ArrayList<String> titles = new ArrayList<String>();
        for (Projection p : theProjections){
            titles.add(p.getMovie().getTitle());
        }
        return titles;
    }
    
    public static ArrayList<String> getProjectionDescriptions(ArrayList<Projection> theProjections, boolean withDate){
        ArrayList<String> descs = new ArrayList<String>();
        for (Projection p : theProjections){
            descs.add(p.getDescription(withDate));
        }
        return descs;
    }
    
    
    
    // VERIFICATION METHODS BELOW
    
    public static String verificarFORM(String time, String date, boolean is3D, boolean is4D, String movieName, String screenName) {
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
        if (checkScreen(proj)) {
            return "This kind of projection is not allowed on this screen";
        }
        mainFrame.cinemapp.getCinema().addProjection(proj);
        ProjectionDAO pdao = new ProjectionDAO();
        pdao.create(proj);
        return "Projection created successfully.";
    }

    //Verify if there is a projection in the same screen at the same time
    private static boolean checkProjectionOverlap(Projection projectiontocheck) {
        LocalTime initHour = LocalTime.parse("10:00");
        LocalTime finHour = LocalTime.parse("22:00");
        int minutes = 120;
        if (projectiontocheck.getTime().isBefore(initHour) || (projectiontocheck.getTime().isAfter(finHour))) {
            return true;
        }
        for (Projection proj : mainFrame.cinemapp.getCinema().getProjections()) {
            if ((projectiontocheck.getScreen().getName().equals(proj.getScreen().getName())) && (projectiontocheck.getDate().equals(proj.getDate()))) {
                if (projectiontocheck.getTime().equals(proj.getTime()) || ((projectiontocheck.getTime().plusMinutes(minutes)).isAfter(proj.getTime()) && (proj.getTime().isAfter(projectiontocheck.getTime())))) {
                    return true;
                }
                if (((proj.getTime().plusMinutes(minutes)).isAfter(projectiontocheck.getTime())) && (projectiontocheck.getTime().isAfter(proj.getTime()))) {
                    return true;
                }
            }
        }
        return false;
    }

    //Verify if this kind of projection is allowed
    private static boolean checkScreen(Projection projectiontocheck) {

        if (projectiontocheck.isIs3D() != projectiontocheck.getScreen().isIs3D()) {
            return true;
        }
        if (projectiontocheck.isIs3D() == true && projectiontocheck.isIs4D() == true && projectiontocheck.getScreen().getRow4DX() == 0) {
            return true;
        }

        return false;
    }
    
}
