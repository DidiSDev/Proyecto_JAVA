import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;
public class ventanaGestionCitas extends JInternalFrame{
	private JTable tabla;
	private Vector<String[]> columnas;
	private Vector<Vector<Object>> datos;
	private Vector<Object> fila; //Que se queden vacias incluso si no hay datos O ver si hay scrolllbar, entonces que vaya apareciendo secuencialmente
	private JTextField d, m, y;
	private JLabel separador; //Simplemente para dejar bonito la seleccion de fecha
	private JButton aceptar, modificar, borrar, salir; //el primer JButton (Aceptar) es para cambiar la fecha. Mod y Borr gestionan la tabla. Salir cierra el JIF.
	
	ventanaGestionCitas() throws ClassNotFoundException, SQLException{
		super("Gestión de citas existentes");
		this.setLayout(new BorderLayout(0, 10));
		PanelFechas(); //Añade panel con las fechas
		PanelTabla();
		
		
		
		this.setVisible(true);
	}
	
	
	public void PanelFechas () {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		d = new JTextField();
		m = new JTextField();
		y = new JTextField();
		separador = new JLabel();
		aceptar = new JButton("Aceptar");
		
		d.setPreferredSize(new Dimension(70,30));
		m.setPreferredSize(new Dimension(70,30));
		y.setPreferredSize(new Dimension(70,30));
		separador.setPreferredSize(new Dimension(40,30));
		aceptar.setPreferredSize(new Dimension(70,30));
		aceptar.setActionCommand("introfecha");
		
		panel.add(d);
		panel.add(separador);
		panel.add(m);
		panel.add(separador);
		panel.add(y);
		panel.add(aceptar);
		
		this.add(panel);
	}
	
	
	public void PanelTabla() throws SQLException, ClassNotFoundException {
		JPanel panel = new JPanel();
		JScrollPane scroll = new JScrollPane();
		
		String[] nomcolumnas = {"ID Cita", "Hora", "Nombre Cliente", "Vehiculo", "Matricula", "Servicio", "Coste"};
		columnas = new Vector<>();
		columnas.add(nomcolumnas);
		
		//No usamos fechas (luego eliminare el panel superior, lo he creado por si acaso) asi que la tabla debe ser dinamica
		BaseDatos bd = new BaseDatos();
		ResultSet rs = bd.query("SELECT c.cita_id, c.fecha_hora, cl.nombre, cl.apellido, v.marca, v.modelo, v.matricula, s.nombre, s.costo "
				+ "FROM citas c, clientes cl, vehiculos v, servicios s "
				+ "WHERE c.cliente_id = cl.cliente_id AND cl.cliente_id = v.id_cliente AND c.servicio_id = s.servicio_id");
		datos = new Vector<>();
		while(rs.next()) {
				fila = new Vector<>();
				fila.add(rs.getInt(1)); // ID Cita
				fila.add(rs.getString(2)); //Hora
				fila.add("" + rs.getString(3) + " " + rs.getString(4)); //Nombre + apellido
				fila.add("" + rs.getString(5) + " " + rs.getString(6)); //Marca + Modelo
				fila.add(rs.getString(7)); //Matricula
				fila.add(rs.getString(8)); //Nombre servicio
				fila.add(rs.getDouble(9)); //Coste
				datos.add(fila); //añadimos fila a la tabla
		}
		bd.cerrarConexion();
		tabla = new JTable(datos, columnas);
		scroll.add(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scroll);
	}
	
	//panelbotones, comprobar funcion tabla, añadir vinculo desde menu a esta ventana y luego ya funciones
}
