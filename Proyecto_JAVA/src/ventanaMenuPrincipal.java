import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
public class ventanaMenuPrincipal extends JFrame{
	
		private JMenu menu, alta, baja, modificar;
		private JMenuItem anadir_cliente, anadir_empleado, anadir_proveedor, borrar_cliente, borrar_empleado, borrar_proveedor, 
		modificar_cliente, modificar_empleado, pedirCita, altaVehiculo, mostrarVehiculos, buscarVehiculo,
		modificar_proveedor, vehiculo, servicio, cita, factura, nomina, maquinaria, salir;
		private JMenuBar menubar;
		private BaseDatos operaciones;
		private ModificacionCliente mc;
		private BajaClientes bc;
		private AltaCliente altacli;
		
		ventanaMenuPrincipal(BaseDatos operaciones) throws ClassNotFoundException, SQLException
		{
			this.setBounds(450,100,600,400);
			//this.setLayout(new FlowLayout());
			this.operaciones=operaciones;
			inicializarComponentes();
			MenuAltaBajaModificacion();
			loDeCiro();
			MenuClienteEmpleadoProveedor();
			itemsMenu();
			añadirTodo();
			añadirAlMenuBar();
			this.setJMenuBar(menubar); //LO METEMOS EN LA VENTANA
			this.setVisible(true);	
		}

		public void loDeCiro()
		{
			//pedirCita, altaVehiculo, mostrarVehiculos, buscarVehiculo,
			pedirCita=new JMenuItem("Pedir cita");
			altaVehiculo=new JMenuItem("Alta de vehículo");
			mostrarVehiculos=new JMenuItem("Mostrar vehículos");
			buscarVehiculo=new JMenuItem("Buscar vehículo");
			cita.add(pedirCita);
			vehiculo.add(altaVehiculo);
			vehiculo.add(mostrarVehiculos);
			vehiculo.add(buscarVehiculo);
			
		}
		
		private void inicializarComponentes() throws ClassNotFoundException, SQLException {
	        altacli = new AltaCliente(this);
	        mc = new ModificacionCliente(this);
	        bc = new BajaClientes(this,operaciones);
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
		
		
		public void añadirTodo() throws ClassNotFoundException, SQLException
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
			servicio=new JMenuItem("Servicios");
			
			factura=new JMenuItem("Facturas");
			nomina=new JMenuItem("Nominas");
			maquinaria=new JMenuItem("Maquinaria");			
		}
		
		
		public void MenuAltaBajaModificacion()
		{
			menu=new JMenu("Menú");
			alta=new JMenu("Alta");
			baja=new JMenu("Baja");
			vehiculo=new JMenu("Vehículos");
			cita=new JMenu("Citas");
			modificar=new JMenu("Modificar");
			salir=new JMenuItem("Salir");
			salir.addActionListener(new EscuchadorMenu(this, "salir", operaciones));
		}
		
		
		public void MenuClienteEmpleadoProveedor()
		{
			anadir_cliente=new JMenuItem("Clientes");
			anadir_cliente.addActionListener(new EscuchadorMenu(this, "ac", operaciones));
			anadir_empleado=new JMenuItem("Empleados");
			anadir_empleado.addActionListener(new EscuchadorMenu(this, "ae", operaciones));
			anadir_proveedor=new JMenuItem("Proveedores");
			anadir_proveedor.addActionListener(new EscuchadorMenu(this, "ap", operaciones));
			borrar_cliente=new JMenuItem("Clientes");
			borrar_cliente.addActionListener(new EscuchadorMenu(this, "bc", operaciones));
			borrar_empleado=new JMenuItem("Empleados");
			borrar_empleado.addActionListener(new EscuchadorMenu(this, "be", operaciones));
			borrar_proveedor=new JMenuItem("Proveedores");
			borrar_proveedor.addActionListener(new EscuchadorMenu(this, "bp", operaciones));
			modificar_cliente=new JMenuItem("Clientes");
			modificar_cliente.addActionListener(new EscuchadorMenu(this, "mc", operaciones));
			modificar_empleado=new JMenuItem("Empleados");
			modificar_empleado.addActionListener(new EscuchadorMenu(this, "me", operaciones));
			modificar_proveedor=new JMenuItem("Proveedores");
			modificar_proveedor.addActionListener(new EscuchadorMenu(this, "mp", operaciones));
			
			//pedirCita, altaVehiculo, mostrarVehiculos, buscarVehiculo,
			pedirCita.addActionListener(new EscuchadorMenu(this, "acita", operaciones));
			altaVehiculo.addActionListener(new EscuchadorMenu(this, "av", operaciones));
			mostrarVehiculos.addActionListener(new EscuchadorMenu(this, "mv", operaciones));
			buscarVehiculo.addActionListener(new EscuchadorMenu(this, "bv", operaciones));
		}	
		
		public void anadirModi() {
			this.remove(mc);
			this.remove(bc);
			this.getContentPane().add(mc);
			this.repaint();
			this.revalidate();
		}
		public void anadirBorrar() {
			this.remove(mc);
			this.remove(bc);
			this.getContentPane().add(bc);
			this.repaint();
			this.revalidate();
		}
		public void anadirPanel() {
			mc.anadirPanel();
		}
		public void insertarModi() throws ClassNotFoundException, SQLException {
			mc.insertar();
		}
		public void validarModi() throws ClassNotFoundException, SQLException {
			mc.validar();
		}
		public String retornarCorreo() {
			return mc.retornarCorreo();
		}
		public void setearCajas() throws ClassNotFoundException, SQLException {
			mc.setearCajas();
		}
		public void borrar() throws SQLException, ClassNotFoundException {
			bc.borrar();
		}
		public void limpiarAltaCli() {
			altacli.limpiar();
		}

		public void validarAltaCli() {
			altacli.validar();
		}
		public void insertarAlta() throws ClassNotFoundException, SQLException {
			altacli.insertarAlta();
		}
		
		
		
		
		
		
		
}