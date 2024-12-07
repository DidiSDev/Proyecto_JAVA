import javax.swing.*;


import com.toedter.calendar.JCalendar;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ventanaCita extends JInternalFrame {
    private JLabel titulo;
    private JLabel[] l;
    private JTextField[] t;
    private JComboBox[] cb;
    private JButton b;
    private JCalendar calendar;
    private BaseDatos bd;
    private claseCita cc;
    private ArrayList<String> horas = new ArrayList<>(Arrays.asList("8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"));
   private ventanaMenuPrincipal v;
    public ventanaCita(BaseDatos bd, ventanaMenuPrincipal v) {
        super("Registrar Cita");
        this.setBounds(500, 50, 450, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER)); 
        this.v=v;
        this.bd = bd;
        
        cc = new claseCita();
        
        String[] servicios = {"Cambio de Aceite", "Cambio Neumaticos", "Chapa y Pintura"};
        String[] labels = {"Nombre y Apellidos", "Correo", "Matricula", "Fecha", "Hora", "Servicio"};
     
        titulo = new JLabel("Registrar Cita");
        Font f = new Font("Arial", Font.ITALIC, 30);
        titulo.setFont(f);
        titulo.setPreferredSize(new Dimension(400, 50));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.red);
        this.getContentPane().add(titulo);

        l = new JLabel[labels.length];
        t = new JTextField[4];
        cb = new JComboBox[2];
        cb[0] = new JComboBox();
        for(int x = 0; x < horas.size(); x++) {
    		cb[0].addItem(horas.get(x));
    	}
        cb[0].setPreferredSize(new Dimension(230, 25));
        cb[0].setSelectedIndex(-1);
        cb[1] = new JComboBox(servicios);
        cb[1].setPreferredSize(new Dimension(230, 25));
        cb[1].setSelectedIndex(-1);
        
 
 
        for (int x = 0; x < l.length; x++) {
            l[x] = new JLabel(labels[x]);
            l[x].setPreferredSize(new Dimension(200, 40));
            this.getContentPane().add(l[x]);
            if (x < 4) {
                t[x] = new JTextField();
                t[x].setPreferredSize(new Dimension(230, 20));
                this.getContentPane().add(t[x]);
                if(x == 3) {
                	//desactivo el campo porque si se selecciona con tabulacion no funcionaria el evento mouseListener
                	t[x].setEnabled(false);
                	//con este evento al hacer clik sobre la anterior caja de texto, apareceria el calendar y se ampliaria el tamaño de la ventana, intentando simular un dataPicker XD.. Demasiado feo y grande para que este siempre visible.. pero se puede cambiar si os apetece.. ademas es tambien para utilizar un nuevo evento
                	t[x].addMouseListener(new eventoMouseClickFechaJTF(this));
                	calendar = new JCalendar();
                	calendar.setPreferredSize(new Dimension(400,300));
                	calendar.setDecorationBordersVisible(true);
                	calendar.setVisible(false);
                    //como el calendario viene por defecto con la fecha del dia actual, este evento lo que hace es que al cambiar de dia nota un cambio y desaparecieria el calendario y en la caja de texto apareciar la fecha formateada y volveria a setear el tamaño de la ventana
                	calendar.addPropertyChangeListener(new eventoCambioEstadoCalendarioCita(this, v));
                    this.getContentPane().add(calendar);
                }else if(x == 2) {
                	t[x].setEnabled(false);
                }
            } else if (x == 4) {
                this.getContentPane().add(cb[0]);
            } else {
                this.getContentPane().add(cb[1]);
            }
        }
        
        b = new JButton("Reservar");
        b.addActionListener(new eventoReservarCita(this,v ));
        
        this.getContentPane().add(b);
        
 
        this.setResizable(false);
        this.setVisible(true);

    }
    
    public String formatearFecha(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(date);
    }
    
    public boolean comprobarCampos() throws SQLException {
    	boolean ok = true;
    	ArrayList<String> campos = new ArrayList<String>();
    	
    	
    	if(t[0].getText().toString().isBlank()){
    		ok = false;
    		campos.add("Nombre y Apellidos");
    		l[0].setForeground(Color.RED);
    	}else {
    		l[0].setForeground(Color.GREEN);
    	}
    	
    	if(t[1].getText().toString().isBlank() || !t[1].getText().toString().contains("@")) {
    		ok = false;
    		campos.add("Correo");
    		l[1].setForeground(Color.RED);
    	}else {
    		ResultSet q = bd.query("SELECT cliente_id from clientes where email like '"+t[1].getText().toString()+"'");
    		
    		if(q.next()) {
    			ResultSet q2 = bd.query("SELECT matricula from vehiculos where id_cliente = '"+q.getInt(1)+"'");
    			q2.next();
    			t[2].setText(q2.getString(1));
    			l[1].setForeground(Color.GREEN);
    		} else {
    			JOptionPane.showMessageDialog(this, "Email no asociado a ningun cliente");
    		}
    	}
    	
    	if(t[2].getText().toString().isBlank()) {
    		ok = false;
    		campos.add("Matricula");
    		l[2].setForeground(Color.RED);
    	}else {
    		l[2].setForeground(Color.GREEN);
    	}
    	
    	if(t[3].getText().toString().isBlank()) {
    		ok = false;
    		campos.add("Fecha");
    		l[3].setForeground(Color.RED);
    	}else {
    		l[3].setForeground(Color.GREEN);
    	}
    	
    	if(cb[0].getSelectedIndex() == -1) {
    		ok = false;
    		campos.add("Hora");
    		l[4].setForeground(Color.RED);
    	} else {
    		l[4].setForeground(Color.GREEN);
    	}
    	
    	if(cb[1].getSelectedIndex() == -1) {
    		ok = false;
    		campos.add("Servicio");
    		l[5].setForeground(Color.RED);
    	}else {
    		l[5].setForeground(Color.GREEN);
    	}
    	
    	
    	if(!ok) {
    		JOptionPane.showMessageDialog(this, "Faltan campos por rellenar: " + campos);
    	}
    	
    	return ok;
    	
    }
    
    public void subirBD() throws SQLException {
    	
    	if(comprobarCampos()) {
    		
    		
    		ResultSet cita = bd.query("SELECT * from citas where fecha like '"+fechaParaBaseDatos()+"' and hora like '"+cb[0].getSelectedItem().toString()+"'");
    		
    		if(cita.next()) {
    			JOptionPane.showMessageDialog(this, "No queda cita para esa fecha y esa hora");
    		}else {
    			

        		ResultSet q = bd.query("SELECT cliente_id FROM clientes WHERE email like '"+t[1].getText().toString()+"'");
        		
        		if(!q.next()) {
        			JOptionPane.showMessageDialog(this, "Cliente no presente en la base de datos, primero dar de alta");
        			this.dispose();
        			// enviar a ventana de Alta Cliente
        		}else {
        			cc.setIdCliente(q.getInt(1));
        			cc.setIdCita(generaIdCita());
        			cc.setFecha(fechaParaBaseDatos());
        			cc.setHora(cb[0].getSelectedItem().toString());
        			System.out.println(cc.getFecha() + " : " + cc.getHora());
        			q = bd.query("SELECT servicio_id from servicios where nombre like '"+cb[1].getSelectedItem().toString()+"'");
        			q.next();
        			
        			cc.setIdServicio(q.getInt(1));
        			
        			bd.update("INSERT INTO citas VALUES('"+cc.getIdCita()+"', '"+cc.getIdCliente()+"', '"+cc.getFecha()+"', '"+cc.getHora()+"', '"+cc.getIdServicio()+"')");
        			
        			JOptionPane.showMessageDialog(this, "Cita registrada correctamente");
        			
        			limpiarCampos();
        			
        		}
        		
        		
        	}
    	}
    		
    		
    }
    
    public String fechaParaBaseDatos() {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fechaBD = format.format(calendar.getDate());
		System.out.println(fechaBD);
		
		return fechaBD;
    }
    
    
    public int generaIdCita() throws SQLException {
    	int id = 0;
    	
    	ResultSet q = bd.query("SELECT MAX(cita_id) from citas");
    	q.next();
    	
    	if(q.getInt(1) == 0) {
    		id = 1;
    	}else {
    		id = q.getInt(1)+1;
    	}
    	
    	return id;
    }
    
    public void limpiarCampos() {
    	for(int x = 0; x < t.length; x++) {
    		t[x].setText("");
    		
    	}
    	
    	for(int x = 0; x < cb.length; x++) {
    		cb[x].setSelectedIndex(-1);
    	}
    	
    	for(int x = 0; x < l.length; x++) {
    		l[x].setForeground(Color.BLACK);
    	}
    	
    }

	public JLabel getTitulo() {
		return titulo;
	}

	public JLabel[] getL() {
		return l;
	}

	public JTextField[] getT() {
		return t;
	}

	public JComboBox[] getCb() {
		return cb;
	}

	public JButton getB() {
		return b;
	}

	public JCalendar getCalendar() {
		return calendar;
	}
    
    

}
