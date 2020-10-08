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
import javax.servlet.http.HttpSession;
import proyecto.alchemilla.baseD.Conexion;
import proyecto.alchemilla.baseD.UsuarioUtilidad;
import proyecto.alchemilla.entidades.Cita;
import proyecto.alchemilla.entidades.CitaLaboratorio;
import proyecto.alchemilla.entidades.Informe;
import proyecto.alchemilla.entidades.Medico;
import proyecto.alchemilla.entidades.Paciente;
import proyecto.alchemilla.servlets.ServletComun;

@WebServlet(name = "MedicoGestor", urlPatterns = {"/MedicoGestor"})
public class MedicoGestor extends ServletComun {//7
   
    private boolean interruptor ;
    private String almacenaje;
    private String alamacenajeDos;
    private HttpSession hs ;
    private String accion;
    private String accionDos;
    private String titulo;
    private String link;
    private String mensaje;
    private String accionTres;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        validar(request, response);
        accion = request.getParameter("accion");
        accionDos = request.getParameter("nombre_de_usuario");
        accionTres = request.getParameter("nombre_de_usuario");
        titulo = "";
        link = "";
        mensaje = "";
        almacenaje = accionDos;
        
        try {
            Connection conn = Conexion.getConnection();
            request.setAttribute("UG", "activo");
            if (almacenaje != null) {
                System.out.println(almacenaje);
                conn = Conexion.getConnection();
                List<Medico> lista = UsuarioUtilidad.buscarMedico(conn, almacenaje);
                if(interruptor == true){
                
                if (lista.size() > 0) {
                    mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                }
                
                }else{
                     mensaje = "no hay informacion";
                    request.setAttribute("error", mensaje);
                } 
                titulo = "Listado de Médicos";
                link = "/usuario/medico.jsp"; 
                request.setAttribute("MENSAJE", mensaje);
                request.setAttribute("TITULO", "Listado De Médicos");
                request.setAttribute("lista", lista);
                request.setAttribute("UG", "activo");        
            }
            if(accion.equals("paciente_lista")){           
                List<Paciente> lista = UsuarioUtilidad.getListaPaciente(conn);
                mensaje = "no hay informacion";
//                request.getRequestDispatcher("/usuario/medico.jsp").forward(request, response);
                if (lista.size() > 0) {
                    mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                }
                titulo = "LISTADO";
                request.setAttribute("lista", lista);
                link = "/usuario/paciente.jsp";               
            } 
                
                if(accion.equals("secreportes")){
                System.out.println("HOLA1");
                 request.getRequestDispatcher("/nuevo/contexto_citame_lista.jsp").forward(request, response);           
            
            }
               
            
            if (accion.equals("histocita_paciente")) {
                System.out.println("HOLA2");
                request.getRequestDispatcher("/nuevo/contexto_citame_lista_2.jsp").forward(request, response);
            }
            
//              if (accion.equals("histolab_paciente")) {
//                System.out.println("HOLA2");
//                request.getRequestDispatcher("/nuevo/contexto_citalab_lista_2.jsp").forward(request, response);
//            }
            
//            if(accion.equals("histocita_pacienteD")){
//                System.out.println("HOLAMUNDO" +accionTres);
//                conn = Conexion.getConnection();
//                List<Cita> lista = UsuarioUtilidad.getListaCitaSideMedico(conn, accionTres);
//                if(interruptor == true){
//                
//                if (lista.size() > 0) {
//                    mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
//                }
//                
//                }else{
//                     mensaje = "no hay informacion";
//                    request.setAttribute("error", mensaje);
//                } 
//                titulo = "Listado de Citas";
//                link = "/nuevo/contexto_citame_lista_1.jsp"; 
//                request.setAttribute("MENSAJE", mensaje);
//                request.setAttribute("TITULO", "Listado De Médicos");
//                request.setAttribute("lista", lista);
//                request.setAttribute("UG", "activo");
//                }
            
            if(accion.equals("histocita_pacienteD")){
                System.out.println("HOLAMUNDO" +accionTres);
                conn = Conexion.getConnection();
                List<CitaLaboratorio> lista = UsuarioUtilidad.getListaLabSideMedico(conn, accionTres);
                if(interruptor == true){
                
                if (lista.size() > 0) {
                    mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                }
                
                }else{
                     mensaje = "no hay informacion";
                    request.setAttribute("error", mensaje);
                } 
                titulo = "Listado de Citas";
                link = "/nuevo/contexto_citame_lista_1.jsp"; 
                request.setAttribute("MENSAJE", mensaje);
                request.setAttribute("TITULO", "Listado De Médicos");
                request.setAttribute("lista", lista);
                request.setAttribute("UG", "activo");
                }
            

            else if (accion.equals("lista")) {
                List<Medico> lista = UsuarioUtilidad.getListaMedico(conn);
                mensaje = "no hay informacion";
                if (lista.size() > 0) {
                    mensaje = lista.size() + (lista.size() > 1 ? "registros" : "registro");
                }
                titulo = "Listado de Médicos";
                request.setAttribute("lista", lista);
                link = "/usuario/medico.jsp";

            } else if (accion.equals("nuevo")) {
                titulo = "Agendar nueva CITA";
                link = "/nuevo/medico_nuevo.jsp";
            } else if (accion.equals("insert")) {

                Medico medico = new Medico();
                medico.setIdMedico(request.getParameter("idDeMedico"));
                medico.setNombre(request.getParameter("nombreDeMedico"));
                medico.setNumeroDeColegiado(Integer.parseInt(request.getParameter("numeroColegiado")));
                medico.setDpi(Integer.parseInt(request.getParameter("dpi")));
                medico.setTelefono(request.getParameter("telefono"));
                medico.setEspecialidad(request.getParameter("especialidad"));
                medico.setEmail(request.getParameter("email"));
                medico.setHorarioDeAtencionInicio(request.getParameter("horaInicio"));
                medico.setHorarioDeAtencionFinal(request.getParameter("horaFin"));
                medico.setFechaDeInicio(request.getParameter("fechaContrato"));

                if (!UsuarioUtilidad.medicoExiste(conn, medico.getNumeroDeColegiado())) {
                    System.out.println(medico.getNumeroDeColegiado());
                    UsuarioUtilidad.insertarMedico(conn, medico);
                    mensaje = "REGISTRO GUARDADO!";
                    System.out.println("GUARDADO");
                } else {
                    request.setAttribute("error", "REGISTRO DUPLICADO: '" + medico.getNumeroDeColegiado() + "'");
                }
                titulo = "Agendar nueva CITA";
                link = "/nuevo/medico_nuevo.jsp";
            }else if(accion.equals("informe")){
                request.getRequestDispatcher("/usuario/informe.jsp").forward(request, response);
                
            }else if(accion.equals("realizarInforme")){
                Informe informe = new Informe();
                informe.setCodigoInforme(Integer.parseInt(request.getParameter("idInforme")));
                informe.setCodigoPaciente(Integer.parseInt(request.getParameter("idPaciente")));
                informe.setCodigoMedico(Integer.parseInt(request.getParameter("idMedico")));
                informe.setInforme(request.getParameter("informeP"));
                informe.setFecha(request.getParameter("fecha"));
                informe.setHora(request.getParameter("hora"));
                
                if (UsuarioUtilidad.informeExiste(conn, informe.getCodigoInforme())==true) {
                    System.out.println(informe.getCodigoInforme());
                    UsuarioUtilidad.insertarInforme(conn, informe);
                    mensaje = "REGISTRO GUARDADO!";
                    System.out.println("GUARDADO");
                } else {
                    request.setAttribute("error", "REGISTRO DUPLICADO: '" + informe.getCodigoInforme() + "'");
                }
                titulo = "INFORMES";
                link = "/usuario/informe.jsp";
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public String getAlamacenajeDos() {
        return alamacenajeDos;
    }

    public void setAlamacenajeDos(String alamacenajeDos) {
        this.alamacenajeDos = alamacenajeDos;
    }

    public boolean isInterruptor() {
        return interruptor;
    }

    public void setInterruptor(boolean interruptor) {
        this.interruptor = interruptor;
    }
   
}
