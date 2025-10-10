package proyecto;

//NM

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenu extends JFrame {

	Borde borde = new Borde(2);
	Redondeador redondo = new Redondeador("");
	Main controlador = new Main();

	public VentanaMenu() {
		this.setTitle("Menú");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1, 3));
		this.setResizable(false);

		JPanel panelfondo = new JPanel();
		panelfondo.setBackground(Color.BLACK);
		panelfondo.setLayout(new BorderLayout());
		Color crema = new Color(255, 240, 203); // crema
		Color verde = new Color(1, 130, 114); // verde

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JPanel panelarriba = new JPanel();
		panelarriba.setBackground(verde);
		panelarriba.setLayout(new GridLayout(1, 6));
		panelarriba.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 10));
		JPanel panelcentro = new JPanel();
		panelcentro.setBackground(crema);
		panelcentro.setLayout(new BorderLayout());
		panelcentro.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
		JPanel panelac = new JPanel();
		panelac.setBackground(crema);
		panelac.setLayout(new GridBagLayout());
		panelac.setBorder(BorderFactory.createEmptyBorder(0, 0, 260, 10));
		JLabel etiquetamenu = new JLabel("Menú");
		etiquetamenu.setForeground(Color.WHITE);
		etiquetamenu.setFont(new Font("Arial", Font.BOLD, 32));
		JButton botonsalir = new Redondeadorrojo("Salir");
		botonsalir.setForeground(Color.WHITE);
		botonsalir.setFont(new Font("Arial", Font.BOLD, 14));
		botonsalir.setToolTipText("Cerrar el programa");
		JButton actualizar = new Redondeador("");
		actualizar.setForeground(Color.WHITE);
		actualizar.setBackground(Color.WHITE);
		actualizar.setToolTipText("Actualizar lista");
		ImageIcon iconoac = new ImageIcon("C:/Users/Usuario/solipse-workspace/Solipse/src/proyecto/flechaactualizar.png");
		Image imagen = iconoac.getImage();
		Image imagenacescalada = imagen.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		ImageIcon iconoacready = new ImageIcon(imagenacescalada);
		actualizar.setIcon(iconoacready);
		JButton inventario = new Redondeador("Inventario");
		inventario.setForeground(Color.WHITE);
		inventario.setBackground(Color.WHITE);
		inventario.setToolTipText("Menú Inventario");
		JButton realizarprestamo = new Redondeador("Préstamo");
		realizarprestamo.setForeground(Color.WHITE);
		realizarprestamo.setBackground(Color.WHITE);
		realizarprestamo.setToolTipText("Menú Prestamos");
		actualizar.setFont(new Font("Arial", Font.BOLD, 14));
		inventario.setFont(new Font("Arial", Font.BOLD, 14));
		realizarprestamo.setFont(new Font("Arial", Font.BOLD, 14));
		JPanel paneltabla = new JPanel();
		paneltabla.setBackground(crema);
		paneltabla.setLayout(new BorderLayout());
		paneltabla.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

		JSeparator separador = new JSeparator(JSeparator.VERTICAL);

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("Nombre del estudiante");
		modelo.addColumn("Grupo");
		modelo.addColumn("Prestado");
		modelo.addColumn("ID de préstamo");

		JTable tablarecientes = new JTable(modelo);
		tablarecientes.setBackground(crema);
		tablarecientes.getTableHeader().setBackground(new Color(255, 230, 203));
		tablarecientes.getTableHeader().setReorderingAllowed(false);

		JScrollPane scroll = new JScrollPane(tablarecientes);
		scroll.getViewport().setBackground(new Color(255, 230, 203));

		actualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				controlador.actualizarLista(modelo);

			}
		});

		inventario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				controlador.VentanaInventario();
				VentanaMenu.this.dispose();

			}
		});

		realizarprestamo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				controlador.VentanaPrestamo();
				VentanaMenu.this.dispose();

			}
		});

		botonsalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VentanaMenu.this.dispose();

			}
		});

		this.add(panelfondo);
		panelfondo.add(panelarriba, BorderLayout.NORTH);
		// panelfondo.add(panelcentro, BorderLayout.CENTER);
		panelfondo.add(panelac, BorderLayout.WEST);
		panelfondo.add(paneltabla, BorderLayout.CENTER);
		panelarriba.add(etiquetamenu);
		panelarriba.add(separador);
		panelarriba.add(separador);
		panelarriba.add(botonsalir);
		// panelcentro.add(inventario, BorderLayout.WEST);
		// panelcentro.add(realizarprestamo, BorderLayout.EAST);
		paneltabla.add(panelac, BorderLayout.WEST);

		gbc.gridwidth = 0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelac.add(actualizar, gbc);

		gbc.gridwidth = 0;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelac.add(realizarprestamo, gbc);

		gbc.gridwidth = 0;
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelac.add(inventario, gbc);

		paneltabla.add(scroll, BorderLayout.CENTER);

	}
	// teseo was here
}
