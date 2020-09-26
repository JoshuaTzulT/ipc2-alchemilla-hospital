package proyecto.alchemilla.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.alchemilla.baseD.Conexion;
import proyecto.alchemilla.baseD.UsuarioUtilidad;
import proyecto.alchemilla.entidades.Usuario;

@WebServlet(name = "Criterio", urlPatterns = {"/Criterio"})
public class Criterio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("nombre_de_usuario");

        try {
            Connection conn = Conexion.getConnection();
            List<Usuario> lista = UsuarioUtilidad.getListaUsuarioCriterio(conn, usuario);
            String mensaje = "no hay informacion";
            if (lista.size() > 0) {
                mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
            }
            request.setAttribute("MENSAJE", mensaje);
            request.setAttribute("TITULO", "Listado");
            request.setAttribute("lista", lista);
            request.setAttribute("UG", "activo");
            request.getRequestDispatcher("/usuario/usuario1.jsp").forward(request, response);
        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
            request.setAttribute("Error", e.getMessage());
            request.getRequestDispatcher("/usuario/error.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
