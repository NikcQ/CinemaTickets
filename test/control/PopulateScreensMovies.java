/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juanc
 */
public class PopulateScreensMovies {

    // Only successes in this test.
    private static final String SCREEN_SUCCESS = "The screen was registered successfully.";
    private static final String MOVIE_SUCCESS = "Registro Correcto";

    public PopulateScreensMovies() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createScreens() {
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("Sala 2D GA", false, 12, 16, 0, 0, 0, 0, false));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("Sala 2D VIP", false, 0, 0, 6, 12, 0, 0, false));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("Sala 2D GA/VIP", false, 8, 12, 4, 16, 0, 0, false));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("Sala 3D GA", false, 15, 18, 0, 0, 0, 0, true));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("Sala 3D VIP", false, 0, 0, 12, 18, 0, 0, true));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("Sala 3D GA/VIP", false, 9, 18, 3, 12, 0, 0, true));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("Sala 4DX", true, 0, 0, 0, 0, 8, 16, false));
    }

    @Test
    public void createMovies() {
        // String title, int runtime, String rating, boolean is3D, boolean is4D,
        // LocalDate date, String[] genre,String[] languages
        assertEquals(MOVIE_SUCCESS, ManageMovie.verifyMovie("Parasite", 132, "A15", false, false,
                LocalDate.parse("2020-01-09"), new String[]{"Comedy", "Drama", "Thriller"}, new String[]{"English"}));
        assertEquals(MOVIE_SUCCESS, ManageMovie.verifyMovie("The Voyage of Doctor Dolittle", 101, "TP", true, true,
                LocalDate.parse("2020-01-09"), new String[]{"Comedy", "Drama", "Thriller"}, new String[]{"English"}));
        assertEquals(MOVIE_SUCCESS, ManageMovie.verifyMovie("1917", 118, "A12", false, false,
                LocalDate.parse("2020-01-23"), new String[]{"Drama"}, new String[]{"English"}));
        assertEquals(MOVIE_SUCCESS, ManageMovie.verifyMovie("Jojo Rabbit", 108, "A12", false, false,
                LocalDate.parse("2020-01-16"), new String[]{"Comedy", "Drama", "War"}, new String[]{"English"}));
        assertEquals(MOVIE_SUCCESS, ManageMovie.verifyMovie("Frozen 2", 104, "TP", true, false,
                LocalDate.parse("2019-11-21"), new String[]{"Animation", "Adventure", "Comedy"}, new String[]{"English"}));
        assertEquals(MOVIE_SUCCESS, ManageMovie.verifyMovie("Asterix: Le Secret de la Potion Magique", 86, "TP", true, false,
                LocalDate.parse("2020-01-23"), new String[]{"Animation"}, new String[]{"French"}));
        assertEquals(MOVIE_SUCCESS, ManageMovie.verifyMovie("Star Wars: The Rise of Skywalker", 142, "A7", true, false,
                LocalDate.parse("2019-12-19"), new String[]{"Action", "Adventure", "Fantasy"}, new String[]{"English"}));
        assertEquals(MOVIE_SUCCESS, ManageMovie.verifyMovie("The Dead Don't Die", 104, "A12", false, false,
                LocalDate.parse("2020-01-16"), new String[]{"Comedy", "Horror"}, new String[]{"German", "French", "English"}));
        assertEquals(MOVIE_SUCCESS, ManageMovie.verifyMovie("Birds of Prey", 109, "A15", true, true,
                LocalDate.parse("2020-02-06"), new String[]{"Action", "Adventure", "Crime"}, new String[]{"English"}));
        assertEquals(MOVIE_SUCCESS, ManageMovie.verifyMovie("A Beautiful Day in the Neighborhood", 109, "A12", false, false,
                LocalDate.parse("2020-02-06"), new String[]{"Drama"}, new String[]{"English"}));
        assertEquals(MOVIE_SUCCESS, ManageMovie.verifyMovie("Sonic the Hedgehog", 100, "TP", true, true,
                LocalDate.parse("2020-02-13"), new String[]{"Action", "Animation", "Adventure"}, new String[]{"English"}));
        assertEquals(MOVIE_SUCCESS, ManageMovie.verifyMovie("The Grudge", 94, "A15", false, false,
                LocalDate.parse("2020-02-13"), new String[]{"Horror"}, new String[]{"English"}));
    }
    
}
