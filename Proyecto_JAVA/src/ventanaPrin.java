import javax.swing.*;
import java.awt.*;
public class ventana extends JFrame{
	
		private AltaCliente altacli;
		private JMenu menu, alta, baja, modificar,salir;
		private JMenuItem cliente, empleado, proveedor,cliente2, empleado2, proveedor2,cliente3, empleado3, proveedor3, vehiculo, servicio, cita, factura, nomina, maquinaria;
		private JMenuBar menubar;
		
		ventana()
		{
			this.setBounds(450,100,600,400);
			this.setLayout(new FlowLayout());
			
			MenuAltaBajaModificacion();
			MenuClienteEmpleadoProveedor();
			
			itemsMenu();
			añadirTodo();
			añadirAlMenuBar();
			this.setJMenuBar(menubar); //LO METEMOS EN LA VENTANA

			mostrarAlta();
			this.setVisible(true);
			
			//NINGUN BOTON FUNCIONA DE MOMENTO
			
			
		}
		public void añadirAlMenuBar()
		{
			menubar=new JMenuBar();
			menubar.add(menu);
			menubar.add(vehiculo);
			menubar.add(servicio);
			menubar.add(cita);
			menubar.add(factura);
			menubar.add(nomina);
			menubar.add(maquinaria);
		}
		public void añadirTodo()
		{
			alta.add(cliente);
			alta.add(empleado);
			alta.add(proveedor);
			baja.add(cliente2);
			baja.add(empleado2);
			baja.add(proveedor2);
			modificar.add(cliente3);
			modificar.add(empleado3);
			modificar.add(proveedor3);
			
			menu.add(alta);
			menu.add(baja);
			menu.add(modificar);
			JSeparator separador=new JSeparator();
			menu.add(separador); //QUEDA BONITO
			menu.add(salir);
			
		}
		public void itemsMenu()
		{
			vehiculo=new JMenuItem("Vehículos");
			servicio=new JMenuItem("Servicios");
			cita=new JMenuItem("Citas");
			factura=new JMenuItem("Facturas");
			nomina=new JMenuItem("Nominas");
			maquinaria=new JMenuItem("Maquinaria");			
		}
		public void MenuAltaBajaModificacion()
		{
			menu=new JMenu("Menú");
			alta=new JMenu("Alta");
			baja=new JMenu("Baja");
			modificar=new JMenu("Modificar");
			salir=new JMenu("Salir");
		}
		public void MenuClienteEmpleadoProveedor()
		{
			cliente=new JMenuItem("Clientes");
			empleado=new JMenuItem("Empleados");
			proveedor=new JMenuItem("Proveedores");
			cliente2=new JMenuItem("Clientes");
			empleado2=new JMenuItem("Empleados");
			proveedor2=new JMenuItem("Proveedores");
			cliente3=new JMenuItem("Clientes");
			empleado3=new JMenuItem("Empleados");
			proveedor3=new JMenuItem("Proveedores");
		}
		
	public void mostrarAlta() {
		altacli = new AltaCliente(this);
		altacli.setPreferredSize(new Dimension(600,550));
		this.getContentPane().add(altacli);
		this.repaint();
		this.revalidate();
	}	
	public void limpiar() {
		altacli.limpiar();
	}

	public void validar() {
		altacli.validar();
	}
}
