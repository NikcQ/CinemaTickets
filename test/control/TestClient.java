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
    private String PHONE= "Invalid phone namber";
    private String ADDRESS= "Invalid address length";
    private String CLIENT_SUCCESS = "CORRECT REGISTRATION";
    
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
       
    }
    
    @Test
    public void testLastname(){}
    
    @Test
    public void testIc(){}
    
    @Test
    public void testBirthdate (){}
    
    @Test 
    public void testMail (){}
    
    @Test
    public void testPhone(){}
    
    @Test 
    public void testAddress(){}
    
    @Test
    public void testOk(){}
    
}
