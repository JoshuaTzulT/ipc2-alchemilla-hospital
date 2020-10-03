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
import proyecto.alchemilla.servlets.ServletComun;

@WebServlet(name = "CitaMedicaGestor", urlPatterns = {"/CitaMedicaGestor"})
public class CitaMedicaGestor extends ServletComun {//7

    Cita cm = new Cita();
    private String accion;
    private String titulo;
    private String link;
    private String mensaje;

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

        System.out.println(accionCuatro + "GIGIRI");
        try {
            Connection conn = Conexion.getConnection();
            request.setAttribute("UG", "activo");

            switch (accion) {
                case "comprobar":
                    System.out.println("HOLA 1");
                    request.getRequestDispatcher("/usuario/busqueda_cita.jsp").forward(request, response);
                    break;
                case "verificar":       
                  //  try {
                        if (UsuarioUtilidad.citaExiste(conn, accionDos, accionTres, accionCuatro)==true) {
                            System.out.println("1");
                            conn = Conexion.getConnection();
                            System.out.println("2");
                            List<Cita>lista = UsuarioUtilidad.getListaCitaExistente(conn, accionDos, accionTres, accionCuatro);
                            System.out.println("3");
                            mensaje = "no hay informacion";
                            if (lista.size() > 0) 
                            System.out.println("4");{
                                mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                                System.out.println("5");
                            }
                            System.out.println("6");
                            request.setAttribute("MENSAJE", mensaje);
                            request.setAttribute("TITULO", "Listado");
                            request.setAttribute("lista", lista);
                            request.setAttribute("UG", "activo");
                            request.getRequestDispatcher("/usuario/cita_verificacion.jsp").forward(request, response);

                        }else {
                  //  } catch (Exception e) {

                        request.getRequestDispatcher("/usuario/busqueda_cita.jsp").forward(request, response);
                        //  request.setAttribute("error", "Los datos ingresados no coinciden en nuestra base de datos");

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
                    cm = new Cita();
                    cm.setNombreDelMedico(request.getParameter("nombreMedico"));
                    cm.setCodigoCita(Integer.parseInt(request.getParameter("codigoCita")));
                    cm.setIdPaciente(Integer.parseInt(request.getParameter("idDePaciente")));
                    cm.setIdMedico(request.getParameter("idDeMedico"));
                    cm.setTipoDeConsulta(request.getParameter("tipoDeConsulta"));
                    cm.setFecha(request.getParameter("fecha"));
                    cm.setHora(request.getParameter("hora"));
                    if (!UsuarioUtilidad.citaExiste(conn, cm.getIdMedico(), cm.getFecha(), cm.getHora())) {
                        System.out.println(cm.getHora());
                        UsuarioUtilidad.insertarCita(conn, cm);
                        mensaje = "REGISTRO GUARDADO!";
                        System.out.println("GUARDADO");
                    } else {
                        request.setAttribute("error", "Ya hay una cita agendada para esa fecha y hora:");
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
}
