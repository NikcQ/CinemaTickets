// DO NOT RUN - DO NOT MODIFY
// DEPRECATED INITIALIZATION TEST

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package control;

import DAO.MovieDAO;
import DAO.ProjectionDAO;
import DAO.ScreenDAO;
//import DAO.TheaterDAO;
import entity.Movie;
import entity.Projection;
import entity.Screen;
//import entity.Theater;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//**
 //*
// * @author Coordinacion
// */
public class Inicializacion {
    
    public Inicializacion() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void InitData(){
        // NO DAO SINGLETON
        //MovieDAO daoM = new MovieDAO();
        //ScreenDAO daoS = new ScreenDAO();
        //ProjectionDAO daoP = new ProjectionDAO();
        //TheaterDAO daoT = new TheaterDAO();
        ArrayList<Movie> peliculas = new ArrayList<Movie>();
        String ms = "2007-12-03";
        String[] asx = {" ", "Documentary", "Historical", "Musical", "Comedy", "Children's", "Adventure/Action", "Science Fiction", "Thriller"};
        String[] len = {" ", "English", "Spanish", "French", "Portuguese", "German", "Doblada"};
        Movie a = new Movie();
        Movie b = new Movie();
        Movie c = new Movie();
        
        c.setTitle("asdf");
        c.setRuntime(3);
        c.setRating("ASD");
        c.setIs3D(true);
        c.setIs4D(true);
        c.setReleaseDate(LocalDate.parse(ms));
        c.setGenre(asx);
        c.setLanguages(len);
        
        a.setTitle("el bromas");
        a.setRuntime(2);
        a.setRating("TP");
        a.setIs3D(true);
        a.setIs4D(false);
        a.setReleaseDate(LocalDate.parse(ms));
        a.setGenre(asx);
        a.setLanguages(len);
        
        b.setTitle("asd");
        b.setRuntime(2);
        b.setRating("TP");
        b.setIs3D(true);
        b.setIs4D(false);
        b.setReleaseDate(LocalDate.parse(ms));
        b.setGenre(asx);
        c.setLanguages(len);
        
        peliculas.add(a);
        peliculas.add(b);
        peliculas.add(c);
        //cinemapp.setListings(peliculas);
        for (Movie i:peliculas) {
            MovieDAO.create(i);
        }
        ArrayList<Screen> screen = new ArrayList<Screen>();
        Screen d = new Screen();
        d.setRowGA(20);
        d.setColGA(20);
        d.setRowVIP(5);
        d.setColVIP(20);
        d.setRow4DX(0);
        d.setCol4DX(0);
        d.setIs3D(true);
        d.setName("1");
        screen.add(d);
        //cinemapp.setScreens(screen);
        ScreenDAO.create(d);
        ArrayList<Projection> projection = new ArrayList<Projection>();
        Projection e = new Projection();
        e.setMovie(a);
        e.setScreen(d);
        e.setDate(LocalDate.parse(ms));
        e.setTime(LocalTime.now());
        e.setIs3D(true);
        e.setIs4D(false);
        projection.add(e);
        ProjectionDAO.create(e);
//        ArrayList<Theater> theater = new ArrayList<Theater>();
//        Theater t = new Theater();
//        t.setProjections(projection);
//        t.setScreens(screen);
//        t.setTheatreName("teatro_1");
//        theater.add(t);
//        daoT.create(t);
   }
 //TODO add test methods here.
 //The methods must be annotated with annotation @Test. For example:

}
