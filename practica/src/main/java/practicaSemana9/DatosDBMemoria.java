package practicaSemana9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatosDBMemoria {

	private String db = "practica-adicional.semana9";
	private String login = "root";
	private String password = "";
	private String url = "jdbc:mysql://localhost:3306/" + db;

	Connection miConexion = null;

	public DatosDBMemoria() {
		try {
			miConexion = DriverManager.getConnection(url, login, password);
			if (miConexion != null) {
				System.out.println("Se conectó a la DB " + db);
			}
		} catch (SQLException e) {
			System.out.println("SQLException");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
	}

	public Connection obtenerConexion() {
		return miConexion;
	}

}
