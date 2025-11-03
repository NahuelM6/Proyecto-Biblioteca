package proyecto;

//NM //GM

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
		JLabel etiquetamenu = new JLabel("Menu");
		etiquetamenu.setForeground(Color.WHITE);
		etiquetamenu.setFont(new Font("Arial", Font.BOLD, 32));
		JButton botonsalir = new Redondeadorrojo("Salir");
		botonsalir.setForeground(Color.WHITE);
		botonsalir.setFont(new Font("Arial", Font.BOLD, 14));
		botonsalir.setToolTipText("Cerrar el programa");
		JButton actualizar = new Redondeador("");
		actualizar.setForeground(Color.WHITE);
		actualizar.setBackground(Color.WHITE);
		JButton eliminar = new Redondeadorrojo("Eliminar");
		eliminar.setForeground(Color.WHITE);
		eliminar.setBackground(Color.WHITE);
		eliminar.setFont(new Font("Arial", Font.BOLD, 14));
		eliminar.setToolTipText("Terminar prestamo de columna selecionada");
		ImageIcon iconoac = new ImageIcon("C:/Users/Usuario/solipse-workspace/Solipse/src/proyecto/flechaactualizar.png");
		Image imagen = iconoac.getImage();
		Image imagenacescalada = imagen.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		ImageIcon iconoacready = new ImageIcon(imagenacescalada);
		actualizar.setIcon(iconoacready);
		JButton inventario = new Redondeador("Inventario");
		inventario.setForeground(Color.WHITE);
		inventario.setBackground(Color.WHITE);
		inventario.setToolTipText("Menu Inventario");
		JButton realizarprestamo = new Redondeador("Prestamo");
		realizarprestamo.setForeground(Color.WHITE);
		realizarprestamo.setBackground(Color.WHITE);
		realizarprestamo.setToolTipText("Menu Prestamos");
		actualizar.setFont(new Font("Arial", Font.BOLD, 14));
		inventario.setFont(new Font("Arial", Font.BOLD, 14));
		realizarprestamo.setFont(new Font("Arial", Font.BOLD, 14));
		JPanel paneltabla = new JPanel();
		paneltabla.setBackground(crema);
		paneltabla.setLayout(new BorderLayout());
		paneltabla.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		
		JButton botonMiembros = new Redondeador("Miembros");
		botonMiembros.setForeground(Color.WHITE);
		botonMiembros.setBackground(Color.WHITE);
		botonMiembros.setFont(new Font("Arial", Font.BOLD, 14));
		botonMiembros.setToolTipText("Gestión de miembros");

		JSeparator separador = new JSeparator(JSeparator.VERTICAL);

		DefaultTableModel modelo = new DefaultTableModel() {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};

		modelo.addColumn("Nombre");
		modelo.addColumn("Titulo/Laptop");
		modelo.addColumn("Grupo");
		modelo.addColumn("Prestado");
		modelo.addColumn("ISBN");
		modelo.addColumn("ID de préstamo");
        modelo.addColumn("Fecha");
		JTable tablarecientes = new JTable(modelo);
		tablarecientes.setBackground(crema);
		tablarecientes.getTableHeader().setBackground(new Color(255, 230, 203));
		tablarecientes.getTableHeader().setReorderingAllowed(false);

		JScrollPane scroll = new JScrollPane(tablarecientes);
		scroll.getViewport().setBackground(new Color(255, 230, 203));
		
		
		botonMiembros.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        controlador.VentanaMiembros(); 
		    }
		});

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
		
		eliminar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int filaselect = tablarecientes.getSelectedRow();

		        if (filaselect == -1) {
		            JOptionPane.showMessageDialog(null, "Seleccione una fila a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		       
		        String idPrestamo = String.valueOf(tablarecientes.getValueAt(filaselect, 5));

		        
		        String tipo = String.valueOf(tablarecientes.getValueAt(filaselect, 3)).trim();

		        int opcion = JOptionPane.showConfirmDialog(
		                null,
		                "desea eliminar el prestamo?",
		                "Confirmar eliminacion",
		                JOptionPane.YES_NO_OPTION
		        );

		        if (opcion == JOptionPane.YES_OPTION) {
		            try {
		                if (tipo.equalsIgnoreCase("Libro")) {
		                    controlador.terminarprestamolib(idPrestamo);
		                } else if (tipo.equalsIgnoreCase("Laptop")) {
		                    controlador.terminarprestamolap(idPrestamo);
		                } else {
		                	JOptionPane.showMessageDialog(null, "Error al procesar el prestamo.");

		                    return;
		                }

		                controlador.actualizarLista(modelo);
		              

		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(null, "Error al eliminar prestamo: " + ex.getMessage());
		            }
		        }
		    }
		});




	
		
		separador.setBackground(verde);
	    separador.setForeground(verde);

		this.add(panelfondo);
		panelfondo.add(panelarriba, BorderLayout.NORTH);
		panelfondo.add(panelac, BorderLayout.WEST);
		panelfondo.add(paneltabla, BorderLayout.CENTER);
		panelarriba.add(etiquetamenu);
		panelarriba.add(separador);
		panelarriba.add(separador);
		panelarriba.add(botonsalir);
		paneltabla.add(panelac, BorderLayout.WEST);
        
//		gbc.gridwidth = 0;
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		panelac.add(actualizar, gbc);

		gbc.gridwidth = 0;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelac.add(realizarprestamo, gbc);

		gbc.gridwidth = 0;
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelac.add(inventario, gbc);
		
		gbc.gridwidth = 0;
		gbc.gridx = 0;
		gbc.gridy = 4;
		panelac.add(eliminar, gbc);

		paneltabla.add(scroll, BorderLayout.CENTER);
		
		controlador.actualizarLista(modelo);
		
		gbc.gridwidth = 0;
		gbc.gridx = 0;
		gbc.gridy = 3; 
		panelac.add(botonMiembros, gbc);
	}
	
	// Teseo was here
	
}
