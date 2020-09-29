//2
package proyecto.alchemilla.entidades;

public class Examen {
    private int codigoExamen;
    private String nombreDelExamen;
    private String orden;
    private String descripcion;
    private float costo;
    private String informe;

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

    public int getCodigoExamen() {
        return codigoExamen;
    }

    public void setCodigoExamen(int codigoExamen) {
        this.codigoExamen = codigoExamen;
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
}
