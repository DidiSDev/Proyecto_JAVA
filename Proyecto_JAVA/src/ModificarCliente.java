import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ModificarCliente extends JInternalFrame{

	private JButton buscar, enviar, salir;
	private JLabel etiquetaNombre, etiquetaApellidos, etiquetaTelefono, etiquetaSexo, etiquetaDireccion;
    private JTextField cajaNombre, cajaApellidos, cajaTelefono, cajaDireccion;
    private JRadioButton hombre,mujer;
    private ButtonGroup sexo;
    //Lo de arriba es lo mismo que lo de alvaro
    private JLabel buscarid;
    private JTextField cajabuscar;

    
	ModificarCliente(){
		super("Modificar Clientes");
		etiquetaNombre = new JLabel("NOMBRE: ");
        etiquetaApellidos = new JLabel("APELLIDOS: ");
        etiquetaTelefono = new JLabel("TELEFONO: ");
        etiquetaSexo = new JLabel("SEXO: ");
        etiquetaDireccion = new JLabel("DIRECCION: ");

        etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 13));
        etiquetaApellidos.setFont(new Font("Arial", Font.BOLD, 13));
        etiquetaTelefono.setFont(new Font("Arial", Font.BOLD, 13));
        etiquetaSexo.setFont(new Font("Arial", Font.BOLD, 13));
        etiquetaDireccion.setFont(new Font("Arial", Font.BOLD, 13));

        etiquetaNombre.setForeground(Color.white);
        etiquetaApellidos.setForeground(Color.white);
        etiquetaTelefono.setForeground(Color.white);
        etiquetaSexo.setForeground(Color.white);
        etiquetaDireccion.setForeground(Color.white);

        cajaNombre = new JTextField(15);
        cajaApellidos = new JTextField(15);
        cajaTelefono = new JTextField(15);
        cajaDireccion = new JTextField(42);

        cajaDireccion.setPreferredSize(new Dimension(100,24));
        hombre = new JRadioButton("HOMBRE");
        mujer = new JRadioButton("MUJER");
        
        
        hombre.setFont(new Font("Arial", Font.BOLD, 13));
        mujer.setFont(new Font("Arial", Font.BOLD, 13));

        hombre.setForeground(Color.white);
        mujer.setForeground(Color.white);
		hombre.setBackground(Color.LIGHT_GRAY.darker());
		mujer.setBackground(Color.LIGHT_GRAY.darker());

        sexo = new ButtonGroup();
        sexo.add(hombre);
        sexo.add(mujer);
  
        etiquetaNombre.setPreferredSize(new Dimension(80, 25));
        cajaNombre.setPreferredSize(new Dimension(150, 25));
        
        etiquetaApellidos.setPreferredSize(new Dimension(80, 25));
        cajaApellidos.setPreferredSize(new Dimension(150, 25));
        
        etiquetaTelefono.setPreferredSize(new Dimension(80, 25));
        cajaTelefono.setPreferredSize(new Dimension(150, 25));
        
        //Lo de arriba es lo mismo que lo de Alvaro
        buscarid=new JLabel("ID DEL EMPLEADO, PARA MODIFICAR");
        cajabuscar=new JTextField();
        
        //Parte de arriba, la cual es la de buscar el id:
        JPanel top=new JPanel(new GridLayout(1, 2));
        top.add(buscarid);top.add(cajabuscar);
        JPanel fltop=new JPanel(new FlowLayout());
        fltop.add(top);
        
        
        //Lo meto aqui para ponerlo en el medio, y cuando encuentre un id, salga esto:
        JPanel medio=new JPanel();
        medio.add(etiquetaNombre);
        medio.add(cajaNombre);
        medio.add(new JLabel(" ")); 
        medio.add(etiquetaApellidos);
        medio.add(cajaApellidos);
        medio.add(new JLabel(" "));     
        medio.add(etiquetaTelefono);
        medio.add(cajaTelefono);
        medio.add(new JLabel(" ")); 
        medio.add(etiquetaSexo);
        medio.add(hombre);
        medio.add(mujer);
        medio.add(new JLabel(" ")); 
        medio.add(etiquetaDireccion);
        medio.add(cajaDireccion);
        //Hacerlo invisible para que no salga de primeras
        medio.setVisible(true);
        
        
        //Creo la clase de abajo, la cual va a ser de botones
        buscar=new JButton("BUSCAR CLIENTE");
        enviar=new JButton("MODIFICAR");
        salir=new JButton("SALIR");
        JPanel botones=new JPanel(new GridLayout(1, 3));
        botones.add(buscar);botones.add(enviar);botones.add(salir);
        JPanel flbotones=new JPanel(new FlowLayout(FlowLayout.CENTER));
        flbotones.add(botones);
        
        
        
        
        //Estructura de la Ventana
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, fltop);
        //this.add(BorderLayout.CENTER, medio);
        this.add(BorderLayout.SOUTH, flbotones);
	}
}