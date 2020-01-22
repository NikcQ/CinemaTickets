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
public class TestScreen {

    private static String EMPTY_SCREEN_NAME = "The screen name must not be blank.";
    private static String BLOCK_DIMS = "Both dimensions of a block must be positive or zero.";
    private static String BLOCK_DIMS_GAVIP = "A screen must have a valid seat block.";
    private static String BLOCK_DIMS_4DX = "A 4DX screen must have a valid 4DX seat block.";
    private static String SCREEN_SUCCESS = "The screen was registered successfully.";

    public TestScreen() {
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
    public void emptyName() {
        assertEquals(EMPTY_SCREEN_NAME, ManageScreen.verifyScreen("", false, 0, 0, 0, 0, 0, 0, false));
    }

    @Test
    public void wrongGAVIP() {
        assertEquals(BLOCK_DIMS, ManageScreen.verifyScreen("TheScreenName", false, 1, 0, 0, 0, 0, 0, false));
        assertEquals(BLOCK_DIMS, ManageScreen.verifyScreen("TheScreenName", false, 0, 1, 0, 0, 0, 0, false));
        assertEquals(BLOCK_DIMS, ManageScreen.verifyScreen("TheScreenName", false, 0, 0, 1, 0, 0, 0, false));
        assertEquals(BLOCK_DIMS, ManageScreen.verifyScreen("TheScreenName", false, 0, 0, 0, 1, 0, 0, false));
        assertEquals(BLOCK_DIMS, ManageScreen.verifyScreen("TheScreenName", false, 1, 0, 1, 1, 0, 0, false));
        assertEquals(BLOCK_DIMS, ManageScreen.verifyScreen("TheScreenName", false, 0, 1, 1, 1, 0, 0, false));
        assertEquals(BLOCK_DIMS, ManageScreen.verifyScreen("TheScreenName", false, 1, 1, 1, 0, 0, 0, false));
        assertEquals(BLOCK_DIMS, ManageScreen.verifyScreen("TheScreenName", false, 1, 1, 0, 1, 0, 0, false));
    }

    @Test
    public void noBlocksGAVIP() {
        assertEquals(BLOCK_DIMS_GAVIP, ManageScreen.verifyScreen("TheScreenName", false, 0, 0, 0, 0, 0, 0, false));
        assertEquals(BLOCK_DIMS_GAVIP, ManageScreen.verifyScreen("TheScreenName", false, 0, 0, 0, 0, 1, 0, false));
        assertEquals(BLOCK_DIMS_GAVIP, ManageScreen.verifyScreen("TheScreenName", false, 0, 0, 0, 0, 0, 1, false));
        assertEquals(BLOCK_DIMS_GAVIP, ManageScreen.verifyScreen("TheScreenName", false, 0, 0, 0, 0, 1, 1, false));
    }

    @Test
    public void wrong4DX() {
        assertEquals(BLOCK_DIMS_4DX, ManageScreen.verifyScreen("TheScreenName", true, 0, 0, 0, 0, 0, 0, false));
        assertEquals(BLOCK_DIMS_4DX, ManageScreen.verifyScreen("TheScreenName", true, 0, 0, 0, 0, 1, 0, false));
        assertEquals(BLOCK_DIMS_4DX, ManageScreen.verifyScreen("TheScreenName", true, 0, 0, 0, 0, 0, 1, false));
        assertEquals(BLOCK_DIMS_4DX, ManageScreen.verifyScreen("TheScreenName", true, -1, 0, -1, 0, 0, 0, false));
        assertEquals(BLOCK_DIMS_4DX, ManageScreen.verifyScreen("TheScreenName", true, 0, -1, 0, -1, 0, 0, false));
    }
    
    @Test
    public void correctGAVIP(){
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("TheScreenName", false, 1, 1, 0, 0, 1, 0, false));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("TheScreenName", false, 0, 0, 1, 1, 0, 1, false));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("TheScreenName", false, 1, 1, 1, 1, 1, 0, false));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("TheScreenName", false, 1, 1, 0, 0, 0, 1, true));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("TheScreenName", false, 0, 0, 1, 1, 1, 0, true));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("TheScreenName", false, 1, 1, 1, 1, 0, 1, true));
    }
    
    @Test
    public void correct4DX(){
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("TheScreenName", true, 0, 0, 0, 0, 1, 1, false));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("TheScreenName", true, 1, 1, 0, 0, 1, 1, false));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("TheScreenName", true, 0, 0, 1, 1, 1, 1, false));
        assertEquals(SCREEN_SUCCESS, ManageScreen.verifyScreen("TheScreenName", true, 1, 1, 1, 1, 1, 1, false));
    }
}
