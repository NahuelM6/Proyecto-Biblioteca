package proyecto;

//NM

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AltaLibro extends JFrame {
	
	Borde borde = new Borde(2);
	Redondeador redondo = new Redondeador("");
	Main controlador = new Main();
	
	public AltaLibro() {
		this.setTitle("Agregar libro/laptop");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		JPanel panelfondo = new JPanel();
		panelfondo.setBackground(Color.BLACK);
		panelfondo.setLayout(new BorderLayout());
		Color colorpersonalizadoC = new Color(255, 240, 203); // crema
		Color colorpersonalizadoV = new Color(1, 130, 114); // verde
		JPanel panelarriba = new JPanel();
		panelarriba.setBackground(colorpersonalizadoV);
		panelarriba.setLayout(new GridLayout(1,6));
		panelarriba.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		JPanel panelcentro = new JPanel();
		panelcentro.setBackground(colorpersonalizadoC);
		panelcentro.setLayout(new BorderLayout());
		panelcentro.setBorder(BorderFactory.createEmptyBorder(5, 20, 20, 20));
		JPanel panelabajo = new JPanel();
		panelabajo.setBackground(colorpersonalizadoC);
        panelabajo.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelabajo.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
		JButton botonvolver = new Redondeadorrojo("Volver");
		botonvolver.setForeground(Color.WHITE);
		botonvolver.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel etiquetaalta = new JLabel("Agregar libro/laptop");
		etiquetaalta.setForeground(Color.WHITE);
		etiquetaalta.setFont(new Font("Arial", Font.BOLD, 16));
		JButton registrar = new Redondeador("Registrar");
        registrar.setForeground(Color.WHITE);
        registrar.setFont(new Font("Arial", Font.BOLD, 14));
		
		JSeparator separador = new JSeparator(JSeparator.VERTICAL);
		
		registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame dialogo = new JFrame();
				JOptionPane.showMessageDialog(dialogo, "El libro/laptop fue registrado correctamente", "Registrar libro/laptop", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		botonvolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlador.VentanaInventario();
				AltaLibro.this.dispose();
				
			}
		});
		
		JTabbedPane pestañas = new JTabbedPane();
        pestañas.setBorder(null);

        JPanel panelLaptops = new JPanel();
        panelLaptops.setLayout(new GridLayout(4,1)); 
        panelLaptops.add(new JLabel("                                                                                                             Número de serie"));
        panelLaptops.add(new JTextField(7));
        panelLaptops.add(new JLabel("                                                                                                                         ID")); // poner advertencia de solo números luego
        panelLaptops.add(new JTextField(7));
                
        JPanel panelLibros = new JPanel(new GridLayout(6, 2, 10, 10));
        panelLibros.add(new JLabel("                                          Título del libro"));
        panelLibros.add(new JTextField(7));
        panelLibros.add(new JLabel("                                                Autor"));
        panelLibros.add(new JTextField(7));
        panelLibros.add(new JLabel("                                          Año de escritura"));
        panelLibros.add(new JTextField(7));
        panelLibros.add(new JLabel("                                           Tipo de libro"));
        String[] tipos = {"Recreativo","Estudio","Literario"};
		JComboBox tiposLibros = new JComboBox(tipos);
		panelLibros.add(tiposLibros);
        panelLibros.add(new JLabel("                                              Género"));
        panelLibros.add(new JTextField(7));
        panelLibros.add(new JLabel("                                                  ID")); // poner advertencia de solo números luego
        panelLibros.add(new JTextField(7));
        
        pestañas.addTab("Laptops", panelLaptops);
        pestañas.addTab("Libros", panelLibros);
        
		this.add(panelfondo, BorderLayout.CENTER);
		panelfondo.add(panelarriba, BorderLayout.NORTH);
		panelfondo.add(panelcentro, BorderLayout.CENTER);
		panelfondo.add(panelabajo, BorderLayout.SOUTH);
		panelabajo.add(registrar);
		panelarriba.add(etiquetaalta);
		panelarriba.add(separador);
		panelarriba.add(separador);
		panelarriba.add(botonvolver);
		panelcentro.add(pestañas, BorderLayout.CENTER);
	}
	
	
	
}
