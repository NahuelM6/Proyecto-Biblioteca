package proyecto;

import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

//NM //GM

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
	
public void ModificarInventario(String isbn, int año, String genero, String tipo, String autor, String titulo) {
		
		ModificarInventario ventanamodificar = new ModificarInventario(isbn, autor,genero,titulo,año,tipo);
		ventanamodificar.setVisible(true);
		
	}
	public void VentanaMiembros() {
	    VentanaMiembros ventana = new VentanaMiembros();
	    ventana.setVisible(true);
	}
	
	
	
	public void actualizarLista(DefaultTableModel modelo) {
		
		bd.listarPrestamos(modelo);
		
	}
     public void actualizarInventarioLaptop(DefaultTableModel modelo2) {
		
		bd.listarInventarioLaptop(modelo2);
		
	}
	public void actualizarInventariolibro(DefaultTableModel modelo1) {
		
		bd.listarInventarioLibro(modelo1);
		
	}
	
	public void agregarLibroInventario(String titulo, String autor, String año, String tipo, String genero, String ISBN) {
		
		bd.agregarinventarioLibro(titulo, autor, año, tipo, genero, ISBN);
		
	}

	public void agregarLaptopInventario(String numerodeserie, int ID) {
		
		bd.agregarinventarioLaptop(numerodeserie, ID);
		
	}
	


	public void realizarPrestamoLibro(int ci, String isbn, java.sql.Date fechaPrestamo, java.sql.Date fechaDevolucion) {
	    bd.realizarPrestamoLibro(ci, isbn, fechaPrestamo, fechaDevolucion);
	}




	public void realizarprestamolaptop(int CI, int IDLaptop, String grupo, String fechaPrestamo, String fechaDevolucion) { 
	    try {
	        Date fechaP = Date.valueOf(fechaPrestamo);
	        Date fechaD = Date.valueOf(fechaDevolucion);

	        bd.realizarPrestamoLaptop(CI, IDLaptop, fechaP, fechaD);

	    } catch (IllegalArgumentException e) {
	        JOptionPane.showMessageDialog(null, "Error");
	    }
	}


	public void terminarprestamolib(String idPrestamo) {
		
		bd.terminarprestamolibro(idPrestamo);
		
		
	}
	public void terminarprestamolap(String idPrestamo) {
		
			bd.terminarprestamolaptop(idPrestamo);
			
			
		}
	
	public void eliminarinventarioLib(String dato) {
		
		bd.eliminarinventarioLib(dato);
		
		
	}
	
	public void eliminarinventarioLap(int dato) {
		
		bd.eliminarinventarioLap(dato);
		
		
	}
	public void modificarinv(String ISBN, String titulo, String autor, String año, String tipo, String genero) {
	    bd.modificarInventarioLib(ISBN, titulo, autor, año, tipo, genero);
	}



		
		public void actualizarMiembros(DefaultTableModel modelo) {
		    
		    bd.listarMiembros(modelo);
		}

		 
		 
		public void eliminarMiembro(String ci) {
		    
		    bd.eliminarMiembro(ci);
		}
		public void registrarNuevoMiembro(int ci, String nombre, String grupo) {
		   
		    bd.registrarMiembro(ci, nombre, grupo);
}}
	

