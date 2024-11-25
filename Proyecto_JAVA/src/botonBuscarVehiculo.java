import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class botonBuscarVehiculo implements ActionListener{

	private panelBusqueda pb;
	
	botonBuscarVehiculo(panelBusqueda pb){
		this.pb = pb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			pb.buscarMatricula();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
