package proyecto;

//NM

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AltaLibro extends JFrame {
	
	Borde borde = new Borde(2);
	Redondeador redondo = new Redondeador("");
	Main controlador = new Main();
	int change = 1;
	
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
		Color crema = new Color(255, 240, 203); // crema
		Color verde = new Color(1, 130, 114); // verde
		JPanel panelarriba = new JPanel();
		panelarriba.setBackground(verde);
		panelarriba.setLayout(new GridLayout(1,6));
		panelarriba.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		JPanel panelcentro = new JPanel();
		panelcentro.setBackground(crema);
		panelcentro.setLayout(new BorderLayout());
		panelcentro.setBorder(BorderFactory.createEmptyBorder(5, 20, 20, 20));
		JPanel panelabajo = new JPanel();
		panelabajo.setBackground(crema);
        panelabajo.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelabajo.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
		JButton botonvolver = new Redondeadorrojo("Volver");
		botonvolver.setForeground(Color.WHITE);
		botonvolver.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel etiquetaalta = new JLabel("Agregar");
		etiquetaalta.setForeground(Color.WHITE);
		etiquetaalta.setFont(new Font("Arial", Font.BOLD, 16));
		JButton registrarLib = new Redondeador("Registrar");
        registrarLib.setForeground(Color.WHITE);
        registrarLib.setFont(new Font("Arial", Font.BOLD, 14));
		
		JSeparator separador = new JSeparator(JSeparator.VERTICAL);
		
		//Laptops
		
		JTabbedPane pestañas = new JTabbedPane();
        pestañas.setBorder(null);

        JPanel panelLaptops = new JPanel();
        panelLaptops.setLayout(new GridLayout(8,2)); 
        
        JLabel NSLP = new JLabel("Número de serie", SwingConstants.CENTER);
        panelLaptops.add(NSLP);
        JTextField txtNSLP = new JTextField (7);
        panelLaptops.add(txtNSLP);
        
       
        JLabel IDLP = new JLabel ("ID", SwingConstants.CENTER);  // poner advertencia de solo números luego
        panelLaptops.add(IDLP);
        JTextField txtIDLP = new JTextField (7);
        panelLaptops.add(txtIDLP);
        
        txtIDLP.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
        		if (!Character.isDigit(c)) {
        			e.consume(); //Elimina cualquier letra, dejando solo numeros
        		}
        	}
        	
        	
		});
        
        //Libros
                
        JPanel panelLibros = new JPanel(new GridLayout(6, 2, 10,10));
        JLabel tituloL = new JLabel("Título del libro", SwingConstants.CENTER);
        panelLibros.add(tituloL);
        JTextField insertT = new JTextField(7);
        panelLibros.add(insertT);
        
        
        
        JLabel autorL = new JLabel("Autor", SwingConstants.CENTER);
        panelLibros.add(autorL);
        JTextField insertA = new JTextField(7);
        panelLibros.add(insertA);
        
        JLabel añoeL = new JLabel("Año de escritura", SwingConstants.CENTER);
        panelLibros.add(añoeL);
        JTextField insertE = new JTextField(7);
        panelLibros.add(insertE);
        
        JLabel tipoL = new JLabel("Tipo de libro", SwingConstants.CENTER);
        panelLibros.add(tipoL);
       
        String[] tipos = {"Recreativo","Estudio","Literario"};
		JComboBox tiposLibros = new JComboBox(tipos);
		panelLibros.add(tiposLibros);
		
		JLabel generoL = new JLabel("Género", SwingConstants.CENTER);
        panelLibros.add(generoL);
        JTextField insertgenero = new JTextField(7);
        panelLibros.add(insertgenero);
		
        JLabel IDL = new JLabel("ISBN", SwingConstants.CENTER); // poner advertencia de solo números luego
        panelLibros.add(IDL);
        JTextField insertIDL = new JTextField(7);
        panelLibros.add(insertIDL);
        
        pestañas.addTab("Libros", panelLibros);
        pestañas.addTab("Laptops", panelLaptops);
        pestañas.setBackground(new Color(255, 230, 203));
        panelLaptops.setBackground(new Color(255, 230, 203));
        panelLibros.setBackground(new Color(255, 230, 203));
        pestañas.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI());
        pestañas.setBorder(null);
        
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
	     
	     //Acciones de botones
	     
        botonvolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlador.VentanaInventario();
				AltaLibro.this.dispose();
				
			}
		});
        
        registrarLib.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int pestaña = pestañas.getSelectedIndex();
				
				if (pestaña == 0) {
					
					String titulo = insertT.getText();
					String autor = insertA.getText();
					String añoescritura = insertE.getText();
					String tipo = (String) tiposLibros.getSelectedItem();
					String genero = insertgenero.getText();
					String ISBN = insertIDL.getText();
					
					try {
			            controlador.agregarLibroInventario(titulo, autor, añoescritura, tipo, genero, ISBN);
			            JOptionPane.showMessageDialog(null, "el libro fue registrado correctamente", "Libro registrado correctamente", JOptionPane.INFORMATION_MESSAGE);
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(null, "el ID debe ser un numero valido.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
					
					System.out.println("Libro");
					
				} else if (pestaña == 1) {
					
					String numerodeserie = txtNSLP.getText();
			        
			        try {
			            int ID = Integer.parseInt(txtIDLP.getText());
			            controlador.agregarLaptopInventario(numerodeserie, ID);
			            JOptionPane.showMessageDialog(null, "la laptop fue registrada correctamente", "Laptop registrada correctamente", JOptionPane.INFORMATION_MESSAGE);
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(null, "el ID debe ser un número valido.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			        
				}
				
				
			}
		});
        
        //Layout
        
        separador.setBackground(verde);
	    separador.setForeground(verde);
        
		this.add(panelfondo, BorderLayout.CENTER);
		panelfondo.add(panelarriba, BorderLayout.NORTH);
		panelfondo.add(panelcentro, BorderLayout.CENTER);
		panelfondo.add(panelabajo, BorderLayout.SOUTH);
		panelabajo.add(registrarLib);
		panelarriba.add(etiquetaalta);
		panelarriba.add(separador);
		panelarriba.add(separador);
		panelarriba.add(botonvolver);
		panelcentro.add(pestañas, BorderLayout.CENTER);
	}
	
	
	
}
