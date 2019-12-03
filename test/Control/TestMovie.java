/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import control.ManageMovie;
import java.time.LocalDate;

/**
 *
 * @author user
 */
public class TestMovie {
    private static ManageMovie managemovie= new ManageMovie();
    private String NO_HAY_TITULO = "Titulo invalido";
    private String  DURACION_INVALIDA="Duracion invalida";
    private String NO_HAY_RATING= "No hay rating";
    private String FECHA_INVALIDA= "Fecha invalida";
    private String NO_HAY_GENERO="No hay genero";
    private String NO_HAY_LENGUAJES= "No hay lenguajes";
    private String OK= "Registro Correcto";
            String[] asx = {" ", "Documentary", "Historical", "Musical", "Comedy", "Children's", "Adventure/Action", "Science Fiction", "Thriller"};
        String[] len = {" ", "English", "Spanish", "French", "Portuguese", "German", "Doblada"};
        
        String[] prueba ={};
    private final static String[] MOVIE_RATING = {"TP", "A7", "A12", "A15", "A18"};
    public TestMovie() {
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
    public void testTitulo(){
            assertEquals(managemovie.verificarMovie("", 20, MOVIE_RATING[0], true, true, LocalDate.now(), asx, len), NO_HAY_TITULO);
            assertEquals(managemovie.verificarMovie("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", 20, MOVIE_RATING[0], true, true, LocalDate.now(), asx, len), NO_HAY_TITULO);
            
    }
    
    @Test 
    public void testDuracion(){
        assertEquals(managemovie.verificarMovie("prueba", 14, MOVIE_RATING[0], true, true, LocalDate.now(), asx, len), DURACION_INVALIDA);
        assertEquals(managemovie.verificarMovie("prueba", 481, MOVIE_RATING[0], true, true, LocalDate.now(), asx, len), DURACION_INVALIDA);
    
    }
    
    @Test
    public void testRating(){
        assertEquals(managemovie.verificarMovie("prueba", 30, "", true, true, LocalDate.now(), asx, len), NO_HAY_RATING);
    
    }
    
    @Test
    public void testFecha(){
        assertEquals(managemovie.verificarMovie("prueba", 30, MOVIE_RATING[0], true, true,LocalDate.of(1979, 12,31), asx, len), FECHA_INVALIDA);
    
    }
    
    @Test
    
    public void testGenero(){
        assertEquals(managemovie.verificarMovie("prueba", 30, MOVIE_RATING[0], true, true,LocalDate.now(), prueba, len), NO_HAY_GENERO);
    }
    
    @Test
    
    public void testLenguajes(){
        assertEquals(managemovie.verificarMovie("prueba", 30, MOVIE_RATING[0], true, true,LocalDate.now(), asx, prueba), NO_HAY_LENGUAJES);
    }
    
    @Test
    public void testOk(){
    assertEquals(managemovie.verificarMovie("prueba", 30, MOVIE_RATING[0], true, true,LocalDate.now(), asx, len), OK);
    }
}
