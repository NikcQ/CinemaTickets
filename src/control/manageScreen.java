package control;

/**
 *
 * @author NikcQ
 */
import boundary.mainFrame;
import entity.*;


public class manageScreen {

    private CinemApp cinemap = mainFrame.cinemapp;
            
    
    public manageScreen() {
        
        
    }
    
    public String verifyScreen(Screen screen){
            if(!verifyNotNull()){
            return ("Longitud nombre incorrecta");
       
    }
            if(!verificarLongitudPassword(usuario.getPassword())){
            return ("Longitud contraseña incorrecta");
       
    }
            for(Usuario u: sistema.getUsuarios()){
                if(usuario.getNombre().equals(u.getNombre()))
                {
                    return("Usuario ya Registrado");
                }
            }
            
           if((usuario.getPassword()).equals(usuario.getPasswordv())){
                  return ("Registro exitoso");
                }
           else{
               return ("Las contraseñas no coinciden");
           }
        }
            public boolean validateNotNull(String nombre){
             return true;
            }
        
        
      public boolean ValidarLongitudPassword(String password){
        return true;
        
    }
      
          public boolean verifyNotNull(String id){
             return (!id.equals(null));
            }
          
          public boolean verifyNameAvaillability(){
              if ()
          }
        return ();
    
          
    
    
    
    
    
}
