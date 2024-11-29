
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ModificacionAbajo extends JPanel{
	private JButton btnRegistro,btnLimpiar,btnSalir;
	ModificacionAbajo(ventanaMenuPrincipal v){
		super();
		this.setBackground(Color.LIGHT_GRAY.darker());
		btnRegistro = new JButton("MODIFICAR");
		btnSalir = new JButton("SALIR");
		
		btnRegistro.addActionListener(new BotonesCliente(v));
//		btnLimpiar.addActionListener(new BotonesAlta(v));
//		btnSalir.addActionListener(new BotonesAlta(v));

		btnRegistro.setBackground(Color.black);
		btnSalir.setBackground(Color.black);
		
		btnRegistro.setForeground(Color.white);
		btnSalir.setForeground(Color.white);

		this.add(btnRegistro);
		this.add(btnSalir);
	}

}