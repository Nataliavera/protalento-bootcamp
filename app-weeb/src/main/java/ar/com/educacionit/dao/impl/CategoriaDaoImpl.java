package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.domain.Categorias;

public class CategoriaDaoImpl extends JDBCDaoBase<Categorias> implements CategoriaDao{

	public CategoriaDaoImpl() {
		super("categorias");
	}

	@Override
	public String getSaveSQL() {
		return ("(descripcion, codigo, habilitada) values(?,?,?)");
	}

	@Override
	protected void save(PreparedStatement st, Categorias entity) throws SQLException {
//	INSERT INTO CATEGORIAS ()	
		st.setString(1, entity.getDescripcion());
		st.setString(2, entity.getCodigo());
	}
	@Override
	public String getUpdateSQL() {
		return "descripcion = ?";
	}

	@Override
	protected void update(PreparedStatement st, Categorias entity) throws SQLException {
		st.setString(1, entity.getDescripcion());
		st.setLong(2, entity.getHabilitada());
	}
	
	/*public Categorias getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Categorias save(Categorias entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Categorias entity) {
		// TODO Auto-generated method stub
		
	}

	public Categorias[] findAll() {
		// TODO Auto-generated method stub
		return null;
	}*/
}
