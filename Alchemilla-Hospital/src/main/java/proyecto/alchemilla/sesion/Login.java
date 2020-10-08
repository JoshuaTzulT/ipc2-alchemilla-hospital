//4
package proyecto.alchemilla.sesion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import proyecto.alchemilla.baseD.Conexion;
import proyecto.alchemilla.baseD.UsuarioUtilidad;
import proyecto.alchemilla.entidades.Administrador;
import proyecto.alchemilla.entidades.Medico;
import proyecto.alchemilla.entidades.Usuario;
import proyecto.alchemilla.gestor.CitaMedicaGestor;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    private HttpSession emailPuente;
    private String almacenajeCorreo;
    CitaMedicaGestor cmg = new CitaMedicaGestor();

    UsuarioUtilidad uti = new UsuarioUtilidad();
    private String usuario;
    private String password;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        usuario = request.getParameter("email");
        password = request.getParameter("password");
        System.out.println("PRIMER:" + usuario);
        System.out.println("SEGUNDO :" + password);

        try {
            Connection conn = Conexion.getConnection();
            uti.revisarUsuario(conn, usuario, password);
//            Usuario usu = UsuarioUtilidad.revisarLoginUsuario(conn, usuario, password);

            if (uti != null && uti.revisarUsuario(conn, usuario, password).equals("usuario")) {
                Usuario usu = new Usuario();
                usu = uti.revisarLoginUsuario(conn, usuario, password);
                System.out.println("usuario");
                request.getSession().setAttribute("USUARIO_ACTUAL", usu);
                conn.close();
                request.setAttribute("PRINCIPAL", "activo");
                request.getRequestDispatcher("/principal/index.jsp").forward(request, response);

            } else if (uti != null && uti.revisarUsuario(conn, usuario, password).equals("medico")) {
                Medico medico = new Medico();
                medico = uti.revisarLoginMedico(conn, usuario, password);
                System.out.println("MEDICO");
                request.getSession().setAttribute("MEDICO_ACTUAL", medico);
                conn.close();
                request.setAttribute("PRINCIPAL", "activo");
                request.getRequestDispatcher("/principal/index_1.jsp").forward(request, response);
                // request.getRequestDispatcher("HOLA.jsp").forward(request, response);

            } //else if(uti != null && uti.revisarUsuario(conn, usuario, password).equals("laboratorista")){
            //                    Administrador admin = new Administrador();
            //                request.getSession().setAttribute("LABORATORISTA_ACTUAL", admin);
            //                conn.close();
            //                request.setAttribute("PRINCIPAL", "activo");
            //                request.getRequestDispatcher("/principal/index.jsp").forward(request, response);
            //                
            //                
            //            }else if(uti != null && uti.revisarUsuario(conn, usuario, password).equals("administrador")){
            //                request.getSession().setAttribute("ADMIN_ACTUAL", uti);
            //                conn.close();
            //                request.setAttribute("PRINCIPAL", "activo");
            //                request.getRequestDispatcher("/principal/index.jsp").forward(request, response);
            //                
            //            }
            else {
                request.setAttribute("error", "USUARIO INCORRECTO O CONTRASEÑA INCORRECTA");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
            request.setAttribute("error", "ERROR DEL SISTEMA:" + e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        emailPuente = request.getSession();
        emailPuente.setAttribute("PUENTE", usuario);
        emailPuente.getAttribute("PUENTE");
        cmg.setHs(emailPuente);

    }

    public HttpSession getEmailPuente() {
        return emailPuente;
    }

    public void setEmailPuente(HttpSession emailPuente) {
        this.emailPuente = emailPuente;
    }

}
