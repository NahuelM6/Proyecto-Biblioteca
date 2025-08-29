package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class VentanaPrestamo extends JFrame {

 
    Borde borde = new Borde(2);
    Redondeador redondo = new Redondeador("");
    Main controlador = new Main();

    public VentanaPrestamo() {
        this.setTitle("Préstamos");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        
        Color colorpersonalizadofondo = new Color(255, 240, 203);
        Color colorpersonalizadopanelarriba = new Color(1, 130, 114);

        
        JPanel panelfondo = new JPanel(new BorderLayout());
        panelfondo.setBackground(Color.BLACK);
             JButton realizarP = new Redondeador("Realizar Prestamo"); 
                     realizarP.setFont(new Font("Arial", Font.BOLD, 14));
                     JPanel panelabajo = new JPanel();
                     JButton terminarP = new Redondeadorrojo("Terminar Prestamo"); 
                     terminarP.setFont(new Font("Arial", Font.BOLD, 14));
                     panelfondo.setLayout(new BorderLayout());
        JPanel panelarriba = new JPanel(new GridLayout(1, 4, 10, 10));
        panelarriba.setBackground(colorpersonalizadopanelarriba);
        panelarriba.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JLabel etiquetamenu = new JLabel("Prestamos");
        etiquetamenu.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetamenu.setForeground(Color.WHITE);

        JButton botonvolver = new Redondeadorrojo("Volver");
        botonvolver.setFont(new Font("Arial", Font.BOLD, 14));

        JButton botonsalir = new Redondeadorrojo("Salir");
        botonsalir.setFont(new Font("Arial", Font.BOLD, 14));

        

       
        botonvolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.VentanaMenu();
                VentanaPrestamo.this.dispose();
            }
        });

        botonsalir.addActionListener(e -> System.exit(0));
        
        
        

      
        JPanel panelcentro = new JPanel(); 
        panelcentro.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 2)); 
       

        JTabbedPane pestañas = new JTabbedPane();
        pestañas.setBorder(null);

        JPanel panelComputadoras = new JPanel();
        panelComputadoras.setLayout(new GridLayout(7, 2, 20,20)); 
        panelComputadoras.add(new JLabel("                                                                                                              Nombre Estudiante"));
       
        panelComputadoras.add(new JTextField(10));
        panelComputadoras.add(new JLabel("                                                                                                                       Grupo"));
        panelComputadoras.add(new JTextField(10));
        panelComputadoras.add(new JLabel("                                                                                                          Numero de serie Laptop"));
        JTextField txtNumeroSerie = new JTextField();
        txtNumeroSerie.setPreferredSize(new Dimension(767, 25));
        panelComputadoras.add(txtNumeroSerie);
        

        JPanel panelLibros = new JPanel(new GridLayout(7, 2, 20, 20));
        panelLibros.add(new JLabel("                                                                                                              Nombre Estudiante"));
        panelLibros.add(new JTextField(10));
        panelLibros.add(new JLabel("                                                                                                                       Grupo"));
        panelLibros.add(new JTextField(10));
        panelLibros.add(new JLabel("                                                                                                                       ID libro"));
        panelLibros.add(new JTextField(10));
        //String[] tipos = {"Normal", "Literario"};
        //panelLibros.add(new JComboBox<>(tipos));
        
        
       
     
        
        

       
        
        pestañas.addTab("Computadoras", panelComputadoras);
        pestañas.addTab("Libros", panelLibros);
       
        panelcentro.add(pestañas, BorderLayout.CENTER);

        
        panelfondo.add(panelarriba, BorderLayout.NORTH);
        panelfondo.add(panelcentro, BorderLayout.CENTER);

        this.add(panelfondo);
        setVisible(true);
        
        panelarriba.add(etiquetamenu);
        
        panelarriba.add(botonvolver);
        panelarriba.add(botonsalir);
        panelfondo.add(panelabajo, BorderLayout.SOUTH);
       
        panelabajo.add(realizarP,BorderLayout.WEST);
        panelabajo.add(terminarP,BorderLayout.WEST);
        panelabajo.setBackground(colorpersonalizadofondo);
		panelcentro.setBackground(colorpersonalizadofondo);
		panelcentro.setLayout(new BorderLayout());
		panelcentro.setBorder(BorderFactory.createEmptyBorder(5, 10, 20, 10));
		
		//panelComputadoras.setBackground(colorpersonalizadofondo);
		//panelLibros.setBackground(colorpersonalizadofondo);
		
		 
    } }

  

