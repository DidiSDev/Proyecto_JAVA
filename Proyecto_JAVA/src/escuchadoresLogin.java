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
			String query="SELECT * from admin";
			ResultSet rs=operaciones.query(query);
			if (rs.next())
			{
				nombreAdmin=rs.getString(2);
				passAdmin=rs.getString(3);
				if (v.getNombreCaja().getText().equalsIgnoreCase(nombreAdmin)
					&& v.getContraseñaCaja().getText().equals(passAdmin))
				{
					System.out.println("Entra");
					JOptionPane.showMessageDialog(v, "Datos correctos, conectando...");
					//TRAS ESTO NOS VAMOS AL MENU PPAL
					ventanaMenuPrincipal ventanaMenuPrincipal=new ventanaMenuPrincipal(operaciones); //NOS LLEVAMOS LA CONEXION
					ventanaMenuPrincipal.setVisible(true);
					//LIMPIAMOS LA VENTANA PRINCIPAL Y DAMOS MÁS TAMAÑO PARA LAS DEMÁS VENTANAS
					v.setSize(750,750);
					v.getContentPane().removeAll();
					v.getContentPane().add(ventanaMenuPrincipal);
					v.revalidate();
					v.repaint();
				}
					
			}
			else
			{
				JOptionPane.showMessageDialog(v, "Error al obtener los datos del admin");
			}
		}
		else if (e.getSource()==v.getRegistrar())
		{
			//HAY QUE:
			
			//AÑADIR EL ASUNTILLO ESE DE REGISTRAR Y MODIFICAR LA VENTANA PRINCIPAL CON NUEVOS ELEMENTOS
			//NOMBRE, CONTRASEÑA, REPETIR CONTRASEÑA....
			
			
			
			
			
			
			
			
		}

	}

}