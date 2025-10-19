package proyecto;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MySQL {

	private final String DB_URL = "jdbc:mysql://170.249.219.114/program1_equipo2?useSSL=false";
	private final String DB_USER = "program1_estudiantes";
	private final String DB_PASS = "estudiantesarrayanes";

	private Connection getconnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}

	public void listarPRecientes(DefaultTableModel modelo) {

	    String sentencia = "SELECT nombreEstudiante, nombreLibro, Grupo, es, ISBN, idPrestamo FROM prestamo";

	    try (Connection conexion = getconnection();
	         PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
	         ResultSet rs = declaracionSQL.executeQuery()) {

	        modelo.setRowCount(0); // borra la tabla antes de volver a llenarla

	        while (rs.next()) {

	            String nombreEstudiante = rs.getString(1);
	            String nombreLibro = rs.getString(2);
	            String Grupo = rs.getString(3);
	            int es = rs.getInt(4);         
	            String ISBN = rs.getString(5);
	            int idPrestamo = rs.getInt(6);

	            
	            Object[] fila = { nombreEstudiante, nombreLibro, Grupo, es, ISBN, idPrestamo };
	            modelo.addRow(fila);
	        }

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }

	}

	

	public void listarInventarios(DefaultTableModel modelo1, DefaultTableModel modelo2) {

		String sentencia = "SELECT Titulo, Autor, Año, Tipo, Genero, ISBN FROM inventariolibros";

		try {
			Connection conexion = getconnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			modelo1.setRowCount(0); // borra la tabla antes de volver a llenarla

			while (rs.next()) {

				String titulo = rs.getString(1);
				String autor = rs.getString(2);
				String año = rs.getString(3);
				String tipo = rs.getString(4);
				String genero = rs.getString(5);
				String ID = rs.getString(6);

				Object[] fila = { titulo, autor, año, tipo, genero, ID };
				modelo1.addRow(fila);

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

		sentencia = "SELECT numerodeserie, ID FROM inventariolaptops";

		try {
			Connection conexion = getconnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			modelo2.setRowCount(0); // borra la tabla antes de volver a llenarla

			while (rs.next()) {

				String numerodeserie = rs.getString(1);
				int ID = rs.getInt(2);

				Object[] fila = { numerodeserie, ID };
				modelo2.addRow(fila);

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	public void agregarinventarioLibro(String titulo, String autor, String año, String tipo, String genero,
			String ISBN) {

		String sentencia = "INSERT INTO inventariolibros VALUES ('" + titulo + "','" + autor + "','" + año + "','" + tipo + "','" + genero + "','" + ISBN + "');";

		try {
			Connection conexion = getconnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	public void agregarinventarioLaptop(String numerodeserie, int ID) {

		String sentencia = "INSERT INTO inventariolaptops VALUES ('" + numerodeserie + "'," + ID + ");";

		try {
			Connection conexion = getconnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	public void realizarprestamo(String nombreestudiante, String nombreLib, String grupo, String ISBN, int es) {
	    String sentencia = "INSERT INTO prestamo (nombreEstudiante, nombreLibro, Grupo, es, ISBN) VALUES ('"  + nombreestudiante + "', '" + nombreLib + "', '" + grupo + "', " + es + ", '" + ISBN + "')";
	    
	    try {Connection conexion = getconnection();
	         PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia); 
	        declaracionSQL.executeUpdate();
	        

	         }  catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}


	public void terminarprestamo(String dato) {

		String sentencia = "DELETE FROM prestamo WHERE idPrestamo = '" + dato + "'";

		try {
			Connection conexion = getconnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	public void eliminarinventarioLib(String dato) {

		String sentencia = "DELETE FROM inventariolibros WHERE ISBN = '" + dato + "'";

		try {
			Connection conexion = getconnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	public void eliminarinventarioLap(int dato) {

		String sentencia = "DELETE FROM inventariolaptops WHERE ID = " + dato + "";

		try {
			Connection conexion = getconnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}
	
}
