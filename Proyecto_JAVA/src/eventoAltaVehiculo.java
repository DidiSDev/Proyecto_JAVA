import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class eventoAltaVehiculo implements ActionListener{
	altaVehiculo av;
	
	eventoAltaVehiculo(altaVehiculo altaVe){
		av = altaVe;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			av.alta();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
	}

}
