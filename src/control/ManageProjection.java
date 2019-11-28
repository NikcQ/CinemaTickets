/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.MovieDAO;
import DAO.ProjectionDAO;
import boundary.mainFrame;
import entity.CinemApp;
import entity.Movie;
import entity.Projection;
import entity.Screen;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Estudiante
 */
public class ManageProjection {

    //MovieDAO movdao = mainFrame.pelicula;
    //CinemApp cinemapp = mainFrame.cinemapp;
    
    
    // Traer 1 película
    public static Movie traerPeli(String titulo) {
        Movie peli = new Movie();
        for (Movie mov : mainFrame.cinemapp.getListings()) {
            if (mov.getTitle().equals(titulo)) {
                peli=mov;
            }
        }
        return peli;
    }
    
    public static Screen traerScreen(String nomScr) {
        Screen pant = new Screen();
        for (Screen scr : mainFrame.cinemapp.getCinema().getScreens()) {
            if (scr.getName().equals(nomScr)) {
                pant=scr;
            }
        }
        return pant;
    }
    public static String verificarFORM(String time, String date, boolean is3D, boolean is4D, String movieName, String screenName){
        Movie peli = traerPeli(movieName);
        Screen pant = traerScreen(screenName);
        
        // Check  movie 3D
        if(is3D && !peli.isIs3D()){
            return "The movie is not avaliable in 3D.";
        }
        // Check movie 4D and screen 4D
        if(is4D){
            if (!peli.isIs4D()){
                return "The movie is not avaliable in 4D.";
            } else if (pant.getCol4DX() == 0){
                return "The screen does not have 4DX seats.";
            }
        }
        
        LocalDate pDate = LocalDate.parse(date);
        LocalTime pTime = LocalTime.parse(time);
        
        
        // Check if date is in past
        if (pDate.isBefore(LocalDate.now())){
            return "The projection date has passed";
        } else if (pDate.isEqual(LocalDate.now()) && pTime.isBefore(LocalTime.now())){
            return "The projection time has passed";
        } else if (pDate.isBefore(peli.getReleaseDate())){ // Check release date
            return "The projection date is before the movie release date";
        }
    
        
        Projection proj = new Projection(peli,pant,pDate,pTime, is3D, is4D);
        mainFrame.cinemapp.getCinema().addProjection(proj);
        ProjectionDAO pdao = new ProjectionDAO();
        pdao.create(proj);
        return "Projection created successfully.";
    }
    

    
}
