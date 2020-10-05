package proyecto.alchemilla.entidades;

public class Informe {

    private int codigoInforme;
    private String nombrePaciente;
    private String nombreMedico;
    private String informe;
    private String fecha;
    private String hora;

    public int getCodigoInforme() {
        return codigoInforme;
    }

    public void setCodigoInforme(int codigoInforme) {
        this.codigoInforme = codigoInforme;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
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

}
