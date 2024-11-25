import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JOptionPane;

public class eventoCambioEstadoCalendarioCita implements PropertyChangeListener{
	private ventanaCita vc;
	private ventanaMenuPrincipal v;
	eventoCambioEstadoCalendarioCita(ventanaCita vc2, ventanaMenuPrincipal v){
		vc = vc2;
		this.v=v;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
		if(evt.getPropertyName().equalsIgnoreCase("calendar")) {
			Date dataSeleccionada = vc.getCalendar().getDate();
			Date d = new Date();
			 v.setSize(490, 580);
			if(dataSeleccionada.before(d)) {
				JOptionPane.showMessageDialog(vc, "No puede seleccionar una fecha anterior a la actual!");
			}else {
				vc.getT()[3].setText(vc.formatearFecha(dataSeleccionada));
	            vc.getCalendar().setVisible(false);
	           
			}
            
		}
		
	}

}
