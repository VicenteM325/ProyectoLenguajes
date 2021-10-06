package gestores;

public class Identificador {
    String palabra;
    int posicion=0;
    int matriz[][] = new int[3][2];
    int estadosFinalizacion[] = new int[2];
    String descripcionFinalizacion[] = new String[2];
    int estadoActual = 0;
    
    // filas s1 --> 1 s2 -> 2  s3->3 
    // \letra --> 1
    // \digito -->2
    // no pertenece a mi alfabeto -1
    {
        matriz[0][0] = 1;  matriz[0][1] = -1;
        matriz[1][0] = 1;  matriz[1][1] = 2;
        matriz[2][0] = 1;  matriz[2][1] = 2;
       

        //letra
        estadosFinalizacion[0]=1;
        descripcionFinalizacion[0]="letras";
        //numero
        estadosFinalizacion[1]=2;
        descripcionFinalizacion[1]="Numero";
    }
    
    public void Verificar(String p){
    this.palabra=p;
    while(posicion < palabra.length()){
        getToken();
    
    }
    
    }
    public void getToken(){
      estadoActual=0;
      boolean seguirLeyendo=true;
      String token = "";
      while((seguirLeyendo) && posicion<palabra.length()){
          if(Character.isSpaceChar(palabra.charAt(posicion))){
              System.out.println("espacio");
              seguirLeyendo=false;
          }
          
          else {
              
              
              int estadoTempotal= getSiguienteEstado(estadoActual,getIntCaracter(palabra.charAt(posicion)));
               System.out.println("Estado actual " + estadoActual + " caracter----- "+ palabra.charAt(posicion) + "----transicion a "+estadoTempotal);
               
               token+=palabra.charAt(posicion);
               estadoActual = estadoTempotal;
              System.out.println(palabra.charAt(posicion));
          } 
          posicion++;
      }
      System.out.println("*********Termino en el estado "+ getEstadoAceptacion(estadoActual) + " token actual : "+token);
    }
    
     //revisa movimiento den la matriz
    public int getSiguienteEstado(int posicionActual, int caracter){
       int resultado = -1;
        if (caracter >= 0 && caracter <= 1) {
            resultado = matriz[estadoActual][caracter];
        }
        return resultado;
    }
    
    //alfabeto
    public int getIntCaracter(char caracter) {
        int resultado = -1;

        if (Character.isLetter(caracter)) {
            resultado = 0;
        } 
        
        else{
           
            if (Character.isDigit(caracter))
             resultado = 1;
        }


        return resultado;
    }
    
     public String getEstadoAceptacion(int i){
        String res = "Error";
        int indice = 0;
        for (int estadoAceptacion : estadosFinalizacion) {
            
            if (estadoAceptacion == i){
                res = descripcionFinalizacion[indice];
                break;
            }
            indice++;
        }

        return res;
    }
}