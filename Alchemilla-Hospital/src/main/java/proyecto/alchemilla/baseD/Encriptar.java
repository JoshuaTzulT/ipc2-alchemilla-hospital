//5
package proyecto.alchemilla.baseD;

import java.io.UnsupportedEncodingException;
import java.util.Base64;


public class Encriptar {
     public static String encriptar(String value) throws UnsupportedEncodingException{
       Base64.Encoder e = Base64.getEncoder();
       return e.encodeToString(value.getBytes("utf-8"));
    }
    
    public static String desencriptar(String encrypted) throws UnsupportedEncodingException{
        byte[] b = Base64.getDecoder().decode(encrypted);
        return new String(b, "utf-8");
    }

}
