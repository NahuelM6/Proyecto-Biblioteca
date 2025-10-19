package proyecto;

//NM

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	    Color crema = new Color(255, 240, 203); // crema
	    Color verde = new Color(1, 130, 114); // verde
		JPanel panel1 = new JPanel();
		panel1.setBackground(crema);
		panel1.setLayout(new GridLayout(7, 1, 50, 15));
		ImageIcon imagenbase = new ImageIcon("C:/Users/Usuario/solipse-workspace/Solipse/src/proyecto/liceoreadysupuestamentev3.jpeg");
		JLabel imagen1 = new JLabel(new ImageIcon());
		imagen1.setBounds(800, 600, 10, 10);
		imagen1.setIcon(new ImageIcon(imagenbase.getImage().getScaledInstance(1220, 660, Image.SCALE_AREA_AVERAGING)));
		//ImageIcon imagenbase2 = new ImageIcon("C:/Users/Usuario/solipse-workspace/Solipse/src/proyecto/liceo.png");
		//JLabel imagen2 = new JLabel(new ImageIcon());
		//imagen2.setBounds(800, 600, 10, 10);
		//imagen2.setIcon(new ImageIcon(imagenbase2.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH)));
		JLabel welcome = new JLabel("¡Bienvenido!");
		welcome.setFont(new Font("Arial", 0, 40));
		JPasswordField entradadetexto = new JPasswordField();
		entradadetexto.setColumns(20);
		
		JButton ingresar = new Redondeador("Ingresar");
		ingresar.setForeground(Color.WHITE);
		ingresar.setBackground(verde);
		ingresar.setFocusable(false);
		ingresar.setBorderPainted(false);
		panel1.setBorder(BorderFactory.createEmptyBorder(150, 60, 0, 60));
		
		JSeparator separador = new JSeparator(JSeparator.VERTICAL);
		separador.setPreferredSize(new Dimension(55, 55));
		
	    ingresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String password = new String(entradadetexto.getPassword());
				
				if (password.equals("Alvarofigueredo")) {
					controlador.VentanaMenu();
					VentanaInicio.this.dispose();
				} else {
					JOptionPane.showMessageDialog(VentanaInicio.this, "Contraseña incorrecta");
					entradadetexto.setText("");
				}
			}
		});
	    
	    entradadetexto.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String password = new String(entradadetexto.getPassword());
					
					if (password.equals("Alvarofigueredo")) {
						controlador.VentanaMenu();
						VentanaInicio.this.dispose();
					} else {
						JOptionPane.showMessageDialog(VentanaInicio.this, "Contraseña incorrecta");
						entradadetexto.setText("");
					}
				}
			}
		});
	    
	    separador.setBackground(crema);
	    separador.setForeground(crema);
	    
		this.add(panelfondo, BorderLayout.CENTER);
		panelfondo.add(panel1, BorderLayout.WEST);
		panelfondo.add(imagen1, BorderLayout.CENTER);
		//panelfondo.add(imagen2, BorderLayout.CENTER);
		panel1.add(welcome);
		panel1.add(separador);
		panel1.add(entradadetexto);
		panel1.add(separador);
		panel1.add(ingresar);
	}
}
