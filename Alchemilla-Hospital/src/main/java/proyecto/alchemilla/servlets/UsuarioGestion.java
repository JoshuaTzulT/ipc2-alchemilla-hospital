//6
package proyecto.alchemilla.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.alchemilla.baseD.Conexion;
import proyecto.alchemilla.baseD.UsuarioUtilidad;
import proyecto.alchemilla.entidades.Usuario;

@WebServlet(name = "UsuarioGestion", urlPatterns = {"/UsuarioGestion"})
public class UsuarioGestion extends ServletComun {//7

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        validar(request,response);//7
        String accion = request.getParameter("accion");
        try {
            Connection conn = Conexion.getConnection();
            if (accion.equals("lista")) {
                List<Usuario> lista = UsuarioUtilidad.getListaUsuario(conn);
                String mensaje = "no hay informacion";
                if (lista.size() > 0) {
                    mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                }
                request.setAttribute("MENSAJE", mensaje);
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("/usuario/usuario.jsp").forward(request, response);
            }
        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
            request.setAttribute("Error", e.getMessage());
           request.getRequestDispatcher("/usuario/error.jsp").forward(request, response);
        }

    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//6     validate(request, response);
//        String action = request.getParameter("action");
//// 6       String caption = "";
//// 6       String link = "";
//        String msg = "";
//        try {
//            Connection conn = Conexion.getConnection();
////  6          request.setAttribute("UM", "active");
//            if (action.equals("list")) {
//                List<Usuario> list = UsuarioUtilidad.getListaUsuario(conn);
//                msg = "no data";
//                if (list.size() > 0) {
//                    msg = list.size() + (list.size() > 1 ? "records" : "record");
//                }
//                request.setAttribute("MSG", msg);
//                request.setAttribute("list", list);
//                request.getRequestDispatcher("/usuario/usuario.jsp").forward(request, response);
////  6              request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
////  6              caption = "List of Users";
//
////  6              link = "/WEB-INF/view/user/user.jsp";
////6
////  6          } else if (action.equals("new")) {
////  6              caption = "Add New User";
//// 6               link = "/WEB-INF/view/user/user_new.jsp";
////            } else if (action.equals("insert")) {
////                Usuario u = new Usuario();
////                u.setUserName(request.getParameter("userName"));
////                u.setPassword(request.getParameter("password"));
//////                    u.setPassword(CryptoUtil.encode(request.getParameter("password")));
////                u.setEmail(request.getParameter("email"));
////                u.setDisplayName(request.getParameter("displayName"));
////
////                if (!UserBusiness.isUserExisted(conn, u.getUserName())) {
////                    UserBusiness.insertUser(conn, u);
////                    msg = "Inserted Successfully!";
////                } else {
////                    request.setAttribute("err", "Duplicated user: '" + u.getUserName() + "'");
////                }
////                caption = "Add New User";
////                link = "/WEB-INF/view/user/user_new.jsp";
////            }
////            conn.close();
////
////            request.setAttribute("MSG", msg);
////            request.setAttribute("CAPTION", caption);
////            request.getRequestDispatcher(link).forward(request, response);
//            }
//        } catch(IOException | ClassNotFoundException | SQLException | ServletException e){ //(IOException | ServletException e) {
//            request.setAttribute("Error", e.getMessage());
////  6          request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
//        } 
//
//    }
//
////    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }

}
