package test;

import beans.Articulo;
import connection.DBConnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {

    public static void main(String[] args) {
        actualizarArticulo(10, "PERIFERICOS");
        listarArticulo();

    }

    public static void actualizarArticulo(int id_articulo, String categoria) {
        DBConnection con = new DBConnection();
        String sql = "UPDATE articulo SET categoria = '" + categoria + "'WHERE id_articulo = " + id_articulo;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void listarArticulo() {
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM articulo";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id_articulo = rs.getInt("id_articulo");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                String tipo = rs.getString("tipo");
                String servicio = rs.getString("servicio");
                Date fecha_adquisicion = rs.getDate("fecha_adquisicion");
                Articulo articulos = new Articulo(id_articulo, nombre, categoria, tipo, servicio, fecha_adquisicion);
                System.out.println(articulos.toString());
            }
            st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

    }

}
