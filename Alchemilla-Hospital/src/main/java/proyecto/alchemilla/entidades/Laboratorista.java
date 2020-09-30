//2
package proyecto.alchemilla.entidades;

public class Laboratorista {
    
    private String idLaboratorista;
    private String nombre;
    private String registroMinisterio;
    private int dpi;
    private String telefono;
    private String examen;
    private String email;
    private String diasHabiles;
    private String password;
    private String fechaInicio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistroMinisterio() {
        return registroMinisterio;
    }

    public void setRegistroMinisterio(String registroMinisterio) {
        this.registroMinisterio = registroMinisterio;
    }

    public String getDiasHabiles() {
        return diasHabiles;
    }

    public void setDiasHabiles(String diasHabiles) {
        this.diasHabiles = diasHabiles;
    }
    
    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdLaboratorista() {
        return idLaboratorista;
    }

    public void setIdLaboratorista(String idLaboratorista) {
        this.idLaboratorista = idLaboratorista;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
