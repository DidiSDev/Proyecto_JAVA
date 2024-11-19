import java.sql.SQLException;

public class MAIN {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BaseDatos bd = new BaseDatos();
		/*ventanaLogin ventanaLogin=new ventanaLogin(bd);
		ventanaLogin.setVisible(true);*/
		//ventanaCita vc = new ventanaCita();
		
		ventanaGestionCitas vgc = new ventanaGestionCitas();
		vgc.setBounds(10,10,800,800);
	}

}
