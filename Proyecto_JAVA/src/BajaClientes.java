import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class BajaClientes extends JInternalFrame{
	private JTextField cajaEmail;
	private JLabel etiquetaEmail,titulo;
	private BaseDatos bd;
	private JButton btnBorrar;
	BajaClientes(ventanaMenuPrincipal v,BaseDatos operaciones) throws ClassNotFoundException, SQLException{
		super();
		this.setLayout(new FlowLayout());
		titulo = new JLabel("BORRAR CLIENTE");
		titulo.setPreferredSize(new Dimension(550,20));
		etiquetaEmail = new JLabel("EMAIL: ");
		cajaEmail = new JTextField(20);
		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new BotonesCliente(v));
		bd = operaciones;
		titulo.setForeground(Color.RED.darker());
		this.getContentPane().add(titulo);
		this.getContentPane().add(etiquetaEmail);
		this.getContentPane().add(cajaEmail);
		this.getContentPane().add(btnBorrar);
		this.setVisible(true);
	}
	public boolean comprobarUsu() throws ClassNotFoundException, SQLException {
		String query = "SELECT * from clientes where email like '"+cajaEmail.getText()+"'";
		ResultSet rs = bd.query(query);
		if(rs.next()) {
			return true;
		}
		else {
			return false;
		}
	}
	public void borrar() throws SQLException, ClassNotFoundException {
		boolean comprobacion = comprobarUsu();
		String query = "DELETE FROM clientes WHERE email like '"+cajaEmail.getText()+"'";
		if(comprobacion==true) {
			bd.update(query);
			JOptionPane.showMessageDialog(this, "Usuario Borrado");
		}
		else {
			JOptionPane.showMessageDialog(this, "Usuario inexistente");
		}
	}
}