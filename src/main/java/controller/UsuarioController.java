package controller;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Usuario;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController{

        @Override
	public String login(String username, String contrasena) {	
		Gson gson = new Gson();
		DBConnection con = new DBConnection();
		String sql = "Select * from usuarios where username = '" + username + 
                        "' and contrasena = '" + contrasena + "'";
		try {
			Statement st = con.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				String email = rs.getString("email");
				String tipo_cliente = rs.getString("tipo_cliente");
				
				
				Usuario usuario = 
                                        new Usuario(username,contrasena,nombre,apellidos,email,tipo_cliente);
				return gson.toJson(usuario);
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			con.desconectar();
		}
		
		return "false";
	}
}
