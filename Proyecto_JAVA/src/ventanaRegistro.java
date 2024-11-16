import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.*;
public class ventanaRegistro extends JInternalFrame{

	private BaseDatos operaciones;
	private JLabel usuarioLabel, contraseñaLabel, repetirContraseñaLabel, titulo;
	private JTextField usuarioCaja, contraseñaCaja, repetirContraseñaCaja;
	private JPanel panel;
	private JButton registrar, volver;
	private ventanaLogin v;
	
	ventanaRegistro(BaseDatos oper, ventanaLogin v)
	{
		this.operaciones=oper;
		this.setLayout(new FlowLayout());
		this.setTitle("Ventana de registro");
		this.setSize(getPreferredSize());
		
		this.v=v;
		
		crearPanelContenedor();

		crearTitulo();
		
		panel.add(titulo);
		
		
		creacionYTamañoLabelsCajas();
		
		añadirAPanel();
		
		
		
		
		//AÑADO EL PANEL CONTENEDOR CON TODO, AL JINTERNALFRAME
		this.add(panel); 
		Botones();
		//ESCUCHADORES
		registrar.addActionListener(new escuchadoresRegistro(this, operaciones, v));
		volver.addActionListener(new escuchadoresRegistro(this, operaciones, v));
	}
	public void Botones()
	{
		registrar=new JButton("Registrar");
		volver=new JButton("Volver");
		this.add(registrar);
		this.add(volver);
	}
	public void añadirAPanel()
	{
		panel.add(usuarioLabel);
		panel.add(usuarioCaja);
		panel.add(contraseñaLabel);
		panel.add(contraseñaCaja);
		panel.add(repetirContraseñaLabel);
		panel.add(repetirContraseñaCaja);
	}
	public void creacionYTamañoLabelsCajas()
	{
		usuarioLabel=new JLabel("Nombre de usuario:");
		contraseñaLabel=new JLabel("Contraseña:");
		repetirContraseñaLabel=new JLabel("Repetir contraseña:");
		
		usuarioCaja=new JTextField("");
		contraseñaCaja=new JTextField("");
		repetirContraseñaCaja=new JTextField("");
		
		usuarioLabel.setPreferredSize(new Dimension(170, 30));
		contraseñaLabel.setPreferredSize(new Dimension(170,30));
		repetirContraseñaLabel.setPreferredSize(new Dimension(170,30));
		
		usuarioCaja.setPreferredSize(new Dimension(170,30));
		contraseñaCaja.setPreferredSize(new Dimension(170,30));
		repetirContraseñaCaja.setPreferredSize(new Dimension(170,30));
	}
	public void crearTitulo()
	{
		titulo=new JLabel("Registrar administrador");
		
		titulo.setFont(new Font("Arial", Font.BOLD, 24));
		titulo.setForeground(Color.red);
	}
	public void crearPanelContenedor()
	{
		panel=new JPanel();
		panel.setPreferredSize(new Dimension(300,300));
	}
	public BaseDatos getOperaciones() {
		return operaciones;
	}
	public void setOperaciones(BaseDatos operaciones) {
		this.operaciones = operaciones;
	}
	public JLabel getUsuarioLabel() {
		return usuarioLabel;
	}
	public void setUsuarioLabel(JLabel usuarioLabel) {
		this.usuarioLabel = usuarioLabel;
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
	public JLabel getTitulo() {
		return titulo;
	}
	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}
	public JTextField getUsuarioCaja() {
		return usuarioCaja;
	}
	public void setUsuarioCaja(JTextField usuarioCaja) {
		this.usuarioCaja = usuarioCaja;
	}
	public JTextField getContraseñaCaja() {
		return contraseñaCaja;
	}
	public void setContraseñaCaja(JTextField contraseñaCaja) {
		this.contraseñaCaja = contraseñaCaja;
	}
	public JTextField getRepetirContraseñaCaja() {
		return repetirContraseñaCaja;
	}
	public void setRepetirContraseñaCaja(JTextField repetirContraseñaCaja) {
		this.repetirContraseñaCaja = repetirContraseñaCaja;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JButton getRegistrar() {
		return registrar;
	}
	public void setRegistrar(JButton registrar) {
		this.registrar = registrar;
	}
	public JButton getVolver() {
		return volver;
	}
	public void setVolver(JButton volver) {
		this.volver = volver;
	}
	public ventanaLogin getV() {
		return v;
	}
	public void setV(ventanaLogin v) {
		this.v = v;
	}
	
}
