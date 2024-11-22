import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

class EscuchadorProveedoresModificacion implements ActionListener {

    private ModificacionProveedor modificacionProveedor;
    private BaseDatos operaciones;

    EscuchadorProveedoresModificacion(ModificacionProveedor modificacionProveedor, BaseDatos operaciones) 
    {
        this.modificacionProveedor = modificacionProveedor;
        this.operaciones = operaciones;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	


        if (e.getSource() == modificacionProveedor.getBtnValidar()) 
        {
            modificacionProveedor.validarCamposVaciosEmail();
            String email = modificacionProveedor.getEmailCaja().getText().trim();
            if(email.isEmpty()) 
            {
                return; // EMAIL VACIO, FUERA
            }

            String query = "SELECT * FROM proveedores where email='"+email+"'";
            try {
                ResultSet rs = operaciones.query(query);
                if(rs.next()) 
                {
                    modificacionProveedor.getNombreCaja().setText(rs.getString(1));
                    modificacionProveedor.getDireccionCaja().setText(rs.getString(2));
                    modificacionProveedor.getTelefonoCaja().setText(rs.getString(3));
                    modificacionProveedor.getEmailCaja().setEnabled(false);
                    modificacionProveedor.getNombreCaja().setEnabled(true);
                    modificacionProveedor.getDireccionCaja().setEnabled(true);
                    modificacionProveedor.getTelefonoCaja().setEnabled(true);
                    // HABILITOAMOS MODIFICAR
                    modificacionProveedor.getBtnModificar().setEnabled(true);
                }
                else 
                {
                    JOptionPane.showMessageDialog(modificacionProveedor, "¡Oh no! No se encontró a ningún proveedor con ese email.");
                }
                rs.close(); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else if (e.getSource() == modificacionProveedor.getBtnModificar()) 
        {
            modificacionProveedor.validarCamposVaciosTodos();
            String email = modificacionProveedor.getEmailCaja().getText();
            String nombre = modificacionProveedor.getNombreCaja().getText();
            String direccion = modificacionProveedor.getDireccionCaja().getText();
            String telefono = modificacionProveedor.getTelefonoCaja().getText();

            if(email.isEmpty() || nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) 
            {
                return; 
            }

            String query = "UPDATE proveedores SET nombre='"+nombre+"',direccion='"+direccion
                    +"',telefono='"+telefono+"' WHERE email='"+email+"'";
            try {
                operaciones.update(query);
                JOptionPane.showMessageDialog(modificacionProveedor, "¡¡Proveedor modificado correctamente!!");
                modificacionProveedor.limpiarCajas();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else if (e.getSource() == modificacionProveedor.getBtnLimpiar()) 
        {
            modificacionProveedor.limpiarCajas();
        }
        else if (e.getSource() == modificacionProveedor.getBtnSalir()) 
        {
            modificacionProveedor.dispose();
        }
    }
}
