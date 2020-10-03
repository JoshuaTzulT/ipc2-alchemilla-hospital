/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.alchemilla.gestor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Toshiba
 */
@WebServlet(name = "MenuGestor", urlPatterns = {"/MenuGestor"})
public class MenuGestor extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
         try {
           
         

            if(accion.equals("nuestros_servicios")){
                request.getRequestDispatcher("/principal/nuestros_servicios.jsp").forward(request, response);
            }
            
            if(accion.equals("principal")){
                request.getRequestDispatcher("inicio.jsp").forward(request, response);
            }
            
            
            
    
        } catch (IOException |ServletException e) {
            request.setAttribute("Error", e.getMessage());
            request.getRequestDispatcher("/usuario/error.jsp").forward(request, response);
        }

        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//       doGet(request,response);
        
    }

    
}
