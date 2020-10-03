////6
//package proyecto.alchemilla.gestor;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import proyecto.alchemilla.baseD.Conexion;
//import proyecto.alchemilla.baseD.UsuarioUtilidad;
//import proyecto.alchemilla.entidades.Consulta;
//import proyecto.alchemilla.entidades.Medico;
//import proyecto.alchemilla.servlets.ServletComun;
//
//@WebServlet(name = "ConsultaGestor", urlPatterns = {"/ConsultaGestor"})
//public class ConsultaGestor extends ServletComun {//7
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        validar(request, response);
//        String accion = request.getParameter("accion");
//        String titulo = "";
//        String link = "";
//        String mensaje = "";
//        try {
//            Connection conn = Conexion.getConnection();
//            request.setAttribute("UG", "activo");
//            if (accion.equals("lista")) {
//                List<Medico> lista = UsuarioUtilidad.getListaMedico(conn);
//                mensaje = "no hay informacion";
//                if (lista.size() > 0) {
//                    mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
//                }
//                titulo = "LISTADO";
//
//                request.setAttribute("lista", lista);
//                link = "/usuario/medico.jsp";
//
//            } else if (accion.equals("nuevo")) {
//                titulo = "Agendar nueva CITA";
//                link = "/nuevo/consulta_nueva.jsp";
//            } else if (accion.equals("insert")) {
//
//                Consulta consulta = new Consulta();
//                consulta.setTipoDeConsulta(request.getParameter("tipoDeConsulta"));
//                consulta.setPrecio(Float.parseFloat(request.getParameter("costoConsulta")));
//
//                if (!UsuarioUtilidad.citaExiste(conn, consulta.getTipoDeConsulta())) {
//                    System.out.println(consulta.getTipoDeConsulta());
//                    UsuarioUtilidad.insertarConsulta(conn, consulta);
//                    mensaje = "REGISTRO GUARDADO!";
//                    System.out.println("GUARDADO");
//                } else {
//                    request.setAttribute("error", "REGISTRO DUPLICADO: '" + consulta.getTipoDeConsulta() + "'");
//                }
//                titulo = "Agendar nueva CITA";
//                link = "/nuevo/consulta_nueva.jsp";
//            }
//            conn.close();
//
//            request.setAttribute("MENSAJE", mensaje);
//            request.setAttribute("TITULO", titulo);
//            request.getRequestDispatcher(link).forward(request, response);
//        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
//            request.setAttribute("Error", e.getMessage());
//            request.getRequestDispatcher("/usuario/error.jsp").forward(request, response);
//        }
//
//    }
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//}
