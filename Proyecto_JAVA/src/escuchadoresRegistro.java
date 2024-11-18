import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class escuchadoresRegistro implements ActionListener {

	private BaseDatos operaciones;
	private ventanaRegistro vRegistro;
	private ventanaLogin vLogin;
	private int id_admin;
	
	public escuchadoresRegistro(ventanaRegistro ventanaRegistro, BaseDatos operaciones, ventanaLogin v) 
	{
		this.operaciones=operaciones;
		this.vRegistro=ventanaRegistro;
		this.vLogin=v;
	}

	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==vRegistro.getRegistrar())
		{
			if (!vRegistro.getContraseñaCaja().getText().equalsIgnoreCase(vRegistro.getRepetirContraseñaCaja().getText()))
			{
				JOptionPane.showMessageDialog(vLogin, "¡Error, Las contraseñas no coinciden!");
				limpiamos();
				return;
			}
			else if (!validarContraseña(vRegistro.getContraseñaCaja().getText())) 
			{
			    //OBLIGAOMS A 1 MAYUS 1 MINUS Y 8 CARACTERES 
			    JOptionPane.showMessageDialog(vLogin, "¡La contraseña debe tener al menos 8 caracteres, una letra mayúscula y una letra minúscula!");
			    limpiamos();
			    return;
			}

			else if (vRegistro.getUsuarioCaja().getText().equalsIgnoreCase("") 
					|| vRegistro.getContraseñaCaja().getText().equalsIgnoreCase("")
					|| vRegistro.getRepetirContraseñaCaja().getText().equalsIgnoreCase(""))
			{
				JOptionPane.showMessageDialog(vLogin, "¡Por favor, rellena todos los campos!");
				limpiamos();
				return;
			}
			
			else
			{
				
				try {
					
					//TODO OK, PRIMERO RECOGEMOS ID
					recogerID();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String query="INSERT INTO admin VALUES("+id_admin+", '"+vRegistro.getUsuarioCaja().getText()+"', '"+vRegistro.getContraseñaCaja().getText()+"')";
				try {
					//EJECUTO OPERACION CON AL QUERY
					operaciones.update(query);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				limpiamos();
				JOptionPane.showMessageDialog(vLogin, "¡Te has registrado correctamente!");
			}
							
		}
		else if (e.getSource()==vRegistro.getVolver())
		{
			/**
			 * PARA VOLVER AL LOGIN, EN LUGAR DE INSTANCIAR DE NUEVO, LA LIMPIO
			 * Y VUELVO A LLAMAR A SUS MÉTODOS PARA CREAR DE NUEVO LOS ELEMENTOS
			 * */
			
		    vLogin.getContentPane().removeAll(); 
		    vLogin.crearAñadirTitulo(); 
		    vLogin.crearAñadirLogin(); 
		    vLogin.crearAñadirBotones(); 

		    
		    //HAY UN PROBLEMA Y ES QUE TRAS VOLVER, NO FUNCIONAN LOS BOTONES
		    //HAY QUE  VOLVER A HACERLES ESCUCHADORES AQUÍ
		    vLogin.getLogin().addActionListener(new escuchadoresLogin(vLogin, vLogin.getOperaciones()));
		    vLogin.getRegistrar().addActionListener(new escuchadoresLogin(vLogin, vLogin.getOperaciones()));
		    
		    
		    vLogin.revalidate(); 
		    vLogin.repaint(); 

		    // CIERRO LA DE REGISTRO DEVOLVIENDO TAMAÑO AL LOGIN
		    vLogin.setSize(450,300);
		    vRegistro.dispose(); 
		    
		    
			
		}
	}
	
	private boolean validarContraseña(String pass) 
	{
		// TODO Auto-generated method stub
		
	    String patron = "^(?=.*[a-z])(?=.*[A-Z]).{8,}$";
	    return pass.matches(patron);

	}



	public void recogerID() throws SQLException
	{
		String query="SELECT MAX(id_admin) from admin";
		ResultSet rs=operaciones.query(query);
		if (rs.next())
		{
			//HASTA AQUI TODO BIEN
			id_admin=rs.getInt(1)+1;
		}
		else
		{
			JOptionPane.showMessageDialog(vLogin, "¡¡Error al consultar la base de datos!!");
		}
	}
	public void limpiamos()
	{
		vRegistro.getUsuarioCaja().setText("");
		vRegistro.getContraseñaCaja().setText("");
		vRegistro.getRepetirContraseñaCaja().setText("");
	}

}
