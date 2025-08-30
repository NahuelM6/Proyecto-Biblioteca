package proyecto;

//NM

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInventario extends JFrame {
	
	Borde borde = new Borde(2);
	Redondeador redondo = new Redondeador("");
	Main controlador = new Main();
	
	public VentanaInventario() {
		
		this.setTitle("Inventario"); 
		this.setSize(800,600); 
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.setLayout(new GridLayout(1,3));
		this.setResizable(false);
		
		JPanel panelfondo = new JPanel();
		panelfondo.setBackground(Color.BLACK);
		panelfondo.setLayout(new BorderLayout());
		Color colorpersonalizadofondo = new Color(255, 240, 203); // crema
		Color colorpersonalizadopanelarriba = new Color(1, 130, 114); // verde
		JPanel panelarriba = new JPanel();
		panelarriba.setBackground(colorpersonalizadopanelarriba);
		panelarriba.setLayout(new GridLayout(1,6));
		panelarriba.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		JPanel panelcentro = new JPanel();
		panelcentro.setBackground(colorpersonalizadofondo);
		panelcentro.setLayout(new BorderLayout());
		panelcentro.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10));
		JPanel panelbotones = new JPanel();
		panelbotones.setBackground(colorpersonalizadofondo);
		panelbotones.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelbotones.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		JLabel etiquetainventario = new JLabel("Inventario");
		etiquetainventario.setForeground(Color.WHITE);
		etiquetainventario.setFont(new Font("Arial", Font.BOLD, 16));
		JButton botonvolver = new Redondeadorrojo("Volver");
		botonvolver.setForeground(Color.WHITE);
		botonvolver.setFont(new Font("Arial", Font.BOLD, 14));
		JButton agregar = new Redondeador("Agregar libro/laptop");
		agregar.setForeground(Color.WHITE);
		agregar.setFont(new Font("Arial", Font.BOLD, 14));
		JButton eliminar = new Redondeador("Eliminar libro/laptop");
		eliminar.setForeground(Color.WHITE);
		eliminar.setFont(new Font("Arial", Font.BOLD, 14));
		JButton modificar = new Redondeador("Modificar libro/laptop");
		modificar.setForeground(Color.WHITE);
		modificar.setFont(new Font("Arial", Font.BOLD, 14));
		JButton actualizar = new Redondeador("Actualizar lista");
		actualizar.setForeground(Color.WHITE);
		actualizar.setFont(new Font("Arial", Font.BOLD, 14));
		
		JSeparator separador = new JSeparator(JSeparator.VERTICAL);
		
		modificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlador.ModificarInventario();
				VentanaInventario.this.dispose();
				
			}
		});
		
		agregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlador.AltaLibro();
				VentanaInventario.this.dispose();
				
			}
		});
		
		eliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame dialogo = new JFrame();
				JOptionPane.showMessageDialog(dialogo, "El libro seleccionado fue eliminado correctamente", "Eliminar libro/laptop", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		botonvolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlador.VentanaMenu();
				VentanaInventario.this.dispose();
				
			}
		});
		
        DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("Titulo");
		modelo.addColumn("Autor");
		modelo.addColumn("Año");
		modelo.addColumn("Tipo");
		modelo.addColumn("Género");
		modelo.addColumn("ID");
		
		JTable tablainventario = new JTable(modelo);
		
		JScrollPane scroll = new JScrollPane(tablainventario);
		
		this.add(panelfondo);
		panelfondo.add(panelarriba, BorderLayout.NORTH);
		panelfondo.add(panelbotones, BorderLayout.SOUTH);
		panelfondo.add(panelcentro, BorderLayout.CENTER);
		panelarriba.add(etiquetainventario);
		panelarriba.add(separador);
		panelarriba.add(separador);
		panelarriba.add(separador);
		panelarriba.add(botonvolver);
		panelbotones.add(agregar);
		panelbotones.add(eliminar);
		panelbotones.add(modificar);
		panelbotones.add(actualizar);
		panelcentro.add(scroll);
		
	}
	
}
