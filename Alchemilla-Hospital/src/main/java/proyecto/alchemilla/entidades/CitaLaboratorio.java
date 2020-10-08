//2
package proyecto.alchemilla.entidades;

public class CitaLaboratorio {

    private int IDCita;
    private int IDExamen;
    private String nombreDelExamen;
    private int IDPaciente;
    private int IDLaboratorista;
    private String nombreDePaciente;
    private String orden;
    private String fechaExamen;
    private String horaExamen;
    private String estado;
    private Float costo;
    private String informe;

    public String getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(String fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public String getHoraExamen() {
        return horaExamen;
    }

    public void setHoraExamen(String horaExamen) {
        this.horaExamen = horaExamen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIDExamen() {
        return IDExamen;
    }

    public void setIDExamen(int IDExamen) {
        this.IDExamen = IDExamen;
    }


    public int getIDPaciente() {
        return IDPaciente;
    }

    public void setIDPaciente(int IDPaciente) {
        this.IDPaciente = IDPaciente;
    }

    public int getIDCita() {
        return IDCita;
    }

    public void setIDCita(int IDCita) {
        this.IDCita = IDCita;
    }

    public String getNombreDelExamen() {
        return nombreDelExamen;
    }

    public void setNombreDelExamen(String nombreDelExamen) {
        this.nombreDelExamen = nombreDelExamen;
    }

    public String getNombreDePaciente() {
        return nombreDePaciente;
    }

    public void setNombreDePaciente(String nombreDePaciente) {
        this.nombreDePaciente = nombreDePaciente;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public int getIDLaboratorista() {
        return IDLaboratorista;
    }

    public void setIDLaboratorista(int IDLaboratorista) {
        this.IDLaboratorista = IDLaboratorista;
    }

}
