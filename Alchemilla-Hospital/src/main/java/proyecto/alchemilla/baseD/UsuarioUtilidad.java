//3
package proyecto.alchemilla.baseD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto.alchemilla.entidades.CitaLaboratorio;
import proyecto.alchemilla.entidades.CitaMedica;
import proyecto.alchemilla.entidades.Medico;
import proyecto.alchemilla.entidades.Usuario;

public class UsuarioUtilidad {

    public static Usuario login(Connection con, String usuario, String password) throws SQLException {
        String sql = "SELECT nombre_de_usuario, "
                + "password, "
                + "alias "
                + "FROM usuario WHERE nombre_de_usuario = ? and password = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        int i = 1;
        ps.setString(i++, usuario);
        ps.setString(i++, password);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Usuario u = new Usuario();
            u.setNombreDeUsuario(rs.getString("nombre_de_usuario"));
            u.setAlias(rs.getString("alias"));

            return u;
        }
        return null;
    }

    public static List<Usuario> getListaUsuario(Connection con) throws SQLException {
        String query = "SELECT nombre_de_usuario, password, alias FROM usuario";
        System.out.println(query);

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<Usuario> lista = new ArrayList<Usuario>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setNombreDeUsuario(rs.getString("nombre_de_usuario"));
            usuario.setPassword(rs.getString("password"));
            usuario.setAlias(rs.getString("alias"));
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

    public static List<CitaMedica> getListaCita(Connection con) throws SQLException {
        String query = "SELECT id_paciente, "
                + "nombre_paciente,"
                + "id_medico,"
                + "nombre_medico,"
                + "fecha_hora,"
                + "estado "
                + "FROM cita_medica";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<CitaMedica> lista = new ArrayList<CitaMedica>();
        while (rs.next()) {
            CitaMedica cm = new CitaMedica();
            cm.setIdPaciente(rs.getInt("id_paciente"));
            cm.setNombrePaciente(rs.getString("nombre_paciente"));
            cm.setIdMedico(rs.getInt("id_medico"));
            cm.setNombreMedico(rs.getString("nombre_medico"));
            cm.setFecha(rs.getString("DATE(fecha_hora)"));
            cm.setHora(rs.getString("TIME(fecha_hora)"));
            cm.setEstado(rs.getString("estado"));
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

    public static boolean citaExiste(Connection conn, String nombrePaciente) throws SQLException {
        String sql = "SELECT nombre_paciente "
                + "FROM cita_medica WHERE nombre_paciente = ?";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nombrePaciente);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public static void insertarCita(Connection conn, CitaMedica cm) throws SQLException {
        String sql = "INSERT INTO cita_medica "
                + "(id_paciente, "
                + "nombre_paciente, "
                + "id_medico, "
                + "nombre_medico, "
                + "fecha_hora) "
                + "VALUES (?, ?, ?, ?, ?)";
        System.out.println(sql);
        System.out.println(cm.getFecha() +" "+ cm.getHora());
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 1;
        ps.setInt(i++, cm.getIdPaciente());
        ps.setString(i++, cm.getNombrePaciente());
        ps.setInt(i++, cm.getIdMedico());
        ps.setString(i++, cm.getNombreMedico());
        ps.setString(i++, cm.getFecha() +" "+ cm.getHora());
        ps.executeUpdate();
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
            usuario.setAlias(rs.getString("alias"));
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
