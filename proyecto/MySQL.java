package proyecto;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MySQL {
	
	private final String DB_URL = "jdbc:mysql://23.111.185.242/program1_equipo2?useSSL=false";
	private final String DB_USER = "program1_estudiantes";
	private final String DB_PASS = "estudiantesarrayanes";
	
	private Connection getconnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}
	
	public void listarPRecientes(DefaultTableModel modelo) {
		
		String sentencia = "SELECT nombreEstudiante, Grupo, idPrestamo, es FROM prestamo";
		
		try {
			Connection conexion = getconnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			modelo.setRowCount(0); //borra la tabla antes de volver a llenarla
			
			while (rs.next()) {
				
				String nombreEstudiante = rs.getString(1);
				String Grupo = rs.getString(2);
				String es = rs.getString(3);
				String nombreLibro =  rs.getString(4);
								
				Object[] fila = { nombreEstudiante, Grupo, nombreLibro, es };
				modelo.addRow(fila);
				
			}
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
		
	}
	
public void listarInventarioLibros (DefaultTableModel modelo1, DefaultTableModel modelo2) {
	
	String sentencia = "SELECT Titulo, Autor, Año, Tipo, Genero, ID FROM inventariolibros";
	
	try {
		Connection conexion = getconnection();
		PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
		ResultSet rs = declaracionSQL.executeQuery();
		
		modelo1.setRowCount(0); //borra la tabla antes de volver a llenarla
		
		while (rs.next()) {
			
			String titulo = rs.getString(1);
			String autor = rs.getString(2);
			String año =  rs.getString(3);
			String tipo = rs.getString(4);
			String genero = rs.getString(5);
			int ID =  rs.getInt(6);
			
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
		
		modelo2.setRowCount(0); //borra la tabla antes de volver a llenarla
		
		while (rs.next()) {
			
			String numerodeserie = rs.getString(1);
			int ID =  rs.getInt(2);
			
			Object[] fila = { numerodeserie, ID };
			modelo2.addRow(fila);
			
		}
		
	} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	}
	
	
}
	
public void agregarinventarioLibro(String titulo, String autor, String año, String tipo, String genero, int ID) {
		
		String sentencia = "INSERT INTO inventariolibros VALUES ('"+ titulo +"','" + autor +"','"+ año +"','"+ tipo +"','"+ genero +"',"+ ID + ");";
		
		try {
			Connection conexion = getconnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	
	}

public void agregarinventarioLaptop(String numerodeserie, int ID) {
	
	String sentencia = "INSERT INTO inventariolaptops VALUES ('"+ numerodeserie +"',"+ ID + ");";
	
	try {
		Connection conexion = getconnection();
		PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
		declaracionSQL.executeUpdate();
		
	} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	}

}

public void realizarprestamo(String nombreestudiante, String grupo, String quees, int ID) {
	
	String sentencia = "INSERT INTO prestamo VALUES ('"+ nombreestudiante +"','" + grupo +"','"+ quees +"',"+ ID + ");";
	
	System.out.println(sentencia);
	
	try {
		Connection conexion = getconnection();
		PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
		declaracionSQL.executeUpdate();
		
	} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	}

}


}	

