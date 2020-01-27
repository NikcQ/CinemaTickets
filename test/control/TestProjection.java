/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Edisson
 */
public class TestProjection {

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
        assertEquals(ManageProjection.verifyProjection("15:00", "2020-01-30", true, false, "Parasite", "Sala 2D GA"), MOVIE_NOT_AVAILABLE_3D);

    }

    @Test
    public void testMovie4D() {
        assertEquals(ManageProjection.verifyProjection("15:00", "2020-01-30", true, true, "Parasite", "Sala 2D GA"), MOVIE_NOT_AVAILABLE_4D);

    }

    @Test
    public void testSeats4D() {
        assertEquals(ManageProjection.verifyProjection("15:00", "2020-01-30", true, true, "The Voyage of Doctor Dolittle", "Sala 3D GA"), SEATS_4D);

    }

    @Test
    public void testDateBeforeNow() {
        assertEquals(ManageProjection.verifyProjection("15:00", "2020-01-01", true, true, "The Voyage of Doctor Dolittle", "Sala 3D GA"), DATE_PASSED);

    }

    @Test
    public void testTimeBeforeNow() {
        assertEquals(ManageProjection.verifyProjection("12:00", "2020-01-27", false, false, "Parasite", "Sala 2D GA"), TIME_PASSED);

    }

    @Test
    public void testDateBeforeRelease() {
        assertEquals(ManageProjection.verifyProjection("15:00", "2020-01-30", false, false, "Sonic the Hedgehog", "Sala 2D GA"), DATE_BEFORE_RELEASE);

    }

    @Test
    public void testoverlapping() {
        assertEquals(ManageProjection.verifyProjection("12:00", "2020-01-30", false, false, "Parasite", "Sala 2D GA"), OVERLAPPING);

    }

    @Test
    public void testOk() {
        assertEquals(ManageProjection.verifyProjection("18:00", "2020-02-10", false, false, "Jojo Rabbit", "Sala 2D GA"), ALLOWED);
        assertEquals(ManageProjection.verifyProjection("15:00", "2020-01-30", false, false, "Parasite", "Sala 2D GA"), ALLOWED);
        assertEquals(ManageProjection.verifyProjection("18:00", "2020-03-10", true, true, "Sonic the Hedgehog", "Sala 4DX"), ALLOWED);

    }
}
