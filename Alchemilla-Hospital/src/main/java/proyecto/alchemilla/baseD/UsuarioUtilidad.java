//3
package proyecto.alchemilla.baseD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto.alchemilla.entidades.Administrador;
import proyecto.alchemilla.entidades.CitaLaboratorio;
import proyecto.alchemilla.entidades.Cita;
import proyecto.alchemilla.entidades.Consulta;
import proyecto.alchemilla.entidades.Examen;
import proyecto.alchemilla.entidades.Informe;
import proyecto.alchemilla.entidades.Laboratorista;
import proyecto.alchemilla.entidades.Medico;
import proyecto.alchemilla.entidades.Paciente;
import proyecto.alchemilla.entidades.Usuario;
import proyecto.alchemilla.gestor.MedicoGestor;

public class UsuarioUtilidad {

    Usuario u = new Usuario();

    public String revisarUsuario(Connection con, String usuario, String password) throws SQLException {
        System.out.println("ACA ENTRAMOS ");

        for (int i = 0; i <= 4; i++) {
            if (i == 1) {
                System.out.println("UNO");
                String sql = "SELECT nombre, "
                        + "passw "
                        + "FROM paciente WHERE email = ? and passw = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                System.out.println(sql);
                int j = 1;
                ps.setString(j++, usuario);
                ps.setString(j++, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    u.setNombreDeUsuario(rs.getString("nombre"));
                    u.setEmail("alias");
                    return "usuario";
                }
            }
            if (i == 2) {
                System.out.println("DOS");
                String sql = "SELECT nombre, "
                        + "pass "
                        + "FROM medico WHERE email = ? and pass = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                int j = 1;
                ps.setString(j++, usuario);
                ps.setString(j++, password);
                ResultSet rs = ps.executeQuery();
                System.out.println(sql);
                if (rs.next()) {
                    u.setNombreDeUsuario(rs.getString("nombre"));
                    u.setEmail("alias");
                    return "medico";
                }
                if (rs.next()) {
                    break;
                }
            }
            if (i == 3) {
                System.out.println("TRES");
                String sql = "SELECT nombre, "
                        + "passw "
                        + "FROM laboratorista WHERE email = ? and passw = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                System.out.println(sql);
                int j = 1;
                ps.setString(j++, usuario);
                ps.setString(j++, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    u.setNombreDeUsuario(rs.getString("nombre"));
                    u.setEmail("alias");
                    return "laboratorista";
                }
                if (rs.next()) {
                    break;
                }
            }

            if (i == 4) {
                System.out.println("CUATRO");
                String sql = "SELECT nombre, "
                        + "passw "
                        + "FROM administrador WHERE email = ? and passw = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                System.out.println(sql);
                int j = 1;
                ps.setString(j++, usuario);
                ps.setString(j++, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    u.setNombreDeUsuario(rs.getString("nombre"));
                    u.setEmail("alias");
                    return "administrador";
                }
                if (rs.next()) {
                    break;
                }
            }
        }
        return "nada";
    }

    public Usuario revisarLoginUsuario(Connection con, String usuario, String password) throws SQLException {
        String sql = "SELECT nombre, "
                + "passw "
                + "FROM usuario WHERE email = ? and passw = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        int i = 1;
        ps.setString(i++, usuario);
        ps.setString(i++, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Usuario u = new Usuario();
            u.setNombreDeUsuario(rs.getString("nombre"));
            return u;
        }
        return null;
    }

