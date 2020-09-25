//4
package proyecto.alchemilla.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.alchemilla.baseD.Conexion;
import proyecto.alchemilla.baseD.UsuarioUtilidad;
import proyecto.alchemilla.entidades.Usuario;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("nombre_de_usuario");
        String password = request.getParameter("password");

//5        password = CryptoUtil.encode(password);
        try {
            Connection conn = Conexion.getConnection();
            Usuario usu = UsuarioUtilidad.login(conn, usuario, password);

            if (usu != null) {
                request.getSession().setAttribute("USUARIO_ACTUAL", usu);
                conn.close();
//4                request.setAttribute("HOME", "active");
//4                request.getRequestDispatcher("/WEB-INF/view/home/index.jsp").forward(request, response);
                request.getRequestDispatcher("/principal/index.jsp").forward(request, response);

            } else {
                request.setAttribute("error", "USUARIO INCORRECTO O CONTRASEÑA INCORRECTA");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
            request.setAttribute("error", "ERROR DEL SISTEMA:" + e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

}
