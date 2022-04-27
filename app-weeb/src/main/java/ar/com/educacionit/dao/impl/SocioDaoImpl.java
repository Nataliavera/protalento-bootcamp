package ar.com.educacionit.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.domain.Socios;

public class SocioDaoImpl extends JDBCDaoBase<Socios> implements SociosDao {

	public SocioDaoImpl() {
		super("socios");//ES LA TABLA
	}

	@Override
	public String getSaveSQL() {
//		LO PARTICULAR DE SQL
		return ("(nombre, apellido, email, direccion, paises_id, fecha_alta) values(?,?,?,?,?, ?");
		
	}

	@Override
	protected void save(PreparedStatement st, Socios entity) throws SQLException {
		st.setString(1, entity.getNombre() );
		st.setString(2, entity.getApellido());
		st.setString(3, entity.getEmail());
		st.setString(4, entity.getDireccion());
		st.setLong(5, entity.getPaisesId());
		st.setDate(6, new java.sql.Date(new Date(0).getTime()));
	}
	
	@Override
	public String getUpdateSQL() {
		return "nommbre = ?, apellido = ?, email = ?, direccion = ?, paises_id= ?";
	}

	@Override
	protected void update(PreparedStatement st, Socios entity) throws SQLException {
		st.setString(1, entity.getNombre());
		st.setString(2, entity.getApellido());
		st.setString(3, entity.getEmail());
		st.setString(4, entity.getDireccion());
		st.setLong(5, entity.getPaisesId());
	}
	
	
	
	/*public Socios save(Socios socio) {
//		MAS ADELANTE VEREMSO COMO CONECTAR A DB
//		INSERTAR DATOS 

		String sql = "INSERT INTO SOCIOS (NOMBRE, APELLIDO, EMAIL, DIRECCION ) VALUES ('CARLOS','LOPEZ', 'KRLOSS@GMAIL.COM', 'AV SIEMPRE VIVA 46')";
		System.out.println("Ejecutando sql: " + sql);
		return new Socios(10l, "carlos", "lopez", "krloss@gmail.com", "avenida siempre viva 46", 1l);
	}

//	READ (BY ID)
	public Socios getOne(Long id) {
		String sql = "SELECT * FROM SOCIOS WHERE ID= " + id;
		System.out.println("Ejecutando sql: " + sql);
		return new Socios(id, "carlos", "lopez", "krloss@gmail.com", "avenida siempre viva 46", 1l);
	}

//	SELECT*
	public Socios[] findAll() {
		String sql = "SELECT * FROM SOCIO";
//		VARIOS ROW
		System.out.println("Ejecutando sql: " + sql);

//		SIMULO QUE ENCONTRE 3 SOCIOS EN LA BASE DE DATOS 
		Socios socio1 = new Socios(1l, "carlos", "lopez", "krloss@gmail.com", "avenida siempre viva 46", 1l);
		Socios socio2 = new Socios(2l, "carlos", "lopez", "krloss@gmail.com", "avenida siempre viva 46", 1l);
		Socios socio3 = new Socios(3l, "carlos", "lopez", "krloss@gmail.com", "avenida siempre viva 46", 1l);

		return new Socios[] { socio1, socio2, socio3 };
	}

	public void delete(Long id) {
		String sql = "DELETE FROM SOCIOS WHERE ID = " + id;
		System.out.println(sql);
	}

	public void update(Socios entity) {
		String sql = "UPDATE SOCIOS " + "SET DIRECCION = '" + entity.getDireccion() + "', APELLIDO = '"
				+ entity.getApellido() + "', PAISES_ID = " + entity.getPaisesId() + "" + "WHERE ID = 1";
		System.out.println(sql);
	}

	/*
	 * public Socios selectCustom() { String sql =
	 * "SELECT nombre, apellido * FROM SOCIO";
	 * 
	 * return new Socios(1l, "carlos", "lopez", "krloss@gmail.com",
	 * "avenida siempre viva 46", 1l); }
	 */
}
