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
import proyecto.alchemilla.entidades.Laboratorista;
import proyecto.alchemilla.entidades.Medico;
import proyecto.alchemilla.servlets.ServletComun;

@WebServlet(name = "LaboratoristaGestor", urlPatterns = {"/LaboratoristaGestor"})
public class LaboratoristaGestor extends ServletComun {//7

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
                    link = "/nuevo/laboratorista_nuevo.jsp";
                    break;
                case "insert":
                    Laboratorista lab = new Laboratorista();
                    lab.setIdLaboratorista(request.getParameter("idDeLaboratorista"));
                    lab.setNombre(request.getParameter("nombreDeLaboratorista"));
                    lab.setRegistroMinisterio(request.getParameter("registroMinisterio"));
                    lab.setDpi(Integer.parseInt(request.getParameter("dpi")));
                    lab.setTelefono(request.getParameter("telefono"));
                    lab.setExamen(request.getParameter("examen"));
                    lab.setEmail(request.getParameter("email"));
                    lab.setDiasHabiles(request.getParameter("diasTrabajo"));
                    lab.setPassword(request.getParameter("contraseña"));
                    lab.setFechaInicio(request.getParameter("contratoFecha"));
                    if (!UsuarioUtilidad.laboratoristaExiste(conn, lab.getRegistroMinisterio())) {
                        System.out.println(lab.getRegistroMinisterio());
                        UsuarioUtilidad.insertarLaboratorista(conn, lab);
                        mensaje = "REGISTRO GUARDADO!";
                        System.out.println("GUARDADO");
                    } else {
                        request.setAttribute("error", "REGISTRO DUPLICADO: '" + lab.getRegistroMinisterio() + "'");
                    }   titulo = "Agendar nueva CITA";
                    link = "/nuevo/laboratorista_nuevo.jsp";
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
}
