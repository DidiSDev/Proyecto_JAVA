import javax.swing.*;
import java.awt.*;

public class ventanaCita extends JFrame {
    private JLabel titulo;
    private JLabel[] l;
    private JTextField[] t;
    private JComboBox[] cb;
    private JButton b;

    public ventanaCita() {
        super("Registrar Cita");
        this.setBounds(500, 250, 450, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER)); 

        String[] servicios = {"Cambio Aceite", "Cambio Neumaticos", "Chapa y Pintura"};
        String[] labels = {"Nombre y Apellido", "Correo", "Fecha", "Hora", "Servicio"};
        String[] horas = {"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"};


        titulo = new JLabel("Registrar Cita");
        Font f = new Font("Arial", Font.ITALIC, 30);
        titulo.setFont(f);
        titulo.setPreferredSize(new Dimension(400, 50));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.red);
        this.getContentPane().add(titulo);

        l = new JLabel[labels.length];
        t = new JTextField[3];
        cb = new JComboBox[2];
        cb[0] = new JComboBox(horas);
        cb[0].setPreferredSize(new Dimension(230, 25));
        cb[0].setSelectedIndex(-1);
        cb[1] = new JComboBox(servicios);
        cb[1].setPreferredSize(new Dimension(230, 25));
        cb[1].setSelectedIndex(-1);
        b = new JButton("Reservar");

 
        for (int x = 0; x < l.length; x++) {
            l[x] = new JLabel(labels[x]);
            l[x].setPreferredSize(new Dimension(200, 40));
            this.getContentPane().add(l[x]);
            if (x < 3) {
                t[x] = new JTextField();
                t[x].setPreferredSize(new Dimension(230, 20));
                this.getContentPane().add(t[x]);
            } else if (x == 3) {
                this.getContentPane().add(cb[0]);
            } else {
                this.getContentPane().add(cb[1]);
            }
        }

    
        
        this.getContentPane().add(b);

        this.setVisible(true);
        this.setResizable(false);
    }

}
