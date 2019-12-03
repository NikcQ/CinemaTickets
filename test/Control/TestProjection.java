/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import entity.Projection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import control.ManageProjection;

/**
 * @author Edisson
 */

public class TestProjection {

    private static ManageProjection manageprojection = new ManageProjection();

    private String MOVIE_NOT_AVAILABLE_3D = "The movie is not avaliable in 3D.";
    private String MOVIE_NOT_AVAILABLE_4D = "The movie is not avaliable in 4D.";
    private String SEATS_4D = "The screen does not have 4DX seats.";
    private String DATE_PASSED = "The projection date has passed";
    private String DATE_BEFORE_RELEASE = "The projection date is before the movie release date";
    private String OVERLAPPING = "Projection overlapping";
    private String NOT_ALLOWED = "This kind of projection is not allowed on this screen";
    private String ALLOWED = "Projection created successfully.";
    private String TIME_PASSED = "The projection time has passed";

    public TestProjection() {
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
    // @Test
    // public void hello() {}
    
    @Test
    public void testMovie3D() {
        assertEquals(manageprojection.verificarFORM("15:00", "2020-01-01", true, false, "hoi", "1"), MOVIE_NOT_AVAILABLE_3D);

    }

    @Test
    public void testMovie4D() {
        assertEquals(manageprojection.verificarFORM("15:00", "2020-01-01", true, true, "el bromas", "Sala Mayor"), MOVIE_NOT_AVAILABLE_4D);

    }

    @Test
    public void testSeats4D() {
        assertEquals(manageprojection.verificarFORM("15:00", "2020-01-01", true, true, "pruebaNO4D", "PANTALLA4D"), SEATS_4D);

    }

    @Test
    public void testDateBeforeNow() {
        assertEquals(manageprojection.verificarFORM("15:00", "2010-01-01", false, false, "el bromas", "1"), DATE_PASSED);

    }

    @Test
    public void testTimeBeforeNow() {
        assertEquals(manageprojection.verificarFORM("10:00", "2019-12-02", false, false, "el bromas", "1"), TIME_PASSED);

    }
    
    @Test
    public void testDateBeforeRelease() {
        assertEquals(manageprojection.verificarFORM("10:00", "2019-12-29", false, false, "hoi", "1"), DATE_BEFORE_RELEASE);

    }
}