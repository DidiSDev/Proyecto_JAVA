import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {
private Connection con;
	
	BaseDatos() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost/empresa?serverTimezone=Europe/Madrid";
		con = DriverManager.getConnection(url, "root", ""); //depende de cada uno, en XAMPP no tengo contraseña
	}
	
	public Statement crearSta() throws SQLException {
		Statement sta;
		sta = con.createStatement();
		
		return sta;
	}
	
	public void cerrarConexion() throws SQLException {
		con.close();
	}
	
	public ResultSet query(String consulta) throws SQLException {
		Statement sta = crearSta();
		ResultSet q = sta.executeQuery(consulta);
		
		return q;
	}
	
	public void update(String consulta) throws SQLException {
		Statement sta = crearSta();
		sta.executeUpdate(consulta);
	}
}
