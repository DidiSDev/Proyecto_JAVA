import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
public class AltaCliente extends JInternalFrame{

	private AltaArriba altarriba;
	private AltaAbajo altaabajo;
    private JCheckBox opc1,opc2;

	AltaCliente(ventanaMenuPrincipal v){
		super("Alta de Cliente");
		this.setLayout(new FlowLayout());
		this.setBackground(Color.LIGHT_GRAY.darker());
		altarriba = new AltaArriba(v);
		altarriba.setPreferredSize(new Dimension(550,180));
		this.getContentPane().add(altarriba);
        opc1 = new JCheckBox("HE LEÍDO Y ACEPTO LOS TÉRMINOS Y CONDICIONES");
        opc2 = new JCheckBox("ESTOY DE ACUERDO CON LA POLITICA DE PRIVACIDAD DE LA EMPRESA");
		opc1.setBackground(Color.LIGHT_GRAY.darker());
		opc2.setBackground(Color.LIGHT_GRAY.darker());
        opc1.setForeground(Color.white);
        opc2.setForeground(Color.white);
        opc1.setFont(new Font("Arial", Font.BOLD, 14));
        opc2.setFont(new Font("Arial", Font.BOLD, 14));


        this.getContentPane().add(opc1);
        this.getContentPane().add(opc2);

		altaabajo = new AltaAbajo(v);
		this.getContentPane().add(altaabajo);
		this.setVisible(true);
	}

	public void limpiar() {
		altarriba.limpiarCajas();
		opc1.setSelected(false);
		opc2.setSelected(false);
	}

	public void validar() {
		altarriba.validar();
		if(opc1.isSelected()==false || opc2.isSelected()==false) {
			JOptionPane.showMessageDialog(altarriba, "ACEPTE LOS TERMINOS PORFAVOR");
		}
	}
	public void insertarAlta() throws ClassNotFoundException, SQLException {
		altarriba.insertar();
	}
	
}