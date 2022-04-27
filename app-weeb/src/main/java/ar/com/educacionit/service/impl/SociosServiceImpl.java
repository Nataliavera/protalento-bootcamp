package ar.com.educacionit.service.impl;

import ar.com.educacionit.dao.impl.SocioDaoImpl;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.services.SociosService;

public class SociosServiceImpl extends AbstractBaseService<Socios> implements SociosService {

//	ATRIBUTOS
	// private SociosDao dao;

//	CONSTRUCTORES
	public SociosServiceImpl() {
//		DESIGNO QUE IMPLEMENTACION USAR DE LA INTERFACE SOCIOS DAO 
		super(new SocioDaoImpl());
	}

}
