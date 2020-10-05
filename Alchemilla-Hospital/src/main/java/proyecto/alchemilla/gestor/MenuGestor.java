
package proyecto.alchemilla.gestor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MenuGestor", urlPatterns = {"/MenuGestor"})
public class MenuGestor extends HttpServlet {

    private String accion;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        accion = request.getParameter("accion");
        try {

            if (accion.equals("nuestros_servicios")) {
                request.getRequestDispatcher("/principal/nuestros_servicios.jsp").forward(request, response);
            }

            if (accion.equals("principal")) {
                request.getRequestDispatcher("inicio.jsp").forward(request, response);
            }

        } catch (IOException | ServletException e) {
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