    public Medico revisarLoginMedico(Connection con, String usuario, String password) throws SQLException {
        String sql = "SELECT nombre, "
                + "pass "
                + "FROM medico WHERE email = ? and pass = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        int i = 1;
        ps.setString(i++, usuario);
        ps.setString(i++, password);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Medico med = new Medico();
            med.setNombre(rs.getString("nombre"));
            return med;
        }
        return null;
    }

    public Usuario revisarLoginLaboratorista(Connection con, String usuario, String password) throws SQLException {
        String sql = "SELECT nombre, "
                + "passw "
                + "FROM laboratorista WHERE email = ? and passw = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        int i = 1;
        ps.setString(i++, usuario);
        ps.setString(i++, password);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Usuario u = new Usuario();
            u.setNombreDeUsuario(rs.getString("nombre"));
            u.setEmail("alias");

            return u;
        }
        return null;
    }

    public static Administrador revisarLoginAdmin(Connection con, String usuario, String password) throws SQLException {
        String sql = "SELECT nombre, "
                + "passw "
                + "FROM administrador WHERE email = ? and passw = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        int i = 1;
        ps.setString(i++, usuario);
        ps.setString(i++, password);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Administrador admin = new Administrador();
            admin.setNombre(rs.getString("nombre"));
            return admin;
        }
        return null;
    }

    public static List<Medico> getListaMedico(Connection con) throws SQLException {
        String query = "SELECT id_medico, "
                + " nombre, "
                + "numero_colegiado, "
                + " dpi,"
                + "especialidad, "
                + "email, "
                + "horario_atencion_inicio, "
                + "horario_atencion_final, "
                + "fecha_inicio "
                + "FROM medico";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Medico> lista = new ArrayList<>();
        while (rs.next()) {
            Medico medico = new Medico();
            medico.setIdMedico(rs.getString("id_medico"));
            medico.setNombre(rs.getString("nombre"));
            medico.setNumeroDeColegiado(rs.getInt("numero_colegiado"));
            medico.setDpi(rs.getInt("dpi"));
            medico.setEspecialidad(rs.getString("especialidad"));
            medico.setEmail(rs.getString("email"));
            medico.setHorarioDeAtencionInicio(rs.getString("horario_atencion_inicio"));
            medico.setHorarioDeAtencionFinal(rs.getString("horario_atencion_final"));
            medico.setFechaDeInicio(rs.getString("fecha_inicio"));
            lista.add(medico);
        }
        return lista;
    }

    public static List<Cita> getMiListaCita(Connection con, String email, String idMedico, String fecha, String hora) throws SQLException {
        System.out.println("HOLA EL EMAIL ES :" + email);
        String primerQuery = "SELECT id_paciente FROM paciente WHERE email = ? ";
        PreparedStatement psP = con.prepareStatement(primerQuery);
        psP.setString(1, email);
        ResultSet rsP = psP.executeQuery();
        String id = "";
        if (rsP.next()) {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(rsP.getInt("id_paciente"));
            System.out.println(rsP.getInt("id_paciente"));
            System.out.println(rsP.getString("id_paciente"));
            id = rsP.getString("id_paciente");
        }

        String query = "SELECT paciente.nombre, "
                + "cita.tipo_de_consulta, "
                + "cita.fecha, "
                + "cita.hora "
                + "FROM paciente JOIN cita ON cita.id_paciente = paciente.id_paciente "
                + "WHERE cita.id_medico =  ? "
                + "AND  cita.fecha = ? "
                + "AND cita.hora = ? ";

        System.out.println(query);
        PreparedStatement ps = con.prepareStatement(query);
        int i = 1;
        ps.setString(i++, id);
//        ps.setString(i++, idMedico);
        ps.setString(i++, fecha);
        ps.setString(i++, hora);
        System.out.println(ps);
        ResultSet rs = ps.executeQuery();
        System.out.println(rs);
        List<Cita> lista = new ArrayList<>();
        while (rs.next()) {
            Cita cm = new Cita();
            cm.setNombreDelPaciente(rs.getString("paciente.nombre"));
            cm.setTipoDeConsulta(rs.getString("cita.tipo_de_consulta"));
            cm.setFecha(rs.getString("cita.fecha"));
            cm.setHora(rs.getString("cita.hora"));
            lista.add(cm);
        }
        return lista;
    }

    public static List<Cita> getListaHistorialCita(Connection con, String email) throws SQLException {
        System.out.println("HOLA EL EMAIL ES :" + email);
        String primerQuery = "SELECT id_paciente FROM paciente WHERE email = ? ";
        PreparedStatement psP = con.prepareStatement(primerQuery);
        psP.setString(1, email);
        ResultSet rsP = psP.executeQuery();
        String id = "";
        if (rsP.next()) {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(rsP.getInt("id_paciente"));
            System.out.println(rsP.getInt("id_paciente"));
            System.out.println(rsP.getString("id_paciente"));
            id = rsP.getString("id_paciente");
        }

        String query = "SELECT "
                + "paciente.nombre, "
                + "medico.nombre, "
                + "cita.tipo_de_consulta, "
                + "cita.fecha, "
                + "cita.hora, "
                + "consulta.costo "
                + "FROM "
                + "paciente "
                + "INNER JOIN "
                + "cita ON paciente.id_paciente = cita.id_paciente "
                + "JOIN "
                + "medico ON medico.id_medico = cita.id_medico "
                + "JOIN "
                + "consulta ON consulta.tipo_de_consulta = cita.tipo_de_consulta "
                + "WHERE paciente.id_paciente = ? "
                + "ORDER BY cita.fecha DESC";

        System.out.println(query);
        PreparedStatement ps = con.prepareStatement(query);
        int i = 1;
        ps.setString(i++, id);
        System.out.println(ps);
        ResultSet rs = ps.executeQuery();
        System.out.println(rs);
        List<Cita> lista = new ArrayList<>();
        while (rs.next()) {
            Cita cm = new Cita();
            cm.setNombreDelPaciente(rs.getString("paciente.nombre"));
            cm.setNombreDelMedico(rs.getString("medico.nombre"));
            cm.setTipoDeConsulta(rs.getString("cita.tipo_de_consulta"));
            cm.setFecha(rs.getString("cita.fecha"));
            cm.setHora(rs.getString("cita.hora"));
            cm.setCosto(Float.parseFloat(rs.getString("consulta.costo")));
            lista.add(cm);
        }
        return lista;
    }


    public static List<CitaLaboratorio> getListaHistorialLaboratorio(Connection con, String email) throws SQLException {
        System.out.println("HOLA EL EMAIL ES :" + email);
        String primerQuery = "SELECT id_paciente FROM paciente WHERE email = ? ";
        PreparedStatement psP = con.prepareStatement(primerQuery);
        psP.setString(1, email);
        ResultSet rsP = psP.executeQuery();
        String id = "";
        if (rsP.next()) {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(rsP.getInt("id_paciente"));
            System.out.println(rsP.getInt("id_paciente"));
            System.out.println(rsP.getString("id_paciente"));
            id = rsP.getString("id_paciente");
        }

        String query = "SELECT "
                + "paciente.nombre, "
                + "examen.codigo_examen, "
                + "examen.nombre_examen, "
                + "cita_laboratorio.fecha_examen, "
                + "cita_laboratorio.hora_examen, "
                + "examen.costo "
                + "FROM "
                + "paciente "
                + "INNER JOIN "
                + "cita_laboratorio ON paciente.id_paciente = cita_laboratorio.id_paciente "
                + "JOIN "
                + "examen ON examen.codigo_examen = cita_laboratorio.codigo_examen "
                + "WHERE paciente.id_paciente = ? "
                + "ORDER BY cita_laboratorio.fecha_examen DESC ";

        System.out.println(query);
        PreparedStatement ps = con.prepareStatement(query);
        int i = 1;
        ps.setString(i++, id);
        System.out.println(ps);
        ResultSet rs = ps.executeQuery();
        System.out.println(rs);
        List<CitaLaboratorio> lista = new ArrayList<>();
        while (rs.next()) {
            CitaLaboratorio cl = new CitaLaboratorio();
            cl.setNombreDePaciente(rs.getString("paciente.nombre"));
            cl.setIDExamen(rs.getInt("examen.codigo_examen"));
            cl.setNombreDelExamen(rs.getString("examen.nombre_examen"));
            cl.setFechaExamen(rs.getString("cita_laboratorio.fecha_examen"));
            cl.setHoraExamen(rs.getString("cita_laboratorio.hora_examen"));
            cl.setCosto(Float.parseFloat(rs.getString("examen.costo")));
            lista.add(cl);
        }
        System.out.println("HASTA ACA");
        return lista;
    }
    public static List<Paciente>getListaPaciente(Connection con) throws SQLException{
        String query = "SELECT "
                + "id_paciente, "
                + "nombre, "
                + "sexo, "
                + "fecha_nacimiento, "
                + "dpi, "
                + "telefono, "
                + "peso, "
                + "tipo_de_sangre, "
                + "email "
                + "FROM paciente";
        
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Paciente> lista = new ArrayList<>();
        while (rs.next()) {
           Paciente paciente = new Paciente();
           paciente.setIdPaciente(rs.getInt("id_paciente"));
           paciente.setNombre(rs.getString("nombre"));
           paciente.setSexo(rs.getString("sexo"));
           paciente.setFechaNacimiento(rs.getString("fecha_nacimiento"));
           paciente.setDpi(rs.getInt("dpi"));
           paciente.setTelefono(rs.getString("telefono"));
           paciente.setPeso(rs.getInt("peso"));
           paciente.setTipoDeSangre(rs.getString("tipo_de_sangre"));
           paciente.setEmail(rs.getString("email"));       
            lista.add(paciente);
        }
        return lista;
    }

    public static List<Cita> getListaCitaSideMedico(Connection con,  String id ) throws SQLException {
        String query = "SELECT codigo_cita, "
                + "id_paciente, "
                + "id_medico, "
                + "tipo_de_consulta, "
                + "fecha, "
                + "hora "
                + "FROM cita WHERE "
                + "id_paciente = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        int i = 1;
        ps.setString(i++, id);
        ResultSet rs = ps.executeQuery();
        List<Cita> lista = new ArrayList<>();
        while (rs.next()) {
            Cita cm = new Cita();
            cm.setIdPaciente(rs.getInt("codigo_cita"));
            cm.setIdPaciente(rs.getInt("id_paciente"));
            cm.setIdMedico(rs.getString("id_medico"));
            cm.setTipoDeConsulta(rs.getString("tipo_de_consulta"));
            cm.setFecha(rs.getString("fecha"));
            cm.setHora(rs.getString("hora"));
            lista.add(cm);
        }
        return lista;
    }
    
    
     public static List<CitaLaboratorio> getListaLabSideMedico(Connection con,  String id ) throws SQLException {
        String query = "SELECT id_citalab, "
                + "id_paciente, "
                + "id_laboratorista, "
                + "codigo_examen, "
                + "nombre_examen, "
                + "fecha_examen, "
                + "hora_examen "
                + "FROM cita_laboratorio WHERE "
                + "id_paciente = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        int i = 1;
        ps.setString(i++, id);
        ResultSet rs = ps.executeQuery();
        List<CitaLaboratorio> lista = new ArrayList<>();
        while (rs.next()) {
            CitaLaboratorio cl = new CitaLaboratorio();
            cl.setIDCita(rs.getInt("codigo_cita"));
            cl.setIDPaciente(rs.getInt("id_paciente"));
            cl.setIDLaboratorista(rs.getInt("id_laboratorista"));
            cl.setIDExamen(rs.getInt("codigo_examen"));
            cl.setNombreDelExamen(rs.getString("nombre_examen"));
            cl.setFechaExamen(rs.getString("fecha_examen"));
            cl.setHoraExamen(rs.getString("hora_examen"));
            lista.add(cl);
        }
        return lista;
    }
    
    
    

