import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class BajaEmpleado extends JInternalFrame{
	private BotonesAbajo botones;
	private JLabel nombre, direccion, telefono, email, puesto, sexo;
	private JTextField tnombre, tdireccion, temail, tpuesto, hm;
	private JComboBox<String> ttelefono;
	private BaseDatos c;
	
	BajaEmpleado(ventanaMenuPrincipal v, BaseDatos operaciones){
		
		super("Baja Empleados");
		c=operaciones;
		botones=new BotonesAbajo("ELIMINAR", this, v, operaciones);
		//JLabels
		nombre=new JLabel("Nombre y Apellidos:");
		direccion=new JLabel("Direccion:");
		telefono=new JLabel("Telefono:");
		email=new JLabel("Email:");
		puesto=new JLabel("Puesto:");
		sexo=new JLabel("Sexo:");
		//JTextFields
		tnombre=new JTextField();
		tnombre.setEditable(false);
		tdireccion=new JTextField();
		tdireccion.setEditable(false);
		ttelefono=new JComboBox<>();
		try {
			AgregarCombo();
		} catch (Exception e2) {}
		ttelefono.addActionListener(new EscuchadorBotones(this, "desplegablebe", operaciones));
		temail=new JTextField();
		temail.setEditable(false);
		tpuesto=new JTextField();
		tpuesto.setEditable(false);
		hm=new JTextField();
		hm.setEditable(false);
		//TitledBorder
		TitledBorder tb=new TitledBorder("EMPLEADO:");
		tb.setTitleColor(Color.WHITE);
		tb.setTitleFont(new Font("Arial", Font.BOLD, 14));
		
		//Darle tamaño a los JTextFields
		Dimension d=new Dimension(280, 25);
		tdireccion.setPreferredSize(d);temail.setPreferredSize(d);tpuesto.setPreferredSize(d);tnombre.setPreferredSize(d);hm.setPreferredSize(d);
		
		
		//Parte de Arriba(El JComboBox)
		JPanel arriba=new JPanel(new GridLayout(1, 2));
		arriba.add(telefono);arriba.add(ttelefono);
		arriba.setBackground(Color.LIGHT_GRAY);
		
		//Parte centras (Todo lo restante)
		//Parte IZQ
		JPanel izq=new JPanel(new GridLayout(5, 1));
		izq.add(nombre);izq.add(direccion);izq.add(email);izq.add(puesto);izq.add(sexo);
		izq.setBorder(new EmptyBorder(0, 100, 0, 0));
		izq.setBackground(Color.LIGHT_GRAY);
		//Parte DER
		JPanel der=new JPanel(new GridLayout(5, 1, 0, 19));
		der.add(tnombre);der.add(tdireccion);der.add(temail);der.add(tpuesto);der.add(hm);
		der.setBackground(Color.LIGHT_GRAY);
		JPanel flder=new JPanel(new FlowLayout());
		flder.setBorder(new EmptyBorder(5, 0, 0, 0));
		flder.add(der);
		flder.setBackground(Color.LIGHT_GRAY);
		//MEDIO
		JPanel medio=new JPanel(new GridLayout(1, 2));
		medio.add(izq);medio.add(flder);
		
		
		//Agrupar todo y meter el TitledBorder
		JPanel agrupar=new JPanel(new BorderLayout());
		agrupar.add(BorderLayout.NORTH, arriba);
		agrupar.add(BorderLayout.CENTER, medio);
		agrupar.setBorder(tb);
		agrupar.setBackground(Color.LIGHT_GRAY);
		
		botones.getBtnLimpiar().setVisible(false);
	
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, agrupar);
		this.add(BorderLayout.SOUTH, botones);
	}

	
	
	//Agregar en el Combo de modificar los empleados:
	private void AgregarCombo() throws ClassNotFoundException, SQLException {
		ResultSet rs=c.query("SELECT * FROM empleados");
		while(rs.next())
			ttelefono.addItem(rs.getString(5));
		//c.cerrarConexion();
	}
	
	
	public BotonesAbajo getBotones() {
		return botones;
	}

	public void setBotones(BotonesAbajo botones) {
		this.botones = botones;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getDireccion() {
		return direccion;
	}

	public void setDireccion(JLabel direccion) {
		this.direccion = direccion;
	}

	public JLabel getTelefono() {
		return telefono;
	}

	public void setTelefono(JLabel telefono) {
		this.telefono = telefono;
	}

	public JLabel getEmail() {
		return email;
	}

	public void setEmail(JLabel email) {
		this.email = email;
	}

	public JLabel getPuesto() {
		return puesto;
	}

	public void setPuesto(JLabel puesto) {
		this.puesto = puesto;
	}

	public JLabel getSexo() {
		return sexo;
	}

	public void setSexo(JLabel sexo) {
		this.sexo = sexo;
	}

	public JTextField getTnombre() {
		return tnombre;
	}

	public void setTnombre(JTextField tnombre) {
		this.tnombre = tnombre;
	}

	public JTextField getTdireccion() {
		return tdireccion;
	}

	public void setTdireccion(JTextField tdireccion) {
		this.tdireccion = tdireccion;
	}

	public JTextField getTemail() {
		return temail;
	}

	public void setTemail(JTextField temail) {
		this.temail = temail;
	}

	public JTextField getTpuesto() {
		return tpuesto;
	}

	public void setTpuesto(JTextField tpuesto) {
		this.tpuesto = tpuesto;
	}

	public JTextField getHm() {
		return hm;
	}

	public void setHm(JTextField hm) {
		this.hm = hm;
	}

	public JComboBox<String> getTtelefono() {
		return ttelefono;
	}

	public void setTtelefono(JComboBox<String> ttelefono) {
		this.ttelefono = ttelefono;
	}
}
