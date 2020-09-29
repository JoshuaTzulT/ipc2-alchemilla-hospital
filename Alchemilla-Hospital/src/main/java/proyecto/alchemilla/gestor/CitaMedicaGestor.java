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

@WebServlet(name = "CitaMedicaGestor", urlPatterns = {"/CitaMedicaGestor"})
public class CitaMedicaGestor extends ServletComun {//7

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
                List<Medico> lista = UsuarioUtilidad.getListaMedico(conn);
                mensaje = "no hay informacion";
                if (lista.size() > 0) {
                    mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                }
                titulo = "LISTADO";

                request.setAttribute("lista", lista);
                link = "/usuario/medico.jsp";

            } else if (accion.equals("nuevo")) {
                titulo = "Agendar nueva CITA";
                link = "/nuevo/cita_nueva.jsp";
            } else if (accion.equals("insert")) {

                Cita cm = new Cita();
                cm.setIdPaciente(Integer.parseInt(request.getParameter("idDePaciente")));
                cm.setIdMedico(request.getParameter("idDeMedico"));
                cm.setTipoDeConsulta(request.getParameter("tipoDeConsulta"));
                cm.setFecha(request.getParameter("fecha"));
                cm.setHora(request.getParameter("hora"));

                if (!UsuarioUtilidad.citaExiste(conn, cm.getHora())) {
                    System.out.println(cm.getHora());
                    UsuarioUtilidad.insertarCita(conn, cm);
                    mensaje = "REGISTRO GUARDADO!";
                    System.out.println("GUARDADO");
                } else {
                    request.setAttribute("error", "REGISTRO DUPLICADO: '" + cm.getHora() + "'");
                }
                titulo = "Agendar nueva CITA";
                link = "/nuevo/cita_nueva.jsp";
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
