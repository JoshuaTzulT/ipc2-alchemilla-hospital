//2
package proyecto.alchemilla.entidades;

public class Cita {

    private String nombreDelPaciente;
    private String nombreDelMedico;
    private int codigoCita;
    private int idPaciente;
    private String idMedico;
    private String tipoDeConsulta;
    private String fecha;
    private String hora;
    private float costo;

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipoDeConsulta() {
        return tipoDeConsulta;
    }

    public void setTipoDeConsulta(String tipoDeConsulta) {
        this.tipoDeConsulta = tipoDeConsulta;
    }

    public int getCodigoCita() {
        return codigoCita;
    }

    public void setCodigoCita(int codigoCita) {
        this.codigoCita = codigoCita;
    }

    public String getNombreDelMedico() {
        return nombreDelMedico;
    }

    public void setNombreDelMedico(String nombreDelMedico) {
        this.nombreDelMedico = nombreDelMedico;
    }

    public String getNombreDelPaciente() {
        return nombreDelPaciente;
    }

    public void setNombreDelPaciente(String nombreDelPaciente) {
        this.nombreDelPaciente = nombreDelPaciente;
    }

}
