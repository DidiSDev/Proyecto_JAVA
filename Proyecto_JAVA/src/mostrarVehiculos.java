import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class mostrarVehiculos extends JInternalFrame{
	private BaseDatos bd;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	
	mostrarVehiculos(BaseDatos base, ventanaMenuPrincipal v) throws SQLException{
		super("Mostrar Vehiculos");
        this.setBounds(500, 50, 750, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER)); 
        
        bd = base;
        
        // este metodo sirve para que las celdas no se puedan editar
        model = new DefaultTableModel() {
        	@Override
        	public boolean isCellEditable(int fila, int columnas) {
        		return false;
        	}
        };
        

        ResultSet q = bd.query("SELECT marca, modelo, año, matricula from vehiculos");
            
            // A traves de metadatos obtenemos el numero de las columnas
        	int numeroColumnas = q.getMetaData().getColumnCount();
        
          
        	
            // Obtener y añadir los nombres de las columnas
            for (int x = 1; x <= numeroColumnas; x++) {
                model.addColumn(q.getMetaData().getColumnName(x));
          
            }
            

            // Rellenar el modelo con los datos de la consulta
            while (q.next()) {
                
            	Object [] fila = new Object[numeroColumnas];
                
            	for (int x = 1; x <= numeroColumnas; x++) {
                    fila[x-1] = q.getObject(x);
                }
            	
                model.addRow(fila);
                
            }
            	
            
        
        // Crear la tabla con el modelo
        table = new JTable(model);
        table.setRowHeight(80);
        modificarCeldas();
        
        scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(700,350));
        this.getContentPane().add(scroll);
        this.setVisible(true);
	}
	
	
	public void modificarCeldas() {
		//este metodo permite poder modificar las celdas
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                
                
                
                // Alternar color de fondo entre filas para que sea mas intuitivo
                if (row % 2 == 0) {
                    cell.setBackground(Color.LIGHT_GRAY);
                } else {
                    cell.setBackground(Color.WHITE); 
                }


                if (isSelected) {
                    cell.setBackground(Color.PINK);
                    cell.setForeground(Color.BLACK); 
                } else {
                    cell.setForeground(Color.BLACK); 
                }

                return cell;
            	}
        });
	}


	public BaseDatos getBd() {
		return bd;
	}


	public void setBd(BaseDatos bd) {
		this.bd = bd;
	}


	public DefaultTableModel getModel() {
		return model;
	}


	public void setModel(DefaultTableModel model) {
		this.model = model;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public JScrollPane getScroll() {
		return scroll;
	}


	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	
	
}
