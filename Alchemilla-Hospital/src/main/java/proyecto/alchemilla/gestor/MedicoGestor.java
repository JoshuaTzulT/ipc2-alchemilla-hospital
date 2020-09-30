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

@WebServlet(name = "MedicoGestor", urlPatterns = {"/MedicoGestor"})
public class MedicoGestor extends ServletComun {//7

    private String almacenaje;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        validar(request, response);
        String accion = request.getParameter("accion");
        String accionDos = request.getParameter("nombre_de_usuario");
        String titulo = "";
        String link = "";
        String mensaje = "";
        almacenaje = accionDos;
        try {
            Connection conn = Conexion.getConnection();
            request.setAttribute("UG", "activo");

            if (almacenaje != null) {
                System.out.println(almacenaje);
                conn = Conexion.getConnection();
                List<Medico> lista = UsuarioUtilidad.buscarMedico(conn, almacenaje);
                 mensaje = "no hay informacion";
                if (lista.size() > 0) {
                    mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                }
                request.setAttribute("MENSAJE", mensaje);
                request.setAttribute("TITULO", "Listado");
                request.setAttribute("lista", lista);
                request.setAttribute("UG", "activo");
                request.getRequestDispatcher("/usuario/medico.jsp").forward(request, response);
            }

            else if (accion.equals("lista")) {
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
                link = "/nuevo/medico_nuevo.jsp";
            } else if (accion.equals("insert")) {

                Medico medico = new Medico();
                medico.setIdMedico(request.getParameter("idDeMedico"));
                medico.setNombre(request.getParameter("nombreDeMedico"));
                medico.setNumeroDeColegiado(Integer.parseInt(request.getParameter("numeroColegiado")));
                medico.setDpi(Integer.parseInt(request.getParameter("dpi")));
                medico.setTelefono(request.getParameter("telefono"));
                medico.setEspecialidad(request.getParameter("especialidad"));
                medico.setEmail(request.getParameter("email"));
                medico.setHorarioDeAtencionInicio(request.getParameter("horaInicio"));
                medico.setHorarioDeAtencionFinal(request.getParameter("horaFin"));
                medico.setFechaDeInicio(request.getParameter("fechaContrato"));

                if (!UsuarioUtilidad.medicoExiste(conn, medico.getNumeroDeColegiado())) {
                    System.out.println(medico.getNumeroDeColegiado());
                    UsuarioUtilidad.insertarMedico(conn, medico);
                    mensaje = "REGISTRO GUARDADO!";
                    System.out.println("GUARDADO");
                } else {
                    request.setAttribute("error", "REGISTRO DUPLICADO: '" + medico.getNumeroDeColegiado() + "'");
                }
                titulo = "Agendar nueva CITA";
                link = "/nuevo/medico_nuevo.jsp";
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
