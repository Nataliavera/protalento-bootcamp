package ar.com.educacionit.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.com.educacionit.dao.exceptions.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException{
		String url= "jdbc:mysql://localhost:3306/bootcamp-protalento?serverTimezone=UTC&userSSL=false"; //DEFINIR LOS DATOS DONDE ME VOY A CONECTAR
		String user = "root"; 
		String password = "root"; 
		String driverName = "com.mysql.cj.jdbc.Driver"; //UBICACION DE LA CLASE QUE VAMOS A SACAR
		
//		
//		try {
//			Class.forName(driverName);//INSTANCIAMOS LA CLASE 
//			Connection connection = DriverManager.getConnection(url, user, password);
//			return connection;
//		} catch (ClassNotFoundException e) {
//			throw new GenericException("No existe el driver: "+driverName);
//		} catch (SQLException e) {
//			throw new GenericException("Error obteniendo conexion: "+driverName);
//		}
		
		try {
			//com.mysql.cj.jdbc.Driver.class.newInstance();
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (Exception  e) {
			throw new GenericException("Error oteniendo conexion: " + e.getMessage(),e);
		} 
		
	}
	public static void main(String[] args) {
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion();) {			
			System.out.println("Conexion obtenida");
		}catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
