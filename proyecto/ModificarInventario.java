package proyecto;

//NM

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ModificarInventario extends JFrame {
	
	Borde borde = new Borde(2);
	Redondeador redondo = new Redondeador("");
	Main controlador = new Main();
	
	public ModificarInventario() {
		this.setTitle("Modificar libro/laptop");
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
		JLabel etiquetamodificar = new JLabel("Modificar");
		etiquetamodificar.setForeground(Color.WHITE);
		etiquetamodificar.setFont(new Font("Arial", Font.BOLD, 16));
		JButton modificar = new Redondeador("Modificar");
        modificar.setForeground(Color.WHITE);
        modificar.setFont(new Font("Arial", Font.BOLD, 14));
        
        JSeparator separador = new JSeparator(JSeparator.VERTICAL);
        
        modificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
        
        botonvolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlador.VentanaInventario();
				ModificarInventario.this.dispose();
				
			}
		});
		
		JTabbedPane pestañas = new JTabbedPane();
        pestañas.setBorder(null);

        JPanel panelLaptops = new JPanel();
        panelLaptops.setLayout(new GridLayout(8, 2)); 
        JLabel IDLI = new JLabel("ID de la laptop a modificar", SwingConstants.CENTER);
        panelLaptops.add(IDLI);
        JTextField txtIDLI = new JTextField (7);
        panelLaptops.add(txtIDLI);
        
       
        JLabel NSLI = new JLabel ("Número de serie", SwingConstants.CENTER);  // poner advertencia de solo números luego
        panelLaptops.add(NSLI);
        JTextField txtNSLI = new JTextField (7);
        panelLaptops.add(txtNSLI);
                
        JPanel panelLibros = new JPanel(new GridLayout(6, 2, 10,10));
        
        JLabel IDLII = new JLabel ("ID del libro a modificar", SwingConstants.CENTER);  
        panelLibros.add(IDLII);
        JTextField txtIDLII = new JTextField (7);
        panelLibros.add(txtIDLII);
        
        JLabel TLI = new JLabel ("Título del libro", SwingConstants.CENTER);  
        panelLibros.add(TLI);
        JTextField txtTLI = new JTextField (7);
        panelLibros.add(txtTLI);
        
        JLabel ALI = new JLabel ("Autor", SwingConstants.CENTER);  
        panelLibros.add(ALI);
        JTextField txtALI = new JTextField (7);
        panelLibros.add(txtALI);
        
        JLabel AELI = new JLabel ("Año de escritura", SwingConstants.CENTER);  
        panelLibros.add(AELI);
        JTextField txtAELI = new JTextField (7);
        panelLibros.add(txtAELI);
        
        JLabel TdLI = new JLabel ("Tipo de libro", SwingConstants.CENTER);  
        panelLibros.add(TdLI);
        
        String[] tipos = {"Recreativo","Estudio","Literario"};
		JComboBox tiposLibros = new JComboBox(tipos);
		panelLibros.add(tiposLibros);
		
		JLabel GLI = new JLabel ("Género", SwingConstants.CENTER);  
        panelLibros.add(GLI);
        JTextField txtGLI = new JTextField (7);
        panelLibros.add(txtGLI);
        
        // La idea de modificar libros y computadoras está siendo pensada, esta es la primera idea, puede que se apliquen cambios significativos.
        
        pestañas.addTab("Libros", panelLibros);
        pestañas.addTab("Laptops", panelLaptops);
        pestañas.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI());
        pestañas.setBorder(null);
        pestañas.setBackground(new Color(255, 230, 203));
        panelLaptops.setBackground(new Color(255, 230, 203));
        panelLibros.setBackground(new Color(255, 230, 203));
        
        this.add(panelfondo, BorderLayout.CENTER);
		panelfondo.add(panelarriba, BorderLayout.NORTH);
		panelfondo.add(panelcentro, BorderLayout.CENTER);
		panelfondo.add(panelabajo, BorderLayout.SOUTH);
		panelabajo.add(modificar);
		panelarriba.add(etiquetamodificar);
		panelarriba.add(separador);
		panelarriba.add(separador);
		panelarriba.add(botonvolver);
		panelcentro.add(pestañas, BorderLayout.CENTER);
		
	}
	
	//franco was here
	
}
