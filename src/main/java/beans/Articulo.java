
package beans;

import java.sql.Date;

public class Articulo {
    private int id_articulo;
    private String nombre;
    private String categoria;
    private String tipo;
    private String servicio;
    private Date fecha_adquisicion;

    public Articulo(int id_articulo, String nombre, String categoria, String tipo, String servicio, Date fecha_adquisicion) {
        this.id_articulo = id_articulo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipo = tipo;
        this.servicio = servicio;
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Date getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    public void setFecha_adquisicion(Date fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id_articulo=" + id_articulo + ", nombre=" + nombre + ", categoria=" + categoria + ", tipo=" + tipo + ", servicio=" + servicio + ", fecha_adquisicion=" + fecha_adquisicion + '}';
    }
    
}
