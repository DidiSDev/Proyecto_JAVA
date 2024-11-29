import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BotonesCliente implements ActionListener {
	private ventanaMenuPrincipal v;
	
	BotonesCliente(ventanaMenuPrincipal v){
		this.v = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "ELEGIR":
			v.anadirPanel();
			try {
				v.setearCajas();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "MODIFICAR":
			try {
				v.validarModi();
				v.insertarModi();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "BORRAR":
			try {
				v.borrar();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case  "REGISTRARSE":
			try {
				v.validarAltaCli();
				v.insertarAlta();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "LIMPIAR":
			v.limpiarAltaCli();
			break;
		case "SALIR":
			break;
		}
	}

}