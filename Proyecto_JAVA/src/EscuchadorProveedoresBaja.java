import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

class EscuchadorProveedoresBaja implements ActionListener {

    private BajaProveedor bajaProveedor;
    private BaseDatos operaciones;

    EscuchadorProveedoresBaja(BajaProveedor bajaProveedor, BaseDatos operaciones) 
    {
        this.bajaProveedor = bajaProveedor;
        this.operaciones = operaciones;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == bajaProveedor.btnEliminar) 
        {
            bajaProveedor.validar();
            String email = bajaProveedor.getEmailCaja().getText();
            String query = "DELETE FROM proveedores WHERE email='"+email+"'";
            try {
                operaciones.update(query);
                JOptionPane.showMessageDialog(bajaProveedor, "¡¡Proveedor eliminado!!");
                bajaProveedor.limpiarCajas();
                //DESPUES DE ELIMINAR, EL BOTON ELIMINAR A FALSE OTRA VE
                bajaProveedor.getBtnEliminar().setEnabled(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else if (e.getSource() == bajaProveedor.btnLimpiar) 
        {
            bajaProveedor.limpiarCajas();
        }
        else if (e.getSource() == bajaProveedor.btnSalir) 
        {
            bajaProveedor.dispose();
        }
        
        else  if (e.getSource() == bajaProveedor.btnValidar) 
        {
            bajaProveedor.validar();
            String email = bajaProveedor.getEmailCaja().getText();
            if(email.isEmpty()) 
            {
                return; //EMAIL VACIO, FUERA
            }

            String query = "SELECT * FROM proveedores WHERE email='"+email+"'";
            try {
                ResultSet rs = operaciones.query(query);
                if(rs.next()) 
                {
                	//ESTO ES Q EXISTE
                    bajaProveedor.getNombreCaja().setText(rs.getString(1));
                    bajaProveedor.getTelefonoCaja().setText(rs.getString(3));
                    bajaProveedor.getDireccionCaja().setText(rs.getString(2));
                    bajaProveedor.getNombreCaja().setEnabled(false);
                    bajaProveedor.getTelefonoCaja().setEnabled(false);
                    bajaProveedor.getDireccionCaja().setEnabled(false);
                    //AQUI HABILITAMOS ELIMINAR
                    bajaProveedor.getBtnEliminar().setEnabled(true);
                }
                else 
                {
                    JOptionPane.showMessageDialog(bajaProveedor, "¡Oh no! No se encontró a ningún proveeddor con ese email.");
                }
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
