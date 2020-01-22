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
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ManageMovie {

    private static CinemApp cinemapp = mainFrame.cinemapp;
    private static MovieDAO pelicula = mainFrame.movieDAO;
    public ArrayList<Movie> movies = new ArrayList<Movie>();
    String[] asx = {" ", "Documentary", "Historical", "Musical", "Comedy", "Children's", "Adventure/Action", "Science Fiction", "Thriller"};
    String[] len = {" ", "English", "Spanish", "French", "Portuguese", "German", "Doblada"};

    public ManageMovie() {
    }

    public static String verifyMovie(String title, int runtime, String rating, boolean is3D, boolean is4D, LocalDate date, String[] genre,String[] languages) {

        if (title.isEmpty()|| title.length()>40) {
            return ("Titulo invalido");
        }
        if (runtime<15 || runtime>480) {
            return ("Duracion invalida");
        }
        if (rating.isEmpty()) {
            return ("No hay rating");
        }
        if (date.isBefore(LocalDate.of(1980, 01,01))) {
            return ("Fecha invalida");
        }
        if (genre.length<1) {
            return ("No hay genero");
                    
        }
        if (languages.length<1) {
            return ("No hay lenguajes");
        }
        Movie nuevo = new Movie(title, runtime, rating, is3D, is4D);

//        cinemapp.addMovie(nuevo);
//        printUsers();
        pelicula.create(nuevo);
        return ("Registro Correcto");

    }

    public void printUsers() {
        for (Movie movie : cinemapp.getListings()) {
            System.out.println(movie.getTitle());
            System.out.println("---------------");
        }

    }
    
    public String [] arrayToList(ArrayList list){
    String[] array = (String[]) list.toArray(new String[list.size()]);
        return array;
    }

    public static ArrayList<String> getMovieTitles() {
        ArrayList<Movie> list = mainFrame.cinemapp.getListings();
        ArrayList<String> titles = new ArrayList<String>();
        for (Movie m : list) {
            titles.add(m.getTitle());
        }
        return titles;
    }

}