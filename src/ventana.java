import javax.swing.*;
import java.awt.*;
public class ventana extends JFrame{
	
		private JMenu menu, alta, baja, modificar;
		private JMenuItem anadir_cliente, anadir_empleado, anadir_proveedor, borrar_cliente, borrar_empleado, borrar_proveedor, modificar_cliente, modificar_empleado, modificar_proveedor, vehiculo, servicio, cita, factura, nomina, maquinaria, salir;
		private JMenuBar menubar;
		
		ventana()
		{
			this.setBounds(450,100,600,400);
			//this.setLayout(new FlowLayout());
			
			MenuAltaBajaModificacion();
			MenuClienteEmpleadoProveedor();
			
			itemsMenu();
			añadirTodo();
			añadirAlMenuBar();
			this.setJMenuBar(menubar); //LO METEMOS EN LA VENTANA
			this.setVisible(true);				
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
			alta.add(anadir_cliente);
			alta.add(anadir_empleado);
			alta.add(anadir_proveedor);
			baja.add(borrar_cliente);
			baja.add(borrar_empleado);
			baja.add(borrar_proveedor);
			modificar.add(modificar_cliente);
			modificar.add(modificar_empleado);
			modificar.add(modificar_proveedor);
			
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
			salir=new JMenuItem("Salir");
			salir.addActionListener(new EscuchadorMenu(this, "salir"));
		}
		
		
		public void MenuClienteEmpleadoProveedor()
		{
			anadir_cliente=new JMenuItem("Clientes");
			anadir_cliente.addActionListener(new EscuchadorMenu(this, "ac"));
			anadir_empleado=new JMenuItem("Empleados");
			anadir_empleado.addActionListener(new EscuchadorMenu(this, "ae"));
			anadir_proveedor=new JMenuItem("Proveedores");
			anadir_proveedor.addActionListener(new EscuchadorMenu(this, "ap"));
			borrar_cliente=new JMenuItem("Clientes");
			borrar_cliente.addActionListener(new EscuchadorMenu(this, "bc"));
			borrar_empleado=new JMenuItem("Empleados");
			borrar_empleado.addActionListener(new EscuchadorMenu(this, "be"));
			borrar_proveedor=new JMenuItem("Proveedores");
			borrar_proveedor.addActionListener(new EscuchadorMenu(this, "bp"));
			modificar_cliente=new JMenuItem("Clientes");
			modificar_cliente.addActionListener(new EscuchadorMenu(this, "mc"));
			modificar_empleado=new JMenuItem("Empleados");
			modificar_empleado.addActionListener(new EscuchadorMenu(this, "me"));
			modificar_proveedor=new JMenuItem("Proveedores");
			modificar_proveedor.addActionListener(new EscuchadorMenu(this, "mp"));
		}	
		
}
