package ar.com.educacionit.service.impl;

import ar.com.educacionit.dao.impl.CategoriaDaoImpl;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.services.CategoriaService;

public class CategoriaServiceImpl extends AbstractBaseService<Categorias> implements CategoriaService{

	//ESTA OBLIGADO A IMPLEMNETAR LOS METODOS DE CATEGORIA POR MEDIO DE LA CLASE GENERICA
	
		public CategoriaServiceImpl() {
			super(new CategoriaDaoImpl());
		}

	/*
		public Categorias getOne(Long id) {
			return this.dao.getOne(id);
		}
		public void delete(Long id) {
			this.dao.delete(id);
		}
		public Categorias save(Categorias entity) {
			return this.dao.save(entity);
		}
		public void update(Categorias entity) {
			this.dao.update(entity);
		}
		public Categorias[] findAll() {
			return this.dao.findAll();
		}*/
}
