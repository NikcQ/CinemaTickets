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
import control.ManageClient;
import java.time.LocalDate;

/**
 *
 * @author user
 */
public class TestClient {
    
    private  ManageClient managClient= new ManageClient();
    private String NAME ="Invalid Name";
    private String LASTNAME= "Invalid Lastname";
    private String IC= "existing user";
    private String BIRTHDATE_BEFORE = "Invalid birthDate";
    private String BIRTHDATE_AFTER = "The client must be 16 or older";
    private String MAIL= "Invalid mail length";
    private String PHONE= "Invalid phone number";
    private String ADDRESS= "Invalid address length";
    private String CLIENT_SUCCESS = "Client successfully registered.";
    
    public TestClient() {
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
    public void testName(){
        assertEquals(NAME, ManageClient.verifyClient("o", "gonzalez", LocalDate.parse("2000-02-02"), "10", "3214670108", "dgonzalezo@unal.edu.co", "cra 335466954"));
        assertEquals(NAME, ManageClient.verifyClient("", "gonzalez", LocalDate.parse("2000-02-02"), "10", "3214670108", "dgonzalezo@unal.edu.co", "cra 335466954"));
        assertEquals(NAME, ManageClient.verifyClient("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "gonzalez", LocalDate.parse("2000-02-02"), "10", "3214670108", "dgonzalezo@unal.edu.co", "cra 335466954"));
    
    }   
    
    @Test
    public void testLastname(){
        assertEquals(LASTNAME, ManageClient.verifyClient("ELIAN", "o", LocalDate.parse("2000-02-02"), "10", "3214670108", "dgonzalezo@unal.edu.co", "cra 335466954"));
        assertEquals(LASTNAME, ManageClient.verifyClient("ELIAN", "", LocalDate.parse("2000-02-02"), "10", "3214670108", "dgonzalezo@unal.edu.co", "cra 335466954"));
        assertEquals(LASTNAME, ManageClient.verifyClient("ELIAN", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", LocalDate.parse("2000-02-02"), "10", "3214670108", "dgonzalezo@unal.edu.co", "cra 335466954"));
    }
    
    @Test
    public void testIc(){
        assertEquals(CLIENT_SUCCESS, ManageClient.verifyClient("ELIAN", "gonzalez", LocalDate.parse("2000-02-02"), "11000", "3214670108", "dgonzalezo@unal.edu.co", "cra 335466954"));
        assertEquals(IC, ManageClient.verifyClient("ELIAN", "gonzalez", LocalDate.parse("2000-02-02"), "11000", "3214670108", "dgonzalezo@unal.edu.co", "cra 335466954"));
    }
    
    @Test
    public void testBirthdate (){
    assertEquals(BIRTHDATE_BEFORE, ManageClient.verifyClient("ELIAN", "gonzalez", LocalDate.parse("1889-02-02"), "12345678", "3214670108", "dgonzalezo@unal.edu.co", "cra 335466954"));
        assertEquals(BIRTHDATE_AFTER, ManageClient.verifyClient("ELIAN", "gonzalez", LocalDate.parse("2006-02-02"), "12345678", "3214670108", "dgonzalezo@unal.edu.co", "cra 335466954"));

    }
    
    @Test 
    public void testMail (){
        assertEquals(MAIL, ManageClient.verifyClient("ELIAN", "gonzalez", LocalDate.parse("2000-02-02"), "12345678", "3214670108", "dgonz", "cra 335466954"));
        assertEquals(MAIL, ManageClient.verifyClient("ELIAN", "gonzalez", LocalDate.parse("2000-02-02"), "12345678", "3214670108", "dgonzJDHYEHHNHHBDHSGSSYSHUDJSHSJDHSSJDHDJ", "cra 335466954"));
    }
    
    @Test
    public void testPhone(){
    assertEquals(PHONE, ManageClient.verifyClient("ELIAN", "gonzalez", LocalDate.parse("2000-02-02"), "12345678", "321467010", "dgonzalezo@unal.edu.co", "cra 335466954"));
    }
    
    @Test 
    public void testAddress(){
        assertEquals(ADDRESS, ManageClient.verifyClient("ELIAN", "gonzalez", LocalDate.parse("2000-02-02"), "12345678", "3214670108", "dgonzalezo@unal.edu.co", "cra "));

    }
    
    @Test
    public void testOk(){
            assertEquals(CLIENT_SUCCESS, ManageClient.verifyClient("ELIAN", "gonzalez", LocalDate.parse("2000-02-02"), "110001", "3214670108", "dgonzalezo@unal.edu.co", "cra 335466954"));

    }
    
}
