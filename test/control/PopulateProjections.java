/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
public class PopulateProjections {

    private static final String PROJECTION_SUCCESS = "Projection successfully created.";

    public PopulateProjections() {
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
    public void createProjections() {
        assertEquals(PROJECTION_SUCCESS, ManageProjection.verifyProjection("22:00", "2020-02-11", false, false, "Parasite", "Sala 2D GA"));
        assertEquals(PROJECTION_SUCCESS, ManageProjection.verifyProjection("21:00", "2020-02-12", false, false, "1917", "Sala 2D VIP"));
        assertEquals(PROJECTION_SUCCESS, ManageProjection.verifyProjection("20:00", "2020-02-13", false, false, "Jojo Rabbit", "Sala 2D GA/VIP"));
        assertEquals(PROJECTION_SUCCESS, ManageProjection.verifyProjection("19:00", "2020-02-14", true, false, "Frozen 2", "Sala 3D GA"));
        assertEquals(PROJECTION_SUCCESS, ManageProjection.verifyProjection("18:00", "2020-02-15", true, false, "Asterix: Le Secret de la Potion Magique", "Sala 3D VIP"));
        assertEquals(PROJECTION_SUCCESS, ManageProjection.verifyProjection("17:00", "2020-02-16", true, false, "Star Wars: The Rise of Skywalker", "Sala 3D GA/VIP"));
        assertEquals(PROJECTION_SUCCESS, ManageProjection.verifyProjection("16:00", "2020-02-17", false, true, "The Voyage of Doctor Dolittle", "Sala 4DX"));
        assertEquals(PROJECTION_SUCCESS, ManageProjection.verifyProjection("15:00", "2020-02-18", true, true, "Birds of Prey", "Sala 4DX"));
    }
    
}
