//2
package proyecto.alchemilla.entidades;

public class CitaLaboratorio {
    
    private String fechaExamen;
    private String horaExamen;
    private String estado;
    private int IDExamen;
    private int IDLaboratorista;
    private int IDPaciente;

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

    public int getIDLaboratorista() {
        return IDLaboratorista;
    }

    public void setIDLaboratorista(int IDLaboratorista) {
        this.IDLaboratorista = IDLaboratorista;
    }

    public int getIDPaciente() {
        return IDPaciente;
    }

    public void setIDPaciente(int IDPaciente) {
        this.IDPaciente = IDPaciente;
    }

}
