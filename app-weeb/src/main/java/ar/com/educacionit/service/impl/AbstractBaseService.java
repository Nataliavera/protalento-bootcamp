package ar.com.educacionit.service.impl;

import java.util.List;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.service.exceptions.ServiceException;
import ar.com.educacionit.services.GenericService;

public class AbstractBaseService<T> implements GenericService<T> {

//	ATRIBUTO PROTECTED PARA HEREDAR 
	protected GenericDao<T> genericDao;

//CONSTRUCTOR
	public AbstractBaseService(GenericDao<T> genericDaoHijo) {
		super();
		this.genericDao = genericDaoHijo;
	}

	public T getOne(Long id) throws ServiceException {
		T entity;
		try {
			entity = genericDao.getOne(id);
		} catch (GenericException e) {
				throw new ServiceException("Error de DB al intentar obtener entity id=" + id, e);
		}
		return entity;
		/*finally {
//			SIEMPRE SE EJECUTA
//			SIRVE PARA REALIZAR UNA ACCION ANTES DE SALIR DE METODO 
			entity = null;
		}*/

	}

	public void delete(Long id) throws ServiceException{
		try {
			genericDao.delete(id);
		} catch (GenericException e) {
			throw new ServiceException("Error eliminando entity id: "+id, e);
		}
	}

	public T save(T entity) throws ServiceException{
		try {
			return genericDao.save(entity);
		} catch (DuplicatedException | GenericException de) {
//			RELANZO LA EXCEPTION COMO UNA SERVICEEXCEPTION QUE CONTIENE LA EXCEPTION ORIGINAL 
			throw new ServiceException("No se ha podido grabar la entidad ", de);
		}
	}

	public void update(T entity) throws ServiceException {
		try {
			genericDao.update(entity);
		} catch (GenericException | DuplicatedException e) {
			throw new ServiceException("Error al actualizar", e);
		}
	}

	public List<T> findAll() {
		try {
			return genericDao.findAll();
		} catch (GenericException e) {
			e.printStackTrace();
		}
		return null;
	}
}
