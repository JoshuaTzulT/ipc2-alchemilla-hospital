//2
package proyecto.alchemilla.entidades;

public class Examen {
    private String nombreDelExamen;
    private String descripcion;
    private float costo;

    public String getNombreDelExamen() {
        return nombreDelExamen;
    }

    public void setNombreDelExamen(String nombreDelExamen) {
        this.nombreDelExamen = nombreDelExamen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
