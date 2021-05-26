package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CarrinhoCompraDao;
import br.com.fiap.entity.CarrinhoCompra;

public class CarrinhoCompraDaoImpl extends GenericDaoImpl<CarrinhoCompra, Integer> implements CarrinhoCompraDao {

	public CarrinhoCompraDaoImpl(EntityManager em) {
		super(em);
	}

}