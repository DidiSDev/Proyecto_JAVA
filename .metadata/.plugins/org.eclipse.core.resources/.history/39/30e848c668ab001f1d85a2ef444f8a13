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
        case "ac":
            v.getContentPane().removeAll();
            AltaCliente altacli = new AltaCliente(v);
            v.setSize(600,400);
            v.getContentPane().add(altacli); 
            v.repaint(); 
            v.revalidate(); 
            break;
        case "ae":
            break;
        case "ap":
        	  v.getContentPane().removeAll();
              AltaProveedor altaProveedor = new AltaProveedor(v, operaciones);
              altaProveedor.setVisible(true);
              v.setSize(540, 310);
              v.getContentPane().add(altaProveedor);
              v.repaint();
              v.revalidate();
            break;
        case "mc":
        	v.getContentPane().removeAll(); 
        	ModificarCliente mc = new ModificarCliente();
            mc.setVisible(true);
            v.getContentPane().add(mc);
            v.repaint(); 
            v.revalidate(); 
            break;
        case "bc":
        	break;
        case "be":
        	break;
        case "bp":
        	v.getContentPane().removeAll();
        	BajaProveedor bajaProveedor = new BajaProveedor(v, operaciones);
        	bajaProveedor.setVisible(true);
        	 v.setSize(540, 310);
        	v.getContentPane().add(bajaProveedor);
        	v.repaint();
        	v.revalidate();
        	break;
        case "me":
        	break;
        case "mp":
        	v.getContentPane().removeAll();
            ModificacionProveedor modificacionProveedor = new ModificacionProveedor(v, operaciones);
            modificacionProveedor.setVisible(true);
            v.setSize(540, 310);
            v.getContentPane().add(modificacionProveedor);
            v.repaint();
            v.revalidate();
            break;
    }
		
	}

}