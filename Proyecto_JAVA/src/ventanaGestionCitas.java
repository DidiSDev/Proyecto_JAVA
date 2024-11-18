import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Vector;
public class ventanaGestionCitas extends JInternalFrame{
	private JTable tabla;
	private Vector<String[]> columnas;
	private Vector<Vector<Object>> datos;
	private Vector<Object>[] fila_n; //Que se queden vacias incluso si no hay datos O ver si hay scrolllbar, entonces que vaya apareciendo secuencialmente
	private JTextField d, m, y;
	private JLabel separador; //Simplemente para dejar bonito la seleccion de fecha
	private JButton aceptar, modificar, borrar, salir; //el primer JButton (Aceptar) es para cambiar la fecha. Mod y Borr gestionan la tabla. Salir cierra el JIF.
	
	ventanaGestionCitas(){
		super("Gestión de citas existentes");
		this.setLayout(new BorderLayout(0, 10));
		PanelFechas(); //Añade panel con las fechas
		
		
		
		
		this.setVisible(true);
	}
	
	
	public void PanelFechas () {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		d = new JTextField();
		m = new JTextField();
		y = new JTextField();
		separador = new JLabel();
		aceptar = new JButton("Aceptar");
		
		d.setPreferredSize(new Dimension(70,30));
		m.setPreferredSize(new Dimension(70,30));
		y.setPreferredSize(new Dimension(70,30));
		separador.setPreferredSize(new Dimension(40,30));
		aceptar.setPreferredSize(new Dimension(70,30));
		aceptar.setActionCommand("introfecha");
		
		panel.add(d);
		panel.add(separador);
		panel.add(m);
		panel.add(separador);
		panel.add(y);
		panel.add(aceptar);
		
		this.add(panel);
	}
	
	
	public void PanelTabla() {
		JPanel panel = new JPanel();
		tabla = new JTable();
		JScrollPane scroll = new JScrollPane();
		
		String[] nomcolumnas = {"Hora", "Nombre", "Correo", "Vehiculo", "Matricula", "Servicio"};
		columnas = new Vector<>();
		columnas.add(nomcolumnas);
		
		datos = new Vector<>();
		for(int i=0; i<10; i++) {
			fila_n = new Vector<>[]();
			
			
			
			
		}
		
		
		
		
		
		
		
	}
	
}
