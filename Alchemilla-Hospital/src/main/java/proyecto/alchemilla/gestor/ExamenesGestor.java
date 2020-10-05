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
import proyecto.alchemilla.entidades.Examen;
import proyecto.alchemilla.entidades.Medico;
import proyecto.alchemilla.servlets.ServletComun;

@WebServlet(name = "ExamenesGestor", urlPatterns = {"/ExamenesGestor"})
public class ExamenesGestor extends ServletComun {//7

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
                    link = "/nuevo/examen_nuevo.jsp";
                    break;
                case "insert":
                    Examen ex = new Examen();
                    ex.setCodigoExamen(Integer.parseInt(request.getParameter("idDeExamen")));
                    ex.setNombreDelExamen(request.getParameter("nombreDeExamen"));
                    ex.setOrden(request.getParameter("orden"));
                    ex.setDescripcion(request.getParameter("descr"));
                    ex.setCosto(Float.parseFloat(request.getParameter("costoExamen")));
                    ex.setInforme(request.getParameter("informe"));
                    if (!UsuarioUtilidad.examenExiste(conn, ex.getNombreDelExamen())) {
                        System.out.println(ex.getNombreDelExamen());
                        UsuarioUtilidad.insertarExamen(conn, ex);
                        mensaje = "REGISTRO GUARDADO!";
                        System.out.println("GUARDADO");
                    } else {
                        request.setAttribute("error", "REGISTRO DUPLICADO: '" + ex.getNombreDelExamen() + "'");
                    }   titulo = "Agendar nueva CITA";
                    link = "/nuevo/examen_nuevo.jsp";
                    break;
                default:
                    break;
            }
            conn.close();

            request.setAttribute("MENSAJE", mensaje);
            request.setAttribute("TITULO", titulo);
            request.getRequestDispatcher(link).forward(request, response);
        } catch (IOException | ClassNotFoundException | SQLException | NumberFormatException| ServletException e  ) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/usuario/error.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
