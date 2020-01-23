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
 * @author user
 */
public class PopulateClient {
    private static final String CLIENT_SUCCESS = "Client successfully registered.";
    public PopulateClient() {
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
    public void createMovies() {
        // String title, int runtime, String rating, boolean is3D, boolean is4D,
        // LocalDate date, String[] genre,String[] languages
        assertEquals(CLIENT_SUCCESS, ManageClient.verifyClient("Elian", "Gonzalez", LocalDate.parse("2000-07-21"), "1", "3214670108", "dgonzalezo@unal.edu.co", "cra 33"));
        assertEquals(CLIENT_SUCCESS, ManageClient.verifyClient("Jhon", "Santofimio", LocalDate.parse("1998-05-15"), "2","3214435466", "jesantofimiom@unal.edu.co", "cra 38"));
        assertEquals(CLIENT_SUCCESS, ManageClient.verifyClient("Nicolas", "La rotta", LocalDate.parse("1998-04-23"), "3","3234567895", "nlam@unal.edu.co", "cra 13"));
        assertEquals(CLIENT_SUCCESS, ManageClient.verifyClient("Juan", "Vargas", LocalDate.parse("1994-12-27"), "4", "3456784246", "jcvargasq@unal.edu.co", "cra 9"));
        assertEquals(CLIENT_SUCCESS, ManageClient.verifyClient("Edisson", "Prieto", LocalDate.parse("1994-01-14"), "5", "321324562", "edprietov@unal.edu.co", "cra 13"));
        assertEquals(CLIENT_SUCCESS, ManageClient.verifyClient("Henry", "Umana", LocalDate.parse("2000-06-21"), "6", "3215468975", "hrumana@unal.edu.co", "cra 20"));
    }
    
}
