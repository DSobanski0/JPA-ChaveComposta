package br.com.fiap.exercicio.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.GenericDaoImpl;
import br.com.fiap.exercicio.dao.AlunoCourseDao;
import br.com.fiap.exercicio.entity.AlunoCourse;
import br.com.fiap.exercicio.entity.AlunoCoursePK;

public class AlunoCourseDaoImpl extends GenericDaoImpl<AlunoCourse, AlunoCoursePK> implements AlunoCourseDao{
	
	public AlunoCourseDaoImpl(EntityManager em) {
		super(em);
	}

}
