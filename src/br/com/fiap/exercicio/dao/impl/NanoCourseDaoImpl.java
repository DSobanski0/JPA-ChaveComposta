package br.com.fiap.exercicio.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.GenericDaoImpl;
import br.com.fiap.exercicio.dao.NanoCourseDao;
import br.com.fiap.exercicio.entity.NanoCourse;

public class NanoCourseDaoImpl extends GenericDaoImpl<NanoCourse, Integer> implements NanoCourseDao {

	public NanoCourseDaoImpl(EntityManager em) {
		super(em);
	}
}