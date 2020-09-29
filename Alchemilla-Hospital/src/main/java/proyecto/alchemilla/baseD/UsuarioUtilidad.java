//3
package proyecto.alchemilla.baseD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto.alchemilla.entidades.CitaLaboratorio;
import proyecto.alchemilla.entidades.Cita;
import proyecto.alchemilla.entidades.Consulta;
import proyecto.alchemilla.entidades.Medico;
import proyecto.alchemilla.entidades.Usuario;

public class UsuarioUtilidad {

    public static Usuario login(Connection con, String usuario, String password) throws SQLException {
        String sql = "SELECT nombre, "
                + "passw "
                + "FROM usuario WHERE nombre = ? and passw = ?";

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

    public static List<Usuario> getListaUsuario(Connection con) throws SQLException {
        String query = "SELECT nombre, passw FROM usuario";
        System.out.println(query);

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<Usuario> lista = new ArrayList<Usuario>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setNombreDeUsuario(rs.getString("nombre"));
            usuario.setPassword(rs.getString("password"));
            lista.add(usuario);

        }
        return lista;
    }

    public static List<Medico> getListaMedico(Connection con) throws SQLException {
        String query = "SELECT nombre,"
                + " dpi,"
                + "email, "
                + "numero_colegiado, "
                + "especialidad, "
                + "horario_atencion_inicio, "
                + "horario_atencion_final, "
                + "fecha_inicio "
                + "FROM medico";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<Medico> lista = new ArrayList<Medico>();
        while (rs.next()) {
            Medico medico = new Medico();
            medico.setNombre(rs.getString("nombre"));
            medico.setDpi(rs.getInt("dpi"));
            medico.setEmail(rs.getString("email"));
            medico.setNumeroDeColegiado(rs.getString("numero_colegiado"));
            medico.setEspecialidad(rs.getString("especialidad"));
            medico.setHorarioDeAtencionInicio(rs.getString("horario_atencion_inicio"));
            medico.setHorarioDeAtencionFinal(rs.getString("horario_atencion_final"));
            medico.setFechaDeInicio(rs.getString("fecha_inicio"));
            lista.add(medico);
        }
        return lista;
    }

    public static List<Cita> getListaCita(Connection con) throws SQLException {
        String query = "SELECT id_paciente, "
                + "id_medico,"
                + "tipo_de_consulta, "
                + "fecha, "
                + "hora, "
                + "FROM cita";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<Cita> lista = new ArrayList<Cita>();
        while (rs.next()) {
            Cita cm = new Cita();
            cm.setIdPaciente(rs.getInt("id_paciente"));
            cm.setIdMedico(rs.getString("id_medico"));
            cm.setTipoDeConsulta(rs.getString("tipo_de_consulta"));
            cm.setFecha(rs.getString("fecha"));
            cm.setHora(rs.getString("hora"));
            lista.add(cm);
        }
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
////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean citaExiste(Connection conn, String horario) throws SQLException {
        String sql = "SELECT hora "
                + "FROM cita WHERE hora = ?";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, horario);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
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
    
    

    public static void insertarCita(Connection conn, Cita cm) throws SQLException {
        String sql = "INSERT INTO cita "
                + "(id_paciente, "
                + "id_medico, "
                + "tipo_de_consulta, "
                + "fecha, "
                + "hora) "
                + "VALUES (?, ?, ?, ?, ?)";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 1;
        ps.setInt(i++, cm.getIdPaciente());
        ps.setString(i++, cm.getIdMedico());
        ps.setString(i++, cm.getTipoDeConsulta());
        ps.setString(i++, cm.getFecha());
        ps.setString(i++, cm.getHora());
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
    
    

    public static List<Usuario> getListaUsuarioCriterio(Connection con, String nombre) throws SQLException {
        String query = "SELECT nombre_de_usuario, password, alias FROM usuario WHERE nombre_de_usuario = ? ";
//        System.out.println(query);     
        PreparedStatement ps = con.prepareStatement(query);

        int i = 1;
        ps.setString(i++, nombre);
        ResultSet rs = ps.executeQuery();

        List<Usuario> lista = new ArrayList<Usuario>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setNombreDeUsuario(rs.getString("nombre_de_usuario"));
            usuario.setPassword(rs.getString("password"));
            lista.add(usuario);

        }
        return lista;
    }

    public static List<Medico> buscarMedico(Connection con, String criterio) throws SQLException {
        String query = "SELECT nombre,"
                + " dpi,"
                + "email, "
                + "numero_colegiado, "
                + "especialidad, "
                + "horario_atencion_inicio, "
                + "horario_atencion_final, "
                + "fecha_inicio "
                + "FROM medico WHERE nombre LIKE  ? OR especialidad LIKE  ? ";

        PreparedStatement ps = con.prepareStatement(query);
        int i = 1;
        ps.setString(i++, "%" + criterio + "%");
        ps.setString(i++, "%" + criterio + "%");
        ResultSet rs = ps.executeQuery();

        List<Medico> lista = new ArrayList<Medico>();
        while (rs.next()) {
            Medico medico = new Medico();
            medico.setNombre(rs.getString("nombre"));
            medico.setDpi(rs.getInt("dpi"));
            medico.setEmail(rs.getString("email"));
            medico.setNumeroDeColegiado(rs.getString("numero_colegiado"));
            medico.setEspecialidad(rs.getString("especialidad"));
            medico.setHorarioDeAtencionInicio(rs.getString("horario_atencion_inicio"));
            medico.setHorarioDeAtencionFinal(rs.getString("horario_atencion_final"));
            medico.setFechaDeInicio(rs.getString("fecha_inicio"));
            lista.add(medico);
        }
        return lista;
    }

}
