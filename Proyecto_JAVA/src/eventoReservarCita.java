import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class eventoReservarCita implements ActionListener{
	private ventanaCita vc;
	private ventanaMenuPrincipal v;
	eventoReservarCita(ventanaCita vc2, ventanaMenuPrincipal v){
		vc = vc2;
		this.v=v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			vc.subirBD();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
	}

}
