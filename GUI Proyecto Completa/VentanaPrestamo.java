package proyecto;

//GM

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrestamo extends JFrame {
 
    Borde borde = new Borde(2);
    Redondeador redondo = new Redondeador("");
    Main controlador = new Main();

    public VentanaPrestamo() {
        this.setTitle("Préstamos");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        Color colorpersonalizadofondo = new Color(255, 240, 203); // crema
        Color colorpersonalizadopanelarriba = new Color(1, 130, 114); // verde
        
        JPanel panelfondo = new JPanel(new BorderLayout());
        panelfondo.setBackground(Color.BLACK);
        JButton realizarP = new Redondeador("Realizar Préstamo");
        realizarP.setForeground(Color.WHITE);
        realizarP.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel panelabajo = new JPanel();
        panelabajo.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelabajo.setBorder(BorderFactory.createEmptyBorder(0, 0, 60, 0));
        JButton terminarP = new Redondeadorrojo("Cancelar Préstamo");
        terminarP.setForeground(Color.WHITE);
        terminarP.setFont(new Font("Arial", Font.BOLD, 14));
        panelfondo.setLayout(new BorderLayout());
        JPanel panelarriba = new JPanel(new GridLayout(1, 4, 10, 10));
        panelarriba.setBackground(colorpersonalizadopanelarriba);
        panelarriba.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JLabel etiquetamenu = new JLabel("Préstamos");
        etiquetamenu.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetamenu.setForeground(Color.WHITE);

        JButton botonvolver = new Redondeadorrojo("Volver");
        botonvolver.setForeground(Color.WHITE);
        botonvolver.setFont(new Font("Arial", Font.BOLD, 14));
        
        JSeparator separador = new JSeparator(JSeparator.VERTICAL);
       
        botonvolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.VentanaMenu();
                VentanaPrestamo.this.dispose();
            }
        });
        
        JPanel panelcentro = new JPanel(); 
        panelcentro.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 2)); 
       

        JTabbedPane pestañas = new JTabbedPane();
        pestañas.setBorder(null);

        JPanel panelLaptops = new JPanel();
        panelLaptops.setLayout(new GridLayout(7, 2, 20,20)); 
        panelLaptops.add(new JLabel("                                                                                                              Nombre Estudiante"));
        panelLaptops.add(new JTextField(7));
        panelLaptops.add(new JLabel("                                                                                                                       Grupo"));
        panelLaptops.add(new JTextField(7));
        panelLaptops.add(new JLabel("                                                                                                          Numero de serie de la laptop"));
        JTextField txtNumeroSerie = new JTextField();
        txtNumeroSerie.setPreferredSize(new Dimension(767, 25));
        panelLaptops.add(txtNumeroSerie);

        JPanel panelLibros = new JPanel(new GridLayout(7, 2, 20, 20));
        panelLibros.add(new JLabel("                                                                                                              Nombre Estudiante"));
        panelLibros.add(new JTextField(7));
        panelLibros.add(new JLabel("                                                                                                                       Grupo"));
        panelLibros.add(new JTextField(7));
        panelLibros.add(new JLabel("                                                                                                                       ID libro"));
        panelLibros.add(new JTextField(7));
        
        pestañas.addTab("Laptops", panelLaptops);
        pestañas.addTab("Libros", panelLibros);
       
        panelcentro.add(pestañas, BorderLayout.CENTER);

        
        panelfondo.add(panelarriba, BorderLayout.NORTH);
        panelfondo.add(panelcentro, BorderLayout.CENTER);

        this.add(panelfondo);
        setVisible(true);
        
        panelarriba.add(etiquetamenu);
        panelarriba.add(separador);
        panelarriba.add(botonvolver);
        panelfondo.add(panelabajo, BorderLayout.SOUTH);
       
        panelabajo.add(realizarP);
        panelabajo.add(terminarP);
        panelabajo.setBackground(colorpersonalizadofondo);
		panelcentro.setBackground(colorpersonalizadofondo);
		panelcentro.setLayout(new BorderLayout());
		panelcentro.setBorder(BorderFactory.createEmptyBorder(5, 10, 20, 10));
		
		//panelComputadoras.setBackground(colorpersonalizadofondo);
		//panelLibros.setBackground(colorpersonalizadofondo);
		
		 
    } }

  

