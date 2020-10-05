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
import javax.servlet.http.HttpSession;
import proyecto.alchemilla.baseD.Conexion;
import proyecto.alchemilla.baseD.UsuarioUtilidad;
import proyecto.alchemilla.entidades.Cita;
import proyecto.alchemilla.entidades.Medico;
import proyecto.alchemilla.servlets.ServletComun;

@WebServlet(name = "PacienteGestor", urlPatterns = {"/PacienteGestor"})
public class PacienteGestor extends ServletComun {//7

    private HttpSession hs;
    private String accion;
    private String titulo;
    private String link;
    private String mensaje;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        validar(request, response);
        accion = request.getParameter("accion");
        titulo = "";
        link = "";
         mensaje = "";
        try {
            Connection conn = Conexion.getConnection();
            request.setAttribute("UG", "activo");
            switch (accion) {

                case "historial":
                    request.getRequestDispatcher("/historial/historialmedico.jsp").forward(request, response);
                    break;
                case "historialcita":
                    
                    try {
                    hs = request.getSession();
                    getHs().getAttribute("PUENTE");
                    String email = getHs().getAttribute("PUENTE").toString();
                    List<Cita> miCita = UsuarioUtilidad.getListaHistorialCita(conn, email);
                    mensaje = "no hay informacion";
                    if (miCita.size() > 0) {
                        mensaje = miCita.size() + (miCita.size() > 1 ? "registros" : "registro");
                    }
                    titulo = "LISTADO";
                    request.setAttribute("lista", miCita);
                    link = "/historial/contextocitahisto.jsp";

                } catch (SQLException e) {
                    request.getRequestDispatcher("/usuario/mibusqueda_cita.jsp").forward(request, response);
                    request.setAttribute("error", "No Tiene cita para tal fecha/hora");
                }

                break;
                case "historialexam":
                    
                    try {
                    hs = request.getSession();
                    getHs().getAttribute("PUENTE");
                    String email = getHs().getAttribute("PUENTE").toString();
                    List<Cita> miCita = UsuarioUtilidad.getListaHistorialCita(conn, email);
                    mensaje = "no hay informacion";
                    if (miCita.size() > 0) {
                        mensaje = miCita.size() + (miCita.size() > 1 ? "registros" : "registro");
                    }
                    titulo = "LISTADO";
                    request.setAttribute("lista", miCita);
                    link = "/historial/contextocitahisto.jsp";

                } catch (SQLException e) {
                    request.getRequestDispatcher("/usuario/mibusqueda_cita.jsp").forward(request, response);
                    request.setAttribute("error", "No Tiene cita para tal fecha/hora");
                }

                break;

                case "lista":
                    List<Medico> lista = UsuarioUtilidad.getListaMedico(conn);
                    mensaje = "no hay informacion";
                    if (lista.size() > 0) {
                        mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                    }
                    titulo = "LISTADO";
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public HttpSession getHs() {
        return hs;
    }

    public void setHs(HttpSession hs) {
        this.hs = hs;
    }
}
