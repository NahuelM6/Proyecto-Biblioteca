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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setLocationRelativeTo(null); 
		this.setLayout(new GridLayout(1,3));
		this.setResizable(false);
		
		JPanel panelfondo = new JPanel();
		panelfondo.setBackground(Color.BLACK);
		panelfondo.setLayout(new BorderLayout());
		Color colorpersonalizadofondo = new Color(255, 240, 203);
		Color colorpersonalizadopanelarriba = new Color(1, 130, 114);
		JPanel panelarriba = new JPanel();
		panelarriba.setBackground(colorpersonalizadopanelarriba);
		panelarriba.setLayout(new GridLayout(1, 8));
		panelarriba.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		JPanel panelcentro = new JPanel();
		panelcentro.setBackground(colorpersonalizadofondo);
		panelcentro.setLayout(new BorderLayout());
		panelcentro.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		JLabel etiquetainventario = new JLabel("Inventario");
		etiquetainventario.setFont(new Font("Arial", Font.BOLD, 14));
		JButton botonvolver = new Redondeadorrojo("Volver");
		botonvolver.setFont(new Font("Arial", Font.BOLD, 14));
		
		botonvolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlador.VentanaMenu();
				VentanaInventario.this.dispose();
				
			}
		});
		
        DefaultTableModel modelo = new DefaultTableModel();
        
        
		
		modelo.addColumn("¿Disponible?");
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
		panelfondo.add(panelcentro, BorderLayout.CENTER);
		panelarriba.add(botonvolver, BorderLayout.WEST);
		panelarriba.add(etiquetainventario, BorderLayout.CENTER);
		panelcentro.add(scroll);
		
	}
	
}
