import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class escuchadoresServicios implements ListSelectionListener, ActionListener{
	private VentanaServicios vs;
	private BaseDatos bd;
	
	escuchadoresServicios(VentanaServicios ven, BaseDatos b){
		this.vs = ven;
		this.bd = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
