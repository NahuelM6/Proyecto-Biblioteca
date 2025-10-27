package proyecto;
//GM
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MySQL {

	private final String DB_URL = "jdbc:mysql://127.0.0.1/biblioteca?useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	private Connection getconnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}

	public void listarPrestamos(DefaultTableModel modelo) {
	    try (Connection con = getconnection()) {

	       
	        modelo.setRowCount(0);

	      
	        LocalDateTime ahora = LocalDateTime.now();

	        
	        String sentenciaLibros = 
	            "SELECT m.NombreEstudiante, i.Titulo, m.Grupo, 'Libro', i.ISBN, p.idPrestamo, p.FechaPrestamo " +
	            "FROM prestamo p " +
	            "INNER JOIN miembros m ON p.CI = m.CI " +
	            "INNER JOIN inventariolibros i ON p.ISBN = i.ISBN";

	        PreparedStatement psLibros = con.prepareStatement(sentenciaLibros);
	        ResultSet rsLib = psLibros.executeQuery();

	        while (rsLib.next()) {
	            Object[] fila = {
	                rsLib.getString(1),
	                rsLib.getString(2),
	                rsLib.getString(3),
	                rsLib.getString(4),
	                rsLib.getString(5),
	                rsLib.getInt(6),
	                rsLib.getDate(7),
	                ahora
	            };
	            modelo.addRow(fila);
	        }

	        
	        String sentenciaLaptops = 
	            "SELECT m.NombreEstudiante, 'Laptop', m.Grupo, 'Laptop', il.numeroDeSerie, pl.idPrestamoLaptop, pl.FechaPrestamo " +
	            "FROM prestamolaptop pl " +
	            "INNER JOIN miembros m ON pl.CI = m.CI " +
	            "INNER JOIN inventariolaptops il ON pl.idlaptop = il.ID";

	        PreparedStatement psLap = con.prepareStatement(sentenciaLaptops);
	        ResultSet rsLap = psLap.executeQuery();

	        while (rsLap.next()) {
	            Object[] fila = {
	                rsLap.getString(1),
	                rsLap.getString(2),
	                rsLap.getString(3),
	                rsLap.getString(4),
	                rsLap.getString(5),
	                rsLap.getInt(6),
	                rsLap.getDate(7),
	                ahora 
	            };
	            modelo.addRow(fila);
	        }

	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	    }
	}




	            
	        

	    



	public void listarInventarioLaptop(DefaultTableModel modelo2) {
	    String sentencia = "SELECT ID, numerodeserie FROM inventariolaptops";
	    
	    try (Connection conexion = getconnection();
	         PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
	         ResultSet rs = declaracionSQL.executeQuery()) {

	        modelo2.setRowCount(0); // 

	       
	        modelo2.setColumnIdentifiers(new Object[]{"Numero de serie", "ID"});

	        while (rs.next()) {
	            int ID = rs.getInt("ID");
	            String numerodeserie = rs.getString("numerodeserie");

	       
	            Object[] fila = {numerodeserie, ID};
	            modelo2.addRow(fila);
	        }

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}




		
		
	
	
	public void listarInventarioLibro(DefaultTableModel modelo) {
	    String sentencia = "SELECT Titulo, Autor, Año, Tipo, Genero, ISBN FROM inventariolibros";

	    try (Connection conn = getconnection();
	         PreparedStatement stmt = conn.prepareStatement(sentencia);
	         ResultSet rs = stmt.executeQuery()) {

	        modelo.setRowCount(0);

	        while (rs.next()) {
	            Object[] fila = new Object[6];
	            fila[0] = rs.getString("Titulo");
	            fila[1] = rs.getString("Autor");
	            fila[2] = rs.getString("Año");
	            fila[3] = rs.getString("Tipo");
	            fila[4] = rs.getString("Genero");
	            fila[5] = rs.getString("ISBN");
	            modelo.addRow(fila);
	        }

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error al listar inventario de libros: " + ex.getMessage());
	    }
	}









	    
		

		

	public void agregarinventarioLibro(String titulo, String autor, String año, String tipo, String genero, String ISBN) {

	    String sentencia = "INSERT INTO inventariolibros (Titulo, Autor, Año, Tipo, Genero, ISBN) " +  "VALUES ('" + titulo + "', '" + autor + "', '" + año + "', '" + tipo + "', '" + genero + "', '" + ISBN + "')";

	    try {
	        Connection conexion = getconnection();
	        PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
	        declaracionSQL.executeUpdate();

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}

	public void agregarinventarioLaptop(String numerodeserie, int ID) {

	    String sentencia = "INSERT INTO inventariolaptops (numerodeserie, ID) VALUES ('" + numerodeserie + "', " + ID + ")";

	    try {
	        Connection conexion = getconnection();
	        PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
	        declaracionSQL.executeUpdate();

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}
	public void realizarPrestamoLibro(int ci, String isbn, java.sql.Date fechaPrestamo, java.sql.Date fechaDevolucion) {
	   
	    String sentencia = "INSERT INTO prestamo (CI, ISBN, FechaPrestamo, FechaDevolucion, Estado) VALUES (" + ci + ", '"+ isbn + "', '" + fechaPrestamo + "', '"+ fechaDevolucion + "', 'En curso')";

	    try (Connection con = getconnection();
	         PreparedStatement ps = con.prepareStatement(sentencia)) {

	        ps.executeUpdate();

	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error al registrar prestamo: " + e.getMessage());
	    }
	}
















	public void realizarPrestamoLaptop(int CI, int IDLaptop, Date fechaP, Date fechaD) {
	    String sentencia = "INSERT INTO prestamolaptop (ci, idLaptop, FechaPrestamo, FechaDevolucion) " + "VALUES (" + CI + ", " + IDLaptop + ", '" + fechaP + "', '" + fechaD + "')";
	    try (Connection conexion = getconnection();
	         PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia)) {
	        declaracionSQL.executeUpdate();
	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "error: " + ex.getMessage());
	    }
	}



	public void terminarprestamolibro(String idPrestamo) {
	  

	   
	       String sentencia = "DELETE FROM prestamo WHERE idPrestamo = " + idPrestamo;
	    

	    try {
	        Connection conexion = getconnection();
	        PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
	        declaracionSQL.executeUpdate();
	        

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}
	
	public void terminarprestamolaptop(String idPrestamo) {
	    

	   
	        String sentencia = "DELETE FROM prestamolaptop WHERE idPrestamoLaptop = " + idPrestamo;
	    

	    try {
	        Connection conexion = getconnection();
	        PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
	        declaracionSQL.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Prestamo finalizado");

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }}
	
	
	

	public void eliminarinventarioLib(String isbn) {
	    String sentenciaEliminarPrestamos = "DELETE FROM prestamo WHERE ISBN = ?";
	    String sentenciaEliminarLibro = "DELETE FROM inventariolibros WHERE ISBN = ?";

	    try (Connection conn = getconnection()) {

	        
	        try (PreparedStatement ps1 = conn.prepareStatement(sentenciaEliminarPrestamos)) {
	            ps1.setString(1, isbn);
	            ps1.executeUpdate();
	        }

	        
	        try (PreparedStatement ps2 = conn.prepareStatement(sentenciaEliminarLibro)) {
	            ps2.setString(1, isbn);
	            int filas = ps2.executeUpdate();
	            if (filas > 0) {
	                JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
	            } else {
	                JOptionPane.showMessageDialog(null, "No se encontro el libro con ese ISBN.");
	            }
	        }

	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error al eliminar libro: " + e.getMessage());
	    }
	}



	public void eliminarinventarioLap(int id) {
	    String sentenciaEliminarPrestamos = "DELETE FROM prestamolaptop WHERE idlaptop = ?";
	    String sentenciaEliminarLaptop = "DELETE FROM inventariolaptops WHERE ID = ?";

	    try (Connection conn = getconnection()) {
	        
	        try (PreparedStatement ps1 = conn.prepareStatement(sentenciaEliminarPrestamos)) {
	            ps1.setInt(1, id);
	            ps1.executeUpdate();
	        }

	      
	        try (PreparedStatement ps2 = conn.prepareStatement(sentenciaEliminarLaptop)) {
	            ps2.setInt(1, id);
	            int filas = ps2.executeUpdate();
	            if (filas > 0) {
	                JOptionPane.showMessageDialog(null, "Laptop eliminada correctamente.");
	            } else {
	                JOptionPane.showMessageDialog(null, "No se encontro la laptop con ese ID.");
	            }
	        }

	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error al eliminar laptop: " + e.getMessage());
	    }
	}


	
	
	
	public void modificarInventarioLib(String ISBN, String titulo, String autor, String año, String tipo, String genero) {
	    String sentencia = "UPDATE inventariolibros SET " + "Titulo = '" + titulo + "', " + "Autor = '" + autor + "', "  + "Año = '" + año + "', "+ "Tipo = '" + tipo + "', "+ "Genero = '" + genero + "' " + "WHERE ISBN = '" + ISBN + "'";

	    try (Connection conexion = getconnection();
	         PreparedStatement ps = conexion.prepareStatement(sentencia)) {

	        int filas = ps.executeUpdate();

	        if (filas > 0) {
	            JOptionPane.showMessageDialog(null, "Libro modificado correctamente.");
	        } else {
	            JOptionPane.showMessageDialog(null, "No se encontro ningún libro con ese ISBN.");
	        }

	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error al modificar libro: " + e.getMessage());
	    }
	}







	
	
	
	
	
	public void registrarMiembro(int CI, String nombre, String grupo) {
	    String sentencia = "INSERT INTO miembros (CI, NombreEstudiante, Grupo) VALUES (" + CI + ", '" + nombre + "', '" + grupo + "')";

	    try (Connection conexion = getconnection();
	         PreparedStatement ps = conexion.prepareStatement(sentencia)) {

	        ps.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Miembro registrado correctamente.");

	    } catch (SQLIntegrityConstraintViolationException e) {
	        JOptionPane.showMessageDialog(null, "Ya existe un miembro con ese CI.");
	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error al registrar miembro: " + ex.getMessage());
	    }
	}


	
	
	
	public void listarMiembros(DefaultTableModel modelo) {
	    String sentencia = "SELECT CI, NombreEstudiante, Grupo FROM miembros";
	    
	    try (Connection conexion = getconnection();
	         PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
	         ResultSet rs = declaracionSQL.executeQuery()) {

	        modelo.setRowCount(0); // limpia la tabla

	        while (rs.next()) {
	            int CI = rs.getInt("CI");
	            String nombre = rs.getString("NombreEstudiante");
	            String grupo = rs.getString("Grupo");

	            Object[] fila = {CI, nombre, grupo};
	            modelo.addRow(fila);
	        }

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error al listar miembros: " + ex.getMessage());
	    }
	}

	
	
	public void eliminarMiembro(String ci) {
	    try (Connection conexion = getconnection();
	         PreparedStatement ps = conexion.prepareStatement("DELETE FROM miembros WHERE CI = ?")) {
	        ps.setString(1, ci);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error al eliminar miembro: " + e.getMessage());
	    }
	}
	
	
	
	
	
	
	
	
	

}
