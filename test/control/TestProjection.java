/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
    private String ALLOWED = "Projection successfully created.";
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
        assertEquals(manageprojection.verifyProjection("15:00", "2020-01-01", true, false, "hoi", "1"), MOVIE_NOT_AVAILABLE_3D);

    }

    @Test
    public void testMovie4D() {
        assertEquals(manageprojection.verifyProjection("15:00", "2020-01-01", true, true, "el bromas", "Sala Mayor"), MOVIE_NOT_AVAILABLE_4D);

    }

    @Test
    public void testSeats4D() {
        assertEquals(manageprojection.verifyProjection("15:00", "2020-01-01", true, true, "asdf", "1"), SEATS_4D);

    }

    @Test
    public void testDateBeforeNow() {
        assertEquals(manageprojection.verifyProjection("15:00", "2010-01-01", false, false, "el bromas", "1"), DATE_PASSED);

    }

    @Test
    public void testTimeBeforeNow() {
        assertEquals(manageprojection.verifyProjection("01:00", "2019-12-03", false, false, "el bromas", "1"), TIME_PASSED);

    }

    @Test
    public void testDateBeforeRelease() {
        assertEquals(manageprojection.verifyProjection("10:00", "2019-12-29", false, false, "hd", "1"), DATE_BEFORE_RELEASE);

    }

    @Test
    public void testoverlapping() {
        assertEquals(manageprojection.verifyProjection("08:00", "2019-12-12", false, false, "el bromas", "1"), OVERLAPPING);

    }

    @Test
    public void testOk() {
        assertEquals(manageprojection.verifyProjection("18:00", "2019-12-12", false, false, "el bromas", "Normal"), ALLOWED);

    }
}
