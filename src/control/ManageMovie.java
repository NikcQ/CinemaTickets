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
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ManageMovie {

    private CinemApp cinemapp = mainFrame.cinemapp;
    private MovieDAO pelicula = mainFrame.pelicula;
    public ArrayList<Movie> movies = new ArrayList<Movie>();
    String[] asx = {" ", "Documentary", "Historical", "Musical", "Comedy", "Children's", "Adventure/Action", "Science Fiction", "Thriller"};
    String[] len = {" ", "English", "Spanish", "French", "Portuguese", "German", "Doblada"};

    public ManageMovie() {
    }

    public String verificarMovie(String title, int runtime, String rating, boolean is3D, boolean is4D, LocalDate date, ArrayList genre,ArrayList languages) {

        if (title.length()<=1) {
            return ("No hay un titulo");
        }
        if (runtime<15 || runtime>480) {
            return ("Duracion invalida");
        }
        if (rating== null) {
            return ("No hay rating");
        }
        if (date.isBefore(LocalDate.now())) {
            return ("Fecha invalida");
        }
        if (genre.size()<1) {
            return ("No hay genero");
                    
        }
        if (languages.size()<1) {
            return ("No hay lenguajes");
        }
        Movie nuevo = new Movie();
        nuevo.setTitle(title);
        nuevo.setRuntime(runtime);
        nuevo.setRating(rating);
        nuevo.setIs3D(is3D);
        nuevo.setIs4D(is4D);
        nuevo.setReleaseDate(date);
        nuevo.setGenre(arrayToList(genre));
        nuevo.setLanguages(arrayToList(languages));

//    movies.add(nuevo);
        cinemapp.addMovie(nuevo);
        printUsers();
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
