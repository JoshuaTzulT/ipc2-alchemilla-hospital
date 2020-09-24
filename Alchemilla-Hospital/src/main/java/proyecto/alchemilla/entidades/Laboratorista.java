//2
package proyecto.alchemilla.entidades;

public class Laboratorista {
    
    private String nombre;
    private int dpi;
    private String telefono;
    private String email;
    private String registroMinisterio;
    private String diasHabiles;
    private String fehcaInicio;

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

    public String getFehcaInicio() {
        return fehcaInicio;
    }

    public void setFehcaInicio(String fehcaInicio) {
        this.fehcaInicio = fehcaInicio;
    }
}
