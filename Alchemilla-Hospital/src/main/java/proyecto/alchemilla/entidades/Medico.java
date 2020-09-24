//2
package proyecto.alchemilla.entidades;

public class Medico {
    private String nombre;
    private int dpi;
    private String email;
    private String numeroDeColegiado;
    private String especialidad;
    private String horarioDeAtencionInicio;
    private String horarioDeAtencionFinal;
    private String fechaDeInicio;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroDeColegiado() {
        return numeroDeColegiado;
    }

    public void setNumeroDeColegiado(String numeroDeColegiado) {
        this.numeroDeColegiado = numeroDeColegiado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHorarioDeAtencionInicio() {
        return horarioDeAtencionInicio;
    }

    public void setHorarioDeAtencionInicio(String horarioDeAtencion) {
        this.horarioDeAtencionInicio = horarioDeAtencion;
    }

    public String getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(String fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public String getHorarioDeAtencionFinal() {
        return horarioDeAtencionFinal;
    }

    public void setHorarioDeAtencionFinal(String horarioDeAtencionFinal) {
        this.horarioDeAtencionFinal = horarioDeAtencionFinal;
    }
}
