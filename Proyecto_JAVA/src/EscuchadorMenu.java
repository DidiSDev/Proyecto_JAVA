import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EscuchadorMenu implements ActionListener {

	private ventanaMenuPrincipal v;
	private String opc;
	private BaseDatos operaciones;
	private ModificacionCliente mc;
	private BajaClientes bc;
	
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
        	AltaEmpleado ae=new AltaEmpleado(v, operaciones);
			v.getContentPane().removeAll();
			v.getContentPane().add(ae);
			ae.setVisible(true);
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
        	try {
				mc = new ModificacionCliente(v);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	v.getContentPane().add(mc);
            v.repaint(); 
            v.revalidate(); 
            break;
        case "bc":
      	  v.getContentPane().removeAll();
			try {
				bc = new BajaClientes(v,operaciones);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	v.getContentPane().add(bc);
            v.repaint(); 
            v.revalidate(); 
        	break;
        case "be":
        	BajaEmpleado be=new BajaEmpleado(v, operaciones);
			v.getContentPane().removeAll();
			v.getContentPane().add(be);
			be.setVisible(true);
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
        	ModificarEmpleado me=new ModificarEmpleado(v, operaciones);
			v.getContentPane().removeAll();
			v.getContentPane().add(me);
			me.setVisible(true);
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
        case "acita":
        	v.getContentPane().removeAll();
        	ventanaCita ventanaCita=new ventanaCita(operaciones, v);
        	ventanaCita.setVisible(true);
        	v.setSize(490,590);
        	v.getContentPane().add(ventanaCita);
        	v.repaint();
        	v.revalidate();
        	break;
        case "av":
        	v.getContentPane().removeAll();
        	try {
				altaVehiculo altaVehiculo=new altaVehiculo(operaciones, v);
				altaVehiculo.setVisible(true);
				 v.setSize(490, 460);
				v.getContentPane().add(altaVehiculo);
				v.repaint();
				v.revalidate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
        	break;
        case "mv":
        	v.getContentPane().removeAll();
        	mostrarVehiculos mostrarVehiculos;
			try {
				mostrarVehiculos = new mostrarVehiculos(operaciones, v);
	        	mostrarVehiculos.setVisible(true);
	        	v.setSize(750, 450);
	        	v.getContentPane().add(mostrarVehiculos);
	        	v.repaint();
	        	v.revalidate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        	break;
        case "bv":
        	v.getContentPane().removeAll();
        	buscarVehiculo buscarVehiculo=new buscarVehiculo(operaciones, v);
        	buscarVehiculo.setVisible(true);
        	v.setSize(450, 250);
        	v.getContentPane().add(buscarVehiculo);
        	v.revalidate();
        	v.repaint();
        	break;
    }
		
	}

}