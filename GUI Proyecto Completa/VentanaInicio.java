package proyecto;

//NM

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame{
	
	Borde borde = new Borde(2);
	Redondeador redondo = new Redondeador("");
	Main controlador = new Main();
	
	public VentanaInicio() {
		this.setTitle("Inicio de Sesión"); 
		this.setSize(800,600); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		JPanel panelfondo = new JPanel();
		panelfondo.setBackground(Color.BLACK);
		panelfondo.setLayout(new BorderLayout());
	    Color colorpersonalizadofondo = new Color(255, 240, 203); // crema
	    Color colorpersonalizadoboton = new Color(1, 130, 114); // verde
		JPanel panel1 = new JPanel();
		panel1.setBackground(colorpersonalizadofondo);
		panel1.setLayout(new GridLayout(7, 1, 50, 15));
		ImageIcon imagenbase = new ImageIcon("C:/Users/Usuario/solipse-workspace/Solipse/src/proyecto/liceodesenfocado.png");
		JLabel imagen1 = new JLabel(new ImageIcon());
		imagen1.setBounds(800, 600, 10, 10);
		imagen1.setIcon(new ImageIcon(imagenbase.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH)));
		ImageIcon imagenbase2 = new ImageIcon("C:/Users/Usuario/solipse-workspace/Solipse/src/proyecto/liceo.png");
		JLabel imagen2 = new JLabel(new ImageIcon());
		imagen2.setBounds(800, 600, 10, 10);
		imagen2.setIcon(new ImageIcon(imagenbase2.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH)));
		JLabel welcome = new JLabel("¡Bienvenido!");
		welcome.setFont(new Font("Arial", 0, 40));
		JPasswordField entradadetexto = new JPasswordField();
		entradadetexto.setColumns(20);
		entradadetexto.setHorizontalAlignment(JTextField.CENTER);
		JButton ingresar = new Redondeador("Ingresar");
		ingresar.setForeground(Color.WHITE);
		ingresar.setBackground(colorpersonalizadoboton);
		ingresar.setFocusable(false);
		ingresar.setBorderPainted(false);
		panel1.setBorder(BorderFactory.createEmptyBorder(150, 60, 0, 60));
		
		JSeparator separador = new JSeparator(JSeparator.VERTICAL);
		
		separador.setPreferredSize(new Dimension(55, 55));
		
		separador.setFocusable(false);
		
	    ingresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlador.VentanaMenu();
				VentanaInicio.this.dispose();
				
			}
		});
		
		this.add(panelfondo, BorderLayout.CENTER);
		panelfondo.add(panel1, BorderLayout.WEST);
		panelfondo.add(imagen1, BorderLayout.CENTER);
		panel1.add(welcome);
		panel1.add(separador);
		panel1.add(entradadetexto);
		panel1.add(separador);
		panel1.add(ingresar);
		
	}
}
