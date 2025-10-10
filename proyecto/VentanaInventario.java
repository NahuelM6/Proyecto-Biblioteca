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
		Color crema = new Color(255, 240, 203); // crema
		Color verde = new Color(1, 130, 114); // verde
		JPanel panelarriba = new JPanel();
		panelarriba.setBackground(verde);
		panelarriba.setLayout(new GridLayout(1,6));
		panelarriba.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		JPanel panelcentro = new JPanel();
		panelcentro.setBackground(crema);
		panelcentro.setLayout(new BorderLayout());
		panelcentro.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10));
		JPanel panelbotones = new JPanel();
		panelbotones.setBackground(crema);
		panelbotones.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelbotones.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		JLabel etiquetainventario = new JLabel("Inventario");
		etiquetainventario.setForeground(Color.WHITE);
		etiquetainventario.setFont(new Font("Arial", Font.BOLD, 32));
		JButton botonvolver = new Redondeadorrojo("Volver");
		botonvolver.setForeground(Color.WHITE);
		botonvolver.setFont(new Font("Arial", Font.BOLD, 14));
		//ImageIcon icon3 = new ImageIcon("C:/Users/Usuario/solipse-workspace/Solipse/src/proyecto/flechaready.png");
		//Image imagen3 = icon3.getImage();
		//Image imagenescalada3 = imagen3.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		//ImageIcon iconoreal3 = new ImageIcon(imagenescalada3);
		//botonvolver.setIcon(iconoreal3);
		JButton agregar = new Redondeador("Agregar libro/laptop");
		agregar.setForeground(Color.WHITE);
		agregar.setFont(new Font("Arial", Font.BOLD, 14));
		//ImageIcon icon = new ImageIcon("C:/Users/Usuario/solipse-workspace/Solipse/src/proyecto/cajabase.png");
		//Image imagen = icon.getImage();
		//Image imagenescalada = imagen.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		//ImageIcon iconoreal = new ImageIcon(imagenescalada);
		//agregar.setIcon(iconoreal);
		JButton eliminar = new Redondeadorrojo("Eliminar libro/laptop");
		eliminar.setForeground(Color.WHITE);
		eliminar.setFont(new Font("Arial", Font.BOLD, 14));
		//ImageIcon icon2 = new ImageIcon("C:/Users/Usuario/solipse-workspace/Solipse/src/proyecto/papelerabase.png");
		//Image imagen2 = icon2.getImage();
		//Image imagenescalada2 = imagen2.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		//ImageIcon iconoreal2 = new ImageIcon(imagenescalada2);
		//eliminar.setIcon(iconoreal2);
		JButton modificar = new Redondeador("Modificar libro/laptop");
		modificar.setForeground(Color.WHITE);
		modificar.setFont(new Font("Arial", Font.BOLD, 14));
		JButton actualizar = new Redondeador("Actualizar lista");
		actualizar.setForeground(Color.WHITE);
		actualizar.setFont(new Font("Arial", Font.BOLD, 14));
		
		JTabbedPane pestañas = new JTabbedPane();
        JPanel panelLibros = new JPanel();
        
        
        JPanel panelLaptops = new JPanel();
		
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
				dialogo.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		
		botonvolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlador.VentanaMenu();
				VentanaInventario.this.dispose();
				
			}
		});
		
        DefaultTableModel modeloLib = new DefaultTableModel();
		
		modeloLib.addColumn("Titulo");
		modeloLib.addColumn("Autor");
		modeloLib.addColumn("Año");
		modeloLib.addColumn("Tipo");
		modeloLib.addColumn("Género");
		modeloLib.addColumn("ID");
		
		JTable tablainventarioLib = new JTable(modeloLib);
		tablainventarioLib.setBackground(crema);
		tablainventarioLib.getTableHeader().setBackground(new Color(255, 230, 203));
		
		JScrollPane scrollLib = new JScrollPane(tablainventarioLib);
		scrollLib.getViewport().setBackground(new Color(255, 230, 203));
		
		tablainventarioLib.getTableHeader().setReorderingAllowed(false);
		
        DefaultTableModel modeloLap = new DefaultTableModel();
		
		modeloLap.addColumn("Número de serie");
		modeloLap.addColumn("ID");
		
		JTable tablainventarioLap = new JTable(modeloLap);
		tablainventarioLap.setBackground(crema);
		tablainventarioLap.getTableHeader().setBackground(new Color(255, 230, 203));
		
		JScrollPane scrollLap = new JScrollPane(tablainventarioLap);
		scrollLap.getViewport().setBackground(new Color(255, 230, 203));
		
		tablainventarioLap.getTableHeader().setReorderingAllowed(false);
		
		actualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlador.actualizarInventarioLibros(modeloLib, modeloLap);
				
			}
		});
		
		panelLaptops.add(scrollLap);
		panelLibros.add(scrollLib);
		
        pestañas.addTab("Libros", panelLibros);
        pestañas.addTab("Laptops", panelLaptops);
        pestañas.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI());
        pestañas.setBorder(null);
        pestañas.setBackground(new Color(255, 230, 203));
        panelLaptops.setBackground(new Color(255, 230, 203));
        panelLibros.setBackground(new Color(255, 230, 203));
		
		
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
		panelbotones.add(modificar);
		panelbotones.add(actualizar);
		panelbotones.add(eliminar);
		panelcentro.add(pestañas);
		
	}
	
}
