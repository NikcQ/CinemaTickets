/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.MovieDAO;
import boundary.mainFrame;
import entity.CinemApp;
import entity.Movie;

/**
 *
 * @author Estudiante
 */
public class ManageProjection {

    MovieDAO movdao = mainFrame.pelicula;
    CinemApp cinemapp = mainFrame.cinemapp;

    public Movie traer(String titulo) {
        Movie peli = new Movie();
        for (Movie mov : cinemapp.getListings()) {
            if (mov.getTitle().equals(titulo)) {
                peli=mov;
            }
        }
        return peli;
    }
    

    
}
