//6
package proyecto.alchemilla.gestor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import proyecto.alchemilla.baseD.Conexion;
import proyecto.alchemilla.baseD.UsuarioUtilidad;
import proyecto.alchemilla.entidades.Cita;
import proyecto.alchemilla.entidades.CitaLaboratorio;
import proyecto.alchemilla.servlets.ServletComun;

@WebServlet(name = "CitaLaboratorioGestor", urlPatterns = {"/CitaLaboratorioGestor"})

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 1000,
        maxRequestSize = 1024 * 1024 * 100)

public class CitaLaboratorioGestor extends ServletComun {//7

    private HttpSession hs;
    private String accion;
    private String titulo;
    private String link;
    private String mensaje;

    private String accionDos;
    private String accionTres;
    private String accionCuatro;

    PrintWriter out = null;
    HttpSession session = null;

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        validar(request, response);
        accion = request.getParameter("accion");
        accionDos = request.getParameter("nombreDr");
        accionTres = request.getParameter("fecha");
        accionCuatro = request.getParameter("hora");
        titulo = "";
        link = "";
        mensaje = "";

        try {
            Connection conn = Conexion.getConnection();
            request.setAttribute("UG", "activo");

            switch (accion) {
                case "miCita":
                    hs = request.getSession();
                    String email = getHs().getAttribute("PUENTE").toString();
                    List<Cita> miCita = UsuarioUtilidad.getMiListaCita(conn, email, accionDos, accionTres, accionCuatro);
                    mensaje = "no hay informacion";
//                    if (miCita.size() > 0) {
//                        mensaje = miCita.size() + (miCita.size() > 1 ? "registros" : "registro");
//                    }
                    titulo = "LISTADO";
//                    request.setAttribute("lista", miCita);
                    link = "/usuario/miCita.jsp";

                    break;

                case "comprobar":
                    request.getRequestDispatcher("/usuario/busqueda_cita.jsp").forward(request, response);
                    break;

                case "verificar":       
                    try {
                    if (UsuarioUtilidad.citaExiste(conn, accionDos, accionTres, accionCuatro) == true) {
                        conn = Conexion.getConnection();
                        List<Cita> lista = UsuarioUtilidad.getListaCitaExistente(conn, accionDos, accionTres, accionCuatro);
                        mensaje = "no hay informacion";
                        if (lista.size() > 0) {
                            mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                        }
                        request.setAttribute("MENSAJE", mensaje);
                        request.setAttribute("TITULO", "Listado");
                        request.setAttribute("lista", lista);
                        request.setAttribute("UG", "activo");
                        request.getRequestDispatcher("/usuario/cita_verificacion.jsp").forward(request, response);

                    }
                } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {

                    request.getRequestDispatcher("/usuario/busqueda_cita.jsp").forward(request, response);
                    request.setAttribute("error", "Los datos ingresados no coinciden en nuestra base de datos");

                }
                break;
//                case "lista":
//                    List<Cita> lista = UsuarioUtilidad.getListaCita(conn);
//                    mensaje = "no hay informacion";
//                    if (lista.size() > 0) {
//                        mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
//                    }
//                    titulo = "LISTADO";
//                    request.setAttribute("lista", lista);
//                    link = "/usuario/cita.jsp";
//                    break;
                case "nuevo":
                    titulo = "Agendar nueva CITA";
                    link = "/nuevo/cita_laboratorio_nueva.jsp";
                    break;
                case "insert":
                    try {

                    out = response.getWriter();
                    session = request.getSession(false);
                    String folderName = "resources";
                    String uploadPath = request.getServletContext().getRealPath("") + File.separator + folderName;
                    File dir = new File(uploadPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();
            String path = folderName + File.separator + fileName;
            System.out.println("fileName: " + fileName);
            System.out.println("Path: " + uploadPath);
            InputStream is = filePart.getInputStream();
            Files.copy(is, Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
                                       
                    CitaLaboratorio cl = new CitaLaboratorio();
                    cl.setIDCita(Integer.parseInt(request.getParameter("idCita")));
                    cl.setIDPaciente(Integer.parseInt(request.getParameter("idPaciente")));
                    cl.setIDLaboratorista(Integer.parseInt(request.getParameter("idLaboratorista")));
                    cl.setIDExamen(Integer.parseInt(request.getParameter("codigoExamen")));
                    cl.setNombreDelExamen(request.getParameter("nombreExamen"));
                    cl.setOrden(path);
                    cl.setFechaExamen(request.getParameter("fecha"));
                    cl.setHoraExamen(request.getParameter("hora"));
                    cl.setCosto(Float.parseFloat(request.getParameter("costo")));
                    cl.setInforme(request.getParameter("informe"));

                    UsuarioUtilidad.verificarEntero(request.getParameter("idDePaciente"));
                    if (!UsuarioUtilidad.citaLabExiste(conn, cl.getIDCita(), cl.getFechaExamen(), 
                       cl.getHoraExamen()) && UsuarioUtilidad.verificarEntero(request.getParameter("idCita")) == true) {
                        UsuarioUtilidad.insertarCitaLab(conn, cl);
                        mensaje = "REGISTRO GUARDADO!";
                        System.out.println("GUARDADO");
                    } else {
                        request.setAttribute("error", "No se pudo agendar. Ya hay una cita agendada para esa fecha y hora:");
                    }
                } catch (NumberFormatException | SQLException e) {
                    request.setAttribute("error", "No se pudo agendar su cita.\n Posible causas: Su id de paciente no es el correcto, \n El id del medico no es el adecuado o el tipo de examen no existe");
                }
                titulo = "Agendar CITA";
                link = "/nuevo/cita_laboratorio_nueva.jsp";
                break;

                default:
                    break;
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

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public HttpSession getHs() {
        return hs;
    }

    public void setHs(HttpSession hs) {
        this.hs = hs;
    }
}
