import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class BajaProveedor extends JInternalFrame {

    BaseDatos operaciones;
    ventanaMenuPrincipal v;
    JLabel emailLabel, nombreLabel, telefonoLabel, direccionLabel;
    JTextField emailCaja, nombreCaja, telefonoCaja, direccionCaja;
    TitledBorder tit1;
    JPanel panel1;
    JButton btnEliminar, btnLimpiar, btnSalir, btnValidar;

    BajaProveedor(ventanaMenuPrincipal v2, BaseDatos operaciones2) 
    {
        super("Baja de Proveedor");
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        this.setBackground(Color.LIGHT_GRAY.darker());
        this.v = v2;
        this.operaciones = operaciones2;
        JOptionPane.showMessageDialog(v2, "Introduzca el email del proveedor a eliminar, después pulse sobre el botón 'VALIDAR' y si es correcto y ese email existe, automáticamente se cargarán los datos de ese proveedor");
        
        panel1 = new JPanel();
        
		panel1.setPreferredSize(new Dimension(500, 200));

        emailLabel = new JLabel("EMAIL:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 13));
        emailLabel.setPreferredSize(new Dimension(120, 25));
        
        emailCaja = new JTextField("");
        emailCaja.setPreferredSize(new Dimension(300, 25));


        nombreLabel = new JLabel("NOMBRE:");
        nombreLabel.setFont(new Font("Arial", Font.BOLD, 13));
        nombreLabel.setPreferredSize(new Dimension(120, 25));


        nombreCaja = new JTextField("");
        nombreCaja.setPreferredSize(new Dimension(300, 25));
        nombreCaja.setEnabled(false); 

        telefonoLabel = new JLabel("TELÉFONO:");
        telefonoLabel.setFont(new Font("Arial", Font.BOLD, 13));
        telefonoLabel.setPreferredSize(new Dimension(120, 25));


        telefonoCaja = new JTextField("");
        telefonoCaja.setPreferredSize(new Dimension(300, 25));
        telefonoCaja.setEnabled(false);

        direccionLabel = new JLabel("DIRECCIÓN:");
        direccionLabel.setFont(new Font("Arial", Font.BOLD, 13));
        direccionLabel.setPreferredSize(new Dimension(120, 25));


        direccionCaja = new JTextField("");
        direccionCaja.setPreferredSize(new Dimension(300, 25));
        direccionCaja.setEnabled(false); 

        panel1.add(emailLabel);
        panel1.add(emailCaja);
        panel1.add(nombreLabel);
        panel1.add(nombreCaja);
        panel1.add(telefonoLabel);
        panel1.add(telefonoCaja);
        panel1.add(direccionLabel);
        panel1.add(direccionCaja);
        
        instanciarBotones();

        tit1 = new TitledBorder("Datos proveedor a eliminar");
        tit1.setTitleColor(Color.red);
        panel1.setBorder(tit1);

        this.add(panel1);
        this.setSize(600, 400);
        this.setVisible(true);
    }

    public void instanciarBotones() {
        this.setBackground(Color.LIGHT_GRAY.darker());
        btnEliminar = new JButton("ELIMINAR");
        btnLimpiar = new JButton("LIMPIAR");
        btnSalir = new JButton("SALIR");
        btnValidar = new JButton("VALIDAR");

        btnEliminar.setBackground(Color.black);
        btnLimpiar.setBackground(Color.black);
        btnSalir.setBackground(Color.black);
        btnValidar.setBackground(Color.black);

        btnEliminar.setForeground(Color.white);
        btnLimpiar.setForeground(Color.white);
        btnSalir.setForeground(Color.white);
        btnValidar.setForeground(Color.white);

        btnValidar.setBounds(30, 200, 100, 30);
        btnEliminar.setBounds(140, 200, 100, 30);
        btnLimpiar.setBounds(250, 200, 100, 30);
        btnSalir.setBounds(360, 200, 100, 30);

        EscuchadorProveedoresBaja escuchador = new EscuchadorProveedoresBaja(this, operaciones);
        btnEliminar.addActionListener(escuchador);
        btnLimpiar.addActionListener(escuchador);
        btnSalir.addActionListener(escuchador);
        btnValidar.addActionListener(escuchador);
        
        //BOTON ELIMINAR A FALSE EN UN INICIO
        btnEliminar.setEnabled(false);
        
        JLabel labelFalso = new JLabel("");
        labelFalso.setPreferredSize(new Dimension(450, 15));

        panel1.add(labelFalso);

        panel1.add(btnValidar);
        panel1.add(btnEliminar);
        panel1.add(btnLimpiar);
        panel1.add(btnSalir);
    }

   
    public JTextField getEmailCaja() {
        return emailCaja;
    }

    public JTextField getNombreCaja() {
        return nombreCaja;
    }

    public JTextField getTelefonoCaja() {
        return telefonoCaja;
    }

    public JTextField getDireccionCaja() {
        return direccionCaja;
    }

 
    public void limpiarCajas() 
    {
        emailCaja.setText("");
        nombreCaja.setText("");
        telefonoCaja.setText("");
        direccionCaja.setText("");
        nombreCaja.setEnabled(false);
        telefonoCaja.setEnabled(false);
        direccionCaja.setEnabled(false);
    }

    public void validar() 
    {
        if(emailCaja.getText().trim().isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "DEBES INTRODUCIR EL EMAIL DEL PROVEEDOR A ELIMINAR");
        }
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

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    public JLabel getNombreLabel() {
        return nombreLabel;
    }

    public void setNombreLabel(JLabel nombreLabel) {
        this.nombreLabel = nombreLabel;
    }

    public JLabel getTelefonoLabel() {
        return telefonoLabel;
    }

    public void setTelefonoLabel(JLabel telefonoLabel) {
        this.telefonoLabel = telefonoLabel;
    }

    public JLabel getDireccionLabel() {
        return direccionLabel;
    }

    public void setDireccionLabel(JLabel direccionLabel) {
        this.direccionLabel = direccionLabel;
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

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
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

    public JButton getBtnValidar() {
        return btnValidar;
    }

    public void setBtnValidar(JButton btnValidar) {
        this.btnValidar = btnValidar;
    }

    public void setEmailCaja(JTextField emailCaja) {
        this.emailCaja = emailCaja;
    }

    public void setNombreCaja(JTextField nombreCaja) {
        this.nombreCaja = nombreCaja;
    }

    public void setTelefonoCaja(JTextField telefonoCaja) {
        this.telefonoCaja = telefonoCaja;
    }

    public void setDireccionCaja(JTextField direccionCaja) {
        this.direccionCaja = direccionCaja;
    }
}
