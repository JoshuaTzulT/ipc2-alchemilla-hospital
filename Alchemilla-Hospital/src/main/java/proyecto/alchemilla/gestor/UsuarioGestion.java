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
import proyecto.alchemilla.entidades.Usuario;
import proyecto.alchemilla.servlets.ServletComun;

@WebServlet(name = "UsuarioGestion", urlPatterns = {"/UsuarioGestion"})
public class UsuarioGestion extends ServletComun {//7

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        validar(request, response);//7
//        String accion = request.getParameter("accion");
//        try {
//            Connection conn = Conexion.getConnection();
//            if (accion.equals("lista")) {
//                List<Usuario> lista = UsuarioUtilidad.getListaUsuario(conn);
//                String mensaje = "no hay informacion";
//                if (lista.size() > 0) {
//                    mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
//                }
//                request.setAttribute("MENSAJE", mensaje);
//                request.setAttribute("TITULO", "Listado");
//                request.setAttribute("lista", lista);
//                request.setAttribute("UG", "activo");
//                request.getRequestDispatcher("/usuario/usuario.jsp").forward(request, response);
//            }
//        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
//            request.setAttribute("Error", e.getMessage());
//            request.getRequestDispatcher("/usuario/error.jsp").forward(request, response);
//        }
//
//    }
//    @Override
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
                titulo = "Agregar Nuevo Usuario";
                link = "/usuario/usuario_nuevo.jsp";
            } else if (accion.equals("insert")) {
                Usuario usu = new Usuario();
                usu.setNombreDeUsuario(request.getParameter("nombreDeUsuario"));
                usu.setPassword(request.getParameter("password"));
//                    u.setPassword(CryptoUtil.encode(request.getParameter("password")));
                usu.setEmail(request.getParameter("email"));

                if (!UsuarioUtilidad.citaExiste(conn, usu.getNombreDeUsuario())) {
//                    UsuarioUtilidad.insertarCita(conn, usu);
                    mensaje = "REGISTRO GUARDADO!";
                } else {
                    request.setAttribute("error", "REGISTRO DUPLICADO: '" + usu.getNombreDeUsuario() + "'");
                }
                titulo = "AÑADIR REGISTROS";
                link = "/usuario/usuario_nuevo.jsp";
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
