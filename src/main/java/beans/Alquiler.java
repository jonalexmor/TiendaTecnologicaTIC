
package beans;

import java.sql.Date;

public class Alquiler {
    private int id;
    private String username;
    private Date fecha_servicio;
    private boolean novedad;
    private String nombre;
    private String servicio;

    public Alquiler(int id, String username, Date fecha_servicio, boolean novedad, String nombre, String servicio) {
        this.id = id;
        this.username = username;
        this.fecha_servicio = fecha_servicio;
        this.novedad = novedad;
        this.nombre = nombre;
        this.servicio = servicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFecha_servicio() {
        return fecha_servicio;
    }

    public void setFecha_servicio(Date fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "id=" + id + ", username=" + username + ", fecha_servicio=" + fecha_servicio + ", novedad=" + novedad + ", nombre=" + nombre + ", servicio=" + servicio + '}';
    }
    
    
}
