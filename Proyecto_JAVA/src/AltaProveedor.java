import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AltaProveedor extends JInternalFrame {

    BaseDatos operaciones;
    ventanaMenuPrincipal v;
    JLabel nombreLabel, direccionLabel, telefonoLabel, emailLabel;
    JTextField nombreCaja, direccionCaja, telefonoCaja, emailCaja;
    TitledBorder tit1;
    JPanel panel1;
    JButton btnRegistro, btnLimpiar, btnSalir;

    AltaProveedor(ventanaMenuPrincipal v2, BaseDatos operaciones2) 
    {
        super("Alta de proveedor");
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        this.setBackground(Color.LIGHT_GRAY.darker());
        this.v = v2;
        this.operaciones = operaciones2;

        panel1 = new JPanel();
        v2.setSize(540, 310);
		panel1.setPreferredSize(new Dimension(500, 200));
        nombreLabel = new JLabel("NOMBRE:");
        direccionLabel = new JLabel("DIRECCIÓN:");
        telefonoLabel = new JLabel("TELÉFONO:");
        emailLabel = new JLabel("EMAIL:");

        nombreLabel.setFont(new Font("Arial", Font.BOLD, 13));
        direccionLabel.setFont(new Font("Arial", Font.BOLD, 13));
        telefonoLabel.setFont(new Font("Arial", Font.BOLD, 13));
        emailLabel.setFont(new Font("Arial", Font.BOLD, 13));

        nombreLabel.setPreferredSize(new Dimension(120, 25));
        direccionLabel.setPreferredSize(new Dimension(120, 25));
        telefonoLabel.setPreferredSize(new Dimension(120, 25));
        emailLabel.setPreferredSize(new Dimension(120, 25));

        nombreCaja = new JTextField("");
        nombreCaja.setPreferredSize(new Dimension(300, 25));
        direccionCaja = new JTextField("");
        direccionCaja.setPreferredSize(new Dimension(300, 25));
        telefonoCaja = new JTextField("");
        telefonoCaja.setPreferredSize(new Dimension(300, 25));
        emailCaja = new JTextField("");
        emailCaja.setPreferredSize(new Dimension(300, 25));

        panel1.add(nombreLabel);
        panel1.add(nombreCaja);
        panel1.add(direccionLabel);
        panel1.add(direccionCaja);
        panel1.add(telefonoLabel);
        panel1.add(telefonoCaja);
        panel1.add(emailLabel);
        panel1.add(emailCaja);
        instanciarBotones();
        tit1 = new TitledBorder("Datos del proveedor a insertar");
        tit1.setTitleColor(Color.red);
        panel1.setBorder(tit1);
        this.add(panel1);
    }

    public void instanciarBotones() 
    {
        this.setBackground(Color.LIGHT_GRAY.darker());
        btnRegistro = new JButton("REGISTRAR");
        btnLimpiar = new JButton("LIMPIAR");
        btnSalir = new JButton("SALIR");

        btnRegistro.setBackground(Color.black);
        btnLimpiar.setBackground(Color.black);
        btnSalir.setBackground(Color.black);

        btnRegistro.setForeground(Color.white);
        btnLimpiar.setForeground(Color.white);
        btnSalir.setForeground(Color.white);

        btnRegistro.addActionListener(new EscuchadorProveedoresAlta(this, operaciones));
        btnLimpiar.addActionListener(new EscuchadorProveedoresAlta(this, operaciones));
        btnSalir.addActionListener(new EscuchadorProveedoresAlta(this, operaciones));

        JLabel labelFalso = new JLabel("");
        labelFalso.setPreferredSize(new Dimension(450, 15));

        panel1.add(labelFalso);
        panel1.add(btnRegistro);
        panel1.add(btnLimpiar);
        panel1.add(btnSalir);
    }

    public JTextField getEmailCaja() {
        return emailCaja;
    }

    public void limpiarCajas() 
    {
        nombreCaja.setText("");
        direccionCaja.setText("");
        telefonoCaja.setText("");
        emailCaja.setText("");
    }

	public BaseDatos getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(BaseDatos operaciones) {
		this.operaciones = operaciones;
	}

	public ventanaMenuPrincipal getV() {
		return v;
	}

	public void setV(ventanaMenuPrincipal v) {
		this.v = v;
	}

	public JLabel getNombreLabel() {
		return nombreLabel;
	}

	public void setNombreLabel(JLabel nombreLabel) {
		this.nombreLabel = nombreLabel;
	}

	public JLabel getDireccionLabel() {
		return direccionLabel;
	}

	public void setDireccionLabel(JLabel direccionLabel) {
		this.direccionLabel = direccionLabel;
	}

	public JLabel getTelefonoLabel() {
		return telefonoLabel;
	}

	public void setTelefonoLabel(JLabel telefonoLabel) {
		this.telefonoLabel = telefonoLabel;
	}

	public JLabel getEmailLabel() {
		return emailLabel;
	}

	public void setEmailLabel(JLabel emailLabel) {
		this.emailLabel = emailLabel;
	}

	public JTextField getNombreCaja() {
		return nombreCaja;
	}

	public void setNombreCaja(JTextField nombreCaja) {
		this.nombreCaja = nombreCaja;
	}

	public JTextField getDireccionCaja() {
		return direccionCaja;
	}

	public void setDireccionCaja(JTextField direccionCaja) {
		this.direccionCaja = direccionCaja;
	}

	public JTextField getTelefonoCaja() {
		return telefonoCaja;
	}

	public void setTelefonoCaja(JTextField telefonoCaja) {
		this.telefonoCaja = telefonoCaja;
	}

	public TitledBorder getTit1() {
		return tit1;
	}

	public void setTit1(TitledBorder tit1) {
		this.tit1 = tit1;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	public void setBtnRegistro(JButton btnRegistro) {
		this.btnRegistro = btnRegistro;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public void setEmailCaja(JTextField emailCaja) {
		this.emailCaja = emailCaja;
	}
    

 
}