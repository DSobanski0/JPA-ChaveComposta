package br.com.fiap.exercicio.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.GenericDaoImpl;
import br.com.fiap.exercicio.dao.AlunoDao;
import br.com.fiap.exercicio.entity.Aluno;

public class AlunoDaoImpl extends GenericDaoImpl<Aluno, Integer> implements AlunoDao {

	public AlunoDaoImpl(EntityManager em) {
		super(em);
	}
}