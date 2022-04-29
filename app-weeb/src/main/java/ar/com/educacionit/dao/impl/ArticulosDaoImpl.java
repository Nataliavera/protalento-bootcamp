package ar.com.educacionit.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.ArticuloDao;
import ar.com.educacionit.domain.Articulos;

public class ArticulosDaoImpl extends JDBCDaoBase<Articulos> implements ArticuloDao {

	public ArticulosDaoImpl() {
		super("Articulos");
	}

	@Override
	public String getSaveSQL() {
		return ("(titulo,codigo,fechaCreacion,precio,stock,marcaId,categoriaId) values(?,?,?,?,?,?,?)");
	}

	@Override
	protected void save(PreparedStatement st, Articulos entity) throws SQLException {
//	INSERT INTO ARTICULOS ()	
		st.setString(1, entity.getTitulo());
		st.setString(3, entity.getCodigo());
		st.setDate(2, new java.sql.Date(entity.getFechaCreacion().getTime()));
		st.setDouble(4, entity.getPrecio());
		st.setLong(5, entity.getStock());
		st.setLong(6, entity.getMarcaId());
		st.setLong(7, entity.getCategoriaId());
	}

	@Override
	public String getUpdateSQL() {
		return "titulo =?,precio=? ,stock=?, marcaId=?, categoriaId=?";
	}

	@Override
	protected void update(PreparedStatement st, Articulos entity) throws SQLException {
		st.setString(1, entity.getTitulo());
		st.setDouble(2, entity.getPrecio());
		st.setLong(3, entity.getStock());
		st.setLong(4, entity.getMarcaId());
		st.setLong(5, entity.getCategoriaId());
	}

}
