	import java.awt.*;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	
	import javax.swing.*;
	import javax.swing.border.Border;
	import javax.swing.border.TitledBorder;
	
	public class AltaArriba extends JPanel {
	    private String sex;
	    private JLabel etiquetaNombre, etiquetaApellidos, etiquetaTelefono, etiquetaSexo, etiquetaDireccion,etiquetaEmail;
	    private JTextField cajaNombre, cajaApellidos, cajaTelefono, cajaDireccion,cajaEmail;
	    private JRadioButton hombre,mujer;
	    private ButtonGroup sexo;
	    private BaseDatos bd;
	    
	    
	    AltaArriba(ventanaMenuPrincipal v) {
	        super();
	        
	        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
			this.setBackground(Color.LIGHT_GRAY.darker());
	
			Border outerBorder = BorderFactory.createLineBorder(Color.WHITE, 2);
			
	        TitledBorder titulo = BorderFactory.createTitledBorder(outerBorder,"INFORMACIÓN PERSONAL");
	        titulo.setTitleColor(Color.white);
	        titulo.setTitleFont(new Font("Arial", Font.BOLD, 15));
	
	        this.setBorder(titulo);
	        
	        etiquetaNombre = new JLabel("NOMBRE: ");
	        etiquetaApellidos = new JLabel("APELLIDOS: ");
	        etiquetaTelefono = new JLabel("TELEFONO: ");
	        etiquetaSexo = new JLabel("SEXO: ");
	        etiquetaDireccion = new JLabel("DIRECCION: ");
	        etiquetaEmail = new JLabel("EMAIL: ");
	
	        etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 13));
	        etiquetaApellidos.setFont(new Font("Arial", Font.BOLD, 13));
	        etiquetaTelefono.setFont(new Font("Arial", Font.BOLD, 13));
	        etiquetaSexo.setFont(new Font("Arial", Font.BOLD, 13));
	        etiquetaDireccion.setFont(new Font("Arial", Font.BOLD, 13));
	        etiquetaEmail.setFont(new Font("Arial", Font.BOLD, 13));
	
	        etiquetaNombre.setForeground(Color.white);
	        etiquetaApellidos.setForeground(Color.white);
	        etiquetaTelefono.setForeground(Color.white);
	        etiquetaSexo.setForeground(Color.white);
	        etiquetaDireccion.setForeground(Color.white);
	        etiquetaEmail.setForeground(Color.white);
	
	        cajaNombre = new JTextField(15);
	        cajaApellidos = new JTextField(15);
	        cajaTelefono = new JTextField(15);
	        cajaDireccion = new JTextField(42);
	        cajaEmail = new JTextField(42);
	
	
	        cajaDireccion.setPreferredSize(new Dimension(100,24));
	        cajaEmail.setPreferredSize(new Dimension(100,24));
	
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
	        
	        this.add(etiquetaNombre);
	        this.add(cajaNombre);
	        this.add(new JLabel(" ")); 
	        
	        this.add(etiquetaApellidos);
	        this.add(cajaApellidos);
	        this.add(new JLabel(" ")); 
	        
	        this.add(etiquetaTelefono);
	        this.add(cajaTelefono);
	        this.add(new JLabel(" ")); 
	
	        this.add(etiquetaSexo);
	        this.add(hombre);
	        this.add(mujer);
	        this.add(new JLabel(" ")); 
	
	        this.add(etiquetaDireccion);
	        this.add(cajaDireccion);
	        this.add(new JLabel(" ")); 
	
	        this.add(etiquetaEmail);
	        this.add(cajaEmail);
	    }
		public void limpiarCajas() {
			cajaTelefono.setText("");
			cajaDireccion.setText("");
			cajaApellidos.setText("");
			cajaNombre.setText("");
			sexo.clearSelection();;
		}
		public void validar() {
			if(cajaApellidos.equals("")) {
				JOptionPane.showMessageDialog(this, "COMPLETE TODOS LOS CAMPOS PORFAVOR");
			}
			if(cajaEmail.equals("")) {
				JOptionPane.showMessageDialog(this, "COMPLETE TODOS LOS CAMPOS PORFAVOR");
			}
			if(cajaNombre.equals("")) {
				JOptionPane.showMessageDialog(this, "COMPLETE TODOS LOS CAMPOS PORFAVOR");
			}
			if(cajaTelefono.equals("")) {
				JOptionPane.showMessageDialog(this, "COMPLETE TODOS LOS CAMPOS PORFAVOR");
			}
			if(cajaDireccion.equals("")) {
				JOptionPane.showMessageDialog(this, "COMPLETE TODOS LOS CAMPOS PORFAVOR");
			}
			if(hombre.isSelected()==false && mujer.isSelected()==false) {
				JOptionPane.showMessageDialog(this, "COMPLETE TODOS LOS CAMPOS PORFAVOR");
			}
		}
		
		public void insertar() throws ClassNotFoundException, SQLException {
			bd = new BaseDatos();
			if(hombre.isSelected()) {
				sex="Hombre";
			}
			else {
				sex="Mujer";
			}
			int codigo = recogerUltimoCodigo()+1;
			System.out.println(codigo);
			String query="    INSERT INTO `clientes`(`cliente_id`, `nombre`, `apellido`, `direccion`, `telefono`, `email`, `sexo`) "
					+ "VALUES ('"+codigo+"','"+cajaNombre.getText()+"','"+cajaApellidos.getText()+"',"
							+ "'"+cajaDireccion.getText()+"','"+cajaTelefono.getText()+"','"+cajaEmail.getText()+"','"+sex+"')";
			bd.update(query);
		}
		public int recogerUltimoCodigo() throws SQLException, ClassNotFoundException {
			bd = new BaseDatos();
			int codigo=0;
			String query = "SELECT cliente_id from clientes order by cliente_id desc limit 1";
			ResultSet rs = bd.query(query);
			if(rs.next()) {
				while(rs.next()) {
					codigo = rs.getInt(1);
				}
				return codigo+1;
			}
			else {
				return 1;
			}
			
		}
		
		
		
	}