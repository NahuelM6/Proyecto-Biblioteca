package proyecto;

//NM

import javax.swing.*;
import java.awt.*;

public class Redondeador extends JButton {
	
	public Redondeador(String label) {
        super(label);
        setFocusPainted(false);      // Quita el "rectángulo" azul de foco
        setContentAreaFilled(false); // Evita que Swing pinte el fondo por defecto
    }
	
	@Override
	protected void paintComponent(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g.create();
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	    // Cambia el color según si está apretado o no
	    if (getModel().isArmed()) {
	    	Color colorpersonalizadobotonpresionado = new Color(1, 180, 114);
	        g2.setColor(colorpersonalizadobotonpresionado); // cuando lo presionás
	    } else {
	    	Color colorpersonalizadoboton = new Color(1, 130, 114);
	        g2.setColor(colorpersonalizadoboton); // normal
	    }

	    // Dibuja un rectángulo redondeado
	    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

	    super.paintComponent(g); // pinta el texto del botón encima
	    g2.dispose();
	}
	
	@Override
	protected void paintBorder(Graphics g) {
	    g.setColor(null); // color del borde
	    g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
	}
	
	@Override
	public Insets getInsets() {
	    return new Insets(10, 20, 10, 20); // margen arriba, izq, abajo, der
	}

}
