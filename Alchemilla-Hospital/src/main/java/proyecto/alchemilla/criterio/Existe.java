/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.alchemilla.criterio;

/**
 *
 * @author Toshiba
 */
public class Existe {
    
//    BuscarCita bc  = new BuscarCita();
    
    public static boolean noEsNulo(String cu, String cd, String ct, String cc){
        
        if(cu.equals("")|| cd.equals("")|| ct.equals("") || cc.equals(""))
        {
            System.out.println("NO HAY NADA ACA");
            return false;
            
        }else{
            System.out.println("si hay al go aca");
            return true;
        }
    }
    
    
}
