package gestores;

import java.util.ArrayList;

public class BusquedaPalabras {
    
    public void buscarPalabra(String palabraAbuscar, String lienas){
      
        System.out.println(palabraAbuscar);
        
    }
    
    public ArrayList<String > llenarlista(String palabra){
         ArrayList<String > nuevo= new  ArrayList<String >();
        for(int i=0; i<palabra.length();i++){
          
            String p= String.valueOf(palabra.charAt(i));
             nuevo.add(p);
        } 
        return nuevo;
    
    }
}