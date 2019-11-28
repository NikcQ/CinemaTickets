package control;

/**
 *
 * @author NikcQ
 */
import DAO.ScreenDAO;
import boundary.mainFrame;
import entity.*;
import java.util.ArrayList;


public class ManageScreen {
    private CinemApp cinemapp= mainFrame.cinemapp;
    private Theater teatro= mainFrame.cinemapp.getCinema();
    private ScreenDAO salas= mainFrame.salas;

    public ManageScreen() {
    }
    
    public String verificarScreen(int rowGA, int colGA, int rowVIP, int colVIP, int row4DX, int col4DX, boolean is3D, String name){
    
    Screen nueva=new Screen();
    nueva.setRowGA(rowGA);
    nueva.setColGA(colGA);
    nueva.setRowVIP(rowVIP);
    nueva.setColVIP(colVIP);
    nueva.setRow4DX(row4DX);
    nueva.setCol4DX(col4DX);
    nueva.setIs3D(is3D);
    nueva.setName(name);

    

    
    teatro.addScreen(nueva);
    salas.create(nueva);
        printScreen();
    return ("Registro Correcto");

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
