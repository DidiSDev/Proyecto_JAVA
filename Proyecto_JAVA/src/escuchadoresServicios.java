import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
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
		switch(e.getActionCommand()) {
			case "servPropiedades":
				JOptionPane.showMessageDialog(vs, "HOLA");
				System.exit(0);
			break;
		}	
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(!e.getValueIsAdjusting()) { //es true mientra el usuario este haciendo cambios en la seleccion (arrastrando o seleccionando varios o cosas asi)
			if(vs.getListaserv().getSelectedIndex() != -1) {
				vs.getPropiedades().setEnabled(true);
				vs.getNuevo().setEnabled(true);
				vs.getBorrar().setEnabled(true);
			}
			else {
				vs.getPropiedades().setEnabled(false);
				vs.getNuevo().setEnabled(false);
				vs.getBorrar().setEnabled(false);
			}
		}
		
	}
	
	//ENSEÑAR EL PANEL, CARGAR LOS DATOS, CERRAR EL PANEL
	public void mostrarPanelDatos() { //Nuevo y Propiedades
		
	}
	
	public void cargarPanelDatos() { //Propiedades
		
	}
	
	public void cerrarPanelDatos() {
		
	}
	
	//recoge los datos (si estan todos rellenos!!!) y lo manda a la base de datos. Buscar alguna manera de que tambien refresque el JList
	public void crearServicio() {
		
	}
	
	//void o habria que devolver el Jlistselecteditem??. Buscar alguna manera de que tambien refresque el JList
	public void EliminarServicio() {
		
	}
	
	//-------------------METODOS ALEX-------------- (añadirle actionlistener al checkbox y luego el if en la parte del actioncommand).
	public void generarFactura() {
		
	}
	
	
	
}
