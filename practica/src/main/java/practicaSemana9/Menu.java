package practicaSemana9;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu {

	DatosDBMemoria conexion = new DatosDBMemoria();

	Connection miConexion;

	public void inscripcion(Alumno alumno) {
		try {
			miConexion = conexion.obtenerConexion();
			PreparedStatement insertar = miConexion.prepareStatement("INSERT INTO alumno (Nombre, Apellido) VALUES (?, ?)");

			insertar.setString(1, alumno.getNombre());
			insertar.setString(2, alumno.getApellido());
			insertar.executeUpdate();
			System.out.println("Se ha resgitrado exitosamente al alumno " + alumno.getNombre());

			insertar.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("No se pudo registrar al alumno " + alumno.getNombre());
		}
	}

	public void insertarAlumnoMateria(AlumnoMateria alumnoMateria) {
		try {
			miConexion = conexion.obtenerConexion();
			Statement st = miConexion.createStatement();
			st.execute("INSERT INTO alumno_materia (Matricula, IdMateria) VALUES ('" + alumnoMateria.getMatricula()
					+ "','" + alumnoMateria.getIdMateria() + "')");
			System.out.println("Se ha registrado exitosamente al alumno con matricula: " + alumnoMateria.getMatricula()
					+ " a la materia con Id: " + alumnoMateria.getIdMateria());

			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("No se pudo registrar al alumno ");
		}
	}

	public void datosDB() {
		try {
			miConexion = conexion.obtenerConexion();
			PreparedStatement datosDB = miConexion.prepareStatement("SELECT * FROM alumno");

			ResultSet rs = datosDB.executeQuery();

			if (rs.next()) {
				System.out.println("La base datos contiene registros");
			} else {
				System.out.println("No contiene registros");
			}

			datosDB.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("No se pudo verificar si hay registros en la DB");
		}
	}

	public void buscarIncripcion(Integer matricula) {
		try {
			miConexion = conexion.obtenerConexion();
			Statement consulta = miConexion.createStatement();
			ResultSet rs = consulta.executeQuery("SELECT Matricula, Nombre, Apellido FROM alumno WHERE Matricula= "+matricula);
			
			if(rs.next()) {
				System.out.println("\nMatricula: "+rs.getString("Matricula"));
				System.out.println("Nombre: "+rs.getString("Nombre"));
				System.out.println("Apellido: "+rs.getString("Apellido"));
			}else {
				System.out.println("Matricula no encontrada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("No se ha podido realizar la consulta a la DB");
		}
	}

	public void eliminar(Integer matricula) {
		try {
			miConexion = conexion.obtenerConexion();
			Statement delete = miConexion.createStatement();
			delete.execute("DELETE FROM alumno_materia WHERE Matricula = " + matricula);
			System.out.println("Se ha eliminado correctamente el alumno con la matricula: " + matricula);

			delete.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("No se pudo registrar al alumno ");
		}
	}

	public void actualizar(String nombre, String apellido, Long matricula) {
		try {
			miConexion = conexion.obtenerConexion();
			String Ssql = "UPDATE alumno SET Nombre=?, Apellido=? WHERE Matricula = ?";
			PreparedStatement actualiza = miConexion.prepareStatement(Ssql);

			actualiza.setString(1, nombre);
			actualiza.setString(2, apellido);
			actualiza.setLong(3, matricula);

			if (actualiza.executeUpdate() > 0) {
				System.out.println("\nLos datos han sido modificados con exito");
			} else {
				System.out.println("\nNo se ha podido realizar la actualizacion");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("No se ha podido realizar la actualizacion de los datos");
		}
	}

}
