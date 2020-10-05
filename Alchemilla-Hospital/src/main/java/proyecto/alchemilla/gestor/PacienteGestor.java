//6
package proyecto.alchemilla.gestor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.alchemilla.baseD.Conexion;
import proyecto.alchemilla.baseD.UsuarioUtilidad;
import proyecto.alchemilla.entidades.Cita;
import proyecto.alchemilla.entidades.Medico;
import proyecto.alchemilla.servlets.ServletComun;

@WebServlet(name = "PacienteGestor", urlPatterns = {"/PacienteGestor"})
public class PacienteGestor extends ServletComun {//7

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        validar(request, response);
        String accion = request.getParameter("accion");
        String titulo = "";
        String link = "";
        String mensaje = "";
        try {
            Connection conn = Conexion.getConnection();
            request.setAttribute("UG", "activo");
            switch (accion) {
                
                case "historial":
                    request.getRequestDispatcher("/usuario/cargarhistorialmedico.jsp").forward(request, response);
                    
                    break;
                case "lista":
                    List<Medico> lista = UsuarioUtilidad.getListaMedico(conn);
                    mensaje = "no hay informacion";
                    if (lista.size() > 0) {
                        mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                    }   titulo = "LISTADO";
                    request.setAttribute("lista", lista);
                    link = "/usuario/medico.jsp";
                    break;
                case "nuevo":
                    titulo = "Agendar nueva CITA";
                    link = "/nuevo/cita_nueva.jsp";
                    break;
                
                    
                    
                    
                    
                default:
                    break;
            }
            conn.close();

            request.setAttribute("MENSAJE", mensaje);
            request.setAttribute("TITULO", titulo);
            request.getRequestDispatcher(link).forward(request, response);
        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
            request.setAttribute("Error", e.getMessage());
            request.getRequestDispatcher("/usuario/error.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
