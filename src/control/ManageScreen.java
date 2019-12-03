package control;

/**
 *
 * @author NikcQ
 */
import DAO.ScreenDAO;
import boundary.mainFrame;
import entity.Screen.*; 
import entity.CinemApp;
import entity.Screen;
import static entity.Screen_.row4DX;
import entity.Theater;
import java.util.ArrayList;


public class ManageScreen {
    private CinemApp cinemapp= mainFrame.cinemapp;
    private Theater teatro= mainFrame.cinemapp.getCinema();
    private ScreenDAO salas= mainFrame.salas;

    public ManageScreen() {
    }
    
    public String verificarScreen(int rowGA, int colGA, int rowVIP, int colVIP, int row4DX, int col4DX, boolean is3D, String name){
    
        if (TestScreenRows(rowGA, rowVIP, row4DX)){
            
            return ("error 1");
        }
        
        if (TestScreenColumns (colGA, colVIP, col4DX)){
        
        return("error 2");
        
        }
        if (TestScreenName(name)){
            
            return ("error 3");
            
        }
            
    Screen s = new Screen();
    s.setRowGA(rowGA);
    s.setColGA(colGA);
    s.setRowVIP(rowVIP);
    s.setColVIP(colVIP);
    s.setRow4DX(row4DX);
    s.setCol4DX(col4DX);
    s.setIs3D(is3D);
    s.setName(name);
   
    teatro.addScreen(s);
    salas.create(s);
        printScreen();
    return ("Registro Correcto");

    }
    
    public boolean TestScreenRows (int rowGA, int rowVIP, int row4DX){
    
        return (rowGA < 0 || rowVIP < 0 || row4DX < 0);
        
        
    } 
      
    public boolean TestScreenColumns (int colGA, int colVIP, int col4DX){
    
    return (colGA < 0 || colVIP < 0 || col4DX < 0);
    }
    
    public boolean TestScreenName (String name){
    boolean istrue = false;
    if (name.isEmpty()){
        istrue = true;
    }
        return istrue;
    }
    
    
    
             public void printScreen(){
         for (Screen screen : teatro.getScreens()) {
             System.out.println(screen.getName());
             System.out.println("---------------");
        }

     }
            
  
    public static ArrayList<String> getScreenNames(){
        ArrayList<Screen> list = mainFrame.cinemapp.getCinema().getScreens();
        ArrayList<String> names = new ArrayList<String>();
        for (Screen s : list){
            names.add(s.getName());
        }
        return names;
    }
    
}