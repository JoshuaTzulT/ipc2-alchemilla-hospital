
package proyecto.alchemilla.entidades;


public class Resultado {
    private int codigoResultado;
    private String nombreDePaciente;
    private String nombreDeMedico;
    private String codigoExamen;
    private String IDLaboratorista;
    private String orden;
    private String informe;
    private String fecha;
    private String hora;

    public int getCodigoResultado() {
        return codigoResultado;
    }

    public void setCodigoResultado(int codigoResultado) {
        this.codigoResultado = codigoResultado;
    }

    public String getNombreDePaciente() {
        return nombreDePaciente;
    }

    public void setNombreDePaciente(String nombreDePaciente) {
        this.nombreDePaciente = nombreDePaciente;
    }

    public String getNombreDeMedico() {
        return nombreDeMedico;
    }

    public void setNombreDeMedico(String nombreDeMedico) {
        this.nombreDeMedico = nombreDeMedico;
    }

    public String getCodigoExamen() {
        return codigoExamen;
    }

    public void setCodigoExamen(String codigoExamen) {
        this.codigoExamen = codigoExamen;
    }

    public String getIDLaboratorista() {
        return IDLaboratorista;
    }

    public void setIDLaboratorista(String IDLaboratorista) {
        this.IDLaboratorista = IDLaboratorista;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
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
