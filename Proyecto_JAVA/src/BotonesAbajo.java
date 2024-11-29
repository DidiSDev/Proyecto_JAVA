import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BotonesAbajo extends JPanel{
private JButton btnRegistro,btnLimpiar,btnSalir;
	
	BotonesAbajo(String nombre, AltaEmpleado ae, ventanaMenuPrincipal v, BaseDatos operaciones){

		Mostrar(nombre);
		btnRegistro.addActionListener(new EscuchadorBotones(ae, "alta", v, operaciones));
		btnLimpiar.addActionListener(new EscuchadorBotones(ae, "limpiarae", v, operaciones));
		btnSalir.addActionListener(new EscuchadorBotones(ae, "salir", v, operaciones));
	}
	
	BotonesAbajo(String nombre, BajaEmpleado be, ventanaMenuPrincipal v, BaseDatos operaciones){

		Mostrar(nombre);
		btnRegistro.addActionListener(new EscuchadorBotones(be, "baja", v, operaciones));
		btnSalir.addActionListener(new EscuchadorBotones(be, "salir", v, operaciones));
	}
	
	BotonesAbajo(String nombre, ModificarEmpleado me, ventanaMenuPrincipal v, BaseDatos operaciones){

		Mostrar(nombre);
		btnRegistro.addActionListener(new EscuchadorBotones(me, "modificar", v, operaciones));
		btnSalir.addActionListener(new EscuchadorBotones(me, "salir", v, operaciones));
	}
	
	private void Mostrar(String nombre) {
		this.setBackground(Color.LIGHT_GRAY.darker());
		btnRegistro = new JButton(nombre);
		btnLimpiar = new JButton("LIMPIAR");
		btnSalir = new JButton("SALIR");
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

	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	public void setBtnRegistro(JButton btnRegistro) {
		this.btnRegistro = btnRegistro;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}
}
