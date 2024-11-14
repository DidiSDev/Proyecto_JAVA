import java.awt.FlowLayout;

import javax.swing.*;
public class Ventana extends JFrame{

	//ATRIBUTOS PRIVADOS
	private JLabel titulo, nombreLabel, contraseñaLabel;
	private JButton login, registrar;
	
	
	
	//CONSTRUCTOR
	Ventana()
	{
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setResizable(false);
		this.setSize(500,500);
		this.setLocation(getMousePosition());
	}
}
