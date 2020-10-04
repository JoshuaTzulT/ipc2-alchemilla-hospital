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
    Usuario usua = new Usuario();
    String accion;
    String titulo;
    String link;
    String mensaje;

    private String accionDos;
    private String accionTres;
    private String accionCuatro;
    private String accionCinco;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        validar(request, response);
        accion = request.getParameter("accion");
        accionDos = request.getParameter("nombreDeUsuario");
        accionTres = request.getParameter("alias");
        accionCuatro = request.getParameter("email");
        accionCinco = request.getParameter("password");

        titulo = "";
        link = "";
        mensaje = "";

        try {
            Connection conn = Conexion.getConnection();
            request.setAttribute("UG", "activo");
            switch (accion) {              
                 case "nuevo":
                    titulo = "";
                    link = "/nuevo/usuario_nuevo.jsp";
                    break;
                case "registar":
                    System.out.println("JESUS SUPER STAR");
                    
                        usua.setNombreDeUsuario(accionDos);
                        usua.setAlias(accionTres);
                        usua.setEmail(accionCuatro);
                        usua.setPassword(accionCinco);
                    if (UsuarioUtilidad.usuarioExiste(conn, usua.getEmail()) == false) {
                        System.out.println("HEMOS ARRIBADO");
                        UsuarioUtilidad.insertarUsuario(conn, usua);
                        System.out.println("CITA RAPID");
                        mensaje = "Usuario REGISTRADO!";
                    }else {
                        request.setAttribute("error", "No se pudo registra. Ya hay un usuario que pertenece a este E-mail");
                    }
                      titulo = "";
                    link = "/nuevo/usuario_nuevo.jsp";
                    break;
            }

            conn.close();

            request.setAttribute("MENSAJE", mensaje);
            request.setAttribute("TITULO", titulo);
           request.getRequestDispatcher(link).forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
              request.setAttribute("error", "Verifique que este ingresando datos válidos");  
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
