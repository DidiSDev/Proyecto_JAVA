import javax.swing.*;
import java.awt.*;
public class AltaAbajo extends JPanel{
	private JButton btnRegistro,btnLimpiar,btnSalir;
	AltaAbajo(){
		super();
		this.setBackground(Color.LIGHT_GRAY.darker());
		btnRegistro = new JButton("REGISTRARSE");
		btnLimpiar = new JButton("LIMPIAR");
		btnSalir = new JButton("SALIR");
		
//		btnRegistro.addActionListener(new BotonesAlta(v));
//		btnLimpiar.addActionListener(new BotonesAlta(v));
//		btnSalir.addActionListener(new BotonesAlta(v));

		btnRegistro.setBackground(Color.black);
		btnLimpiar.setBackground(Color.black);
		btnSalir.setBackground(Color.black);
		
		btnRegistro.setForeground(Color.white);
		btnLimpiar.setForeground(Color.white);
		btnSalir.setForeground(Color.white);

		this.add(btnRegistro);
		this.add(btnLimpiar);
		this.add(btnSalir);
	}

}