/////////////////////////POSIBLE METÓDO INUTIL///////////////////////////////////////////////////////////////////////////////
    public static List<Cita> getListaCitaExistente(Connection con, String nombre, String fecha, String hora) throws SQLException {
        System.out.println("SHUB NIGGURATH");
        String query = "SELECT medico.nombre, "
                + "cita.id_medico, "
                + "cita.fecha, "
                + "cita.hora "
                + "FROM medico JOIN cita ON cita.id_medico = medico.id_medico "
                + "WHERE medico.id_medico =  ? "
                + "AND  cita.fecha =  ? "
                + " AND  cita.hora = ? ";
        System.out.println(query);
        PreparedStatement ps = con.prepareStatement(query);
        int i = 1;
        ps.setString(i++, nombre);
        ps.setString(i++, fecha);
        ps.setString(i++, hora);

        System.out.println(ps);
        ResultSet rs = ps.executeQuery();
        System.out.println(rs);
        List<Cita> lista = new ArrayList<>();
        while (rs.next()) {
            System.out.println("CHTULHU");
            Cita cm = new Cita();
            cm.setNombreDelMedico(rs.getString("medico.nombre"));
            cm.setIdMedico(rs.getString("cita.id_medico"));
            cm.setFecha(rs.getString("cita.fecha"));
            cm.setHora(rs.getString("cita.hora"));
            lista.add(cm);
        }
        System.out.println("YOG SOTHOT");
        return lista;
    }

    public static List<CitaLaboratorio> getListaCitaLaboratorio(Connection con) throws SQLException {
        String query = "SELECT fecha_examen, "
                + "hora_examen, "
                + "estado, "
                + "id_examen, "
                + "id_laboratorista, "
                + "id_paciente FROM cita_laboratorio";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<CitaLaboratorio> lista = new ArrayList<>();
        while (rs.next()) {
            CitaLaboratorio cl = new CitaLaboratorio();
            lista.add(cl);
        }
        return lista;
    }

    public static List<Examen> getListaExamen(Connection con) throws SQLException {
        String query = "SELECT codigo_examen, "
                + "nombre_examen, "
                + "orden, "
                + "descripcion, "
                + "costo, "
                + "informe FROM examen";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<Examen> lista = new ArrayList<>();
        while (rs.next()) {
            Examen ex = new Examen();
            lista.add(ex);
        }
        return lista;
    }

    public static List<Consulta> getListaConsulta(Connection con) throws SQLException {
        String query = "SELECT tipo_de_consulta, "
                + "costo FROM consulta";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<Consulta> lista = new ArrayList<>();
        while (rs.next()) {
            Consulta consulta = new Consulta();
            lista.add(consulta);
        }
        return lista;
    }

    public static List<Laboratorista> getListaLaboratorista(Connection con) throws SQLException {
        String query = "SELECT id_laboratorista, "
                + " nombre, "
                + "registro_ministerio, "
                + "dpi,"
                + "telefono, "
                + "examen, "
                + "email, "
                + "dias_labura, "
                + "passw, "
                + "fecha_inicio "
                + "FROM laboratorista";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<Laboratorista> lista = new ArrayList<>();
        while (rs.next()) {
            Laboratorista lab = new Laboratorista();
            lab.setIdLaboratorista(rs.getString("id_laboratorista"));
            lab.setNombre(rs.getString("nombre"));
            lab.setRegistroMinisterio(rs.getString("registro_ministerio"));
            lab.setDpi(rs.getInt("dpi"));
            lab.setTelefono(rs.getString("telefono"));
            lab.setExamen(rs.getString("examen"));
            lab.setEmail(rs.getString("email"));
            lab.setDiasHabiles(rs.getString("dias_labura"));
            lab.setPassword(rs.getString("passw"));
            lab.setFechaInicio(rs.getString("fecha_inicio"));
            lista.add(lab);
        }
        return lista;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean verificarEntero(String idPaciente) {
        try {
            int i = Integer.parseInt(idPaciente);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean citaLabExiste(Connection conn, int codigo, String fecha, String horario) throws SQLException {

        String sql = "SELECT codigo_examen, "
                + "fecha_examen, "
                + "hora_examen "
                + "FROM "
                + "cita_laboratorio "
                + "WHERE codigo_examen = ? "
                + "AND fecha_examen = ? "
                + "AND hora_examen = ? ";
                

        System.out.println("HEEMOS LLEGADO ACA");
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.setString(2, fecha);
        ps.setString(3, horario);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println(" hay algo");
            return true;

        } else {
            System.out.println("NO HAY NADA");
            return false;
        }

    }

    public static boolean citaExiste(Connection conn, String idMed, String fecha, String horario) throws SQLException {

        String sql = "SELECT medico.nombre, cita.id_medico, cita.fecha, cita.hora "
                + "FROM medico JOIN cita ON cita.id_medico = medico.id_medico "
                + "WHERE medico.id_medico =  ? "
                + "AND  cita.fecha =  ? "
                + " AND  cita.hora = ? ";

        System.out.println("HEEMOS LLEGADO ACA");
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, idMed);
        ps.setString(2, fecha);
        ps.setString(3, horario);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println(" hay algo");
            return true;

        } else {
            System.out.println("NO HAY NADA");
            return false;
        }

    }
 

    public static boolean consultaExiste(Connection conn, String nombreConsulta) throws SQLException {
        String sql = "SELECT tipo_de_consulta "
                + "FROM consulta WHERE tipo_de_consulta = ?";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nombreConsulta);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public static boolean medicoExiste(Connection conn, int colegiado) throws SQLException {
        String sql = "SELECT numero_colegiado "
                + "FROM medico WHERE numero_colegiado = ?";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, colegiado);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }
    
    public static boolean informeExiste(Connection conn, int codigoInforme) throws SQLException {
        String sql = "SELECT codigo_informe "
                + "FROM informe WHERE informe = ? ";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, codigoInforme);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public static boolean laboratoristaExiste(Connection conn, String ministerio) throws SQLException {
        String sql = "SELECT registro_ministerio "
                + "FROM laboratorista WHERE registro_ministerio = ?";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, ministerio);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public static boolean examenExiste(Connection conn, String nombre) throws SQLException {
        String sql = "SELECT nombre_examen "
                + "FROM examen WHERE nombre_examen = ?";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void insertarCita(Connection conn, Cita cm) throws SQLException {
        String sql = "INSERT INTO cita "
                + "(codigo_cita, "
                + "id_paciente, "
                + "id_medico, "
                + "tipo_de_consulta, "
                + "fecha, "
                + "hora) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 1;
        ps.setInt(i++, cm.getCodigoCita());
        ps.setInt(i++, cm.getIdPaciente());
        ps.setString(i++, cm.getIdMedico());
        ps.setString(i++, cm.getTipoDeConsulta());
        ps.setString(i++, cm.getFecha());
        ps.setString(i++, cm.getHora());
        ps.executeUpdate();
        System.out.println("EJECUTADO");
    }
    
    public static void insertarCitaLab(Connection conn, CitaLaboratorio cl) throws SQLException {
        String sql = "INSERT INTO cita_laboratorio"
                + "(id_citalab, "
                + "id_paciente, "
                + "id_laboratorista, "
                + "codigo_examen, "
                + "nombre_examen, "
                + "orden, "
                + "fecha_examen, "
                + "hora_examen, "
                + "costo_examen, "
                + "informe) "
                + "VALUE(?, ?, ?, ?, ? ,?, ?, ?, ?, ?) ";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 1;
        ps.setInt(i++, cl.getIDCita());
        ps.setInt(i++, cl.getIDPaciente());
        ps.setInt(i++, cl.getIDLaboratorista());
        ps.setInt(i++, cl.getIDExamen());
        ps.setString(i++, cl.getNombreDelExamen());
        ps.setString(i++, cl.getOrden());
        ps.setString(i++, cl.getFechaExamen());
        ps.setString(i++, cl.getHoraExamen());
        ps.setFloat(i++, cl.getCosto());
        ps.setString(i++, cl.getInforme());      
        ps.executeUpdate();
    }

    public static void insertarUsuario(Connection conn, Usuario usu) throws SQLException {
        String sql = "INSERT INTO usuario (nombre, "
                + "alias, "
                + "passw, "
                + "email) "
                + "VALUES(?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 1;
        ps.setString(i++, usu.getNombreDeUsuario());
        ps.setString(i++, usu.getAlias());
        ps.setString(i++, usu.getPassword());
        ps.setString(i++, usu.getEmail());
        ps.executeUpdate();
    }

    public static void insertarExamen(Connection conn, Examen examen) throws SQLException {
        String sql = "INSERT INTO examen "
                + "(codigo_examen, "
                + "nombre_examen, "
                + "orden, "
                + "descripcion, "
                + "costo, "
                + "informe) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 1;
        ps.setInt(i++, examen.getCodigoExamen());
        ps.setString(i++, examen.getNombreDelExamen());
        ps.setString(i++, examen.getOrden());
        ps.setString(i++, examen.getDescripcion());
        ps.setFloat(i++, examen.getCosto());
        ps.setString(i++, examen.getInforme());
        ps.executeUpdate();
        System.out.println("EJECUTADO");
    }

    public static void insertarConsulta(Connection conn, Consulta consulta) throws SQLException {
        String sql = "INSERT INTO consulta "
                + "(tipo_de_consulta, "
                + "costo) "
                + "VALUES (?, ?)";
        System.out.println(sql);

        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 1;
        ps.setString(i++, consulta.getTipoDeConsulta());
        ps.setFloat(i++, consulta.getPrecio());
        ps.executeUpdate();
        System.out.println("EJECUTADO");
    }

    public static void insertarMedico(Connection conn, Medico medico) throws SQLException {
        String sql = "INSERT INTO medico "
                + "(id_medico, "
                + "nombre, "
                + "numero_colegiado, "
                + "dpi, "
                + "telefono, "
                + "especialidad, "
                + "email, "
                + "horario_atencion_inicio, "
                + "horario_atencion_final, "
                + "fecha_inicio) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println(sql);

        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 1;
        ps.setString(i++, medico.getIdMedico());
        ps.setString(i++, medico.getNombre());
        ps.setInt(i++, medico.getNumeroDeColegiado());
        ps.setInt(i++, medico.getDpi());
        ps.setString(i++, medico.getTelefono());
        ps.setString(i++, medico.getEspecialidad());
        ps.setString(i++, medico.getEmail());
        ps.setString(i++, medico.getHorarioDeAtencionInicio());
        ps.setString(i++, medico.getHorarioDeAtencionFinal());
        ps.setString(i++, medico.getFechaDeInicio());
        ps.executeUpdate();
        System.out.println("EJECUTADO");
    }
    

    
    public static void insertarInforme(Connection conn, Informe inf ) throws SQLException{
        String sql ="INSERT INTO informe"
                + "(codigo_informe, "
                + "paciente, "
                + "medico, "
                + "informe, "
                + "fecha, "
                + "hora) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 1;
        ps.setInt(i++, inf.getCodigoInforme());
        ps.setInt(i++, inf.getCodigoPaciente());
        ps.setInt(i++, inf.getCodigoMedico());
        ps.setString(i++, inf.getInforme());
        ps.setString(i++, inf.getFecha());
        ps.setString(i++, inf.getHora());
        ps.executeUpdate();
        System.out.println("EXITO");
    }

    public static void insertarLaboratorista(Connection conn, Laboratorista lb) throws SQLException {
        String sql = "INSERT INTO laboratorista "
                + "(id_laboratorista, "
                + "nombre, "
                + "registro_ministerio, "
                + "dpi, "
                + "telefono, "
                + "examen, "
                + "email, "
                + "dias_labura, "
                + "passw, "
                + "fecha_inicio) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println(sql);

        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 1;
        ps.setString(i++, lb.getIdLaboratorista());
        ps.setString(i++, lb.getNombre());
        ps.setString(i++, lb.getRegistroMinisterio());
        ps.setInt(i++, lb.getDpi());
        ps.setString(i++, lb.getTelefono());
        ps.setString(i++, lb.getExamen());
        ps.setString(i++, lb.getEmail());
        ps.setString(i++, lb.getDiasHabiles());
        ps.setString(i++, lb.getPassword());
        ps.setString(i++, lb.getFechaInicio());
        ps.executeUpdate();
        System.out.println("EJECUTADO");
    }


//    public static void main(String args[]) throws ClassNotFoundException, SQLException{
//        Connection con = Conexion.getConnection();
//        buscarPaciente(con, "1");
//    }
    public static List<Paciente>buscarPaciente(Connection con, String criterio) throws SQLException{
        String query = "SELECT "
                + "id_paciente, "
                + "nombre, "
                + "sexo, "
                + "fecha_nacimiento, "
                + "dpi, "
                + "telefono, "
                + "peso, "
                + "tipo_de_sangre, "
                + "email "
                + "FROM paciente WHERE nombre LIKE  ? "
                + "OR id_paciente LIKE ? "
                + "OR email LIKE ? "
                + "OR dpi LIKE ? ";

        
        PreparedStatement ps = con.prepareStatement(query);
        int i = 1;
        System.out.println(i);
        ps.setString(i++, "%" + criterio + "%");
        ps.setString(i++, "%" + criterio + "%");
        ps.setString(i++, "%" + criterio + "%");
        ps.setString(i++, "%" + criterio + "%");
        System.out.println(i);

        ResultSet rs = ps.executeQuery();

        List<Paciente> lista = new ArrayList<>();
        while (rs.next()) {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(rs.getInt("id_paciente"));
            paciente.setNombre(rs.getString("nombre"));
            paciente.setSexo(rs.getString("sexo"));
            paciente.setDpi(rs.getInt("dpi"));
            paciente.setTelefono(rs.getString("telefono"));
            paciente.setPeso(rs.getInt("peso"));
            paciente.setTipoDeSangre(rs.getString("tipo_de_sangre"));
            paciente.setEmail(rs.getString("email"));
            lista.add(paciente);
        }
        System.out.println("INDICA QUE TODO ESTA BIEN");
        return lista;
    }
    public static List<Medico> buscarMedico(Connection con, String criterio) throws SQLException {
        String query = "SELECT id_medico, "
                + "nombre, "
                + "numero_colegiado, "
                + "dpi,"
                + "especialidad, "
                + "email, "
                + "horario_atencion_inicio, "
                + "horario_atencion_final, "
                + "fecha_inicio "
                + "FROM medico WHERE nombre LIKE  ? OR especialidad LIKE ? "
                + "OR horario_atencion_inicio LIKE ? "
                + "OR horario_atencion_final LIKE ? ";

        PreparedStatement ps = con.prepareStatement(query);
        int i = 1;
        System.out.println(i);
        ps.setString(i++, "%" + criterio + "%");
        ps.setString(i++, "%" + criterio + "%");
        ps.setString(i++, "%" + criterio + "%");
        ps.setString(i++, "%" + criterio + "%");
        System.out.println(i);

        ResultSet rs = ps.executeQuery();

        List<Medico> lista = new ArrayList<Medico>();
        while (rs.next()) {
            MedicoGestor mg = new MedicoGestor();
            mg.setInterruptor(true);
            Medico medico = new Medico();
            medico.setIdMedico(rs.getString("id_medico"));
            medico.setNombre(rs.getString("nombre"));
            medico.setNumeroDeColegiado(rs.getInt("numero_colegiado"));
            medico.setDpi(rs.getInt("dpi"));
            medico.setEspecialidad(rs.getString("especialidad"));
            medico.setEmail(rs.getString("email"));
            medico.setHorarioDeAtencionInicio(rs.getString("horario_atencion_inicio"));
            medico.setHorarioDeAtencionFinal(rs.getString("horario_atencion_final"));
            medico.setFechaDeInicio(rs.getString("fecha_inicio"));
            lista.add(medico);
        }
        return lista;
    }

    public static List<Cita> buscarCitaPorCriterio(Connection con, String criterioUno, String criterioDos, String criterioTres, String criterioCuatro)
            throws SQLException {
        System.out.println(criterioUno);
        System.out.println(criterioDos);
        System.out.println(criterioTres);
        System.out.println(criterioCuatro);
        String query = "SELECT codigo_cita, "
                + "id_paciente, "
                + "id_medico, "
                + "tipo_de_consulta, "
                + "fecha, "
                + "hora "
                + "FROM cita "
                + "WHERE hora BETWEEN ? AND ? "
                + "OR fecha BETWEEN ? AND ? ";

        PreparedStatement ps = con.prepareStatement(query);
        System.out.println(query);
        int i = 1;
        ps.setString(i++, criterioUno);
        ps.setString(i++, criterioDos);
        ps.setString(i++, criterioTres);
        ps.setString(i++, criterioCuatro);

        ResultSet rs = ps.executeQuery();
        List<Cita> lista = new ArrayList<>();
        while (rs.next()) {
            Cita cita = new Cita();
            cita.setCodigoCita(rs.getInt("codigo_cita"));
            cita.setIdPaciente(rs.getInt("id_paciente"));
            cita.setIdMedico(rs.getString("id_medico"));
            cita.setTipoDeConsulta(rs.getString("tipo_de_consulta"));
            cita.setFecha(rs.getString("fecha"));
            cita.setHora(rs.getString("hora"));
            lista.add(cita);
        }
        return lista;
    }

    public static List<Cita> buscarPacientesMayores(Connection con, String criterioUno, String criterioDos, String criterioTres, String criterioCuatro)
            throws SQLException {
        System.out.println(criterioUno);
        System.out.println(criterioDos);
        System.out.println(criterioTres);
        System.out.println(criterioCuatro);
        String query = "SELECT id_paciente, "
                + "COUNT(id_paciente) "
                + "FROM cita "
                + "WHERE hora BETWEEN ? AND ? "
                + "OR fecha  BETWEEN ? AND ? "
                + "GROUP BY id_paciente "
                + "ORDER BY id_paciente DESC;";

        PreparedStatement ps = con.prepareStatement(query);
        System.out.println(query);
        int i = 1;
        ps.setString(i++, criterioUno);
        ps.setString(i++, criterioDos);
        ps.setString(i++, criterioTres);
        ps.setString(i++, criterioCuatro);

        ResultSet rs = ps.executeQuery();
        List<Cita> lista = new ArrayList<>();
        while (rs.next()) {
            Cita cita = new Cita();
            cita.setCodigoCita(rs.getInt("codigo_cita"));
            cita.setIdPaciente(rs.getInt("id_paciente"));
            cita.setIdMedico(rs.getString("id_medico"));
            cita.setTipoDeConsulta(rs.getString("tipo_de_consulta"));
            cita.setFecha(rs.getString("fecha"));
            cita.setHora(rs.getString("hora"));
            lista.add(cita);
        }
        return lista;
    }

}
