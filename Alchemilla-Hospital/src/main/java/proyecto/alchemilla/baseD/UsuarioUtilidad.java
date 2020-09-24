
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
        String sql = "SELECT nombre_de_usuario, password, alias FROM usuario";
        System.out.println(sql);

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Usuario> list = new ArrayList<Usuario>();

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setNombreDeUsuario(rs.getString("nombre_de_usuario"));
            u.setPassword(rs.getString("password"));
            u.setAlias(rs.getString("alias"));
            list.add(u);

        }
        return list;
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

        PreparedStatement stm = con.prepareStatement(query);
        ResultSet rs = stm.executeQuery();

        List<Medico> list = new ArrayList<Medico>();
        while (rs.next()) {
            Medico m = new Medico();
            m.setNombre(rs.getString("nombre"));
            m.setDpi(rs.getInt("dpi"));
            m.setEmail(rs.getString("Email"));
            m.setNumeroDeColegiado(rs.getString("numero_colegiado"));
            m.setEspecialidad(rs.getString("especialidad"));
            m.setHorarioDeAtencionInicio(rs.getString("horario_atencion_inicio"));
            m.setHorarioDeAtencionFinal(rs.getString("horario_atencion_final"));
            m.setFechaDeInicio(rs.getString("fecha_inicio"));
            list.add(m);
        }
        return list;
    }

    public static List<CitaMedica> getListaCita(Connection con) throws SQLException {
        String query = "SELECT id_paciente, "
                + "id_medico,"
                + "fecha_hora,"
                + "estado "
                + "FROM cita_medica";
        PreparedStatement stm = con.prepareStatement(query);
        ResultSet rs = stm.executeQuery();

        List<CitaMedica> list = new ArrayList<CitaMedica>();
        while (rs.next()) {
            CitaMedica cm = new CitaMedica();
            cm.setIdPaciente(rs.getInt("id_paciente"));
            cm.setIdMedico(rs.getInt("id_medico"));
            cm.setFecha(rs.getString("DATE(fecha_hora)"));
            cm.setHora(rs.getString("TIME(fecha_hora)"));
            cm.setEstado(rs.getString("estado"));
            list.add(cm);
        }
        return list;
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
        
        List<CitaLaboratorio> list = new ArrayList<CitaLaboratorio>();
        while(rs.next()){
            CitaLaboratorio cl = new CitaLaboratorio();
            list.add(cl);
        }
        return list;
    }

}
