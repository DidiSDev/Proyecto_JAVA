import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class panelBusqueda extends JPanel{
	private JLabel l;
	private JTextField matricula;
	private JButton btn;
	private BaseDatos bd;
	private TitledBorder border;
	private Font font;
	private JTable tabla;
	private DefaultTableModel model;
	private JScrollPane scroll;
	
	panelBusqueda(BaseDatos bd){
		super();
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(430, 200));
		this.bd = bd;
		
		font = new Font("Arial", Font.ITALIC, 25);
		
		border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Buscar Vehículo", TitledBorder.LEFT, TitledBorder.TOP);
		border.setTitleColor(Color.RED);
		border.setTitleFont(font);
		this.setBorder(border);
		
		l = new JLabel("Introduzca la matricula");	
		this.add(l);
		
		matricula = new JTextField();
		matricula.setPreferredSize(new Dimension(100, 20));
		this.add(matricula);
		
		btn = new JButton("Buscar");
		btn.addActionListener(new botonBuscarVehiculo(this));
		this.add(btn);
		
		model = new DefaultTableModel();
		tabla = new JTable(model);
		tabla.setRowHeight(60);
		tabla.setVisible(false);
		
		scroll = new JScrollPane(tabla);
		scroll.setPreferredSize(new Dimension(400,80));
		this.add(scroll);
	}
	
	public boolean comprobarMatricula() {
		boolean ok = true;
		
		if(matricula.getText().toString().isBlank()) {
			JOptionPane.showMessageDialog(this, "Campo matricula vacio");
			ok = false;
			matricula.setBackground(Color.RED);
		}else if (matricula.getText().length() != 7){
			JOptionPane.showMessageDialog(this, "Numero de caracteres incorrecto");
			ok = false;
			matricula.setBackground(Color.RED);
		}else {
			if(formatoMatricula(matricula.getText().toString())) {
				matricula.setBackground(Color.GREEN);
			}else {
				ok = false;
				matricula.setBackground(Color.RED);
			}
		}
		
		return ok;
	}
	
	public boolean formatoMatricula(String matr) {
		boolean ok = true;
		String matricula = matr.toUpperCase();
		
		for(int x = 0; x < matricula.length(); x++) {
			if(x < 4) {
				if(matricula.charAt(x) < '0' || matricula.charAt(x) > '9') {
					ok = false;
				}
			}else {
				if(matricula.charAt(x) < 'A' || matricula.charAt(x) > 'Z') {
					ok = false;
				}
			}
		}
		
		if(!ok) {
			JOptionPane.showMessageDialog(this, "Formato matricula no valido");
		}
		
		return ok;
	}	
	
	public void buscarMatricula() throws SQLException {
		if(comprobarMatricula()) {
			
			if(model != null) {
				model = new DefaultTableModel();
			}
			
			model = new DefaultTableModel() {
	        	@Override
	        	public boolean isCellEditable(int fila, int columnas) {
	        		return false;
	        	}
	        };
	        
	        
			ResultSet q = bd.query("SELECT marca, modelo, año, matricula from vehiculos where matricula like '"+matricula.getText().toString()+"'");
            
			if(q.next()) {
	        	int numeroColumnas = q.getMetaData().getColumnCount();
	        
	          
	        	
	            for (int x = 1; x <= numeroColumnas; x++) {
	                model.addColumn(q.getMetaData().getColumnName(x));
	          
	            }
	            

	            do {
	                Object[] fila = new Object[numeroColumnas];
	                for (int x = 1; x <= numeroColumnas; x++) {
	                    fila[x - 1] = q.getObject(x);
	                }
	                model.addRow(fila);
	            } while (q.next());
	            
	            
	            
	            tabla.setModel(model);
	            tabla.setVisible(true); 
	            //this.revalidate();
	            //this.repaint();
			}else {
				JOptionPane.showMessageDialog(this, "Matricula no presente en la base de datos!");
			}
            
		}
		
	}
	
}
