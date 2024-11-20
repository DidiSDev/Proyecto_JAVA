import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.*;
public class ventanaLogin extends JFrame{

	//ATRIBUTOS PRIVADOS
	private JLabel titulo, nombreLabel, contraseñaLabel, repetirContraseñaLabel;
	private JTextField nombreCaja,repetirContraseñaCaja;
	private JButton login, registrar;
	private JPasswordField contraseñaCaja;
	
	//AQUÍ NECESITO ESTABLECER LA CONEXION DE CIRO:
	
	private BaseDatos operaciones;
	
	//CONSTRUCTOR
	ventanaLogin(BaseDatos operaciones)
	{
		this.operaciones=operaciones;
		this.setLayout(new FlowLayout(FlowLayout.CENTER)); //TODO CENTRADO
		this.setResizable(false);
		this.setSize(450,300);
		this.setLocation(600,200);
		this.setTitle("Login");
		
		crearAñadirTitulo();
		
		crearAñadirLogin();
		
		crearAñadirBotones();
		
		login.addActionListener(new escuchadoresLogin(this, operaciones));
		registrar.addActionListener(new escuchadoresLogin(this, operaciones));
		
	} 
	public void crearAñadirBotones()
	{
		login=new JButton("Log in");
		login.setPreferredSize(new Dimension(100,30));
		registrar=new JButton("Registrar");
		registrar.setPreferredSize(new Dimension(100,30));
		
		//LABELS FALSOS PARA MAQUETAR
		JLabel labelFalso=new JLabel("");
		JLabel labelFalso2=new JLabel("");
		labelFalso2.setPreferredSize(new Dimension(20,20));
		labelFalso.setPreferredSize(new Dimension(445,20)); //AMPLIAMOS ESPACIO
		
		this.add(labelFalso);
		this.add(login);
		this.add(labelFalso2);
		this.add(registrar);
	}
	public void crearAñadirLogin()
	{
		//NO DEJO NI INSTANCIADOS NI AÑADIDOS LOS DATOS DE LA VENTANA CAMBIADA A REGISTRO (SE ACTIVARÁ ÚNICAMENTE AL PULSAR SOBRE REGISTRAR)
		nombreLabel=new JLabel("Usuario:");
		nombreLabel.setPreferredSize(new Dimension(140,30));
		contraseñaLabel=new JLabel("Contraseña:"); //VALIDAR
		contraseñaLabel.setPreferredSize(new Dimension(140,30));
		nombreCaja=new JTextField("");
		nombreCaja.setPreferredSize(new Dimension(140,30));
		contraseñaCaja=new JPasswordField("");
		contraseñaCaja.setPreferredSize(new Dimension(140,30));
		
		this.add(nombreLabel);
		this.add(nombreCaja);
		this.add(contraseñaLabel);
		this.add(contraseñaCaja);
	}
	public void crearAñadirTitulo()
	{
		titulo=new JLabel("LOGIN DE ADMINISTRADORES");
		titulo.setPreferredSize(new Dimension(360,100)); //AJUSTAR TAMAÑO EN FUNCION DE LO QUE ESCRIBAMOS
		titulo.setFont(new Font("Arial", Font.BOLD, 24)); 
		titulo.setForeground(Color.red);
		this.add(titulo);
	}
	public JLabel getTitulo() {
		return titulo;
	}
	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}
	public JLabel getNombreLabel() {
		return nombreLabel;
	}
	public void setNombreLabel(JLabel nombreLabel) {
		this.nombreLabel = nombreLabel;
	}
	public JLabel getContraseñaLabel() {
		return contraseñaLabel;
	}
	public void setContraseñaLabel(JLabel contraseñaLabel) {
		this.contraseñaLabel = contraseñaLabel;
	}
	public JLabel getRepetirContraseñaLabel() {
		return repetirContraseñaLabel;
	}
	public void setRepetirContraseñaLabel(JLabel repetirContraseñaLabel) {
		this.repetirContraseñaLabel = repetirContraseñaLabel;
	}
	public JTextField getNombreCaja() {
		return nombreCaja;
	}
	public void setNombreCaja(JTextField nombreCaja) {
		this.nombreCaja = nombreCaja;
	}
	public JTextField getContraseñaCaja() {
		return contraseñaCaja;
	}
	
	public BaseDatos getOperaciones() {
		return operaciones;
	}
	public void setOperaciones(BaseDatos operaciones) {
		this.operaciones = operaciones;
	}
	public JTextField getRepetirContraseñaCaja() {
		return repetirContraseñaCaja;
	}
	public void setContraseñaCaja(JPasswordField contraseñaCaja) {
		this.contraseñaCaja = contraseñaCaja;
	}
	public void setRepetirContraseñaCaja(JTextField repetirContraseñaCaja) {
		this.repetirContraseñaCaja = repetirContraseñaCaja;
	}
	public JButton getLogin() {
		return login;
	}
	public void setLogin(JButton login) {
		this.login = login;
	}
	public JButton getRegistrar() {
		return registrar;
	}
	public void setRegistrar(JButton registrar) {
		this.registrar = registrar;
	}

	
}
