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
import proyecto.alchemilla.entidades.Usuario;
import proyecto.alchemilla.gestor.CitaMedicaGestor;
import proyecto.alchemilla.gestor.MedicoGestor;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    private HttpSession emailPuente;
    private String almacenajeCorreo;
    CitaMedicaGestor cmg = new CitaMedicaGestor();
    private String usuario;
    private String password;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        usuario = request.getParameter("nombre_de_usuario");
        password = request.getParameter("password");

        try {
            Connection conn = Conexion.getConnection();
            Usuario usu = UsuarioUtilidad.login(conn, usuario, password);

            if (usu != null) {
                request.getSession().setAttribute("USUARIO_ACTUAL", usu);
                conn.close();
                request.setAttribute("PRINCIPAL", "activo");
                request.getRequestDispatcher("/principal/index.jsp").forward(request, response);

            } else {
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
        usuario = request.getParameter("nombre_de_usuario");
        emailPuente = request.getSession();
        emailPuente.setAttribute("PUENTE", usuario);
        cmg.setHs(emailPuente);

    }

    public HttpSession getEmailPuente() {
        return emailPuente;
    }

    public void setEmailPuente(HttpSession emailPuente) {
        this.emailPuente = emailPuente;
    }

}
