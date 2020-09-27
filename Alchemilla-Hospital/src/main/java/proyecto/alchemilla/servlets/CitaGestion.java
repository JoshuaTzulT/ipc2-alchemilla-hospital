//6
package proyecto.alchemilla.servlets;

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
import proyecto.alchemilla.entidades.CitaMedica;
import proyecto.alchemilla.entidades.Usuario;

@WebServlet(name = "CitaGestion", urlPatterns = {"/CitaGestion"})
public class CitaGestion extends ServletComun {//7

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
            if (accion.equals("lista")) {
                List<Usuario> lista = UsuarioUtilidad.getListaUsuario(conn);
                mensaje = "no hay informacion";
                if (lista.size() > 0) {
                    mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                }
                titulo = "LISTADO";

                request.setAttribute("lista", lista);
                link = "/usuario/usuario.jsp";

            } else if (accion.equals("nuevo")) {
                titulo = "Agendar nueva CITA";
                link = "/usuario/cita_nueva.jsp";
            } else if (accion.equals("insert")) {

                CitaMedica cm = new CitaMedica();
                cm.setIdPaciente(Integer.parseInt(request.getParameter("idDePaciente")));
                cm.setNombrePaciente(request.getParameter("nombreDePaciente"));
                cm.setIdMedico(Integer.parseInt(request.getParameter("idDeMedico")));
                cm.setNombreMedico(request.getParameter("nombreDeMedico"));


                if (!UsuarioUtilidad.citaExiste(conn, cm.getNombrePaciente())) {
                    UsuarioUtilidad.insertarCita(conn, cm);
                    mensaje = "REGISTRO GUARDADO!";
                } else {
                    request.setAttribute("error", "REGISTRO DUPLICADO: '" + cm.getNombrePaciente() + "'");
                }
                titulo = "Agendar nueva CITA";
                link = "/usuario/cita_nueva.jsp";
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
