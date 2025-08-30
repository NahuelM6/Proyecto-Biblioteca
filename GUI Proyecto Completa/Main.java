package proyecto;

//NM

public class Main {

	public static void main(String[] args) {
		
		VentanaInicio ventanainicio = new VentanaInicio();
		ventanainicio.setVisible(true);
		
	}
	
	public void VentanaMenu() {
		
		VentanaMenu ventanamenu = new VentanaMenu();
		ventanamenu.setVisible(true);
		
	}
	
	public void VentanaInventario() {
		
		VentanaInventario ventanainventario = new VentanaInventario();
		ventanainventario.setVisible(true);
		
	}
	
	public void VentanaPrestamo() {
		
		VentanaPrestamo ventanaprestamo = new VentanaPrestamo();
		ventanaprestamo.setVisible(true);
		
	}
	
	public void AltaLibro() {
		
		AltaLibro ventanaaltalibro = new AltaLibro();
		ventanaaltalibro.setVisible(true);
		
	}
	
	public void ModificarInventario() {
		
		ModificarInventario ventanamodificar = new ModificarInventario();
		ventanamodificar.setVisible(true);
		
	}
	
}
