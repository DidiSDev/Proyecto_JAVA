import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscuchadorMenu implements ActionListener {

	private ventanaMenuPrincipal v;
	private String opc;
	private BaseDatos operaciones;
	
	EscuchadorMenu(ventanaMenuPrincipal vent, String frase, BaseDatos operaciones){
		v=vent;
		opc=frase;
		this.operaciones=operaciones;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(opc) {
			case "salir":
				System.exit(0);
				break;
				//Añadir
			case "ac":
				AltaCliente altacli = new AltaCliente(v);
				altacli.setPreferredSize(new Dimension(600,550));
				v.getContentPane().add(altacli);
				v.repaint();
				v.revalidate();
				break;
			case "ae":
				break;
			case "ap":
				AltaProveedor AltaProveedor=new AltaProveedor(v, operaciones);
				AltaProveedor.setVisible(true);
				v.getContentPane().removeAll();
				v.getContentPane().add(AltaProveedor);
				v.repaint();
				v.revalidate();
				break;
				//Borrar
			case "bc":
				break;
			case "be":
				break;
			case "bp":
				break;
				//Modificar
			case "mc":
				ModificarCliente mc=new ModificarCliente();
				v.getContentPane().removeAll();
				v.getContentPane().add(mc);
				mc.setVisible(true);
				break;
			case "me":
				break;
			case "mp":
				break;
		}
	}

}