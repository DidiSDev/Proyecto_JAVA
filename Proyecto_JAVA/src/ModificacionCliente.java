import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModificacionCliente extends JInternalFrame{
	//private PanelModificador panel;
	private BaseDatos bd;
	private DefaultListModel listaVacia;
	private JList lista;
	private ModificacionAbajo mabajo;
	private JScrollPane scroll;
	private JButton btnModificar;
	private ModificacionArriba marriba;
	
	ModificacionCliente(ventanaMenuPrincipal v) throws ClassNotFoundException, SQLException{
		super("Modificacion Cliente");
		this.setLayout(new FlowLayout());
		btnModificar = new JButton("ELEGIR");
		btnModificar.addActionListener(new BotonesCliente(v));
		listaVacia = new DefaultListModel();
		marriba = new ModificacionArriba(v);
		marriba.setPreferredSize(new Dimension(550,170));
		this.add(marriba);
		marriba.setVisible(false);
		mabajo = new ModificacionAbajo(v);
		mabajo.setVisible(false);
		mabajo.setPreferredSize(new Dimension(550,70));
		this.add(mabajo);
		lista = new JList(listaVacia);
		scroll = new JScrollPane(lista,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		lista.setPreferredSize(new Dimension(200,200));
		anadirLista();
		//setearCajas();
		this.add(scroll);
		this.add(btnModificar);
		this.setVisible(true);
	}
	
	
	public void anadirLista() throws ClassNotFoundException, SQLException {
		bd = new BaseDatos();
		String query = "SELECT email from clientes";
		ResultSet rs = bd.query(query);
		while(rs.next()) {
			String correo = rs.getString(1);
			listaVacia.addElement(correo);
		}
	}
	public String retornarCorreo() {
		String opcion ="";
		if(lista.getSelectedIndices().length>1) {
			JOptionPane.showMessageDialog(this, "Porfavor seleccione una única opción");
		}
		else {
			 opcion = lista.getModel().getElementAt(lista.getSelectedIndex()).toString();
		}
		System.out.println(opcion);
		return opcion;
	}
	public void anadirPanel() {
		String opcion=retornarCorreo();
		if(opcion.equals("")) {
			JOptionPane.showMessageDialog(this, "Porfavor seleccione una opción antes de pulsar");
		}
		else {
			this.remove(scroll);
			this.remove(btnModificar);
			marriba.setVisible(true);
			mabajo.setVisible(true);

			this.repaint();
			this.revalidate();
		}
	}

	public void setearCajas() throws ClassNotFoundException, SQLException {
		bd = new BaseDatos();

		String query = "SELECT * FROM clientes where email like '"+retornarCorreo()+"'";
		ResultSet rs = bd.query(query);
		while(rs.next()) {
				marriba.getCajaNombre().setText(rs.getString(2));
				System.out.println("Contador 2");
				marriba.getCajaApellidos().setText(rs.getString(3));

				marriba.getCajaDireccion().setText(rs.getString(4));

				marriba.getCajaTelefono().setText(rs.getString(5));
				marriba.getCajaEmail().setText(rs.getString(6));

				if(rs.getString(7).equals("Hombre")) {
					marriba.retornarHombre().setSelected(true);
				}
				else {
					marriba.retornarMujer().setSelected(true);
				}
		}
		
	}
	public boolean validar() {
		return marriba.validar();
	}
	public void insertar() throws ClassNotFoundException, SQLException {
		if(validar()==false) {
			System.out.println();
		}
		else {
			int id=0;
			String query1="";
			String sexo="";
			bd = new BaseDatos();
			if(marriba.retornarHombre().isSelected()==true) {
				sexo = "Hombre";
			}
			else {
				sexo = "Mujer";
			}
			String query2 = "SELECT * FROM clientes where email = 'alfredi@gmail.com'";
			ResultSet rs = bd.query(query2);
			if(rs.next()) {
				System.out.println("Entra en la segunda consulta");
				 query1 = "UPDATE `clientes` SET `nombre`='"+marriba.getCajaNombre().getText().toString()+"',"
						+ "`apellido`='"+marriba.getCajaApellidos().getText().toString()+"',"
						+ "`direccion`='"+marriba.getCajaDireccion().getText().toString()+"',"
								+ "`telefono`='"+marriba.getCajaTelefono().getText().toString()+"',`email`='"+marriba.getCajaEmail().getText().toString()+"',`sexo`='"+sexo+"' WHERE email = '"+retornarCorreo()+"'";
			}
			bd.update(query1);
			JOptionPane.showMessageDialog(this, "USUARIO ACTUALIZADO");
			System.out.println(marriba.getCajaDireccion().getText());
			System.out.println("Nombre Actualizado: "+marriba.getCajaNombre().getText());
		}
	}
}