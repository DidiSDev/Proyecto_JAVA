import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class EscuchadorBotones implements ActionListener {
	private AltaEmpleado ae;
	private BajaEmpleado be;
	private ModificarEmpleado me;
	private String opc;
	private ventanaMenuPrincipal v;
	private BaseDatos c;

	EscuchadorBotones(AltaEmpleado altaEmpleado, String frase, ventanaMenuPrincipal ventanamenuPrincipal, BaseDatos operaciones){
		ae=altaEmpleado;
		opc=frase;
		v=ventanamenuPrincipal;
		c=operaciones;
	}
	
	EscuchadorBotones(BajaEmpleado bajaEmpleado, String frase, ventanaMenuPrincipal ventanamenuPrincipal, BaseDatos operaciones){
		be=bajaEmpleado;
		opc=frase;
		v=ventanamenuPrincipal;
		c=operaciones;
	}

	EscuchadorBotones(ModificarEmpleado modificarEmpleado, String frase, ventanaMenuPrincipal ventanamenuPrincipal, BaseDatos operaciones){
		me=modificarEmpleado;
		opc=frase;
		v=ventanamenuPrincipal;
		c=operaciones;
	}
	
	EscuchadorBotones(ModificarEmpleado modificarEmpleado, String frase, BaseDatos operaciones){
		me=modificarEmpleado;
		opc=frase;
		c=operaciones;
	}
	
	EscuchadorBotones(BajaEmpleado bajaEmpleado, String frase, BaseDatos operaciones){
		be=bajaEmpleado;
		opc=frase;
		c=operaciones;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(opc) {
			case "salir":
				v.getContentPane().removeAll();
			    v.repaint();
				break;
				
			case "alta":
				if(VerificarAlata()==false)
					JOptionPane.showMessageDialog(ae, "Los campos no pueden estas vacios");
				else {
					try {
						if(!ae.getTemail().getText().contains("@")) {
							JOptionPane.showMessageDialog(ae, "El correo debe contener una '@'");
							ae.getTemail().setText("");
						}
						else
							Insertar();
					} catch (Exception e2) {}
				}
				break;
				
			case "baja":
				if(!be.getTnombre().getText().trim().isEmpty())
					try {
						c.update("DELETE FROM empleados where telefono='"+be.getTtelefono().getSelectedItem().toString()+"'");
						//c.cerrarConexion();
						JOptionPane.showMessageDialog(be, "Empleado dado de baja");
						v.getContentPane().removeAll();
					    v.repaint();
					} catch (Exception e2) {}
				else
					JOptionPane.showMessageDialog(be, "Debe selecionar que empleado desea dar de baja");
				break;
				
			case "modificar":
				ComprobarMod();
				break;
				
			case "limpiarae":
				LimpiarAlta();
				break;
				
			case "desplegableme":
				try {
					MostrarTextomodificar();
				} catch (Exception e2) {}
				break;
				
			case "desplegablebe":
			try {
				MostrarTextobaja();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break;
		}
	}
	
	//Comprobar Modificaciones
	private void ComprobarMod(){
		if(me.getNombre().getText().isBlank() || me.getTapellido().getText().isBlank() || me.getDireccion().getText().isBlank() || me.getEmail().getText().isBlank() || me.getPuesto().getText().isBlank() || me.getHm().getText().isBlank())
			JOptionPane.showMessageDialog(me, "Los campos no pueden estar vacios");
		else {
			if(!me.getHm().getText().equalsIgnoreCase("hombre") && !me.getHm().getText().equalsIgnoreCase("mujer")) {
				JOptionPane.showMessageDialog(me, "Porfavor, indique si es Hombre o Mujer");
				me.getHm().setText("");
			}
			else {
				if(!me.getTemail().getText().contains("@")) {
					me.getTemail().setText("");
					JOptionPane.showMessageDialog(me, "El correo debe contener una '@'");
				}
				else {
					try {
						ResultSet rs=c.query("SELECT * FROM empleados where email='"+me.getTemail().getText()+"' and telefono <> '"+me.getTtelefono().getSelectedItem().toString()+"'");
						if(rs.next()) {
							JOptionPane.showMessageDialog(me, "Ese Email ya esta en uso, introduzca otro");
							me.getTemail().setText("");
						}
						else {
							c.update("UPDATE empleados set nombre='"+me.getTnombre().getText()+"', apellido='"+me.getTapellido().getText()+"', "
									+ "direccion='"+me.getTdireccion().getText()+"', email='"+me.getTemail().getText()+"', puesto='"+me.getTpuesto().getText()+"', "
									+ "sexo='"+me.getSexo().getText()+"' where telefono='"+me.getTtelefono().getSelectedItem().toString()+"'");
							JOptionPane.showMessageDialog(me, "Datos del Empleado modificados");
							v.getContentPane().removeAll();
						    v.repaint();
						}
						//c.cerrarConexion();
					} catch (Exception e) {}
				}
			}
		}
	}
	
	//Mostar texto en los TEXTFIELD
	private void MostrarTextomodificar() throws ClassNotFoundException, SQLException{
		//Labels
		me.getNombre().setVisible(true);me.getDireccion().setVisible(true);me.getEmail().setVisible(true);
		me.getPuesto().setVisible(true);me.getSexo().setVisible(true);me.getApellido().setVisible(true);
		//Cajas de Texto
		me.getTnombre().setVisible(true);me.getTdireccion().setVisible(true);me.getTemail().setVisible(true);
		me.getTpuesto().setVisible(true);me.getHm().setVisible(true);;me.getTapellido().setVisible(true);
		//Mostar texto en los TEXTFIELD
		ResultSet rs=c.query("SELECT * FROM empleados where telefono='"+me.getTtelefono().getSelectedItem().toString()+"'");
		if(rs.next()) {
			me.getTnombre().setText(rs.getString(2));
			me.getTapellido().setText(rs.getString(3));
			me.getTdireccion().setText(rs.getString(4));
			me.getTemail().setText(rs.getString(6));
			me.getTpuesto().setText(rs.getString(7));
			me.getHm().setText(rs.getString(8));
		}
		//c.cerrarConexion();
	}
	
	//Mostar texto en los TEXTFIELD
		private void MostrarTextobaja() throws ClassNotFoundException, SQLException{
			ResultSet rs=c.query("SELECT * FROM empleados where telefono='"+be.getTtelefono().getSelectedItem().toString()+"'");
			if(rs.next()) {
				be.getTnombre().setText(rs.getString(2)+" "+rs.getString(3));
				be.getTdireccion().setText(rs.getString(4));
				be.getTemail().setText(rs.getString(6));
				be.getTpuesto().setText(rs.getString(7));
				be.getHm().setText(rs.getString(8));
			}
			//c.cerrarConexion();
		}
	
	//Verificar que los campos no esten vacios en ALTA
	private boolean VerificarAlata() {
		boolean ok=true;
		if(ae.getTnombre().getText().trim().isEmpty() || ae.getTapellidos().getText().trim().isEmpty() || ae.getTtelefono().getText().trim().isEmpty() ||
			ae.getTdireccion().getText().isBlank() || ae.getTemail().getText().trim().isEmpty() || ae.getTpuesto().getText().trim().isEmpty() ||
			(!ae.getH().isSelected() && !ae.getM().isSelected())) {
			
			ok=false;
		}
		return ok;
	}
	
	//Inserta Empleado a la BBDD
	private void Insertar() throws ClassNotFoundException, SQLException {
		int id;
		boolean ok1=false, ok2=false;
		//Sacar la nueva ID
		ResultSet rs=c.query("SELECT empleado_id from empleados order by empleado_id desc limit 1");
		if(rs.next())
			id=rs.getInt(1)+1;
		else
			id=1;
		
		//Mirar si el Email es igual
		ResultSet rs2=c.query("SELECT * from empleados where email='"+ae.getTemail().getText()+"'");
		if(rs2.next()) {
			JOptionPane.showMessageDialog(ae, "El correo esta repetido, ingresa otro porfavor");
			ae.getTemail().setText("");
		}
		else
			ok1=true;
		
		//Mirar si el Telefono es igual y que sean 9 numeros
		ResultSet rs3=c.query("SELECT * from empleados where telefono='"+ae.getTtelefono().getText()+"'");
		if(rs3.next()) {
			JOptionPane.showMessageDialog(ae, "El telefono esta repetido, ingresa otro porfavor");
			ae.getTtelefono().setText("");
		}
		else {
			if(ae.getTtelefono().getText().length()!=9) {
				JOptionPane.showMessageDialog(ae, "El telefono debe tener mas de 9 nuemros");
				ae.getTtelefono().setText("");
			}
			else {
				boolean vale=true;
				for(int i=0;i<ae.getTtelefono().getText().length() && vale==true;i++) {
					if(ae.getTtelefono().getText().charAt(i)<'0' || ae.getTtelefono().getText().charAt(i)>'9') {
						vale=false;
						JOptionPane.showMessageDialog(ae, "El telefono solo puede contener numeros");
						ae.getTtelefono().setText("");
					}
				}
				if(vale==true)
					ok2=true;
			}
		}
			
		
		//Insertar en la BBDD
		if(ok1==true && ok2==true) {
			String s;
			if(ae.getH().isSelected())
				s="Hombre";
			else
				s="Mujer";
			
			c.update("INSERT INTO empleados values("+id+", '"+ae.getTnombre().getText()+"', '"+ae.getTapellidos().getText()+"', '"+ae.getTdireccion().getText()+"', '"+ae.getTtelefono().getText()+"', '"+ae.getTemail().getText()+"', '"+ae.getTpuesto().getText()+"', '"+s+"')");
			JOptionPane.showMessageDialog(ae, "Empleado añadido");
			LimpiarAlta();
		}
		//c.cerrarConexion();
	}
	
	//Limpiar
	private void LimpiarAlta() {
		ae.getTnombre().setText("");ae.getTapellidos().setText("");ae.getTtelefono().setText("");ae.getTdireccion().setText("");
		ae.getTemail().setText("");ae.getTpuesto().setText("");ae.getBg().clearSelection();
	}
}
