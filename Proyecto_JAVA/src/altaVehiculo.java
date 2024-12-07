import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;

public class altaVehiculo extends JInternalFrame{
	 	private JLabel titulo;
	    private JLabel[] l;
		private JTextField[] t;
		private JSpinner año;
		private SpinnerNumberModel model;
		private JComboBox nombres;
	    private JButton b;
	    private BaseDatos bd;
	    private claseVehiculo cv;
	   private ventanaMenuPrincipal v;
		   
		    altaVehiculo(BaseDatos bd, ventanaMenuPrincipal v) throws SQLException{
				super("Alta Vehiculo");
		        this.setBounds(500, 50, 490, 480);
		        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		        this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER)); 
		        this.v=v;
		        this.bd = bd;
		       
		        
		        cv  = new claseVehiculo();
		        
		 
		        String[] labels = {"Nombre y Apellidos", "Marca", "Modelo", "Matricula", "Año"};
		     
		        titulo = new JLabel("Alta Vehículo");
		        Font f = new Font("Arial", Font.ITALIC, 30);
		        titulo.setFont(f);
		        titulo.setPreferredSize(new Dimension(400, 50));
		        titulo.setHorizontalAlignment(SwingConstants.CENTER);
		        titulo.setForeground(Color.red);
		        this.getContentPane().add(titulo);
		        
		        l = new JLabel[labels.length];
		        t = new JTextField[3];
		        
		       
		        for (int x = 0; x < l.length; x++) {
		            l[x] = new JLabel(labels[x]);
		            l[x].setPreferredSize(new Dimension(200, 40));
		            this.getContentPane().add(l[x]);
		            if (x == 0) {
		            	nombres = new JComboBox();
				        rellenarNombres();
				        nombres.setPreferredSize(new Dimension(230, 25));
				        nombres.setSelectedIndex(-1);
				        this.getContentPane().add(nombres);
		            }else if(x > 0 && x < 4) {
		                	t[x-1] = new JTextField();
			                t[x-1].setPreferredSize(new Dimension(230, 20));
			                this.getContentPane().add(t[x-1]);
		            } else {
		            	//valor 1, el que sale por defecto a inicializarse, valor 2 es el minimo, valor 3 el maximo, valor 4 incrementa y decrementa de uno en uno
		            	model = new SpinnerNumberModel(2000, 2000, 2024, 1);
	
				        año = new JSpinner(model);
				        año.setPreferredSize(new Dimension(230, 20));
				        // evita que se puedan introducir valores al JSpinner
				        ((JSpinner.DefaultEditor) año.getEditor()).getTextField().setEditable(false);

				        this.getContentPane().add(año);
		            }
		        }
		        
		        b = new JButton("Alta");
		        b.setForeground(Color.GREEN);
		        b.addActionListener(new eventoAltaVehiculo(this));
		        this.getContentPane().add(b);
		        
		        this.setResizable(false);
		        this.setVisible(true);
	}
		    
	public void rellenarNombres() throws SQLException {
		ResultSet q = bd.query("SELECT nombre, apellido from clientes");
		
		while(q.next()) {
			String completo = q.getString(1) + " " +q.getString(2);
			nombres.addItem(completo);
		}
		
	}
	
	public boolean comprobarCampos() {
		boolean ok = true;
		ArrayList<String> campos = new ArrayList<>();
		
		if(nombres.getSelectedIndex() == -1) {
			ok = false;
			nombres.setBackground(Color.RED);
			campos.add("Nombre y Apellidos");
		}else {
			nombres.setBackground(Color.GREEN);
		}
		
		if(t[0].getText().toString().isBlank()) {
			ok = false;
			t[0].setBackground(Color.RED);
			campos.add("Marca");
		}else {
			t[0].setBackground(Color.GREEN);
			cv.setMarca(t[0].getText().toString());
		}
		
		if(t[1].getText().toString().isBlank()) {
			ok = false;
			t[1].setBackground(Color.RED);
			campos.add("Modelo");
		}else {
			t[1].setBackground(Color.GREEN);
			cv.setModelo(t[1].getText().toString());
		}
		
		if(t[2].getText().toString().isBlank() || t[2].getText().toString().length() != 7) {
			ok = false;
			t[2].setBackground(Color.RED);
			campos.add("Matricula");
		}else {
			if(formatoMatricula(t[2].getText().toString())) {				
				t[2].setBackground(Color.GREEN);
				cv.setMatricula(t[2].getText().toString());
			} else {
				ok = false;
				t[2].setBackground(Color.RED);
				campos.add("Matricula");
			}
		}
		
		// devuelve el valor del spinner a traves del model
		cv.setAño(model.getNumber().intValue());
		
		return ok;
	}
	
	public boolean formatoMatricula(String matricula) {
		boolean ok = true;
		matricula = matricula.toUpperCase();
		
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
	
	public void alta() throws SQLException {
		if(comprobarCampos()) {
			String nombre = nombres.getSelectedItem().toString();
			String [] dividir = nombre.split(" ");
			ResultSet q = bd.query("SELECT cliente_id from clientes where nombre like '"+dividir[0]+"' and apellido like '"+dividir[1]+"'");
			
			System.out.println(nombres.getSelectedItem().toString());
			
			//siempre devuelve un valor porque los clientes los cargo directamente de la base de datos, entonces existen; el problema es que estamos buscando el id cliente a traves de nombre y podria haber 2 clientes con el mismo nombre
			if(q.next()) {
				cv.setIdVehiculo(ultimoId());
				cv.setIdCliente(q.getInt(1));
				
				bd.update("INSERT INTO vehiculos VALUES('"+cv.getIdVehiculo()+"', '"+cv.getMarca()+"', '"+cv.getModelo()+"', '"+cv.getAño()+"', '"+cv.getMatricula()+"', '"+cv.getIdCliente()+"')");
				JOptionPane.showMessageDialog(this, "Cliente añadido correctamente a la base de datos");
				limpiarCampos();
			}else {
				JOptionPane.showMessageDialog(this, "Cliente no econtrado en la base de datos, por favor dar de alta primero al cliente!");
			}
		}
	}
	
	public int ultimoId() throws SQLException {
		int cod = 0;
		
		ResultSet q = bd.query("SELECT MAX(vehiculo_id) from vehiculos");
		q.next();
		
		if(q.getInt(1) == 0) {
			cod = 1;
		}else {
			cod = q.getInt(1) + 1;
		}
		
		return cod;
	}
	
	public void limpiarCampos() {
		for(int x = 0; x < t.length; x++) {
			t[x].setText("");
			t[x].setBackground(Color.white);
		}
		
		nombres.setSelectedIndex(-1);
		
		model.setValue(2000);
		
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JLabel[] getL() {
		return l;
	}

	public void setL(JLabel[] l) {
		this.l = l;
	}

	public JTextField[] getT() {
		return t;
	}

	public void setT(JTextField[] t) {
		this.t = t;
	}

	public JSpinner getAño() {
		return año;
	}

	public void setAño(JSpinner año) {
		this.año = año;
	}

	public SpinnerNumberModel getModel() {
		return model;
	}

	public void setModel(SpinnerNumberModel model) {
		this.model = model;
	}

	public JComboBox getNombres() {
		return nombres;
	}

	public void setNombres(JComboBox nombres) {
		this.nombres = nombres;
	}

	public JButton getB() {
		return b;
	}

	public void setB(JButton b) {
		this.b = b;
	}

	public BaseDatos getBd() {
		return bd;
	}

	public void setBd(BaseDatos bd) {
		this.bd = bd;
	}

	public claseVehiculo getCv() {
		return cv;
	}

	public void setCv(claseVehiculo cv) {
		this.cv = cv;
	}
	
	
}
