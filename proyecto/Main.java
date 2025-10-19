package proyecto;

import javax.swing.JOptionPane;

//NM

import javax.swing.table.DefaultTableModel;

public class Main {
	
	MySQL bd = new MySQL();
	
	//Ventana default
	
	public static void main(String[] args) {
		
		VentanaInicio ventanainicio = new VentanaInicio();
		ventanainicio.setVisible(true);
		
	}
	
	//Ventanas llamadas
	
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
	
	//Funciones
	
	public void actualizarLista(DefaultTableModel modelo) {
		
		bd.listarPRecientes(modelo);
		
	}
	
	public void actualizarInventarios(DefaultTableModel modelo1, DefaultTableModel modelo2) {
		
		bd.listarInventarios(modelo1, modelo2);
		
	}
	
	public void agregarLibroInventario(String titulo, String autor, String año, String tipo, String genero, String ISBN) {
		
		bd.agregarinventarioLibro(titulo, autor, año, tipo, genero, ISBN);
		
	}

	public void agregarLaptopInventario(String numerodeserie, int ID) {
		
		bd.agregarinventarioLaptop(numerodeserie, ID);
		
	}
	
	public void realizarprestamo(String nombreestudiante, String nombreLib, String grupo, String ISBN, int es) {
	    bd.realizarprestamo(nombreestudiante, nombreLib, grupo, ISBN, es);
	}

	
	public void terminarprestamo(String dato, DefaultTableModel modelo) {
		
			bd.terminarprestamo(dato);
			bd.listarPRecientes(modelo);
			
		}
	
	public void eliminarinventarioLib(String dato) {
		
		bd.eliminarinventarioLib(dato);
		
		
	}
	
	public void eliminarinventarioLap(int dato) {
		
		bd.eliminarinventarioLap(dato);
		
		
	}
		
}
	

