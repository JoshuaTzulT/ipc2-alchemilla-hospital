//9
package proyecto.alchemilla.sesion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.alchemilla.servlets.ServletComun;
import proyecto.alchemilla.servlets.ServletComun;

@WebServlet(name = "principal", urlPatterns = {"/principal"})
public class Principal extends ServletComun {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        validar(request, response);
        request.setAttribute("PRINCIPAL", "activo");
        request.getRequestDispatcher("/principal/index.jsp").forward(request, response);
      

    }

}
