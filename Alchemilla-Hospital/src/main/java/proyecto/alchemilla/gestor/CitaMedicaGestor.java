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
import proyecto.alchemilla.servlets.ServletComun;

@WebServlet(name = "CitaMedicaGestor", urlPatterns = {"/CitaMedicaGestor"})
public class CitaMedicaGestor extends ServletComun {//7

    Cita cm = new Cita();

    private HttpSession hs;
    private String accion;
    private String titulo;
    private String link;
    private String mensaje;
    private String email;

    private String accionDos;
    private String accionTres;
    private String accionCuatro;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        validar(request, response);
        accion = request.getParameter("accion");
        accionDos = request.getParameter("nombreDr");
        accionTres = request.getParameter("fecha");
        accionCuatro = request.getParameter("hora");
        titulo = "";
        link = "";
        mensaje = "";

        try {
            Connection conn = Conexion.getConnection();
            request.setAttribute("UG", "activo");

            switch (accion) {
                case "mibusqueda":
                    request.getRequestDispatcher("/busqueda/contenidoBusqueda.jsp").forward(request, response);
                    break;
                case "miCita": 
                    try {
                    hs = request.getSession();
                    getHs().getAttribute("PUENTE");
                    String emailL = getHs().getAttribute("PUENTE").toString();
                    List<Cita> miCita = UsuarioUtilidad.getMiListaCita(conn, emailL, accionDos, accionTres, accionCuatro);
                    mensaje = "no hay informacion";
                    if (miCita.size() > 0) {
                        mensaje = miCita.size() + (miCita.size() > 1 ? "registros" : "registro");
                    }
                    titulo = "LISTADO";
                    request.setAttribute("lista", miCita);
                    link = "/usuario/miCita.jsp";

                } catch (SQLException e) {
                    request.getRequestDispatcher("/busqueda/mibusqueda_cita.jsp").forward(request, response);
                    request.setAttribute("error", "No Tiene cita para tal fecha/hora");
                }

                break;

                case "comprobar":
                    request.getRequestDispatcher("/busqueda/busqueda_cita.jsp").forward(request, response);
                    break;

                case "verificar":       
                    try {
                    if (UsuarioUtilidad.citaExiste(conn, accionDos, accionTres, accionCuatro) == true) {
                        conn = Conexion.getConnection();
                        List<Cita> lista = UsuarioUtilidad.getListaCitaExistente(conn, accionDos, accionTres, accionCuatro);
                        mensaje = "no hay informacion";
                        if (lista.size() > 0) {
                            mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                        }
                        request.setAttribute("MENSAJE", mensaje);
                        request.setAttribute("TITULO", "Listado");
                        request.setAttribute("lista", lista);
                        request.setAttribute("UG", "activo");
                        request.getRequestDispatcher("/usuario/cita_verificacion.jsp").forward(request, response);

                    }
                } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {

                    request.getRequestDispatcher("/busqueda/busqueda_cita.jsp").forward(request, response);
                    request.setAttribute("error", "Los datos ingresados no coinciden en nuestra base de datos");

                }
                break;
                case "lista":
                    List<Cita> lista = UsuarioUtilidad.getListaCita(conn);
                    mensaje = "no hay informacion";
                    if (lista.size() > 0) {
                        mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                    }
                    titulo = "LISTADO";
                    request.setAttribute("lista", lista);
                    link = "/usuario/cita.jsp";
                    break;
                case "nuevo":
                    titulo = "Agendar nueva CITA";
                    link = "/nuevo/cita_nueva.jsp";
                    break;
                case "insert":
                    try {
                    cm = new Cita();
                    cm.setNombreDelMedico(request.getParameter("nombreMedico"));
                    cm.setCodigoCita(Integer.parseInt(request.getParameter("codigoCita")));
                    cm.setIdPaciente(Integer.parseInt(request.getParameter("idDePaciente")));
                    cm.setIdMedico(request.getParameter("idDeMedico"));
                    cm.setTipoDeConsulta(request.getParameter("tipoDeConsulta"));
                    cm.setFecha(request.getParameter("fecha"));
                    cm.setHora(request.getParameter("hora"));
                    UsuarioUtilidad.verificarEntero(request.getParameter("idDePaciente"));

                    if (!UsuarioUtilidad.citaExiste(conn, cm.getIdMedico(), cm.getFecha(), cm.getHora()) && UsuarioUtilidad.verificarEntero(request.getParameter("idDePaciente")) == true) {
                        System.out.println(cm.getHora());
                        UsuarioUtilidad.insertarCita(conn, cm);
                        mensaje = "REGISTRO GUARDADO!";
                        System.out.println("GUARDADO");
                    } else {
                        request.setAttribute("error", "No se pudo agendar. Ya hay una cita agendada para esa fecha y hora:");
                    }
                } catch (NumberFormatException | SQLException e) {
                    request.setAttribute("error", "No se pudo agendar su cita.\n Posible causas: Su id de paciente no es el correcto, \n El id del medico no es el adecuado o el tipo de examen no existe");
                }
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

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
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
