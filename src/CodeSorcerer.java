import java.io.BufferedReader;
import java.io.FileReader;

public class CodeSorcerer {

    String escriturasDelMapa = "";
    int ciudades = 0;

    Pueblos[] pueblos ;
    
    //txt
    //analiza txt

    public void LeerMapa(String direccion){

        

        try{

            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            
            String bfRead;

            while((bfRead = bf.readLine()) != null){
                
                escriturasDelMapa += bfRead;

            }


        }catch(Exception e){ 
            
            System.err.println("El hechizero no es capaz de descifrar este mapa");

        }
        




    }
    
    //guarda ciudades en array diciendo si son enemeigos o aliados y
    //crea los ejercitos ascosiados a las ciudades arraylist
    
    public void crearCiudades(String numeroDeCiudades){

        ciudades = Integer.valueOf(numeroDeCiudades);

        pueblos = new Pueblos[ciudades];







    }


    //crea el grafo a partir del txt
    //analiza el camino mas corto
    
    //predice si ese camino lleva a la victoria
    //(usando el metodo batalla contra los ejercitos en el metodo mas corto)

    //predecir victoria


    
}
