import java.awt.FlowLayout;

import javax.swing.*;
public class ventanaMenuPrincipal extends JInternalFrame {

	
	//PRIVATE
	private JMenu menu, alta, baja, modificar,salir;
	private JMenuItem cliente, empleado, proveedor, vehiculo, servicio, cita, factura, nomina, maquinaria;
	private JMenuBar menubar;
	private BaseDatos operaciones;
	
	ventanaMenuPrincipal(BaseDatos operaciones)
	{
		this.setLayout(new FlowLayout());
		this.operaciones=operaciones;
		MenuAltaBajaModificacion();
		MenuClienteEmpleadoProveedor();
		
		itemsMenu();
		
		añadirTodo();
		
		añadirAlMenuBar();
		
		
		//NINGUN BOTON FUNCIONA DE MOMENTO
		
		
		this.setJMenuBar(menubar); //LO METEMOS EN LA VENTANA
		
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
		baja.add(cliente);
		baja.add(empleado);
		baja.add(proveedor);
		modificar.add(cliente);
		modificar.add(empleado);
		modificar.add(proveedor);
		
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
	}
}
