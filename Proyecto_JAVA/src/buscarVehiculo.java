import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class buscarVehiculo extends JInternalFrame{
	private  panelBusqueda pb;
	private  BaseDatos bd;
	
	buscarVehiculo(BaseDatos bd, ventanaMenuPrincipal v){
		super("Buscar vehiculo");
		this.setBounds(500, 50, 450, 250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER)); 
        
        this.bd = bd;
        
        pb = new panelBusqueda(bd);
        
        this.getContentPane().add(pb);
        this.setResizable(false);
        this.setVisible(true);
	}
	
	
}
