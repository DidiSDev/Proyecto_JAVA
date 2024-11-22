import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class VentanaServicios extends JFrame{
	private JList listaserv;
	private DefaultListModel<String> modellist;
	private JButton nuevo, modif, elim;
	private JLabel [] lbl;
	private JTextField [] txtfld;
	private BaseDatos bd;
	
	VentanaServicios() throws SQLException, ClassNotFoundException{
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(10,10,600,600);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new BorderLayout());
		
		BaseDatos bd = new BaseDatos();
		PanelList(bd);
		PanelDatos(bd);
		PanelBotones();
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
		listaserv.addListSelectionListener(new escuchadoresServicios(this, bd));
		JScrollPane scroll = new JScrollPane(listaserv);
		
		PanelLista.add(BorderLayout.CENTER, listaserv);
		
		this.add(BorderLayout.NORTH, PanelLista);
	}
	
	public void PanelDatos (BaseDatos bd) {
		JPanel PanelDatos = new JPanel();
		PanelDatos.setBackground(Color.LIGHT_GRAY);
		PanelDatos.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		
		lbl = new JLabel[5];
		txtfld = new JTextField[5];
		
		String[] labels = {"ID", "Nombre", "Coste", "Fecha Ultima Modificación", "Descripción"};
		for(int i=0; i<lbl.length; i++) {
				lbl[i] = new JLabel(labels[i]);
				lbl[i].setPreferredSize(new Dimension(150,50));
				PanelDatos.add(lbl[i]);
				txtfld[i] = new JTextField();
				txtfld[i].setPreferredSize(new Dimension(300,50));
				PanelDatos.add(txtfld[i]);
			}
		txtfld[4].setPreferredSize(new Dimension(300,200));
		this.add(BorderLayout.CENTER, PanelDatos);
	}
	
	public void PanelBotones () {
		JPanel pb = new JPanel();
		pb.setBackground(Color.LIGHT_GRAY);
		pb.setLayout(new GridLayout(1, 3, 10, 10));
		
		nuevo = new JButton("Añadir");
		nuevo.setActionCommand("servAdd");
		modif = new JButton ("Modificar");
		modif.setActionCommand("servMod");
		elim = new JButton ("Eliminar");
		elim.setActionCommand("servElim");
		
		pb.add(nuevo);
		pb.add(modif);
		pb.add(elim);
		this.add(BorderLayout.SOUTH, pb);
		
	}
}
