import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JOptionPane;
public class escuchadoresLogin implements ActionListener 
{

	private ventanaLogin v;
	private BaseDatos operaciones;
	private String nombreAdmin, passAdmin;
	
	public escuchadoresLogin(ventanaLogin ventanaLogin, BaseDatos conexion2) 
	{
		this.v=ventanaLogin;
		this.operaciones=conexion2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==v.getLogin())
		{
			if (v.getNombreCaja().getText().equalsIgnoreCase("") || v.getContraseñaCaja().getText().equalsIgnoreCase(""))
			{
				//OBLIGAMOS A RELLENAR CAMPOS
				return;
			}
			//HE PUESTO BINARY EN LA QUERY PARA QUE SQL SEA SENSIBLE A AMYUSCULAS Y MINUSCULAS
			//SI NO LO PONGO Y LA PASS TIENE MAYUS Y MINUS, AL PONER TODO EN MINUSCULAS ENTRAS, Y NO PUÉ SER
			 String query = "SELECT * FROM admin WHERE nombre_admin = '" + v.getNombreCaja().getText() 
                     + "' AND BINARY pass_admin = '" + v.getContraseñaCaja().getText() + "'";
                     try 
                     {
                         ResultSet rs;
                         rs=operaciones.query(query);

                         if (rs.next()) 
                         {
                             JOptionPane.showMessageDialog(v, "Datos correctos, conectando...");
                             ventanaMenuPrincipal ventanaMenuPrincipal = null;
							try {
								ventanaMenuPrincipal = new ventanaMenuPrincipal(operaciones);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                             ventanaMenuPrincipal.setVisible(true);
                             v.dispose(); //CIERRO ESTA VENTANA
                         } 
                         else 
                         {
                             JOptionPane.showMessageDialog(v, "¡¡Error, las credenciales no son correctas!!");
                         }
                     } catch (SQLException e1) {
                         JOptionPane.showMessageDialog(v, "Error al conectar con la base de datos: " + e1.getMessage());
                         e1.printStackTrace();
                     }
			
		}
		else if (e.getSource()==v.getRegistrar())
		{
			//HAY QUE:
			
			//AÑADIR EL ASUNTILLO ESE DE REGISTRAR Y MODIFICAR LA VENTANA PRINCIPAL CON NUEVOS ELEMENTOS
			//NOMBRE, CONTRASEÑA, REPETIR CONTRASEÑA....
			
			ventanaRegistro ventanaRegistro=new ventanaRegistro(operaciones, v);
			ventanaRegistro.setVisible(true);
			
			/**
			 * 
			 * 
			 * 
			 * ¡¡¡¡¡¡¡¡¡¡¡IMPORTANTE, v ES ventanaLogin!!!!!!!!!!!!!
			 * */ 
			v.setSize(500,385);
			v.getContentPane().removeAll();
			v.getContentPane().add(ventanaRegistro);
			v.revalidate();
			v.repaint();		
			
		}

	}

}
