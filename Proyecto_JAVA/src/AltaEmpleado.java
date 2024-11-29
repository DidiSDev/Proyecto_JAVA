import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class AltaEmpleado extends JInternalFrame{
	private BotonesAbajo botones;
	private JLabel nombre, apellidos, direccion, telefono, email, puesto, sexo;
	private JTextField tnombre, tapellidos, tdireccion, ttelefono, temail, tpuesto;
	private JRadioButton h, m;
	private ButtonGroup bg;
	
	AltaEmpleado(ventanaMenuPrincipal v, BaseDatos operaciones){
		super("Alta de Empleados");
		botones=new BotonesAbajo("REGISTRAR", this, v, operaciones);
		//JLabels
		nombre=new JLabel("Nombre:", JLabel.CENTER);
		apellidos=new JLabel("Apellidos:", JLabel.CENTER);
		direccion=new JLabel("Direccion:");
		telefono=new JLabel("Telefono:");
		email=new JLabel("Email:");
		puesto=new JLabel("Puesto:");
		sexo=new JLabel("Sexo:");
		//JTextFields
		tnombre=new JTextField();
		tapellidos=new JTextField();
		tdireccion=new JTextField();
		ttelefono=new JTextField();
		temail=new JTextField();
		tpuesto=new JTextField();
		//JButtons
		h=new JRadioButton("Hombre");m=new JRadioButton("Mujer");h.setBackground(Color.LIGHT_GRAY);m.setBackground(Color.LIGHT_GRAY);
		bg=new ButtonGroup();bg.add(h);bg.add(m);
		//TitledBorder
		TitledBorder tb=new TitledBorder("Informacion Personal");
		tb.setTitleColor(Color.WHITE);
		tb.setTitleFont(new Font("Arial", Font.BOLD, 14));
		
		//Darle tamaño a los JTextFields
		Dimension d=new Dimension(280, 25);
		tdireccion.setPreferredSize(d);ttelefono.setPreferredSize(d);temail.setPreferredSize(d);tpuesto.setPreferredSize(d);
		
		
		//Parte de Arriba(Nombre y Apellidos
		JPanel arriba=new JPanel(new GridLayout(1, 4, 10, 0));
		arriba.add(nombre);arriba.add(tnombre);arriba.add(apellidos);arriba.add(tapellidos);
		arriba.setBorder(new EmptyBorder(0, 0, 5, 0));
		arriba.setBackground(Color.LIGHT_GRAY);
		//Parte centras (Todo lo restante)
		//Parte IZQ
		JPanel izq=new JPanel(new GridLayout(4, 1));
		izq.add(telefono);izq.add(direccion);izq.add(email);izq.add(puesto);
		izq.setBorder(new EmptyBorder(0, 100, 0, 0));
		izq.setBackground(Color.LIGHT_GRAY);
		//Parte DER
		JPanel der=new JPanel(new GridLayout(4, 1, 0, 22));
		der.add(ttelefono);der.add(tdireccion);der.add(temail);der.add(tpuesto);
		der.setBackground(Color.LIGHT_GRAY);
		JPanel flder=new JPanel(new FlowLayout());
		flder.setBorder(new EmptyBorder(5, 0, 0, 0));
		flder.add(der);
		flder.setBackground(Color.LIGHT_GRAY);
		//MEDIO
		JPanel medio=new JPanel(new GridLayout(1, 2));
		medio.add(izq);medio.add(flder);
		//Parte de abajo (Sexo)
		JPanel sex=new JPanel(new GridLayout(1, 2));
		sex.add(h);sex.add(m);sex.setBackground(Color.LIGHT_GRAY);
		JPanel flsex=new JPanel(new FlowLayout(FlowLayout.LEFT));
		flsex.add(sex);flsex.setBackground(Color.LIGHT_GRAY);
		JPanel abajo=new JPanel(new GridLayout(1, 2, -150, 0));
		abajo.add(sexo);abajo.add(flsex);
		abajo.setBorder(new EmptyBorder(0, 200, 0, 0));
		abajo.setBackground(Color.LIGHT_GRAY);
		
		//Agrupar todo y meter el TitledBorder
		JPanel agrupar=new JPanel(new BorderLayout());
		agrupar.add(BorderLayout.NORTH, arriba);
		agrupar.add(BorderLayout.CENTER, medio);
		agrupar.add(BorderLayout.SOUTH, abajo);
		agrupar.setBorder(tb);
		agrupar.setBackground(Color.LIGHT_GRAY);
		
	
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, agrupar);
		this.add(BorderLayout.SOUTH, botones);
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

	public JLabel getApellidos() {
		return apellidos;
	}

	public void setApellidos(JLabel apellidos) {
		this.apellidos = apellidos;
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

	public JTextField getTapellidos() {
		return tapellidos;
	}

	public void setTapellidos(JTextField tapellidos) {
		this.tapellidos = tapellidos;
	}

	public JTextField getTdireccion() {
		return tdireccion;
	}

	public void setTdireccion(JTextField tdireccion) {
		this.tdireccion = tdireccion;
	}

	public JTextField getTtelefono() {
		return ttelefono;
	}

	public void setTtelefono(JTextField ttelefono) {
		this.ttelefono = ttelefono;
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

	public JRadioButton getH() {
		return h;
	}

	public void setH(JRadioButton h) {
		this.h = h;
	}

	public JRadioButton getM() {
		return m;
	}

	public void setM(JRadioButton m) {
		this.m = m;
	}

	public ButtonGroup getBg() {
		return bg;
	}

	public void setBg(ButtonGroup bg) {
		this.bg = bg;
	}
}
