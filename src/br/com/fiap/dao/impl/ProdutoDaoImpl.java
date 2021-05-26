package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.entity.Produto;

public class ProdutoDaoImpl extends GenericDaoImpl<Produto, Integer> implements ProdutoDao {

	public ProdutoDaoImpl(EntityManager em) {
		super(em);
	}
}
