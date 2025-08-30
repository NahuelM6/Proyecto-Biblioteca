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
		this.setSize(800,600); 
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.setLayout(new GridLayout(1,3));
		this.setResizable(false);
		
		JPanel panelfondo = new JPanel();
		panelfondo.setBackground(Color.BLACK);
		panelfondo.setLayout(new BorderLayout());
		Color colorpersonalizadofondo = new Color(255, 240, 203); // crema
		Color colorpersonalizadopanelarriba = new Color(1, 130, 114); //verde
		JPanel panelarriba = new JPanel();
		panelarriba.setBackground(colorpersonalizadopanelarriba);
		panelarriba.setLayout(new GridLayout(1,6));
		panelarriba.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		JPanel panelcentro = new JPanel();
		panelcentro.setBackground(colorpersonalizadofondo);
		panelcentro.setLayout(new BorderLayout());
		panelcentro.setBorder(BorderFactory.createEmptyBorder(5, 20, 0, 20));
		JLabel etiquetamenu = new JLabel("Menú");
		etiquetamenu.setForeground(Color.WHITE);
		etiquetamenu.setFont(new Font("Arial", Font.BOLD, 16));
		JButton botonsalir = new Redondeadorrojo("Salir");
		botonsalir.setForeground(Color.WHITE);
		botonsalir.setFont(new Font("Arial", Font.BOLD, 14));
		//JLabel etiquetafecha = new JLabel("XX/XX/XXXX");
		//etiquetafecha.setFont(new Font("Arial", Font.BOLD, 14));
		JButton actualizar = new Redondeador("Actualizar");
		actualizar.setForeground(Color.WHITE);
		JButton inventario = new Redondeador("Inventario");
		inventario.setForeground(Color.WHITE);
		JButton realizarprestamo = new Redondeador("Realizar préstamo");
		realizarprestamo.setForeground(Color.WHITE);
		actualizar.setFont(new Font("Arial", Font.BOLD, 14));
		inventario.setFont(new Font("Arial", Font.BOLD, 14));
		realizarprestamo.setFont(new Font("Arial", Font.BOLD, 14));
		JPanel paneltabla = new JPanel();
		paneltabla.setBackground(colorpersonalizadofondo);
		paneltabla.setLayout(new BorderLayout());
		
		JSeparator separador = new JSeparator(JSeparator.VERTICAL);
		
        DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("Nombre del estudiante");
		modelo.addColumn("Grupo");
		modelo.addColumn("Nombre del Libro");
		
		JTable tablarecientes = new JTable(modelo);
		
		JScrollPane scroll = new JScrollPane(tablarecientes);
		
		paneltabla.setBorder(BorderFactory.createEmptyBorder(5, 10, 20, 10));
		
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
		panelfondo.add(panelcentro, BorderLayout.CENTER);
		panelfondo.add(paneltabla, BorderLayout.SOUTH);
		//panelarriba.add(etiquetafecha, BorderLayout.CENTER);
		panelarriba.add(etiquetamenu);
		panelarriba.add(separador);
		panelarriba.add(separador);
		panelarriba.add(botonsalir);
		panelcentro.add(actualizar, BorderLayout.WEST);
		panelcentro.add(inventario, BorderLayout.CENTER);
		panelcentro.add(realizarprestamo, BorderLayout.EAST);
		paneltabla.add(scroll, BorderLayout.CENTER);
		
	}
		
}
