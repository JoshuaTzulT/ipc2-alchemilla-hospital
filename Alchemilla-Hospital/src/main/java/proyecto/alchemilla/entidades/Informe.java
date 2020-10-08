package proyecto.alchemilla.entidades;

public class Informe {

    private int codigoInforme;
    private int codigoPaciente;
    private int codigoMedico;
    private String informe;
    private String fecha;
    private String hora;

    public int getCodigoInforme() {
        return codigoInforme;
    }

    public void setCodigoInforme(int codigoInforme) {
        this.codigoInforme = codigoInforme;
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

    public int getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(int codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public int getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(int codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

}
