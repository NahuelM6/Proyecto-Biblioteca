package proyecto;

//NM

import javax.swing.table.DefaultTableModel;

public class Main {
	
	MySQL bd = new MySQL();
	
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
	
	public void actualizarLista(DefaultTableModel modelo) {
		
		bd.listarPRecientes(modelo);
		
	}
	
	public void actualizarInventarioLibros(DefaultTableModel modelo1, DefaultTableModel modelo2) {
		
		bd.listarInventarioLibros(modelo1, modelo2);
		
	}
	
	public void agregarLibroInventario(String titulo, String autor, String año, String tipo, String genero, int ID) {
		
		bd.agregarinventarioLibro(titulo, autor, año, tipo, genero, ID);
		
	}

	public void agregarLaptopInventario(String numerodeserie, int ID) {
		
		bd.agregarinventarioLaptop(numerodeserie, ID);
		
	}
	
	public void realizarprestamo(String nombreestudiante, String grupo, int ID, int es) {
		
		String quees = null;
		
		if (es == 0) {
			
			quees = "Libro";
			
		}else if (es == 1) {
			
			quees = "Laptop";
			
		}
		
		bd.realizarprestamo(nombreestudiante, grupo, quees, ID);
		
	}
	
}
