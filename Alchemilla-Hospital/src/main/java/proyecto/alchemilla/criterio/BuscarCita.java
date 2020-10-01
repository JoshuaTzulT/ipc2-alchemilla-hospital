//6
package proyecto.alchemilla.criterio;

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

@WebServlet(name = "BuscarCita", urlPatterns = {"/BuscarCita"})
public class BuscarCita extends ServletComun {//7

    Connection conn;
    private String accionUno;
    private String accionDos;
    private String accionTres;
    private String accionCuatro;
//    Existe existe = new Existe();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        validar(request, response);
        accionUno = request.getParameter("criterioUno");
        accionDos = request.getParameter("criterioDos");
        accionTres = request.getParameter("criterioTres");
        accionCuatro = request.getParameter("criterioCuatro");
        

        String titulo = "";
        String link = "";
        String mensaje = "";
        try {
            conn = Conexion.getConnection();
            request.setAttribute("UG", "activo");
            if (Existe.noEsNulo(accionUno, accionDos, accionTres, accionCuatro) == true) {
                conn = Conexion.getConnection();
                System.out.println("DESPUES DE CONEXION");
                List<Cita> lista = UsuarioUtilidad.buscarCitaPorCriterio(conn, accionUno, accionDos, accionTres, accionCuatro);
                System.out.println("ACA DEBERIA LLAMAR A LA LISTA");
                mensaje = "no hay informacion";
                if (lista.size() > 0) {
                    mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                }
                    

                request.setAttribute("MENSAJE", mensaje);
                request.setAttribute("TITULO", "Listado");
                request.setAttribute("lista", lista);
                request.setAttribute("UG", "activo");
                request.getRequestDispatcher("/usuario/cita.jsp").forward(request, response);


            } else {
                System.out.println("NO WE PUDO");
                request.setAttribute("error", "COMPLETE TODOS LOS CAMPOS");
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

    public String getAccionUno() {
        return accionUno;
    }

    public void setAccionUno(String accionUno) {
        this.accionUno = accionUno;
    }

    public String getAccionDos() {
        return accionDos;
    }

    public void setAccionDos(String accionDos) {
        this.accionDos = accionDos;
    }

    public String getAccionTres() {
        return accionTres;
    }

    public void setAccionTres(String accionTres) {
        this.accionTres = accionTres;
    }

    public String getAccionCuatro() {
        return accionCuatro;
    }

    public void setAccionCuatro(String accionCuatro) {
        this.accionCuatro = accionCuatro;
    }
}
