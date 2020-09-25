//7
package proyecto.alchemilla.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletComun", urlPatterns = {"/ServletComun"})
public class ServletComun extends HttpServlet {
     protected void validar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getSession().getAttribute("USUARIO_ACTUAL")==null){
            request.setAttribute("error", "No se ha logeado en el sistema");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        
    }
}
