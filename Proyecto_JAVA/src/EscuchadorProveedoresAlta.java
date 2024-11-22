import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

class EscuchadorProveedoresAlta implements ActionListener {

    private AltaProveedor altaProveedor;
    private BaseDatos operaciones;

    EscuchadorProveedoresAlta(AltaProveedor altaProveedor, BaseDatos operaciones) 
    {
        this.altaProveedor = altaProveedor;
        this.operaciones = operaciones;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == altaProveedor.btnRegistro) 
        {
        	if (altaProveedor.getNombreCaja().getText().isEmpty() ||
                   altaProveedor.getDireccionCaja().getText().isEmpty() ||
                altaProveedor.getTelefonoCaja().getText().isEmpty() ||
                 altaProveedor.getEmailCaja().getText().isEmpty()) 
                {
                    JOptionPane.showMessageDialog(altaProveedor, "COMPLETE TODOS LOS CAMPOS POR FAVOR");
                    return; //ME SALGO
                }
        	//ELSE FALSO{
        	//HAY QUE VER SI EXISTE ESE MAIL
        	String queryMail="SELECT * FROM proveedores WHERE email='"+altaProveedor.getEmailCaja().getText()+"'";
        	try {
				ResultSet rs=operaciones.query(queryMail);
				if (rs.next())
				{
					//YA EXISTE,
					JOptionPane.showMessageDialog(altaProveedor, "¡ERROR! Ese proveedor ya existe en la base de datos :(");
					return;//COMO EXISTE FINALIZAMOS EJECUCIÓN
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            String nombre = altaProveedor.nombreCaja.getText();
            String direccion = altaProveedor.direccionCaja.getText();
            String telefono = altaProveedor.telefonoCaja.getText();
            String email = altaProveedor.getEmailCaja().getText();

            String query = "INSERT INTO proveedores VALUES ('"+nombre+"','"+direccion+"','"+telefono+"','"+email+"')";
            try {
                operaciones.update(query);
                JOptionPane.showMessageDialog(altaProveedor, "¡¡Proveedor registrado correctamente!!");
                altaProveedor.limpiarCajas();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            //}
        }
        else if (e.getSource() == altaProveedor.btnLimpiar) 
        {
            altaProveedor.limpiarCajas();
        }
        else if (e.getSource() == altaProveedor.btnSalir) 
        {
            altaProveedor.dispose(); //CIERRA ESTA
        }
    }
}