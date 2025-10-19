package proyecto;

import javax.swing.*;
import java.awt.*;

public class Redondeador extends JButton {
	
	public Redondeador(String label) {
        super(label);
        setFocusPainted(false);      
        setContentAreaFilled(false); 
    }
	
	@Override
	protected void paintComponent(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g.create();
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    
	    if (getModel().isArmed()) {
	    	Color colorpersonalizadobotonpresionado = new Color(1, 180, 114);
	        g2.setColor(colorpersonalizadobotonpresionado); // apretado
	    } else {
	    	Color colorpersonalizadoboton = new Color(1, 130, 114);
	        g2.setColor(colorpersonalizadoboton); // normal
	    }

	    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

	    super.paintComponent(g);
	    g2.dispose();
	}
	
	@Override
	protected void paintBorder(Graphics g) {
	    g.setColor(Color.BLACK); // color del borde
	    g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
	}
	
	@Override
	public Insets getInsets() {
	    return new Insets(10, 20, 10, 20); // margen arriba, izquierda, abajo, derecha
	}

}
