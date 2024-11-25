import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class VentanaServicios extends JFrame{
	private JList listaserv;
	private DefaultListModel<String> modellist;
	private JButton propiedades, nuevo, borrar;
	private JLabel [] lbl;
	private JTextField [] txtfld;
	private JTextArea desc;
	private JCheckBox factura;
	private BaseDatos bd;
	
	VentanaServicios() throws SQLException, ClassNotFoundException{
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(10,10,600,300);
		this.getContentPane().setBackground(Color.GRAY);
		this.setLayout(new FlowLayout());
		
		BaseDatos bd = new BaseDatos();
		PanelList(bd);
		PanelBotones(bd);
		PanelDatos(bd);
		this.setVisible(true);
	}
	
	public void PanelList(BaseDatos bd) throws SQLException {
		
		JPanel PanelLista = new JPanel();
		PanelLista.setBackground(Color.LIGHT_GRAY);
		PanelLista.setLayout(new BorderLayout(10,10));
		
		lbl = new JLabel[1];
		lbl[0] = new JLabel("LISTA DE SERVICIOS");
		PanelLista.add(BorderLayout.NORTH, lbl[0]);
		
		modellist = new DefaultListModel<String>();
		ResultSet rs = bd.query("SELECT nombre FROM servicios");
		while(rs.next()) {
			modellist.addElement(rs.getString(1));
		}
		listaserv = new JList<>(modellist);
		listaserv.setPreferredSize(new Dimension(500, 150));
		listaserv.addListSelectionListener(new escuchadoresServicios(this, bd));
		JScrollPane scroll = new JScrollPane(listaserv, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		PanelLista.add(BorderLayout.CENTER, scroll);
		
		PanelLista.add(BorderLayout.SOUTH, PanelBotones(bd));
		
		this.add(BorderLayout.NORTH, PanelLista);
	}
	
	public JPanel PanelDatos (BaseDatos bd) {
		JPanel PanelDatos = new JPanel();
		PanelDatos.setBackground(Color.LIGHT_GRAY);
		PanelDatos.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		PanelDatos.setPreferredSize(new Dimension(600,600));
		
		lbl = new JLabel[6];
		txtfld = new JTextField[6];
		
		String[] labels = {"ID", "Nombre", "Coste", "Fecha Ultima Modificación", "Descripción", "Generar Factura"};
		for(int i=0; i<lbl.length; i++) {
				lbl[i] = new JLabel(labels[i]);
				lbl[i].setPreferredSize(new Dimension(150,50));
				PanelDatos.add(lbl[i]);
				if(i < 4 ) {
					txtfld[i] = new JTextField();
					txtfld[i].setPreferredSize(new Dimension(300,50));
					PanelDatos.add(txtfld[i]);
				}
				if(i == 5) {
					desc = new JTextArea();
					desc.setPreferredSize(new Dimension(300,100));
					JScrollPane scr = new JScrollPane(desc, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					PanelDatos.add(scr);
				}
			}
		factura = new JCheckBox();
		PanelDatos.add(factura);
		
		return PanelDatos;
	}
	
	public JPanel PanelBotones (BaseDatos bd) {
		JPanel pb = new JPanel();
		pb.setBackground(Color.LIGHT_GRAY);
		pb.setLayout(new GridLayout(1, 3, 10, 10));
		
		propiedades = new JButton("Propiedades");
		propiedades.setActionCommand("servPropiedades");
		propiedades.addActionListener(new escuchadoresServicios(this, bd));
		//propiedades.setEnabled(false);
		nuevo = new JButton ("Modificar");
		nuevo.setActionCommand("servMod");
		nuevo.setEnabled(false);
		borrar = new JButton ("Eliminar");
		borrar.setActionCommand("servElim");
		borrar.setEnabled(false);
		
		pb.add(propiedades);
		pb.add(nuevo);
		pb.add(borrar);
		
		return pb;
	}
	
	
	public JList getListaserv() {
		return listaserv;
	}

	public void setListaserv(JList listaserv) {
		this.listaserv = listaserv;
	}

	public DefaultListModel<String> getModellist() {
		return modellist;
	}

	public void setModellist(DefaultListModel<String> modellist) {
		this.modellist = modellist;
	}

	public JButton getNuevo() {
		return nuevo;
	}

	public void setNuevo(JButton nuevo) {
		this.nuevo = nuevo;
	}

	public JButton getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(JButton propiedades) {
		this.propiedades = propiedades;
	}

	public JButton getBorrar() {
		return borrar;
	}

	public void setBorrar(JButton borrar) {
		this.borrar = borrar;
	}

	public JLabel[] getLbl() {
		return lbl;
	}

	public void setLbl(JLabel[] lbl) {
		this.lbl = lbl;
	}

	public JTextField[] getTxtfld() {
		return txtfld;
	}

	public void setTxtfld(JTextField[] txtfld) {
		this.txtfld = txtfld;
	}

	public JCheckBox getFactura() {
		return factura;
	}

	public void setFactura(JCheckBox factura) {
		this.factura = factura;
	}

	public BaseDatos getBd() {
		return bd;
	}

	public void setBd(BaseDatos bd) {
		this.bd = bd;
	}
	
	
	
	
}
