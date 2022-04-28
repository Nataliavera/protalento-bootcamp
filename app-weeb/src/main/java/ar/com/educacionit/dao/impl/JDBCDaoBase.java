package ar.com.educacionit.dao.impl;

import ar.com.educacionit.dao.GenericDao;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorDeConexiones;
import ar.com.educacionit.dao.jdbc.util.DTOUtils;

/**
 * LAS T SON ENTIDADES QUE REPRESENTAN TABLAS, POR ENDE VAN A HEREDAR DE ENTITY
 * @param <Entiy>
 * 
 */
public abstract class JDBCDaoBase<T extends Entity> implements GenericDao<T> {

	protected String tabla;
	protected Class<T> clazz;

	public JDBCDaoBase(String tablaDelHijo) {
		this.tabla = tablaDelHijo;
		// API REFLECTION JAVA
		// https://www.javatpoint.com/java-reflection
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T getOne(Long id) throws GenericException {
// GETONE RESUELTO PARA CUALQUIER ENTIDAD 

		if (id == null) {
			throw new GenericException("Id no informado");
		}

		String sql = "SELECT * FROM " + this.tabla + " WHERE ID = " + id;
		T entity = null;

		// connection
		try (Connection con = AdministradorDeConexiones.obtenerConexion();) {

			try (Statement st = con.createStatement()) {

				try (ResultSet res = st.executeQuery(sql)) {

					List<T> list = DTOUtils.populateDTOs(this.clazz, res);

//					¿HAY DATOS?
					if (!list.isEmpty()) {
						entity = list.get(0);
					}
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo consultar:" + sql, e);
		}

		return entity;
	}

	public void delete(Long id) throws GenericException {
		String sql = "DELETE FROM " + this.tabla + " WHERE ID = ? ";

		if (id == null) {
			throw new GenericException("El id informado es NULL");
		}

		try (Connection con = AdministradorDeConexiones.obtenerConexion();) {

			try (PreparedStatement st = con.prepareStatement(sql)) {
//				NO NECESITO UN RESULT PORQUE NO NECESITO HACER UNA CONSULTA 

//				DELETE GENERICO QUE FUNCIONA OARA CUALQUIER ENTIDAD 
				st.setLong(1, id);

				st.executeUpdate();

			}
		} catch (Exception e) {
			throw new GenericException("No se pudo eliminar:" + sql, e);
		}

	}

	/*
	 * public T save(T entity) throws DuplicatedException {//LA EXCEPCION DEBE DE
	 * ESTAR TAMBIEN EN LA INTERFACE DE LA QUE ES HEREDADO EL METODO StringBuffer
	 * nameSQL = new StringBuffer("INSERT INTO ").append(this.tabla).append("(");
	 * StringBuffer valueSQLString = new StringBuffer(" values (");
	 * 
	 * try { T instance = this.clazz.getConstructor().newInstance();
	 * 
	 * // PIDO LOS CAMPOS Field[] fields = instance.getClass().getDeclaredFields();
	 * 
	 * for(Field field : fields) { field.setAccessible(true);
	 * 
	 * String campoSQL = field.getName(); Object valueSQL = field.get(entity);
	 * 
	 * if(valueSQL != null) { nameSQL.append(campoSQL).append(",");
	 * valueSQLString.append("'").append(valueSQL).append("'").append(","); } }
	 * nameSQL = new StringBuffer(nameSQL.substring(0, nameSQL.length()-1));
	 * nameSQL.append(")");
	 * 
	 * valueSQLString = new StringBuffer(valueSQLString.substring(0,
	 * valueSQLString.length()-1)); valueSQLString.append(")"); // INSER INTO TABLA
	 * (CAMPO1, CAMPO2....CAMPON) VALUES ('1', '2', 'VALORN') } catch (Exception e)
	 * { e.printStackTrace(); }
	 * 
	 * String SQLFinal = nameSQL.toString() + valueSQLString.toString(); // EXECUTE
	 * HACIA LA DB // UN RECORDSET
	 * 
	 * System.out.println(SQLFinal);
	 * 
	 * return null; }
	 */

	public T save(T entity) throws DuplicatedException, GenericException {

		String sql = "INSERT INTO " + this.tabla + this.getSaveSQL();// ARMA LA PARTE DE CAMPOS Y VALORES
//		connection
		try (Connection con = AdministradorDeConexiones.obtenerConexion();) {
//			INSERT INTO () VALUES ()

			try (PreparedStatement st = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
//				DEBO DE DECIRLE A LA DB QUE ME GUARDE EL ULTIMO ID 
//				UNA VEZ TENGO LA SENTENCIA 
				this.save(st, entity);// SETEO LOS DATOS. NO GRABA NADA, SOLO SETEA EL LOS ? EL TIPO Y DATO

//				execute
				st.execute();
				try (ResultSet res = st.getGeneratedKeys()) {
					
					if(res.next()) {
						Long lastGeneratedId = res.getLong(1);//ACA ESTA EL ID QUE SE INSERTO
						
						((Entity) entity).setId(lastGeneratedId);
					}
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo insertar:" + sql, e);
		}

		return entity;
	}

	protected abstract void save(PreparedStatement st, T entity) throws SQLException;

//	LOS HIJOS ESTAN OBLIGADOS A IMPLEMENTARLOS 
//	NO SE PONEN EN GENERICDAO PORQUE NO SON PARTE DEL CRUD 
	public abstract String getSaveSQL();

	public void update(T entity) throws GenericException, DuplicatedException{
		
		String sql = "UPDATE " + this.tabla + " SET " + this.getUpdateSQL() + " WHERE id = " + ((Entity) entity).getId();
		
//		connection
		try (Connection con = AdministradorDeConexiones.obtenerConexion();) {
//			INSERT INTO () VALUES ()

			try (PreparedStatement st = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
				
				this.update(st, entity);// SETEO LOS DATOS. NO GRABA NADA, SOLO SETEA EL LOS ? EL TIPO Y DATO

//				execute
				st.execute();
			}
		} catch (SQLException e) {
			
//			ANALIZAR SI HAY DUPLICATED 
			if(e instanceof SQLIntegrityConstraintViolationException) {
//				ESTA EXCEPTION SE DA SI SQL NO SE PUEDE EJECUTAR 
				throw new DuplicatedException("No se pudo actualizar " + sql,e);
			}
			throw new GenericException("No se pudo actualizar:" + sql, e);
		}

	}

	protected abstract void update(PreparedStatement st, T entity) throws SQLException;

	public abstract String getUpdateSQL();

	public List<T> findAll() throws GenericException {

		List<T> list = new ArrayList<>();

		String sql = "SELECT * FROM " + this.tabla;

		// connection
		try (Connection con = AdministradorDeConexiones.obtenerConexion();) {

			try (Statement st = con.createStatement()) {

				try (ResultSet res = st.executeQuery(sql)) {

					list = DTOUtils.populateDTOs(this.clazz, res);
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo consultar:" + sql, e);
		}

		return list;

//		LA INFORMACION DEBE DE VENIR DESDE LA BASE DE DATOS 

//		SUPONGO QUE HAY DOS REGISTROS
//		List<T> instances = new ArrayList<T>();
//		T instance; 
//		try {
//			instance = this.clazz.getDeclaredConstructor().newInstance();
//			instance.setId(1l);
//			instances.add(instance); 
//			instances.add(instance);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return instances;

	}

}
