package proyecto;

//GDS

import java.awt.*;
import javax.swing.border.Border;
	
public class Borde implements Border{

	    private int radius;

	    public Borde (int radius) {
	        this.radius = radius;
	    }

	    @Override
	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius + 1, this.radius + 1, this.radius + 1, this.radius + 1);
	    }

	    @Override
	    public boolean isBorderOpaque() {
	        return true;
	    }

	    @Override
	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.setColor(Color.BLACK); // color del borde
	        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
	    }
	}