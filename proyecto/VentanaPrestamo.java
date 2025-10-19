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

		Color crema = new Color(255, 240, 203); // crema
		Color verde = new Color(1, 130, 114); // verde

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
		panelarriba.setBackground(verde);
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

		

		// Libros

		JPanel panelLibros = new JPanel(new GridLayout(9, 2, 20, 20));
		JLabel estudianteL = new JLabel("Nombre del Estudiante", SwingConstants.CENTER);
		panelLibros.add(estudianteL);
		JTextField txteL = new JTextField(7);
		panelLibros.add(txteL);
		
		JLabel nombreL = new JLabel("Nombre del Libro", SwingConstants.CENTER);
		panelLibros.add(nombreL);
		JTextField txtNL = new JTextField(7);
		panelLibros.add(txtNL);

		JLabel grupoL = new JLabel("Grupo", SwingConstants.CENTER);
		panelLibros.add(grupoL);
		JTextField txtgrupoL = new JTextField(7);
		panelLibros.add(txtgrupoL);

		JLabel IDL = new JLabel("ISBN del Libro", SwingConstants.CENTER);
		panelLibros.add(IDL);
		JTextField txtidL = new JTextField(7);
		panelLibros.add(txtidL);
		
		//Laptops
		
		JPanel panelcentro = new JPanel();
		panelcentro.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 2));

		JTabbedPane pestañas = new JTabbedPane();
		JPanel panelLaptops = new JPanel();
		panelLaptops.setLayout(new GridLayout(7, 2, 20, 20));
		JLabel estudianteLa = new JLabel("Nombre Estudiante", SwingConstants.CENTER);
		panelLaptops.add(estudianteLa);
		JTextField txteLa = new JTextField(7);
		panelLaptops.add(txteLa);

		JLabel grupoLa = new JLabel("Grupo", SwingConstants.CENTER);
		panelLaptops.add(grupoLa);
		JTextField txtgrupoLa = new JTextField(7);
		panelLaptops.add(txtgrupoLa);

		JLabel IDLa = new JLabel("ID de la laptop", SwingConstants.CENTER);
		panelLaptops.add(IDLa);
		JTextField txtNumeroSerie = new JTextField();
		txtNumeroSerie.setPreferredSize(new Dimension(767, 25));
		panelLaptops.add(txtNumeroSerie);

		pestañas.addTab("Libros", panelLibros);
		pestañas.addTab("Laptops", panelLaptops);
		pestañas.setBackground(new Color(255, 230, 203));
		panelLaptops.setBackground(new Color(255, 230, 203));
		panelLibros.setBackground(new Color(255, 230, 203));

		 // Saca los bordes azules
	     pestañas.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
	         @Override
	         protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
	             // no dibuja el borde del contenido
	         }

	         @Override
	         protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
	             // no dibuja el borde azul de selección
	         }
	     });
		
		realizarP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int pestaña = pestañas.getSelectedIndex();
				int es = 0;
				
				if (pestaña == 0) {
					
					es = 0;
					
				}else if (pestaña == 1) {
					
					es = 1;
				}
				
				if (pestaña == 0) {
					
					
					String nombreestudianteLib = txteL.getText();
					String nombreLib = txtNL.getText();
					String grupoLib = txtgrupoL.getText();

					try {
						
						String IDLib = txtidL.getText();
						controlador.realizarprestamo(nombreestudianteLib, nombreLib, grupoLib, IDLib, es);
						JOptionPane.showMessageDialog(null, "el prestamo fue realizado correctamente", "prestamo realizado", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("prestamo hecho");
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "el ISBN debe ser un codigo valido.", "error", JOptionPane.ERROR_MESSAGE);
					}

					System.out.println("Prestamo libro");
					
				}else if (pestaña == 1) {
					
					String nombreestudianteLap = txteLa.getText();
					String grupoLap = txtgrupoLa.getText();

					try {
						String IDLap = txtNumeroSerie.getText();
						controlador.realizarprestamo(nombreestudianteLap, null, grupoLap, IDLap, es);
						System.out.println("prestamo hecho");
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "el ID debe ser un numero valido.", "error",
						JOptionPane.ERROR_MESSAGE);
					}

					System.out.println("prestamo laptops");
					
				}
				
				

			}
		});
		
		separador.setBackground(verde);
	    separador.setForeground(verde);
		
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
		//panelabajo.add(terminarP);
		panelabajo.setBackground(crema);
		panelcentro.setBackground(crema);
		panelcentro.setLayout(new BorderLayout());
		panelcentro.setBorder(BorderFactory.createEmptyBorder(5, 10, 20, 10));

		// panelComputadoras.setBackground(colorpersonalizadofondo);
		// panelLibros.setBackground(colorpersonalizadofondo);

	}
}
